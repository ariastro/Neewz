package io.astronout.neewz.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.astronout.core.components.Gap
import io.astronout.core.components.NetworkImage
import io.astronout.core.domain.model.Article
import io.astronout.core.utils.formatDate
import io.astronout.neewz.presentation.home.HomeScreenEvent
import io.astronout.neewz.ui.theme.Neutral40
import io.astronout.neewz.ui.theme.Primary40

@Composable
fun NewsItem(
    article: Article,
    onDetailNews: (HomeScreenEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onDetailNews(HomeScreenEvent.DetailArticle(article))
            },
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        NetworkImage(
            url = article.urlToImage,
            modifier = Modifier.size(140.dp)
        )
        Column(
            modifier = Modifier.weight(1F)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black
            )
            Gap(size = 10.dp)
            Text(
                text = "By ${article.author.ifEmpty { article.source }}",
                style = MaterialTheme.typography.bodyMedium,
                color = Primary40
            )
            Gap(size = 3.dp)
            Text(
                text = article.publishedAt.formatDate(),
                style = MaterialTheme.typography.bodyMedium,
                color = Neutral40
            )
        }
    }
}