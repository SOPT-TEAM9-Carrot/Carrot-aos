package com.sopt.carrot.presentation.page

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.sopt.carrot.databinding.ActivityPageBinding

class PageActivity : AppCompatActivity() {
    lateinit var binding: ActivityPageBinding
    private val viewModel: PageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPageBinding.inflate(layoutInflater)
        setView()
        observe()
    }

    private fun setView() {
        setContentView(binding.root)
        viewModel.getPageDetail(getPageIdFromHome(), logging = { str ->
            Toast.makeText(
                this,
                "error ${str}",
                Toast.LENGTH_SHORT
            ).show()
        }
        )
    }

    private fun observe() {
        viewModel.pageResponse.observe(this) { response ->
            binding.imgPageRepresentation.load(response.data.image)
            binding.tvPageBodyTitle.text = response.data.title
            binding.tvPageCoin.text = "시급 ${response.data.hourlyWage}"
            binding.tvPageBodyContent.text = response.data.content
            binding.tvPageMapDetail.text = response.data.address
        }
    }

    private fun getPageIdFromHome(): Long {
        return 1L
    }
}