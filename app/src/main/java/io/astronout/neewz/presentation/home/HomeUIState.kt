package io.astronout.neewz.presentation.home

import io.astronout.core.domain.model.Article
import io.astronout.core.domain.model.ViewState

data class HomeUIState(
    val articles: List<Article> = emptyList(),
    val viewState: ViewState = ViewState.Content
)
