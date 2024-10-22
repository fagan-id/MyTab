package com.example.mytab

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mytab.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityProfileBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        with(binding){
            val email = intent.getStringExtra("email")
            val username = intent.getStringExtra("username")
            val password = intent.getStringExtra("password")

            txtInputEmail.text = email
            txtInputPassword.text = password
            txtInputUsername.text = username
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.options2 -> {
                val intentToLogin = Intent(this@ProfileActivity, MainActivity::class.java)
                startActivity(intentToLogin)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}