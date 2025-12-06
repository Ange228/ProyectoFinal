package com.example.flexapp.domain.shipping.model.local.entity.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flexapp.data.shipping.local.entity.ShippingBusinessEntity

@Dao
interface ShippingBusinessDao {    @Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertShippingBusiness(business: ShippingBusinessEntity)

    @Query("SELECT * FROM shipping_business LIMIT 1")
    suspend fun getShippingBusiness(): ShippingBusinessEntity?
}

