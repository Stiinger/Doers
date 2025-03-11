package edu.ucne.doers.presentation.data.local.entity.relation

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import edu.ucne.doers.presentation.data.local.entity.Hijo
import edu.ucne.doers.presentation.data.local.entity.Tarea

@Entity(
    tableName = "TareasHijos",
    foreignKeys = [
        ForeignKey(entity = Tarea::class, parentColumns = ["tareaID"], childColumns = ["tareaID"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Hijo::class, parentColumns = ["hijoID"], childColumns = ["hijoID"], onDelete = ForeignKey.NO_ACTION)
    ]
)
data class TareaHijo(
    @PrimaryKey(autoGenerate = true)
    val tareaHijoID: Int = 0,
    val tareaID: Int,
    val hijoID: Int,
    val estado: String = "Aceptada",
    val fechaAceptada: String,
    val fechaCompletada: String?

)
