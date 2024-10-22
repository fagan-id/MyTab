package com.example.mytab

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mytab.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDashboardBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val email = intent.getStringExtra("email")
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")
        return when (item.itemId) {
            R.id.options1 -> {
                val intentToProfile = Intent(this@DashboardActivity, ProfileActivity::class.java)
                intentToProfile.putExtra("email",email)
                intentToProfile.putExtra("username",username)
                intentToProfile.putExtra("password",password)
                startActivity(intentToProfile)
                true
            }

            R.id.options2 -> {
                val intentToLogin = Intent(this@DashboardActivity, MainActivity::class.java)
                startActivity(intentToLogin)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}