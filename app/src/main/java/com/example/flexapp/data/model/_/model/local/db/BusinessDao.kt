package com.example.flexapp.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flexapp.domain.model.Business

@Dao
interface BusinessDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBusiness(business: Business)

    @Query("SELECT * FROM business LIMIT 1")
    suspend fun getBusiness(): Business?
}