package com.example.flexapp.model
import com.example.flexapp.model.QuoteModel

class QuoteProvider {
    companion object {

        fun random(): QuoteModel{
            val position = (0..3).random()
            return quote[position]
        }
    private val quote = listOf(
        QuoteModel(
            quote = "Gestiona tus envíos de manera simple",
            message = "Organiza pedidos diarios y mantén todo bajo control, sin complicaciones."
        ),

        QuoteModel (
            quote = "Tu negocio, siempre en movimiento",
            message ="Haz que cada envío llegue a tiempo, con confianza y claridad.."
        ),

        QuoteModel (
            quote = "Optimiza tu operación de entregas",
            message = "Planifica, registra y da seguimiento a cada pedido sin perder detalles."
        ),

        QuoteModel (
            quote = "Empieza ahora",
            message = "Una herramienta hecha para emprendedores como tú: Crecimiento real, procesos simples y control total."
        ),
    )

    }
}
