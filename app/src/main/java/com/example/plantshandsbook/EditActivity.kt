package com.example.plantshandsbook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.plantshandsbook.databinding.ActivityMainBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var indexImage = 0
    private var imageId = R.drawable.white
    private val imageIdList = listOf(
        R.drawable.white,
        R.drawable.birth,
        R.drawable.flower,
        R.drawable.flower2,
        R.drawable.flower3,
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initButtons() = with(binding){
        bNext.setOnClickListener {
            indexImage++
            if(indexImage > imageIdList.size - 1) indexImage = 0
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)
        }
        bDone.setOnClickListener {
            val plant = Plant(imageId, edTitle.text.toString(), edDesc.text.toString())
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}