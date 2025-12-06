package com.example.flexapp.domain.shipping.model.repository

import com.example.flexapp.domain.shipping.model.local.entity.db.ShippingBusinessDao
import com.example.flexapp.data.shipping.local.entity.ShippingBusinessEntity
import com.example.flexapp.domain.shipping.model.ShippingBusiness
import com.example.flexapp.domain.shipping.repository.ShippingBusinessRepository

class ShippingBusinessRepositoryImpl(
    private val dao: ShippingBusinessDao
) : ShippingBusinessRepository {

    // CORRECCIÓN: Cambiamos 'registerBusiness' a 'registerShippingBusiness' para coincidir con la interfaz
    override suspend fun registerShippingBusiness(business: ShippingBusiness) {
        val entity = ShippingBusinessEntity(
            name = business.name,
            owner = business.owner,
            type = business.type,
            phone = business.phone
        )
        dao.insertShippingBusiness(entity)
    }

    override suspend fun registerBusiness(business: ShippingBusiness) {
        TODO("Not yet implemented")
    }

    override suspend fun getBusiness(): ShippingBusiness? {
        val entity = dao.getShippingBusiness()

        return entity?.let {
            ShippingBusiness(
                name = it.name,
                owner = it.owner,
                type = it.type,
                phone = it.phone
            )
        }
    }
}
