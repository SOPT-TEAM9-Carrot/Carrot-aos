package com.sopt.carrot.presentation.review

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sopt.carrot.databinding.ActivityReviewBinding
import com.sopt.carrot.presentation.review.adapter.ReviewAdapter
import com.sopt.carrot.presentation.review.model.ReviewViewModel

class ReviewActivity : AppCompatActivity() {
    private val viewModel by viewModels<ReviewViewModel>()
    private var _binding: ActivityReviewBinding? = null
    private val binding: ActivityReviewBinding
        get() = requireNotNull(_binding) { "binding is null" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val reviewAdapter = ReviewAdapter()
        binding.rcReviewReviews.addItemDecoration(CustomItemDecoration())
        binding.rcReviewReviews.adapter = reviewAdapter

        //아이템 개수에 따라 뷰전환
        viewModel.reviews.observe(this) { reviews ->
            if (reviews.isEmpty()) {
                binding.laoutReviewViewFilpper.displayedChild =
                    binding.laoutReviewViewFilpper.indexOfChild(binding.tvReviewNoReview)
            } else {
                binding.laoutReviewViewFilpper.displayedChild =
                    binding.laoutReviewViewFilpper.indexOfChild(binding.rcReviewReviews)
                reviewAdapter.updateList(reviews)
            }
        }

        // 통신처리 예정
        viewModel.signUpResult.observe(this) { signUpResult ->
            makeToastMessage(signUpResult.message)
        }
        viewModel.errorResult.observe(this) { errorResult ->
            makeToastMessage(errorResult.message)
        }
    }

    private fun makeToastMessage(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }
}