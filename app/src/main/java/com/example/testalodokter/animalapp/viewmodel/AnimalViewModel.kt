package com.example.testalodokter.animalapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testalodokter.App
import com.example.testalodokter.animalapp.base.BaseViewModel
import com.example.testalodokter.animalapp.model.animal.Animal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnimalViewModel: BaseViewModel() {

    var animalGetResponse = MutableLiveData<List<Animal>>()
    var animalInsertResponse = MutableLiveData<Boolean>()
    var animalDeleteResponse = MutableLiveData<Boolean>()

    init {
        App.component.inject(this)
    }

    fun getAnimal() {
        viewModelScope.launch(coroutineContext) {
            withContext(Dispatchers.Main) {
                animalGetResponse.value = getAnimalRepository.get()
            }
        }
    }

    fun insertAnimal(animal: List<Animal>) {
        viewModelScope.launch(coroutineContext) {
            withContext(Dispatchers.Main) {
                getAnimalRepository.insert(animal)
            }
        }
    }

    fun deleteAnimal() {
        viewModelScope.launch(coroutineContext) {
            withContext(Dispatchers.Main) {
                getAnimalRepository.delete()
            }
        }
    }
}