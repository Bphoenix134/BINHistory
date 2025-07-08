package com.example.binhistory.data.mapper

import com.example.binhistory.data.api.model.CardInfoResponse
import com.example.binhistory.data.local.model.CardInfoEntity
import com.example.binhistory.domain.model.CardInfo

fun CardInfoResponse.toDomain(bin: String): CardInfo {
    return CardInfo(
        bin = bin,
        scheme = scheme,
        type = type,
        brand = brand,
        countryName = country?.name,
        latitude = country?.latitude,
        longitude = country?.longitude,
        bankName = bank?.name,
        bankUrl = bank?.url,
        bankPhone = bank?.phone,
        bankCity = bank?.city
    )
}

fun CardInfoEntity.toDomain(): CardInfo {
    return CardInfo(
        bin = bin,
        scheme = scheme,
        type = type,
        brand = brand,
        countryName = countryName,
        latitude = latitude,
        longitude = longitude,
        bankName = bankName,
        bankUrl = bankUrl,
        bankPhone = bankPhone,
        bankCity = bankCity
    )
}

fun CardInfo.toEntity(): CardInfoEntity {
    return CardInfoEntity(
        bin = bin,
        scheme = scheme,
        type = type,
        brand = brand,
        countryName = countryName,
        latitude = latitude,
        longitude = longitude,
        bankName = bankName,
        bankUrl = bankUrl,
        bankPhone = bankPhone,
        bankCity = bankCity
    )
}