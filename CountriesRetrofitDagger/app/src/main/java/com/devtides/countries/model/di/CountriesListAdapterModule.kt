package com.devtides.countries.model.di

import com.devtides.countries.view.CountryListAdapter
import dagger.Module
import dagger.Provides

@Module
class CountriesListAdapterModule {
    @Module
    companion object {
        @JvmStatic
        @PerActivity
        @Provides
        fun provideCLA(): CountryListAdapter = CountryListAdapter(arrayListOf())
    }

}