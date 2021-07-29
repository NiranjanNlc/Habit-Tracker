package com.example.cleancodepractise.dragger.module

import com.example.cleancodepractise.data.repo.QuestionRepo
import dagger.Module
import dagger.Provides

@Module
class RepoModule {

    @Provides
    fun provideRepo():QuestionRepo
    {
        return QuestionRepo()
    }
}