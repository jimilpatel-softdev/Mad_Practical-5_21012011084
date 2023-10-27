package com.example.mad_practical_5_21012011084

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener{
            val getUrlText:EditText=findViewById(R.id.editText)
            openBrowser(getUrlText.text.toString())
        }
        findViewById<Button>(R.id.button3).setOnClickListener{
            val callText:EditText=findViewById(R.id.editText2)
            toCall(callText.text.toString())
        }
        findViewById<Button>(R.id.button4).setOnClickListener{
            opencallLog()
        }
        findViewById<Button>(R.id.button5).setOnClickListener{
            openGallery()
        }
        findViewById<Button>(R.id.button7).setOnClickListener{
            openAlarm()
        }
        findViewById<Button>(R.id.button6).setOnClickListener{
            openCamera()
        }
    }
    fun openBrowser(url: String)
    {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }
    fun toCall(no:String)
    {
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$no")).also { startActivity(it) }
    }
    fun opencallLog()
    {
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }
    fun openGallery()
    {
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
    }
    fun openAlarm()
    {
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
    }
    fun openCamera()
    {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
    }
}