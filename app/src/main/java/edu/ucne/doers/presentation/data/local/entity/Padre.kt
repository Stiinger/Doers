package edu.ucne.doers.presentation.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Padres")
data class Padre(
    @PrimaryKey
    val padreID: String,
    val nombre: String,
    val telefono: String?,
    val email: String,
    val fotoPerfilUrl: String?,
    val fechaRegistro: String?

)