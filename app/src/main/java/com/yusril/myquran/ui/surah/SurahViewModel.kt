package com.yusril.myquran.ui.surah

import androidx.lifecycle.*
import com.bumptech.glide.Glide.init
import com.yusril.myquran.data.local.entity.SurahEntity
import com.yusril.myquran.data.repositories.surah.SurahRepository
import com.yusril.myquran.data.response.SurahModel
import com.yusril.myquran.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurahViewModel @Inject constructor(
    private val surahrepository: SurahRepository
) :  ViewModel() {

//    val dataFlow: Flow<Resource<List<SurahModel>>> = surahrepository.getSurah()

    /*val dataFlow: LiveData<Resource<List<SurahModel>>> = liveData {
        emitSource(surahrepository.getSurah().asLiveData())
    }*/

    val surahFetchData: LiveData<Resource<List<SurahModel>>> = liveData {
//        emit(Resource.Loading()) // Emit status loading

        // Ambil data dari Repository
        emitSource(surahrepository.getSurah().asLiveData())
    }


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

     /*fun getListSurah():LiveData<Resource<List<SurahEntity>>>{
         val result = MutableLiveData<Resource<List<SurahEntity>>>()
         viewModelScope.launch {
             surahrepository.getSurah().collect(){
                 result.postValue(it)
                 surahrepository.getSurah(it.data)
             }

         }
         return result
    }*/

   /* fun saveAllSurahToLocal(surah : List<SurahModel>):LiveData<List<SurahModel>>{
        val result = MutableLiveData<List<SurahModel>>()
        viewModelScope.launch {
            surahrepository.saveSurah(surah)
        }
        return result
    }*/
}