package com.example.databindingwithlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.databindingwithlivedata.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //lang nghe LiveData
        //Hàm lắng nghe LiveData nên được viết ở UI Thread vì chỉ
        // UI thread mới có thể update giao diện thôi các bạn nhé

        val mainViewModel = ViewModelProviders.of(this)
            .get(MainViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {
            this.setLifecycleOwner (this@MainActivity)
            this.viewmodel = mainViewModel
        }

        mainViewModel.editTextContent.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            txvChangeValueEdt.text = editText.text.toString()

            btnDisplayEdtContent.setOnClickListener {
                txvShowEdt.text = editText.text.toString()
            }
        })


    }
}
