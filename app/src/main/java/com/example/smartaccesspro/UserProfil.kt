package com.example.smartaccesspro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserProfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_profil)

        // ✅ Handle insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ✅ Bottom navigation setup
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.menu.setGroupCheckable(0, true, false)
        for (i in 0 until bottomNav.menu.size()) {
            bottomNav.menu.getItem(i).isChecked = false
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                R.id.nav_rooms -> {
                    startActivity(Intent(this, PiecesActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                R.id.nav_qr -> {
                    startActivity(Intent(this, QRcode::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                R.id.nav_history -> {
                    startActivity(Intent(this, Historique::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                else -> false
            }
        }

        // ✅ Call menu item setup
        setupMenuItems()
    }

    // ✅ Setup menu icons and labels
    private fun setupMenuItems() {
        val menuItems = listOf(
            Triple(R.id.item_users, R.drawable.ic_users, "Gestion des utilisateurs"),
            Triple(R.id.item_security, R.drawable.ic_lock, "Paramètres de sécurité"),
            Triple(R.id.item_ai, R.drawable.ic_ai, "Intelligence artificielle"),
            Triple(R.id.item_reports, R.drawable.ic_analytics, "Rapports et analytics"),
            Triple(R.id.item_settings, R.drawable.ic_settings, "Paramètres"),
            Triple(R.id.item_support, R.drawable.ic_support, "Support")
        )

        for ((layoutId, iconRes, label) in menuItems) {
            val itemLayout = findViewById<View>(layoutId)
            val icon = itemLayout.findViewById<ImageView>(R.id.icon)
            val text = itemLayout.findViewById<TextView>(R.id.text)

            icon.setImageResource(iconRes)
            text.text = label

            // Optional: Handle click for each item
            itemLayout.setOnClickListener {
                // Example navigation:
                // startActivity(Intent(this, TargetActivity::class.java))
                // overridePendingTransition(0, 0)
            }
        }
    }
}
