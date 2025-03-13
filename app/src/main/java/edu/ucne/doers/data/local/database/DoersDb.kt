package edu.ucne.doers.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.ucne.doers.data.local.dao.CanjeoDao
import edu.ucne.doers.data.local.dao.HijoDao
import edu.ucne.doers.data.local.dao.PadreDao
import edu.ucne.doers.data.local.dao.RecompensaDao
import edu.ucne.doers.data.local.dao.TareaDao
import edu.ucne.doers.data.local.dao.TareaHijoDao
import edu.ucne.doers.data.local.dao.TransaccionHijoDao
import edu.ucne.doers.data.local.entity.HijoEntity
import edu.ucne.doers.data.local.entity.TransaccionHijoEntity
import edu.ucne.doers.data.local.entity.PadreEntity
import edu.ucne.doers.data.local.entity.RecompensaEntity
import edu.ucne.doers.data.local.entity.SalaEntity
import edu.ucne.doers.data.local.entity.TareaEntity
import edu.ucne.doers.data.local.entity.CanjeoEntity
import edu.ucne.doers.data.local.entity.TareaHijoEntity

@Database(
    entities = [
        PadreEntity::class,
        SalaEntity::class,
        HijoEntity::class,
        TareaEntity::class,
        TareaHijoEntity::class,
        RecompensaEntity::class,
        CanjeoEntity::class,
        TransaccionHijoEntity::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class DoersDb : RoomDatabase() {
    abstract val hijoDao: HijoDao
    abstract val padreDao: PadreDao
    abstract val recompensaDao: RecompensaDao
    abstract val tareaDao: TareaDao
    abstract val tareaHijoDao: TareaHijoDao
    abstract val canjeoDao: CanjeoDao
    abstract val transaccionHijoDao: TransaccionHijoDao
}