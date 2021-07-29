package com.example.cleancodepractise.data.modal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Result::class], version = 1)
abstract class ResultsDataBase : RoomDatabase() {
    abstract fun resultdDao(): ResultDao
    private class ResultDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var resultDao = database.resultdDao()
                    // Delete all content here.
                    //  resultDao.deleteAll()
                    // Add sample results.
//                    var result = Result(name ="Hello")
//                    resultDao.save(result)
//                    println( result.toString())

                }
            }
        }
    }
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ResultsDataBase? = null

        fun getDatabase(context: Context,scope: CoroutineScope): ResultsDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database]
            println("You have acces over here ")
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ResultsDataBase::class.java,
                    "result"
                ).addCallback(ResultDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }


    }
}
