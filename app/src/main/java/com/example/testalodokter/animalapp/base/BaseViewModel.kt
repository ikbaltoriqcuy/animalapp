package com.example.testalodokter.animalapp.base

import androidx.lifecycle.ViewModel
import com.example.testalodokter.animalapp.model.AnimalRepository
import com.example.testalodokter.animalapp.model.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject

abstract class BaseViewModel: ViewModel() {

    @Inject
    lateinit var getUserRepository: UserRepository
    @Inject
    lateinit var getAnimalRepository: AnimalRepository

    private val coroutineJob = SupervisorJob()
    val coroutineContext = Dispatchers.IO + coroutineJob
}