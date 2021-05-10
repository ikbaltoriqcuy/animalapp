package com.example.testalodokter.animalapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testalodokter.App
import com.example.testalodokter.animalapp.base.BaseViewModel
import com.example.testalodokter.animalapp.model.User.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel: BaseViewModel() {

    var userGetResponse = MutableLiveData<User>()
    var userInsertResponse = MutableLiveData<Boolean>()
    var userDeleteResponse = MutableLiveData<Boolean>()

    init {
        App.component.inject(this)
    }

    fun getUser() {
        viewModelScope.launch(coroutineContext) {
            withContext(Dispatchers.Main) {
                userGetResponse.value = getUserRepository.get()
            }
        }
    }

    fun insertUser(email: String, password: String) {
        viewModelScope.launch(coroutineContext) {
            withContext(Dispatchers.Main) {
                getUserRepository.insert(User(email,password))
            }
        }
    }

    fun deleteUser() {
        viewModelScope.launch(coroutineContext) {
            withContext(Dispatchers.Main) {
                getUserRepository.delete()
            }
        }
    }
}