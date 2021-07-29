package com.example.cleancodepractise.data.modal

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
abstract class ResultDao { 
        @Insert(onConflict = REPLACE)
       abstract fun save(result: Result)

        @Update
       abstract fun update(result: Result)

//        @Query("SELECT * FROM  result ")
//       abstract fun getAlphabetizedWords(): List<Result<Any>>
    }
