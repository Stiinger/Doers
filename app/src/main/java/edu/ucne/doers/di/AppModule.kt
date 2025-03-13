package edu.ucne.doers.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.doers.data.local.database.DoersDb
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    const val BASE_URL = ""

    //Moshi
    @Provides
    @Singleton
    fun providesMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(Adapter())
            .build()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) =
        Room.databaseBuilder(
            appContext,
            DoersDb::class.java,
            "Doers.db"
        ).fallbackToDestructiveMigration()
            .build()

    //Firebase
    @Provides
    @Singleton
    fun providesFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesHijoDao(db: DoersDb) = db.hijoDao

    @Provides
    @Singleton
    fun providesPadreDao(db: DoersDb) = db.padreDao

    @Provides
    @Singleton
    fun providesRecompensaDao(db: DoersDb) = db.recompensaDao

    @Provides
    @Singleton
    fun providesTareaDao(db: DoersDb) = db.tareaDao

    @Provides
    @Singleton
    fun providesTareaHijoDao(db: DoersDb) = db.tareaHijoDao

    @Provides
    @Singleton
    fun providesCanjeoDao(db: DoersDb) = db.canjeoDao

    @Provides
    @Singleton
    fun providesTransaccionHijoDao(db: DoersDb) = db.transaccionHijoDao

}