package com.example.smartaccesspro

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    @SuppressLint("UseKtx")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        val mainLayout = findViewById<View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { view, insets ->
            val topInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top
            view.setPadding(0, topInset, 0, 0)
            insets
        }

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



        setupToggleCard(
            cardId = R.id.urgenceCard,
            iconId = R.id.urgence_ic,
            titleId = R.id.urgence_title,
            descId = R.id.urgence_description,
            activeColor = R.color.soft_red,
            inactiveColor = R.color.coral_red
        )

        setupToggleCard(
            cardId = R.id.SecuriteCard,
            iconId = R.id.securite_ic,
            titleId = R.id.securite_title,
            descId = R.id.securite_description,
            activeColor = R.color.cyan_blue,
            inactiveColor = R.color.cyan_blue
        )

        setupToggleCard(
            cardId = R.id.nuitCard,
            iconId = R.id.nuit_ic,
            titleId = R.id.nuit_title,
            descId = R.id.nuit_description,
            activeColor = R.color.deep_blue,
            inactiveColor = R.color.dark_gray
        )

        setupToggleCard(
            cardId = R.id.vacancesCard,
            iconId = R.id.vacances_ic,
            titleId = R.id.vacances_title,
            descId = R.id.vacances_description,
            activeColor = R.color.orange_accent,
            inactiveColor = R.color.dark_gray
        )

        // ✅ Bottom Navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_home

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true // Already here
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
    }

    private fun setupToggleCard(
        cardId: Int,
        iconId: Int,
        titleId: Int,
        descId: Int,
        activeColor: Int,
        inactiveColor: Int
    ) {
        val card = findViewById<CardView>(cardId)
        val icon = findViewById<ImageView>(iconId)
        val title = card.findViewById<TextView>(titleId)
        val subtitle = card.findViewById<TextView>(descId)
        var isActive = false

        card.setOnClickListener {
            if (isActive) {
                card.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white))
                title.setTextColor(ContextCompat.getColor(this, inactiveColor))
                subtitle.setTextColor(ContextCompat.getColor(this, inactiveColor))
                icon.setColorFilter(ContextCompat.getColor(this, inactiveColor), PorterDuff.Mode.SRC_IN)
            } else {
                card.setCardBackgroundColor(ContextCompat.getColor(this, activeColor))
                title.setTextColor(ContextCompat.getColor(this, R.color.white))
                subtitle.setTextColor(ContextCompat.getColor(this, R.color.white))
                icon.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN)
            }
            isActive = !isActive
        }
    }
}
