package com.yusril.myquran.ui.dashboard

import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {
   /* private val  mResponseListSurah =  MutableLiveData<Resource<BaseResponseList<SurahModel>?>>()

    fun fetchDataSurah(){
        viewModelScope.launch {
            val response = ApiClient.API_SERVICE.getListSurah()
            mResponseListSurah.postValue(Resource.Loading())
            try {

                mResponseListSurah.postValue(Resource.Success(data = response))
            }catch (e:Exception){
                mResponseListSurah.postValue(Resource.Error(errorMessage = e.toString()))
                Log.d("fetchsurah", e.localizedMessage!!)
            }
        }
    }

    fun getListSurah():MutableLiveData<Resource<BaseResponseList<SurahModel>?>>{
        return mResponseListSurah
    }*/
}