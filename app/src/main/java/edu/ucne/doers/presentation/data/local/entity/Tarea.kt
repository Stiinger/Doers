package edu.ucne.doers.presentation.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Tareas",
    foreignKeys = [ForeignKey(
        entity = Sala::class,
        parentColumns = ["salaID"],
        childColumns = ["salaID"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Tarea(
    @PrimaryKey(autoGenerate = true)
    val tareaID: Int = 0,
    val salaID: Int,
    val nombre: String,
    val descripcion: String,
    val imagenURL: String?,
    val puntos: Int,
    val tiempoLimite: String,
    val estado: String = "Pendiente"

)
