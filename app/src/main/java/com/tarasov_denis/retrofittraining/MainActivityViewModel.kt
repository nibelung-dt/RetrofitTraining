package com.tarasov_denis.retrofittraining

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tarasov_denis.retrofittraining.User
import com.tarasov_denis.retrofittraining.UserNetwork
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    // переменные для хранения ответов с сервера:
    val myResponse: MutableLiveData<User> = MutableLiveData()
    val myResponseList: MutableLiveData<List<User>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            myResponse.value = UserNetwork.retrofit.getPost()
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            myResponseList.value = UserNetwork.retrofit.getPosts()
        }
    }
}