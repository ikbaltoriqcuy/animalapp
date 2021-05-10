package com.example.testalodokter.animalapp.di

import android.app.Application
import com.example.testalodokter.animalapp.model.AnimalRepository
import com.example.testalodokter.animalapp.model.UserRepository
import com.example.testalodokter.animalapp.viewmodel.AnimalViewModel
import com.example.testalodokter.animalapp.viewmodel.LoginViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: Application)
    fun inject(userRepository: UserRepository)
    fun inject(animalRepository: AnimalRepository)

    fun inject(animalViewModel: AnimalViewModel)
    fun inject(loginViewModel: LoginViewModel)
}