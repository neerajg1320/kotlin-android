package com.example.readsms

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter(val context: Context, val list: ArrayList<SmsData>): BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false)

        val item: SmsData = list[position]
        view.findViewById<TextView>(R.id.sms_sender).text = item.senderName
        view.findViewById<TextView>(R.id.sms_message).text = item.message
        view.findViewById<TextView>(R.id.sms_date).text = item.date

        Log.d(TAG, "item: ${item}")
        return view
    }
}