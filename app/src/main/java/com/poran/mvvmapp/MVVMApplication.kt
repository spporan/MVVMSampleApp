package com.poran.mvvmapp

import android.app.Application
import com.poran.mvvmapp.data.db.AppDatabase
import com.poran.mvvmapp.data.db.preferences.PreferenceProvider
import com.poran.mvvmapp.data.network.MyApi
import com.poran.mvvmapp.data.network.NetworkConnectionInterceptor
import com.poran.mvvmapp.data.repositories.QuotesRepository
import com.poran.mvvmapp.data.repositories.UserRepository
import com.poran.mvvmapp.ui.auth.AuthViewModelFactory
import com.poran.mvvmapp.ui.home.profile.ProfileViewModelFactory
import com.poran.mvvmapp.ui.home.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication:Application(),KodeinAware {

    override val kodein= Kodein.lazy {
        import(androidXModule(this@MVVMApplication))
        
        bind() from singleton {
            NetworkConnectionInterceptor(instance())
        }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(),instance()) }
        bind() from singleton { QuotesRepository(instance(),instance(),instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }

    }
}