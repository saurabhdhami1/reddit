package com.example.demo.reddit.data.remote.models

import com.google.gson.annotations.SerializedName

data class PostData(
    var userFlairBackgroundColor: Any? = null,
    var submitTextHtml: String? = "",
    var restrictPosting: Boolean? = null,
    var userIsBanned: Boolean? = null,
    var freeFormReports: Boolean? = null,
    var wikiEnabled: Boolean? = null,
    var userIsMuted: Boolean? = null,
    var userCanFlairInSr: Any? = null,
    @SerializedName("display_name")
    var displayName: String? = "",
    @SerializedName("header_img")
    var headerImg: String? = "",
    var iconSize: List<Int>? = null,
    var primaryColor: String? = "",
    var activeUserCount: Any? = null,
    @SerializedName("icon_img")
    var iconImg: String? = "",
    var displayNamePrefixed: String? = "",
    var accountsActive: Any? = null,
    var publicTraffic: Boolean? = null,
    var subscribers: Int? = null,
    var userFlairRichtext: List<Any>? = null,
    var hideAds: Boolean? = null,
    var emojisEnabled: Boolean? = null,
    var advertiserCategory: String? = "",
    @SerializedName("public_description")
    var publicDescription: String? = "",
    var commentScoreHideMins: Int? = null,
    @SerializedName("user_has_favorited")
    var userHasFavorited: Boolean? = false,
    var userFlairTemplateId: Any? = null,
    var communityIcon: String? = "",
    var bannerBackgroundImage: String? = "",
    var originalContentTagEnabled: Boolean? = null,
    @SerializedName("submit_text")
    var submitText: String? = "",
    var descriptionHtml: String? = "",
    var spoilersEnabled: Boolean? = null,
    @SerializedName("header_title")
    var headerTitle: String? = null,
    var headerSize: List<Int>? = null,
    var userFlairPosition: String? = null,
    var allOriginalContent: Boolean? = null,
    var hasMenuWidget: Boolean? = null,
    var isEnrolledInNewModmail: Any? = null,
    var keyColor: String? = null,
    var canAssignUserFlair: Boolean? = null,
    var showMediaPreview: Boolean? = null,
    var submissionType: String? = null,
    var userIsSubscriber: Boolean? = null,
    var disableContributorRequests: Boolean? = null,
    var allowVideogifs: Boolean? = null,
    var userFlairType: String? = null,
    var collapseDeletedComments: Boolean? = null,
    var emojisCustomSize: Any? = null,
    var publicDescriptionHtml: String? = null,
    var allowVideos: Boolean? = null,
    var isCrosspostableSubreddit: Any? = null,
    var suggestedCommentSort: Any? = null,
    var canAssignLinkFlair: Boolean? = null,
    var accountsActiveIsFuzzed: Boolean? = null,
    var submitTextLabel: String? = null,
    var linkFlairPosition: String? = null,
    var userSrFlairEnabled: Any? = null,
    var userFlairEnabledInSr: Boolean? = null,
    var allowDiscovery: Boolean? = null,
    var userSrThemeEnabled: Boolean? = null,
    var linkFlairEnabled: Boolean? = null,
    var notificationLevel: Any? = null,
    @SerializedName("banner_img")
    var bannerImg: String? = "",
    var userFlairText: Any? = null,
    var bannerBackgroundColor: String? = "",
    var showMedia: Boolean? = null,
    var userIsContributor: Boolean? = null,
    var description: String? = null,
    var submitLinkLabel: String? = null,
    var userFlairTextColor: Any? = null,
    var restrictCommenting: Boolean? = null,
    var userFlairCssClass: Any? = null,
    var allowImages: Boolean? = null,
    var lang: String? = null,
    var bannerSize: List<Int>? = null,
    var mobileBannerImage: String? = null,
    var userIsModerator: Boolean? = null,
    @SerializedName("title")
    var title: String = "",
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("quarantine")
    var quarantine: Boolean? = null,
    @SerializedName("created")
    var created: Int? = null,
    @SerializedName("wls")
    var wls: Int? = null,
    @SerializedName("subreddit_type")
    var subredditType: String? = null,
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("whitelist_status")
    var whitelistStatus: String? = null,
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("created_utc")
    var createdUtc: Int? = null,
    @SerializedName("approved_at_utc")
    var approvedAtUtc: Any? = null,
    @SerializedName("subreddit")
    var subreddit: String? = null,
    @SerializedName("selftext")
    var selftext: String? = null,
    @SerializedName("author_fullname")
    var authorFullname: String? = null,
    @SerializedName("saved")
    var saved: Boolean? = null,
    @SerializedName("mod_reason_title")
    var modReasonTitle: Any? = null,
    @SerializedName("gilded")
    var gilded: Int? = null,
    @SerializedName("clicked")
    var clicked: Boolean? = null,
    @SerializedName("link_flair_richtext")
    var linkFlairRichtext: List<Any>? = null,
    @SerializedName("subreddit_name_prefixed")
    var subredditNamePrefixed: String? = null,
    @SerializedName("hidden")
    var hidden: Boolean? = null,
    @SerializedName("pwls")
    var pwls: Int? = null,
    @SerializedName("link_flair_css_class")
    var linkFlairCssClass: String? = null,
    @SerializedName("downs")
    var downs: Int? = null,
    @SerializedName("hide_score")
    var hideScore: Boolean? = null,
    @SerializedName("link_flair_text_color")
    var linkFlairTextColor: String? = null,
    @SerializedName("author_flair_background_color")
    var authorFlairBackgroundColor: Any? = null,
    @SerializedName("ups")
    var ups: Int? = null,
    @SerializedName("total_awards_received")
    var totalAwardsReceived: Int? = null,
    @SerializedName("author_flair_template_id")
    var authorFlairTemplateId: Any? = null,
    @SerializedName("is_original_content")
    var isOriginalContent: Boolean? = null,
    @SerializedName("user_reports")
    var userReports: List<Any>? = null,
    @SerializedName("secure_media")
    var secureMedia: Any? = null,
    @SerializedName("is_reddit_media_domain")
    var isRedditMediaDomain: Boolean? = null,
    @SerializedName("is_meta")
    var isMeta: Boolean? = null,
    @SerializedName("category")
    var category: Any? = null,
    @SerializedName("link_flair_text")
    var linkFlairText: String? = null,
    @SerializedName("can_mod_post")
    var canModPost: Boolean? = null,
    @SerializedName("score")
    var score: Int = 0,
    @SerializedName("approved_by")
    var approvedBy: Any? = null,
    @SerializedName("author_premium")
    var authorPremium: Boolean? = null,
    @SerializedName("thumbnail")
    var thumbnail: String? = null,
    @SerializedName("edited")
    var edited: Boolean? = null,
    @SerializedName("author_flair_css_class")
    var authorFlairCssClass: Any? = null,
    @SerializedName("steward_reports")
    var stewardReports: List<Any>? = null,
    @SerializedName("author_flair_richtext")
    var authorFlairRichtext: List<Any>? = null,
    @SerializedName("content_categories")
    var contentCategories: Any? = null,
    @SerializedName("is_self")
    var isSelf: Boolean? = null,
    @SerializedName("mod_note")
    var modNote: Any? = null,
    @SerializedName("link_flair_type")
    var linkFlairType: String? = null,
    @SerializedName("removed_by_category")
    var removedByCategory: Any? = null,
    @SerializedName("banned_by")
    var bannedBy: Any? = null,
    @SerializedName("author_flair_type")
    var authorFlairType: String? = null,
    @SerializedName("domain")
    var domain: String? = null,
    @SerializedName("allow_live_comments")
    var allowLiveComments: Boolean? = null,
    @SerializedName("selftext_html")
    var selftextHtml: String? = null,
    @SerializedName("likes")
    var likes: Any? = null,
    @SerializedName("suggested_sort")
    var suggestedSort: String? = null,
    @SerializedName("banned_at_utc")
    var bannedAtUtc: Any? = null,
    @SerializedName("view_count")
    var viewCount: Any? = null,
    @SerializedName("archived")
    var archived: Boolean? = null,
    @SerializedName("no_follow")
    var noFollow: Boolean? = null,
    @SerializedName("is_crosspostable")
    var isCrosspostable: Boolean? = null,
    @SerializedName("pinned")
    var pinned: Boolean? = null,
    @SerializedName("over_18")
    var over18: Boolean? = null,
    @SerializedName("all_awardings")
    var allAwardings: List<Any>? = null,
    @SerializedName("awarders")
    var awarders: List<Any>? = null,
    @SerializedName("media_only")
    var mediaOnly: Boolean? = null,
    @SerializedName("can_gild")
    var canGild: Boolean? = null,
    @SerializedName("spoiler")
    var spoiler: Boolean? = null,
    @SerializedName("locked")
    var locked: Boolean? = null,
    @SerializedName("author_flair_text")
    var authorFlairText: Any? = null,
    @SerializedName("visited")
    var visited: Boolean? = null,
    @SerializedName("removed_by")
    var removedBy: Any? = null,
    @SerializedName("num_reports")
    var numReports: Any? = null,
    @SerializedName("distinguished")
    var distinguished: String? = null,
    @SerializedName("subreddit_id")
    var subredditId: String? = null,
    @SerializedName("mod_reason_by")
    var modReasonBy: Any? = null,
    @SerializedName("removal_reason")
    var removalReason: Any? = null,
    @SerializedName("link_flair_background_color")
    var linkFlairBackgroundColor: String? = null,
    @SerializedName("is_robot_indexable")
    var isRobotIndexable: Boolean? = null,
    @SerializedName("report_reasons")
    var reportReasons: Any? = null,
    @SerializedName("author")
    var author: String? = null,
    @SerializedName("discussion_type")
    var discussionType: Any? = null,
    @SerializedName("num_comments")
    var numComments: Int = 0,
    @SerializedName("send_replies")
    var sendReplies: Boolean? = null,
    @SerializedName("contest_mode")
    var contestMode: Boolean? = null,
    @SerializedName("mod_reports")
    var modReports: List<Any>? = null,
    @SerializedName("author_patreon_flair")
    var authorPatreonFlair: Boolean? = null,
    @SerializedName("author_flair_text_color")
    var authorFlairTextColor: Any? = null,
    @SerializedName("permalink")
    var permalink: String? = null,
    @SerializedName("parent_whitelist_status")
    var parentWhitelistStatus: String? = null,
    @SerializedName("stickied")
    var stickied: Boolean? = null,
    @SerializedName("subreddit_subscribers")
    var subredditSubscribers: Int? = null,
    @SerializedName("num_crossposts")
    var numCrossposts: Int? = null,
    @SerializedName("media")
    var media: Any? = null,
    @SerializedName("is_video")
    var isVideo: Boolean? = null,
    @SerializedName("thumbnail_height")
    var thumbnailHeight: Int? = null,
    @SerializedName("thumbnail_width")
    var thumbnailWidth: Int? = null
)