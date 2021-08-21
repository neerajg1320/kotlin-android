package com.devtides.countries.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devtides.countries.CountriesApplication
import com.devtides.countries.R
import com.devtides.countries.model.di.DaggerCountriesComponent
import com.devtides.countries.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import com.devtides.countries.viewmodel.TAG


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
//    private val countriesAdapter = CountryListAdapter(arrayListOf())

    @Inject
    lateinit var countriesAdapter: CountryListAdapter

//    init {
//        DaggerCountriesComponent.create().inject(this)
//        Log.d(TAG, "CountryListAdapter injected: instance $countriesAdapter")
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (applicationContext as CountriesApplication).appComponent
        DaggerCountriesComponent.builder()
            .appComponent(appComponent)
            .build()
            .inject(this)
        Log.d(TAG, "CountryListAdapter injected: instance $countriesAdapter")

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        countriesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            viewModel.refresh()
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.countries.observe(this, Observer {countries ->
            countries?.let {
                countriesList.visibility = View.VISIBLE
                countriesAdapter.updateCountries(it) }
        })

        viewModel.countryLoadError.observe(this, Observer { isError ->
            isError?.let { list_error.visibility = if(it) View.VISIBLE else View.GONE }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loading_view.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    list_error.visibility = View.GONE
                    countriesList.visibility = View.GONE
                }
            }
        })
    }
}
