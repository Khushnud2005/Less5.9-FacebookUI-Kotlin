package uz.exemple.less59_facebookui_kotlin.model

class FeedModel {
    var isHeader: Boolean = false
    var post: PostModel? = null
    var stories: ArrayList<StoryModel> = ArrayList<StoryModel>()

    constructor() {
        this.isHeader = true
    }

    constructor(post: PostModel) {
        this.post = post
        this.isHeader = false
    }

    constructor(stories: ArrayList<StoryModel>) {
        this.stories = stories
        this.isHeader = false
    }
}