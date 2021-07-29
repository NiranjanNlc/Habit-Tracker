package com.example.cleancodepractise.dragger

import android.app.Application
import com.example.cleancodepractise.dragger.module.ActivityBuilder
import com.example.cleancodepractise.dragger.module.RepoModule
import com.example.cleancodepractise.dragger.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
//
//@Singleton
//@Component(
//    modules = [AndroidInjectionModule::class,AndroidSupportInjectionModule::class,RepoModule::class,ViewModelModule::class,ActivityBuilder::class]
//)
//interface AppComponent : AndroidInjector<MyApplication> {
//
////    @Component.Factory
////    interface Factory {
////        fun create(@BindsInstance application: Application): AppComponent
////    }
//    @Component.Builder
//    interface Builder {
//
//        @BindsInstance
//        fun application(application: Application): AppComponent.Builder
//
//        fun build(): AppComponent
//    }
//}
