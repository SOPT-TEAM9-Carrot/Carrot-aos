package com.sopt.carrot.presentation.page

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.sopt.carrot.databinding.ActivityPageBinding
import com.sopt.carrot.presentation.profile.ProfileActivity
import com.sopt.carrot.presentation.review.ReviewActivity
import com.sopt.carrot.presentation.review.adapter.ReviewAdapter

class PageActivity : AppCompatActivity() {
    var postId: Long = 0L
    var userId: Long = 0L
    lateinit var binding: ActivityPageBinding
    private val viewModel: PageViewModel by viewModels()
    lateinit var reviewAdaptor: ReviewAdapter
    lateinit var albaAdaptor: AlbaAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPageBinding.inflate(layoutInflater)
        postId = intent.getStringExtra("postId")!!.toLong()
        userId = intent.getStringExtra("userId")!!.toLong()
        setView()
        observe()
    }

    private fun setView() {
        setContentView(binding.root)
        viewModel.getPageDetail(postId, logging = { str ->
            Toast.makeText(
                this,
                "error ${str}",
                Toast.LENGTH_SHORT
            ).show()
        })

        reviewAdaptor = ReviewAdapter()
        binding.rcPageReviews.adapter = reviewAdaptor
        viewModel.getReviews(userId) { str ->
            Toast.makeText(
                this,
                "error ${str}",
                Toast.LENGTH_SHORT
            ).show()
        }
        reviewAdaptor.setOnClick(object : ReviewAdapter.OnClickListener {
            override fun execute() {
                val goto = Intent(this@PageActivity, ReviewActivity::class.java)
                goto.putExtra("userId", userId)
                goto.putExtra("postId", postId)
                startActivity(goto)
                finish()
            }
        })
        binding.btnPageReviewMore.setOnClickListener {
            val goto = Intent(this@PageActivity, ReviewActivity::class.java)
            goto.putExtra("userId", userId)
            goto.putExtra("postId", postId)
            startActivity(goto)
            finish()
        }

        viewModel.getAlba(binding.rcPageAlbas)

        binding.btnPageApply.setOnClickListener {
            startActivity(Intent(this@PageActivity, ProfileActivity::class.java))
            finish()
        }
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

}