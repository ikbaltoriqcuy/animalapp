package com.example.testalodokter

import android.app.Activity
import android.app.Application
import com.example.testalodokter.animalapp.model.LocalDB
import com.example.testalodokter.animalapp.di.AppComponent
import com.example.testalodokter.animalapp.di.AppModule
import com.example.testalodokter.animalapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App: Application() , HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    companion object {
        lateinit var database: LocalDB
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        setupDagger()
        database = LocalDB.getDatabase(this)
    }

    private fun setupDagger() {
        component = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

}