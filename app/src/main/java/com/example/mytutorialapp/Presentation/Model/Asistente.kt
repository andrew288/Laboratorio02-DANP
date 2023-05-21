package com.example.mytutorialapp.Presentation.Model

import java.time.LocalDate

data class Asistente(
    var nombre:String = "",
    var apellido:String = "",
    var fechaInscripcion: String = "",
    var tipoSangre: String = "",
    var telefono: String = "",
    var correo: String = "",
    var montoPagado: Double = 0.0
)
