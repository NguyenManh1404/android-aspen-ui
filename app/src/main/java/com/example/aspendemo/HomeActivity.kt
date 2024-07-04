package com.example.aspendemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.aspendemo.databinding.ActivityHomeBinding
import com.example.aspendemo.databinding.ActivityMainBinding
import com.example.aspendemo.fragments.BookingFragment
import com.example.aspendemo.fragments.DashboardFragment
import com.example.aspendemo.fragments.FavoriteFragment
import com.example.aspendemo.fragments.ProfileFragment

class HomeActivity : AppCompatActivity() {
    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        goToFragment(DashboardFragment())


        binding?.bottomNavigation?.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottomHome -> {
                    goToFragment(DashboardFragment())
                }

                R.id.bottomBooking -> {
                    goToFragment(BookingFragment())
                }

                R.id.bottomFavor -> {
                    goToFragment(FavoriteFragment())
                }
                R.id.bottomProfile -> {
                    goToFragment(ProfileFragment())
                }
            }
            true
        }

    }

    private fun goToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit()
    }

}