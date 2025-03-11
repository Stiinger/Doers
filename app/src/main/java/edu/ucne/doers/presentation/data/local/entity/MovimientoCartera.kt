package edu.ucne.doers.presentation.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "MovimientosCartera",
    foreignKeys = [ForeignKey(
        entity = Cartera::class,
        parentColumns = ["carteraID"],
        childColumns = ["carteraID"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class MovimientoCartera(
    @PrimaryKey(autoGenerate = true) val movimientoID: Int = 0,
    val carteraID: Int,
    val tipo: String, // "Ganado" o "Gastado"
    val monto: Int,
    val descripcion: String?,
    val fechaMovimiento: String


)