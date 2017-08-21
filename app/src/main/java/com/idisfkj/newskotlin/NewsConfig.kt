package com.idisfkj.newskotlin

/**
 * Created by idisfkj on 2017/8/15.
 * Email : idisfkj@gmail.com.
 */
class NewsConfig {
    companion object {
        val API_BASE = "https://newsapi.org/v1/"
        val API_KEY = "apiKey"
        val API_KEY_VALUE = "6d3ea7fa6d8e4fdfa663b9e7f00fd408"
        val REQUEST_SOURCE = "source"
        val REQUEST_SORT_BY = "sort_by"
        val DEFAULT_TITLE = "News"
        val CATEGORY = "category"
        var UPDATE_ADAPTER = false
        val DEFAULT_CATEGORY_STRING = "al-jazeera-english#ars-technica#associated-press#bbc-news#bbc-sport#bloomberg"
        var DEFAULT_CATEGORY = mutableListOf<String>()
        val SUBSCRIBE_IMAGE_URL = mutableMapOf(
                "abc-news-au" to "http://mobile.abc.net.au/cm/cb/4355924/News+iOS+120x120/data.png",
                "ars-technica" to "https://icons.better-idea.org/icon?url=http://arstechnica.com&size=70..120..200",
                "bbc-news" to "https://icons.better-idea.org/icon?url=http://www.bbc.co.uk/news&size=70..120..200",
                "bild" to "https://icons.better-idea.org/icon?url=http://www.bild.de&size=70..120..200",
                "breitbart-news" to "https://icons.better-idea.org/icon?url=http://www.breitbart.com&size=70..120..200",
                "business-insider-uk" to "https://icons.better-idea.org/icon?url=http://uk.businessinsider.com&size=70..120..200",
                "cnbc" to "https://icons.better-idea.org/icon?url=http://www.cnbc.com&size=70..120..200",
                "daily-mail" to "https://icons.better-idea.org/icon?url=http://www.dailymail.co.uk/home/index.html&size=70..120..200",
                "die-zeit" to "https://icons.better-idea.org/icon?url=http://www.zeit.de/index&size=70..120..200",
                "entertainment-weekly" to "https://icons.better-idea.org/icon?url=http://www.ew.com&size=70..120..200",
                "espn-cric-info" to "https://icons.better-idea.org/icon?url=http://www.espncricinfo.com/&size=70..120..200",
                "focus" to "https://icons.better-idea.org/icon?url=http://www.focus.de&size=70..120..200",
                "fortune" to "https://icons.better-idea.org/icon?url=http://fortune.com&size=70..120..200",
                "fox-sports" to "https://icons.better-idea.org/icon?url=http://www.foxsports.com&size=70..120..200",
                "gruenderszene" to "https://icons.better-idea.org/icon?url=http://www.gruenderszene.de&size=70..120..200",
                "handelsblatt" to "https://icons.better-idea.org/icon?url=http://www.handelsblatt.com&size=70..120..200",
                "independent" to "https://icons.better-idea.org/icon?url=http://www.independent.co.uk&size=70..120..200",
                "metro" to "https://icons.better-idea.org/icon?url=http://metro.co.uk&size=70..120..200",
                "mtv-news" to "https://icons.better-idea.org/icon?url=http://www.mtv.com/news&size=70..120..200",
                "national-geographic" to "https://icons.better-idea.org/icon?url=http://news.nationalgeographic.com&size=70..120..200",
                "newsweek" to "https://icons.better-idea.org/icon?url=http://www.newsweek.com&size=70..120..200",
                "nfl-news" to "https://icons.better-idea.org/icon?url=http://www.nfl.com/news&size=70..120..200",
                "recode" to "https://icons.better-idea.org/icon?url=http://www.recode.net&size=70..120..200",
                "reuters" to "https://icons.better-idea.org/icon?url=http://www.reuters.com&size=70..120..200",
                "t3n" to "https://icons.better-idea.org/icon?url=http://t3n.de&size=70..120..200",
                "techcrunch" to "https://icons.better-idea.org/icon?url=https://techcrunch.com&size=70..120..200",
                "the-economist" to "https://icons.better-idea.org/icon?url=http://www.economist.com&size=70..120..200",
                "the-guardian-uk" to "https://icons.better-idea.org/icon?url=https://www.theguardian.com/uk&size=70..120..200",
                "the-huffington-post" to "https://icons.better-idea.org/icon?url=http://www.huffingtonpost.com&size=70..120..200",
                "the-new-york-times" to "https://icons.better-idea.org/icon?url=http://www.nytimes.com&size=70..120..200",
                "the-sport-bible" to "https://icons.better-idea.org/icon?url=http://www.thesportbible.com&size=70..120..200",
                "the-time-of-india" to "https://icons.better-idea.org/icon?url=http://timesofindia.indiatimes.com&size=70..120..200",
                "the-wall-street-journal" to "https://icons.better-idea.org/icon?url=http://www.wsj.com&size=70..120..200",
                "time" to "https://icons.better-idea.org/icon?url=http://time.com&size=70..120..200",
                "wired-de" to "https://icons.better-idea.org/icon?url=https://www.wired.de&size=70..120..200",
                "al-jazeera-english" to "https://icons.better-idea.org/icon?url=http://www.aljazeera.com&size=70..120..200",
                "associated-press" to "https://icons.better-idea.org/icon?url=https://apnews.com/&size=70..120..200",
                "bbc-sport" to "https://icons.better-idea.org/icon?url=http://www.bbc.co.uk/sport&size=70..120..200",
                "bloomberg" to "https://icons.better-idea.org/icon?url=http://www.bloomberg.com&size=70..120..200",
                "business-insider" to "https://icons.better-idea.org/icon?url=http://www.businessinsider.com&size=70..120..200",
                "buzzfeed" to "https://icons.better-idea.org/icon?url=https://www.buzzfeed.com&size=70..120..200",
                "cnn" to "https://icons.better-idea.org/icon?url=http://us.cnn.com&size=70..120..200",
                "der-tagesspiegel" to "https://icons.better-idea.org/icon?url=http://www.tagesspiegel.de&size=70..120..200",
                "engadget" to "https://icons.better-idea.org/icon?url=https://www.engadget.com&size=70..120..200",
                "espn" to "https://icons.better-idea.org/icon?url=http://espn.go.com&size=70..120..200",
                "financial-times" to "https://icons.better-idea.org/icon?url=http://www.ft.com/home/uk&size=70..120..200",
                "football-italia" to "https://icons.better-idea.org/icon?url=http://www.football-italia.net&size=70..120..200",
                "four-four-two" to "https://icons.better-idea.org/icon?url=http://www.fourfourtwo.com/news&size=70..120..200",
                "google-news" to "https://icons.better-idea.org/icon?url=https://news.google.com&size=70..120..200",
                "hacker-news" to "https://icons.better-idea.org/icon?url=https://news.ycombinator.com&size=70..120..200",
                "ign" to "https://icons.better-idea.org/icon?url=http://www.ign.com&size=70..120..200",
                "mashable" to "https://icons.better-idea.org/icon?url=http://mashable.com&size=70..120..200",
                "mirror" to "https://icons.better-idea.org/icon?url=http://www.mirror.co.uk/&size=70..120..200",
                "mtv-news-uk" to "https://icons.better-idea.org/icon?url=http://www.mtv.co.uk/news&size=70..120..200",
                "new-scientist" to "https://icons.better-idea.org/icon?url=https://www.newscientist.com/section/news&size=70..120..200",
                "new-york-magazine" to "https://icons.better-idea.org/icon?url=http://nymag.com&size=70..120..200",
                "polygon" to "https://icons.better-idea.org/icon?url=http://www.polygon.com&size=70..120..200",
                "reddit-r-all" to "https://icons.better-idea.org/icon?url=https://www.reddit.com/r/all&size=70..120..200",
                "spiegel-online" to "https://icons.better-idea.org/icon?url=http://www.spiegel.de&size=70..120..200",
                "talksport" to "https://icons.better-idea.org/icon?url=http://talksport.com&size=70..120..200",
                "techradar" to "https://icons.better-idea.org/icon?url=http://www.techradar.com&size=70..120..200",
                "the-guardian-au" to "https://icons.better-idea.org/icon?url=https://www.theguardian.com/au&size=70..120..200",
                "the-lad-bible" to "https://icons.better-idea.org/icon?url=http://www.thehindu.com&size=70..120..200",
                "the-next-web" to "https://icons.better-idea.org/icon?url=http://thenextweb.com&size=70..120..200",
                "the-telegraph" to "https://icons.better-idea.org/icon?url=http://www.telegraph.co.uk&size=70..120..200",
                "the-verge" to "https://icons.better-idea.org/icon?url=http://www.theverge.com&size=70..120..200",
                "the-washington-post" to "https://icons.better-idea.org/icon?url=https://www.washingtonpost.com&size=70..120..200",
                "usa-today" to "https://icons.better-idea.org/icon?url=http://www.usatoday.com/news&size=70..120..200",
                "wirtschafts-woche" to "https://icons.better-idea.org/icon?url=http://www.wiwo.de&size=70..120..200"
        )
    }

    enum class SortBy(val sort: String) {
        TOP("top"), LATEST("latest"), POPULAR("popular")
    }
}