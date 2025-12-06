package com.example.flexapp.ui._.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.flexapp.databinding.ActivityRegisterBusinessBinding
import com.example.flexapp.domain.model.Business
import com.example.flexapp.ui.business.viewmodel.BusinessViewModel

class RegisterBusinessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBusinessBinding
    private val viewModel: BusinessViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBusinessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            // Validar campos vacíos antes de enviar (Opcional pero recomendado)
            if (binding.etName.text.isNullOrEmpty() || binding.etRuc.text.isNullOrEmpty()) {
                Toast.makeText(this, "Por favor complete los campos obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val business = Business(
                name = binding.etName.text.toString(),
                type = binding.etType.text.toString(),
                phone = binding.etPhone.text.toString(),
                city = binding.etCity.text.toString(),
                address = binding.etAddress.text.toString(),
                ruc = binding.etRuc.text.toString()
            )

            viewModel.registerBusiness(business)
        }

        viewModel.isLoading.observe(this) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.message.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            // Lógica de navegación
            if (message == "Negocio registrado") {
                val intent = Intent(this, DashboardActivity::class.java)
                // Estas banderas borran el historial para que el usuario no pueda volver al registro con el botón 'Atrás'
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        }
    }
}
