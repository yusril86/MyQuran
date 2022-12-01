package com.yusril.myquran.ui.dashboard

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusril.myquran.data.response.BaseResponse
import com.yusril.myquran.data.network.ApiClient
import com.yusril.myquran.data.response.BaseResponseList
import com.yusril.myquran.data.response.SurahModel
import com.yusril.myquran.utils.Resource
import kotlinx.coroutines.launch

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