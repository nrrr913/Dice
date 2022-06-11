package com.example.practice01

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practice01.databinding.ActivityFirstBinding
import com.example.practice01.databinding.ActivityMainBinding
import com.example.practice01.databinding.ActivitySecondBinding

class BindingMainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_first)

        binding = ActivityFirstBinding.inflate(layoutInflater)
        binding.mainButton.setOnClickListener {
            binding.mainView.setText(binding.mainEdit.text)
        }

        binding.btnToSub.setOnClickListener{
            startActivity(Intent(this,ActivitySecondBinding::class.java))

        }
    }
}