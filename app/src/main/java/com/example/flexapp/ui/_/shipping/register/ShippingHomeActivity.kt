package com.example.flexapp.ui._.shipping.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flexapp.databinding.ActivityShippingHomeBinding
import com.example.flexapp.ui.shipping.home.CreateShippingOrderActivity
import com.example.flexapp.ui.shipping.home.OrdersHistoryActivity

class ShippingHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShippingHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShippingHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ir a PROGRAMAR ENVÍO
        binding.btnProgramarEnvio.setOnClickListener {
            startActivity(Intent(this, CreateShippingOrderActivity::class.java))
        }

        // Ir al HISTORIAL
        binding.btnVerHistorial.setOnClickListener {
            startActivity(Intent(this, OrdersHistoryActivity::class.java))
        }
    }
}
