package edu.ucne.doers.presentation.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.ucne.doers.presentation.data.local.entity.Padre
import edu.ucne.doers.presentation.data.local.entity.Tarea
import edu.ucne.doers.presentation.data.local.entity.Sala
import edu.ucne.doers.presentation.data.local.entity.Recompensa
import edu.ucne.doers.presentation.data.local.entity.Hijo
import edu.ucne.doers.presentation.data.local.entity.relation.Canjeo
import edu.ucne.doers.presentation.data.local.entity.relation.TareaHijo
import edu.ucne.doers.presentation.data.local.entity.Cartera
import edu.ucne.doers.presentation.data.local.entity.MovimientoCartera

@Database(
    entities = [
        Padre::class,
        Sala::class,
        Hijo::class,
        Tarea::class,
        TareaHijo::class,
        Recompensa::class,
        Canjeo::class,
        Cartera::class,
        MovimientoCartera::class
    ],
    version = 1,
    exportSchema = false
)

abstract class DoersDb : RoomDatabase(){


}