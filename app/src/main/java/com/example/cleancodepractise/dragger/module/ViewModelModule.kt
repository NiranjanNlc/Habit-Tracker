package com.example.cleancodepractise.dragger.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleancodepractise.viewmodal.QuestionViewModal
import com.example.cleancodepractise.viewmodal.viewmodalfactory.ViewModalFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
 abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModalFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(QuestionViewModal::class)
    abstract fun splashViewModel(viewModel: QuestionViewModal): ViewModel



}


