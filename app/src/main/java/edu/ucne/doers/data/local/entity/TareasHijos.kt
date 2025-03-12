package edu.ucne.doers.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import edu.ucne.doers.data.local.model.EstadoTareaHijo
import java.util.Date

@Entity(
    tableName = "TareasHijos",
    foreignKeys = [
        ForeignKey(
            entity = Tarea::class,
            parentColumns = ["tareaID"],
            childColumns = ["tareaID"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Hijo::class,
            parentColumns = ["hijoID"],
            childColumns = ["hijoID"],
            onDelete = ForeignKey.NO_ACTION
        )
    ],
    indices = [Index(value = ["tareaID", "hijoID"])]
)
data class TareasHijos(
    @PrimaryKey(autoGenerate = true) val tareaHijoID: Int = 0,
    val tareaID: Int,
    val hijoID: Int,
    val estado: EstadoTareaHijo = EstadoTareaHijo.PENDIENTE_VERIFICACION,
    val fechaCompletada: Date,
    val fechaVerificada: Date? = null
)
