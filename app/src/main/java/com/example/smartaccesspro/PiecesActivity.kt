package com.example.smartaccesspro

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PiecesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pieces)
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



        val container = findViewById<LinearLayout>(R.id.roomContainer)
        for (i in 1..7) {
            val view = layoutInflater.inflate(R.layout.item_room, container, false)
            setupCardClickListeners(view)
            container.addView(view)
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_rooms

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                R.id.nav_rooms -> true
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

    private fun setupCardClickListeners(roomView: View) {
        val cards = listOf(
            Triple(
                roomView.findViewById<LinearLayout>(R.id.cardPorte),
                roomView.findViewById<TextView>(R.id.textPorte),
                roomView.findViewById<ImageView>(R.id.iconPorte)
            ),
            Triple(
                roomView.findViewById<LinearLayout>(R.id.cardFenetre),
                roomView.findViewById<TextView>(R.id.textFenetre),
                roomView.findViewById<ImageView>(R.id.iconFenetre)
            ),
            Triple(
                roomView.findViewById<LinearLayout>(R.id.cardVolet),
                roomView.findViewById<TextView>(R.id.textVolet),
                roomView.findViewById<ImageView>(R.id.iconVolet)
            )
        )

        cards.forEach { (card, text, icon) ->
            card.setOnClickListener {
                val isSelected = card.background.constantState ==
                        resources.getDrawable(R.drawable.card_selected, null).constantState

                if (isSelected) {
                    card.setBackgroundResource(R.drawable.card_unselected)
                    text.setTextColor(Color.parseColor("#444444"))
                    icon.setColorFilter(Color.parseColor("#444444"))
                } else {
                    card.setBackgroundResource(R.drawable.card_selected)
                    text.setTextColor(Color.WHITE)
                    icon.setColorFilter(Color.WHITE)
                }
            }
        }
    }
}
