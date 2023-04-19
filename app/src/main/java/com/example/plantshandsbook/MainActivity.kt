package com.example.plantshandsbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plantshandsbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()

    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.white,
        R.drawable.birth,
        R.drawable.flower,
        R.drawable.flower2,
        R.drawable.flower3
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                if(index > 4) index = 0
                val plant = Plant(imageIdList[index], "Plant $index")
                adapter.addPlant(plant)
                index++

            }
        }
    }
}