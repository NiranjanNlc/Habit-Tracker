package com.example.cleancodepractise.viewmodal.viewmodalfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleancodepractise.data.repo.QuestionRepo
import com.example.cleancodepractise.viewmodal.QuestionViewModal
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

//
//@Singleton
//class ViewModalFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>,
//        @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
//        viewModels[modelClass]?.get() as T
//}
@Singleton
class ViewModalFactory (private val repo:QuestionRepo): ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuestionViewModal(repo) as T
    }

}