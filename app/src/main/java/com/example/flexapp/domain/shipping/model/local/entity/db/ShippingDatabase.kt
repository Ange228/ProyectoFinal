package com.example.flexapp.data.shipping.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flexapp.data.shipping.local.entity.ShippingBusinessEntity
import com.example.flexapp.domain.shipping.model.local.entity.db.ShippingBusinessDao

@Database(entities = [ShippingBusinessEntity::class], version = 1, exportSchema = false)
abstract class ShippingDatabase : RoomDatabase() {
    abstract fun shippingBusinessDao(): ShippingBusinessDao
}
