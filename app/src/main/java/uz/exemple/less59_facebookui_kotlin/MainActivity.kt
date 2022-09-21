package uz.exemple.less59_facebookui_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less59_facebookui_kotlin.adapter.FeedAdapter
import uz.exemple.less59_facebookui_kotlin.model.FeedModel
import uz.exemple.less59_facebookui_kotlin.model.PostModel
import uz.exemple.less59_facebookui_kotlin.model.StoryModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))

        refreshAdapter(getAllFeeds())
    }

    fun refreshAdapter(feeds: ArrayList<FeedModel>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerView.adapter = adapter
    }

    fun getAllFeeds(): ArrayList<FeedModel> {
        val stories: ArrayList<StoryModel> = ArrayList<StoryModel>()
        stories.add(StoryModel(R.drawable.profile))
        stories.add(StoryModel(R.drawable.profile1, "JamolXon Kamolxon"))
        stories.add(StoryModel(R.drawable.profile2, "Abdulfattoh Nematov"))
        stories.add(StoryModel(R.drawable.profile3, "Muhammad Ikromov"))
        stories.add(StoryModel(R.drawable.profile1, "JamolXon Kamolxon"))
        stories.add(StoryModel(R.drawable.profile2, "Abdulfattoh Nematov"))
        stories.add(StoryModel(R.drawable.profile3, "Muhammad Ikromov"))

        val feeds: ArrayList<FeedModel> = ArrayList<FeedModel>()
        //Head
        feeds.add(FeedModel())
        //Story
        feeds.add(FeedModel(stories))
        //Post
        feeds.add(FeedModel(PostModel(R.drawable.profile3, "Muhammad", R.drawable.photo1)))
        feeds.add(FeedModel(PostModel(R.drawable.profile3, "Muhammad")))
        feeds.add(FeedModel(PostModel(R.drawable.profile2, "Abdulfattoh",getPhotos())))
        feeds.add(FeedModel(PostModel(R.drawable.profile2, "Abdulfattoh",R.drawable.photo3)))
        feeds.add(FeedModel(PostModel(R.drawable.profile1, "Jamolxon", R.drawable.photo2)))
        feeds.add(FeedModel(PostModel(R.drawable.profile3, "Muhammad", R.drawable.photo4)))
        feeds.add(FeedModel(PostModel(R.drawable.profile1, "Jamolxon", R.drawable.photo5)))
        feeds.add(FeedModel(PostModel(R.drawable.profile2, "Abdulfattoh", R.drawable.photo6)))
        return feeds
    }
    fun getPhotos(): IntArray {
        val photos = IntArray(11)
        photos[0] = R.drawable.photo1
        photos[1] = R.drawable.photo2
        photos[2] = R.drawable.photo3
        photos[3] = R.drawable.photo4
        photos[4] = R.drawable.photo5
        photos[5] = R.drawable.photo6
        photos[6] = R.drawable.photo1
        photos[7] = R.drawable.photo2
        photos[8] = R.drawable.photo3
        photos[9] = R.drawable.photo4
        photos[10] = R.drawable.photo5
        return photos
    }
}