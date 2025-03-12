package edu.ucne.doers.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import edu.ucne.doers.data.local.model.TipoTransaccion
import java.util.Date

@Entity(
    tableName = "TransaccionesHijo",
    foreignKeys = [ForeignKey(
        entity = Hijo::class,
        parentColumns = ["hijoID"],
        childColumns = ["hijoID"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["hijoID"])]
)
data class TransaccionesHijo(
    @PrimaryKey(autoGenerate = true) val transaccionID: Int = 0,
    val hijoId: Int,
    val tipo: TipoTransaccion,
    val monto: Int,
    val descripcion: String?,
    val fechaMovimiento: Date
)