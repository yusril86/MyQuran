package com.yusril.myquran.ui.surah

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusril.myquran.data.repositories.surah.SurahRepository
import com.yusril.myquran.data.response.SurahModel
import com.yusril.myquran.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurahViewModel @Inject constructor(
    private val surahrepository: SurahRepository
) :  ViewModel() {
    /*private val  listSurahEmitter =  MutableLiveData<Resource<List<SurahModel>>>()
    val surah : LiveData<Resource<List<SurahModel>>> = listSurahEmitter*/

    /*init {
        getListSurah()
    }



      private fun getListSurah(){
        viewModelScope.launch(Dispatchers.IO) {
          repository.getSurah().collect(){
              listSurahEmitter.postValue(it)
          }
        }
    }*/

     fun getListSurah():LiveData<Resource<List<SurahModel>>>{
         val result = MutableLiveData<Resource<List<SurahModel>>>()
         viewModelScope.launch {
             surahrepository.getSurah().collect(){
                 result.postValue(it)
             }
         }
         return result
    }
}