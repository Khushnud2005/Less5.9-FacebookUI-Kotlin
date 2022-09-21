package uz.exemple.less59_facebookui_kotlin.model

class PostModel {
    var profile:Int
    var fullname:String
    var photo:Int = 0
    var photos: IntArray? = null
    var isUpdated:Boolean = false

    constructor(profile: Int, fullname: String, photo: Int) {
        this.profile = profile
        this.fullname = fullname
        this.photo = photo
        this.isUpdated = false
    }
    constructor(profile: Int, fullname: String, photos: IntArray) {
        this.profile = profile
        this.fullname = fullname
        //this.photo = 0
        this.photos= photos
        this.isUpdated = false
    }
    constructor(profile: Int, fullname: String) {
        this.profile = profile
        this.fullname = fullname
        this.isUpdated = true
    }



}