package com.example.flexapp.ui._.shipping.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.flexapp.data.shipping.local.db.ShippingDatabase
import com.example.flexapp.domain.shipping.model.repository.ShippingBusinessRepositoryImpl
import com.example.flexapp.databinding.ActivityShippingRegisterBusinessBinding
import com.example.flexapp.domain.shipping.model.ShippingBusiness
import com.example.flexapp.domain.shipping.model.usecase.RegisterShippingBusinessUseCase
import com.example.flexapp.ui._.view.DashboardActivity

class ShippingRegisterBusinessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShippingRegisterBusinessBinding
    private lateinit var viewModel: ShippingRegisterBusinessViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            // Inicializar ViewBinding
            binding = ActivityShippingRegisterBusinessBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // 1. Inicializar Base de Datos
            val db = Room.databaseBuilder(
                applicationContext,
                ShippingDatabase::class.java,
                "shipping_db"
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration(true)
                .build()

            // 2. Inicializar Dependencias
            val dao = db.shippingBusinessDao()
            val repo = ShippingBusinessRepositoryImpl(dao)
            val useCase = RegisterShippingBusinessUseCase(repo)

            // 3. Inicializar ViewModel usando la Factory
            val factory = ShippingViewModelFactory(useCase)
            viewModel = ViewModelProvider(this, factory)[ShippingRegisterBusinessViewModel::class.java]

            // 4. Configurar Botón
            binding.btnRegistrar.setOnClickListener {
                registrarEnvio()
            }

        } catch (e: Exception) {
            Log.e("ShippingError", "Error al iniciar: ${e.message}")
            e.printStackTrace()
        }
    }

    private fun registrarEnvio() {
        // Validación simple: Si el nombre está vacío, avisa y no hace nada
        if (binding.etName.text.isEmpty()) {
            Toast.makeText(this, "Por favor escribe el nombre del cliente", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            // Crear el objeto con los datos del formulario
            val business = ShippingBusiness(
                name = binding.etName.text.toString(),
                owner = binding.etOwner.text.toString(), // Teléfono
                type = binding.etType.text.toString(),   // Cantidad
                phone = binding.etPhone.text.toString()  // Producto
            )

            // Llamar al ViewModel para guardar
            viewModel.registerBusiness(business) {
                // Volvemos al hilo principal para mostrar cambios en pantalla
                runOnUiThread {

                    // 1. MOSTRAR EL MENSAJE QUE PEDISTE
                    Toast.makeText(this, "ENVIO REGISTRADO", Toast.LENGTH_LONG).show()

                    // 2. REGRESAR AL DASHBOARD
                    val intent = Intent(this, DashboardActivity::class.java)
                    // Estas banderas limpian las pantallas anteriores para que al volver atrás no vuelva al formulario
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)

                    // 3. CERRAR ESTA ACTIVIDAD
                    finish()
                }
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error al guardar: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}

// Factory para inyectar el UseCase al ViewModel
class ShippingViewModelFactory(private val useCase: RegisterShippingBusinessUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShippingRegisterBusinessViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ShippingRegisterBusinessViewModel(useCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
