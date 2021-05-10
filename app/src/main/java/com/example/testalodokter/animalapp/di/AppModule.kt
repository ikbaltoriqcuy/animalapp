package com.example.testalodokter.animalapp.di

import android.app.Application
import android.content.Context
import com.example.testalodokter.animalapp.model.AnimalRepository
import com.example.testalodokter.animalapp.model.UserRepository
import com.example.testalodokter.animalapp.viewmodel.AnimalViewModel
import com.example.testalodokter.animalapp.viewmodel.LoginViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule (val app: Application) {

    @Singleton
    @Provides
    fun provideApp(): Context = app

    @Provides
    fun provideAnimalViewModel(): AnimalViewModel = AnimalViewModel()

    @Provides
    fun provideLoginViewModel(): LoginViewModel = LoginViewModel()

    @Provides
    fun provideAnimalRepository() = AnimalRepository()

    @Provides
    fun provideUserRepository() = UserRepository()

}