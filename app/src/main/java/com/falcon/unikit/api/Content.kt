package com.falcon.unikit.api

data class Content (
    val contentName: String? = null,
    val contentType: String? = null,      // Example notes, papers etc
    val author: String? = null,
    val contentId: String? = null,
    val likeCount: String? = null,
    val dislikeCount: String? = null,
    val subjectID: String? = null
)