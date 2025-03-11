package edu.ucne.doers.presentation.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Carteras",
    foreignKeys = [ForeignKey(
        entity = Hijo::class,
        parentColumns = ["hijoID"],
        childColumns = ["hijoID"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Cartera(
    @PrimaryKey(autoGenerate = true) val carteraID: Int = 0,
    val hijoID: Int,
    val saldoActual: Int = 0

)
