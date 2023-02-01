package com.example.notesap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.notesap.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataViewModel: DataViewModel by viewModels()
    private val adapter by lazy { Adapter(dataViewModel) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()

        binding.save.setOnClickListener {
            dataViewModel.addData(binding.deel.text.toString())
        }

        observeState()

    }

    private fun setAdapter() {
        binding.recycler.adapter = adapter
    }

    fun observeState() {
        lifecycleScope.launch {
            dataViewModel.state.collect { list ->
                adapter.setList(list)
            }
        }


    }
}