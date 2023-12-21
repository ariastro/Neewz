package io.astronout.neewz.presentation.home

import io.astronout.core.domain.model.Article

sealed class HomeScreenEvent {
    data class DetailArticle(val article: Article): HomeScreenEvent()
}
