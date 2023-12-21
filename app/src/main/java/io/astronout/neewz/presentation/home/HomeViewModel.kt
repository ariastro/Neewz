package io.astronout.neewz.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import io.astronout.core.domain.model.ViewState
import io.astronout.core.domain.usecase.NoParams
import io.astronout.core.domain.usecase.TopHeadlineUsecase
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val topHeadlineUsecase: TopHeadlineUsecase
): ViewModel() {

    private lateinit var navigator: DestinationsNavigator

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState = _uiState.asStateFlow()

    fun onInit(navigator: DestinationsNavigator) {
        this.navigator = navigator
        getTopHeadlineArticles()
    }

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.DetailArticle -> TODO()
        }
    }

    private fun getTopHeadlineArticles() {
        topHeadlineUsecase.invoke(NoParams).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _uiState.update {
                        it.copy(viewState = ViewState.Error(result.message))
                    }
                }
                is Resource.Loading -> {
                    _uiState.update {
                        it.copy(viewState = ViewState.Loading)
                    }
                }
                is Resource.Success -> {
                    _uiState.update {
                        it.copy(articles = result.data, viewState = ViewState.Content)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

}