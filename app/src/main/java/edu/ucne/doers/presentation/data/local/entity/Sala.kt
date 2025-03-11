package edu.ucne.doers.presentation.data.local.entity
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Salas",
    foreignKeys = [ForeignKey(
        entity = Padre::class,
        parentColumns = ["padreID"],
        childColumns = ["padreID"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Sala(
    @PrimaryKey(autoGenerate = true)
    val salaID: Int = 0,
    val codigoSala: String,
    val padreID: String

)
