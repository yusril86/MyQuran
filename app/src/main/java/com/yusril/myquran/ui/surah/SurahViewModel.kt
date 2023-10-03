package com.yusril.myquran.ui.surah

import androidx.lifecycle.*
import com.yusril.myquran.data.repositories.surah.SurahRepository
import com.yusril.myquran.data.response.SurahResponse
import com.yusril.myquran.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SurahViewModel @Inject constructor(
    private val surahrepository: SurahRepository
) :  ViewModel() {


    val surahFetchData: LiveData<Resource<List<SurahResponse>>> = liveData {
        emit(Resource.Loading()) // Emit status loading

        // Ambil data dari Repository
        emitSource(surahrepository.getSurah().asLiveData())
    }

}