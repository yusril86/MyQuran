package com.yusril.myquran.ui.ayat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusril.myquran.data.local.entity.AyatEntity
import com.yusril.myquran.data.repositories.ayat.AyatRepository
import com.yusril.myquran.data.response.AyatModel
import com.yusril.myquran.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AyatViewModel @Inject constructor(
    private val ayatRepository: AyatRepository
) :ViewModel(){

    fun getAyat(nomorAyat:String):LiveData<Resource<List<AyatModel>>>{
        val result = MutableLiveData<Resource<List<AyatModel>>>()
        viewModelScope.launch {
            ayatRepository.getAyat(nomorAyat).collect(){
                result.postValue(it)
            }
        }
        return result
    }

    /*fun saveAyat(ayat: AyatEntity){
        viewModelScope.launch {
            ayatRepository.setAyatBookmarked(ayat, true)
        }
    }

    fun deleteAyat(ayat : AyatEntity){
        viewModelScope.launch {
            ayatRepository.setAyatBookmarked(ayat, false)
        }
    }*/
}