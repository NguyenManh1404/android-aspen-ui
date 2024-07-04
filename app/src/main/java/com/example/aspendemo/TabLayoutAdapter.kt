package com.example.aspendemo
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.aspendemo.fragments.AdventureFragment
import com.example.aspendemo.fragments.FoodFragment
import com.example.aspendemo.fragments.HotelFragment
import com.example.aspendemo.fragments.LocationFragment
import com.example.aspendemo.fragments.VisitFragment

class TabLayoutAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LocationFragment();
            1 -> HotelFragment();
            2 -> FoodFragment();
            3 -> AdventureFragment();
            4 -> VisitFragment();
            else -> LocationFragment()
        }
    }
}


