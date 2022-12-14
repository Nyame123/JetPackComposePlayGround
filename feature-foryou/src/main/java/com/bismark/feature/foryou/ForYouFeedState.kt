package com.bismark.feature.foryou

import com.bismark.core.model.SaveableNewsResource

/**
 * A sealed hierarchy describing the state of the feed on the for you screen.
 */
sealed interface ForYouFeedState {

    /**
     * The feed is still loading.
     */
    object Loading : ForYouFeedState

    /**
     * The feed is loaded with the given list of news resources.
     */
    data class Success(
        /**
         * The list of news resources contained in this [PopulatedFeed].
         */
        val feed: List<SaveableNewsResource>
    ) : ForYouFeedState
}
