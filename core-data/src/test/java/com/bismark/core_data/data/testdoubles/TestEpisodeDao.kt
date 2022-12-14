package com.bismark.core_data.data.testdoubles

import com.bismark.core.database.dao.EpisodeDao
import com.bismark.core.database.model.EpisodeEntity
import com.bismark.core.database.model.PopulatedEpisode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.datetime.Instant

/**
 * Test double for [EpisodeDao]
 */
class TestEpisodeDao : EpisodeDao {

    private var entitiesStateFlow = MutableStateFlow(
        listOf(
            EpisodeEntity(
                id = "1",
                name = "Episode",
                publishDate = Instant.fromEpochMilliseconds(0),
                alternateVideo = null,
                alternateAudio = null,
            )
        )
    )

    override fun getEpisodesStream(): Flow<List<PopulatedEpisode>> =
        entitiesStateFlow.map {
            it.map(EpisodeEntity::asPopulatedEpisode)
        }

    override suspend fun insertOrIgnoreEpisodes(episodeEntities: List<EpisodeEntity>): List<Long> {
        entitiesStateFlow.value = episodeEntities
        // Assume no conflicts on insert
        return episodeEntities.map { it.id.toLong() }
    }

    override suspend fun updateEpisodes(entities: List<EpisodeEntity>) {
        throw NotImplementedError("Unused in tests")
    }

    override suspend fun deleteEpisodes(ids: List<String>) {
        val idSet = ids.toSet()
        entitiesStateFlow.update { entities ->
            entities.filterNot { idSet.contains(it.id) }
        }
    }
}

private fun EpisodeEntity.asPopulatedEpisode() = PopulatedEpisode(
    entity = this,
    newsResources = emptyList(),
    authors = emptyList(),
)
