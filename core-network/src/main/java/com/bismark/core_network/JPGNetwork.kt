package com.bismark.core_network

import com.bismark.core_network.model.NetworkAuthor
import com.bismark.core_network.model.NetworkChangeList
import com.bismark.core_network.model.NetworkNewsResource
import com.bismark.core_network.model.NetworkTopic

/**
 * Interface representing network calls to the JPG backend
 */
interface JPGNetwork {

    suspend fun getTopics(ids: List<String>? = null): List<NetworkTopic>

    suspend fun getAuthors(ids: List<String>? = null): List<NetworkAuthor>

    suspend fun getNewsResources(ids: List<String>? = null): List<NetworkNewsResource>

    suspend fun getTopicChangeList(after: Int? = null): List<NetworkChangeList>

    suspend fun getAuthorChangeList(after: Int? = null): List<NetworkChangeList>

    suspend fun getNewsResourceChangeList(after: Int? = null): List<NetworkChangeList>
}
