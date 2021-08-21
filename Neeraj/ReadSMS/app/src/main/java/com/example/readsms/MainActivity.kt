package com.example.readsms

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import android.Manifest
import android.net.Uri
import android.util.Log
import android.widget.Button
import android.widget.ListView
import java.util.*
import kotlin.collections.ArrayList


val TAG = "SmsApp"

// https://www.youtube.com/watch?v=ZALMdNgx9bw

class MainActivity : AppCompatActivity() {
    private val requestReadSms: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_SMS), requestReadSms)
        } else {
            setSmsMessages("", null)
        }

        findViewById<Button>(R.id.all_sms).setOnClickListener {
            setSmsMessages("", null)
        }

        findViewById<Button>(R.id.inbox_sms).setOnClickListener {
            setSmsMessages("inbox", null)
        }
        findViewById<Button>(R.id.outbox_sms).setOnClickListener {
            setSmsMessages("outbox", null)
        }
        findViewById<Button>(R.id.sent_sms).setOnClickListener {
            setSmsMessages("sent", null)
        }
        findViewById<Button>(R.id.draft_sms).setOnClickListener {
            setSmsMessages("draft", null)
        }
        findViewById<Button>(R.id.one_number_sms).setOnClickListener {
            setSmsMessages("address like '${getString(R.string.phone_number)}'", null)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == requestReadSms) setSmsMessages("", null)
    }

    private fun setSmsMessages(uriString: String, selection: String?) {
        val smsList = ArrayList<SmsData>()

        val cursor = contentResolver.query(
            Uri.parse("content://sms/$uriString"),
            null,
            selection,
            null,
            null
        )

        if (cursor != null) {

            if (cursor.moveToFirst()) {
                val nameID = cursor.getColumnIndex("address")
                val messageID = cursor.getColumnIndex("body")
                val dateID = cursor.getColumnIndex("date")

                do {
                    val dateString = cursor.getString(dateID)
                    val smsItem = SmsData(
                        cursor.getString(nameID),
                        Date(dateString.toLong()).toString(),
                        cursor.getString(messageID)
                    )
                    smsList.add(smsItem)

                } while (cursor.moveToNext())
                cursor.close()

                Log.d(TAG, "smsList.size: ${smsList.size}")
                val adapter = ListAdapter(this, smsList)

            findViewById<ListView>(R.id.sms_list_view).adapter = adapter
            }
        } else {
            Log.d(TAG, "cursor is null")
        }
    }
}