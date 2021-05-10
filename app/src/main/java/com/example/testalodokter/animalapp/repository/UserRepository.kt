package com.example.testalodokter.animalapp.model

import com.example.testalodokter.App
import com.example.testalodokter.animalapp.model.User.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

interface InterUser {
    fun get(): User
    fun insert(data: User): Job
    fun delete()
}

class UserRepository() : InterUser {

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    init {
        App.component.inject(this)
    }

    override fun get(): User = App.database.userDAO().get()

    override fun insert(data: User): Job = scope.launch(coroutineContext) {
        App.database.userDAO().insert(data)
    }

    override fun delete() = App.database.userDAO().delete()

}
