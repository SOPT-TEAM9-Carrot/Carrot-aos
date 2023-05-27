package com.sopt.carrot.presentation.page

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.sopt.carrot.databinding.ActivityPageBinding
import com.sopt.carrot.presentation.review.adapter.ReviewAdapter

class PageActivity : AppCompatActivity() {
    lateinit var binding: ActivityPageBinding
    private val viewModel: PageViewModel by viewModels()
    lateinit var reviewAdaptor: ReviewAdapter
    lateinit var albaAdaptor: AlbaAdaptor

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
        })

        reviewAdaptor = ReviewAdapter()
        binding.rcPageReviews.adapter = reviewAdaptor
        viewModel.getReviews { str ->
            Toast.makeText(
                this,
                "error ${str}",
                Toast.LENGTH_SHORT
            ).show()
        }

        viewModel.getAlba(binding.rcPageAlbas)
    }

    private fun observe() {
        viewModel.pageResponse.observe(this) { response ->
            binding.imgPageRepresentation.load(response.data.image)
            binding.tvPageBodyTitle.text = response.data.title
            binding.tvPageCoin.text = "시급 ${response.data.hourlyWage}"
            binding.tvPageBodyContent.text = response.data.content
            binding.tvPageMapDetail.text = response.data.address
        }
        viewModel.reviews.observe(this) { response ->
            if (response.size > 3) {
                reviewAdaptor.updateList(response.slice(0..2))
            } else {
                reviewAdaptor.updateList(response)
            }
        }
    }

    private fun getPageIdFromHome(): Long {
        return 1L
    }
}