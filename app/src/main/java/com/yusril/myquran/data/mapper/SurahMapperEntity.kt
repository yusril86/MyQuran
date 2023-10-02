package com.yusril.myquran.data.mapper

import com.yusril.myquran.data.local.entity.SurahEntity
import com.yusril.myquran.data.response.SurahModel

internal fun SurahMapperEntity(input : List<SurahModel>):List<SurahEntity> {
    return input.map {
        SurahEntity(
            it.nomorSurah.toString(),
            it.namaSurah.toString(),
            it.asma.toString(),
            it.daerahType.toString(),
            it.jumlahAyat.toString(),
            it.keteranganSurah.toString()
        )
    }
}