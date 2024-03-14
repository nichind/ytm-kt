package dev.toastbits.ytmapi.uistrings

import dev.toastbits.ytmapi.uistrings.localised.UILanguages
import dev.toastbits.ytmapi.uistrings.localised.getYoutubeArtistPageLocalisations
import dev.toastbits.ytmapi.uistrings.localised.getYoutubeFilterChipsLocalisations
import dev.toastbits.ytmapi.uistrings.localised.getYoutubeHomeFeedLocalisations
import dev.toastbits.ytmapi.uistrings.localised.getYoutubeOwnChannelLocalisations
import dev.toastbits.ytmapi.uistrings.localised.getYoutubeSearchPageLocalisations

object YoutubeUILocalisation {
    enum class StringID {
        ARTIST_ROW_SINGLES,
        ARTIST_ROW_SONGS,
        ARTIST_ROW_VIDEOS,
        ARTIST_ROW_ARTISTS,
        ARTIST_ROW_OTHER,

        SONG_FEED_RELAX,
        SONG_FEED_ENERGISE,
        SONG_FEED_WORKOUT,
        SONG_FEED_COMMUTE,
        SONG_FEED_FOCUS,
        SONG_FEED_PODCASTS,
        SONG_FEED_PARTY,
        SONG_FEED_ROMANCE,
        SONG_FEED_SAD,
        SONG_FEED_FEEL_GOOD,
        SONG_FEED_SLEEP
    }

    class LocalisationSet {
        val items: MutableList<Map<String, Pair<String, String?>>> = mutableListOf()
        val item_ids: MutableMap<Int, StringID> = mutableMapOf()

        fun add(vararg strings: Pair<String, String>, id: StringID? = null) {
            if (id != null) {
                item_ids[items.size] = id
            }

            items.add(mutableMapOf<String, Pair<String, String?>>().also { map ->
                for (string in strings) {
                    val existing = map[string.first]
                    if (existing != null) {
                        map[string.first] = existing.copy(second = string.second)
                    }
                    else {
                        map[string.first] = Pair(string.second, null)
                    }
                }
            })
        }
    }

    internal val HOME_FEED_STRINGS: LocalisationSet = getYoutubeHomeFeedLocalisations(UILanguages)
    internal val OWN_CHANNEL_STRINGS: LocalisationSet = getYoutubeOwnChannelLocalisations(UILanguages)
    internal val ARTIST_PAGE_STRINGS: LocalisationSet = getYoutubeArtistPageLocalisations(UILanguages)
    internal val SEARCH_PAGE_STRINGS: LocalisationSet = getYoutubeSearchPageLocalisations(UILanguages)
    internal val FILTER_CHIPS: LocalisationSet = getYoutubeFilterChipsLocalisations(UILanguages)
}
