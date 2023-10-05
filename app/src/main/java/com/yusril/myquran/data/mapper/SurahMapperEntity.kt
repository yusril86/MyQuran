package com.yusril.myquran.data.mapper

import com.yusril.myquran.data.local.entity.SurahEntity
import com.yusril.myquran.data.response.SurahResponse

internal fun surahMapperEntity(input : List<SurahResponse>):List<SurahEntity> {
    return input.map {
        SurahEntity(
            it.id,
            it.namaSurah.toString(),
            it.asma.toString(),
            it.daerahType.toString(),
            it.jumlahAyat.toString(),
            it.nomorSurah.toString(),
            it.keteranganSurah.toString()
        )
    }
}

internal fun surahMapperResponse(input: List<SurahEntity>):List<SurahResponse>{
    return input.map {
        SurahResponse(
            it.id,
            it.namaSurah,
            it.asma,
            it.daerahType,
            it.jumlahAyat,
            it.nomorSurah,
            it.keteranganSurah
        )
    }
}