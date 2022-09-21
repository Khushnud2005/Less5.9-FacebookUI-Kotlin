package uz.exemple.less59_facebookui_kotlin.model

class StoryModel {
    var profile:Int
    var fullname:String? = null

    constructor(profile:Int, fullname:String){
        this.profile = profile
        this.fullname = fullname
    }
    constructor(profile:Int){
        this.profile = profile
    }
}