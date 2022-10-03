package com.yusril.myquran.ui.surah

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusril.myquran.data.network.ApiClient
import com.yusril.myquran.data.response.BaseResponse
import com.yusril.myquran.data.response.SurahModel
import com.yusril.myquran.utils.Resource
import kotlinx.coroutines.launch

class SurahViewModel :  ViewModel() {
    private val  mResponseListSurah =  MutableLiveData<Resource<BaseResponse<SurahModel>?>>()

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

    fun getListSurah(): MutableLiveData<Resource<BaseResponse<SurahModel>?>> {
        return mResponseListSurah
    }
}