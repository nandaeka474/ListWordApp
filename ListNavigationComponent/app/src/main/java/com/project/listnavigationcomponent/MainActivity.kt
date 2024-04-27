package com.project.listnavigationcomponent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.project.listnavigationcomponent.databinding.ActivityMainBinding
import com.project.listnavigationcomponent.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel: MainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.apply {
            isListView.observe(this@MainActivity) {
                if (it) {
                    binding.layoutBtn.setImageDrawable(
                        ContextCompat.getDrawable(
                            this@MainActivity,
                            R.drawable.ic_list
                        )
                    )
                } else {
                    binding.layoutBtn.setImageDrawable(
                        ContextCompat.getDrawable(
                            this@MainActivity,
                            R.drawable.ic_grid
                        )
                    )
                }
            }
        }

        binding.layoutBtn.setOnClickListener {
            viewModel.isListView.value?.let {
                viewModel.isListView.postValue(!it)
            }
        }
    }
}