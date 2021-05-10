package com.example.testalodokter.animalapp.model

import com.example.testalodokter.App
import com.example.testalodokter.animalapp.model.animal.Animal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

interface InterAnimal {
    fun get(): List<Animal>
    fun insert(data: List<Animal>): Job
    fun delete()
}

class AnimalRepository() : InterAnimal {

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    init {
        App.component.inject(this)
    }

    override fun get(): List<Animal> = App.database.animalDAO().get()

    override fun insert(data: List<Animal>): Job = scope.launch(coroutineContext) {
        App.database.animalDAO().insert(data)
    }

    override fun delete() = App.database.animalDAO().delete()

}
