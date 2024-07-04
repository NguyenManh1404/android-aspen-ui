package com.example.aspendemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aspendemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.btnExplore?.setOnClickListener {
            // Toast.makeText(this@MainActivity, "Its a toast!", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, HomeActivity::class.java).apply {
                // you can add values(if any) to pass to the next class or avoid using `.apply`
                putExtra("keyIdentifier", "Home")
            })
        }
    }
}