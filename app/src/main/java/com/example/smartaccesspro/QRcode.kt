package com.example.smartaccesspro

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class QRcode : AppCompatActivity() {

    @SuppressLint("UseKtx")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_qrcode)
        enableEdgeToEdge()



        val profileIcon = findViewById<ImageView>(R.id.profilButton)

        profileIcon.setOnClickListener {
            val intent = Intent(this, UserProfil::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }


        val notificationIcon = findViewById<ImageView>(R.id.notificationButton)

        notificationIcon.setOnClickListener {
            val intent = Intent(this, Historique::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }


        // ✅ Bottom Navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_qr

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0, 0) // 🔄 Disable animation
                    finish()
                    true
                }

                R.id.nav_rooms -> {
                    startActivity(Intent(this, PiecesActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                R.id.nav_qr -> true // Already here
                R.id.nav_history -> {
                    startActivity(Intent(this, Historique::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                else -> false
            }
        }
    }

}
