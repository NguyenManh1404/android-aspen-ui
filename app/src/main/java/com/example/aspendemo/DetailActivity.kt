package com.example.aspendemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.example.aspendemo.databinding.ActivityDetailBinding
import com.example.aspendemo.databinding.ActivityHomeBinding

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding.imageButtonBack.setOnClickListener{
            onBackPressed()
        }
        val cardItem = intent.getParcelableExtra<CardItem>("cardItem")

        Log.d("item", cardItem.toString())
        if (cardItem != null) {
            // Use 'cardItem' here
            val drawable = ContextCompat.getDrawable(this, cardItem.imageRes)
            binding.run {
                tvTitle.text=cardItem.title
                tvRating.text = cardItem.rating.toString()
                ivCard.setImageDrawable(drawable)
                imageButtonFavorite.setImageResource(
                    if (cardItem.isFavorite) R.drawable.baseline_favorite
                    else R.drawable.baseline_favorite_border
                )

                tvReadMore.setOnClickListener {
                    if (tvDescription.maxLines == 3) {
                        // Expand the TextView to show full description
                        tvDescription.maxLines = 100
                        tvReadMore.text = "Read less"
                    } else {
                        // Collapse the TextView to show only 3 lines
                        tvDescription.maxLines = 3
                        tvReadMore.text = "Read more"
                    }
                }

// Check if the description needs to show "Read more" link
                tvDescription.post {
                    if (tvDescription.lineCount > 3) {
                        // Show "Read more" link
                        tvReadMore.visibility = View.VISIBLE
                    } else {
                        // Hide "Read more" link if not needed
                        tvReadMore.visibility = View.GONE
                    }
                }
            }

        }

    }
}