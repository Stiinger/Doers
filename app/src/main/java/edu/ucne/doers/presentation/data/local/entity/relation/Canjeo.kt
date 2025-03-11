package edu.ucne.doers.presentation.data.local.entity.relation

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import edu.ucne.doers.presentation.data.local.entity.Hijo
import edu.ucne.doers.presentation.data.local.entity.Recompensa

@Entity(
    tableName = "Canjeos",
    foreignKeys = [
        ForeignKey(entity = Hijo::class, parentColumns = ["hijoID"], childColumns = ["hijoID"], onDelete = ForeignKey.NO_ACTION),
        ForeignKey(entity = Recompensa::class, parentColumns = ["recompensaID"], childColumns = ["recompensaID"], onDelete = ForeignKey.CASCADE)
    ]
)
data class Canjeo(
    @PrimaryKey(autoGenerate = true) val canjeoID: Int = 0,
    val hijoID: Int,
    val recompensaID: Int,
    val fechaCanjeo: String

)
