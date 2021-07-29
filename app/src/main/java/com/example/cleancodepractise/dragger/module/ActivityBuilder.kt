package com.example.cleancodepractise.dragger.module

import com.example.cleancodepractise.data.repo.QuestionRepo
import com.example.cleancodepractise.view.Quiz
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun provideMainActivity():Quiz

//    @Binds
//    @Singleton
//    abstract fun provideRepository(repositoryImpl: QuestionRepo): QuestionRepo
}