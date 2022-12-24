package com.anish.createlivedatafromscratch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    lateinit var liveDataTextView: TextView
    lateinit var myOwnLiveDataTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        liveDataTextView = findViewById(R.id.liveDataTextView)
        myOwnLiveDataTextView = findViewById(R.id.myOwnLiveDataTextView)

        mainViewModel.dataProvider.observe(this, Observer {
            liveDataTextView.text = it.toString()
        })

        mainViewModel.myDataProvider.addObserver(this) {
            it?.run {
                myOwnLiveDataTextView.text = this.toString()
            }
        }

        mainViewModel.runCounter()
    }
}