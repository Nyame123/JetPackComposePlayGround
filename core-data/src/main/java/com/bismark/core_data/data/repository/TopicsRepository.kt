package com.bismark.core_data.data.repository

import com.bismark.core.model.Topic
import com.bismark.core_data.Syncable
import kotlinx.coroutines.flow.Flow

interface TopicsRepository : Syncable {

    /**
     * Gets the available topics as a stream
     */
    fun getTopicsStream(): Flow<List<Topic>>

    /**
     * Gets data for a specific topic
     */
    fun getTopic(id: String): Flow<Topic>

    /**
     * Sets the user's currently followed topics
     */
    suspend fun setFollowedTopicIds(followedTopicIds: Set<String>)

    /**
     * Toggles the user's newly followed/unfollowed topic
     */
    suspend fun toggleFollowedTopicId(followedTopicId: String, followed: Boolean)

    /**
     * Returns the users currently followed topics
     */
    fun getFollowedTopicIdsStream(): Flow<Set<String>>
}
