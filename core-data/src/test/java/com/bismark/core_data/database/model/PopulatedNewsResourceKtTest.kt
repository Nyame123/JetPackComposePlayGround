package com.bismark.core_data.database.model

import com.bismark.core.database.model.AuthorEntity
import com.bismark.core.database.model.EpisodeEntity
import com.bismark.core.database.model.NewsResourceEntity
import com.bismark.core.database.model.PopulatedNewsResource
import com.bismark.core.database.model.TopicEntity
import com.bismark.core.database.model.asExternalModel
import com.bismark.core.model.Author
import com.bismark.core.model.NewsResource
import com.bismark.core.model.NewsResourceType
import com.bismark.core.model.Topic
import kotlinx.datetime.Instant
import org.junit.Assert.assertEquals
import org.junit.Test

class PopulatedNewsResourceKtTest {

    @Test
    fun populated_news_resource_can_be_mapped_to_news_resource() {
        val populatedNewsResource = PopulatedNewsResource(
            entity = NewsResourceEntity(
                id = "1",
                episodeId = "0",
                title = "news",
                content = "Hilt",
                url = "url",
                headerImageUrl = "headerImageUrl",
                type = NewsResourceType.Video,
                publishDate = Instant.fromEpochMilliseconds(1),
            ),
            episode = EpisodeEntity(
                id = "4",
                name = "episode 4",
                publishDate = Instant.fromEpochMilliseconds(2),
                alternateAudio = "audio",
                alternateVideo = "video",
            ),
            authors = listOf(
                AuthorEntity(
                    id = "2",
                    name = "name",
                    imageUrl = "imageUrl",
                    twitter = "twitter",
                    mediumPage = "mediumPage",
                    bio = "bio",
                )
            ),
            topics = listOf(
                TopicEntity(
                    id = "3",
                    name = "name",
                    shortDescription = "short description",
                    longDescription = "long description",
                    url = "URL",
                    imageUrl = "image URL",
                )
            ),
        )
        val newsResource = populatedNewsResource.asExternalModel()

        assertEquals(
            NewsResource(
                id = "1",
                episodeId = "0",
                title = "news",
                content = "Hilt",
                url = "url",
                headerImageUrl = "headerImageUrl",
                type = NewsResourceType.Video,
                publishDate = Instant.fromEpochMilliseconds(1),
                authors = listOf(
                    Author(
                        id = "2",
                        name = "name",
                        imageUrl = "imageUrl",
                        twitter = "twitter",
                        mediumPage = "mediumPage",
                        bio = "bio",
                    )
                ),
                topics = listOf(
                    Topic(
                        id = "3",
                        name = "name",
                        shortDescription = "short description",
                        longDescription = "long description",
                        url = "URL",
                        imageUrl = "image URL",
                    )
                )
            ),
            newsResource
        )
    }
}
