package com.uiel.data.api

object DeraUrl {
    private const val user = "/user"
    private const val feed = "/feed"
    private const val notification = "/notification"
    private const val like = "/like"

    object User {
        const val SignIn = "$user/token"
        const val SignUp = "$user/"
    }

    object Feed {
        const val CreateFeed = "$feed/"
        const val SearchFeed = "$feed/{feed_id}"
    }

    object Notification {
        const val SaveToken = "$notification/"
        const val SearchAlarmList = "$notification/"
    }

    object Like {
        const val Like = like
    }
}