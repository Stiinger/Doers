package edu.ucne.doers.presentation.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Recompensas",
    foreignKeys = [ForeignKey(
        entity = Sala::class,
        parentColumns = ["salaID"],
        childColumns = ["salaID"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Recompensa(
    @PrimaryKey(autoGenerate = true)
    val recompensaID: Int = 0,
    val salaID: Int,
    val nombre: String,
    val imagenURL: String?,
    val puntosNecesarios: Int,
    val tiempoLimite: String?,
    val estado: String = "Disponible"

)
