package uz.exemple.less59_facebookui_kotlin.adapter

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import uz.exemple.less59_facebookui_kotlin.R
import uz.exemple.less59_facebookui_kotlin.model.FeedModel
import uz.exemple.less59_facebookui_kotlin.model.StoryModel

class FeedAdapter(var context: Context, var items: ArrayList<FeedModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_HEAD = 0
    private val TYPE_ITEM_STORY = 1
    private val TYPE_ITEM_POST = 2
    private val TYPE_ITEM_UPDATED = 3
    private val TYPE_ITEM_PHOTOS = 4

    override fun getItemViewType(position: Int): Int {
        var feed = items[position]

        if (feed.isHeader) {
            return TYPE_ITEM_HEAD
        }else if (feed.stories.size > 0) {
            return TYPE_ITEM_STORY
        }else if (feed.post!!.isUpdated) {
            return TYPE_ITEM_UPDATED
        }else if (feed.post!!.photo != 0){
            return TYPE_ITEM_POST
        }

        return TYPE_ITEM_PHOTOS
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_HEAD) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_head, parent, false)
            return HeadViewHolder(context, view)
        }else if (viewType == TYPE_ITEM_STORY) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
            return StoryViewHolder(context, view)
        }else if (viewType == TYPE_ITEM_UPDATED) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_updated_post, parent, false)
            return UpdatedViewHolder(view)
        }else if (viewType == TYPE_ITEM_POST) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
            return PostViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_5x_photo, parent, false)
        return PhotosViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is HeadViewHolder) {


        }

        if (holder is StoryViewHolder) {
            var recyclerView = holder.recyclerView
            refreshAdapter(feed.stories, recyclerView)
        }
        if (holder is PhotosViewHolder){
            var iv_profile = holder.iv_profile
            var iv_photo1 = holder.iv_photo1
            var iv_photo2 = holder.iv_photo2
            var iv_photo3 = holder.iv_photo3
            var iv_photo4 = holder.iv_photo4
            var iv_photo5 = holder.iv_photo5
            var tv_fullname = holder.tv_fullname
            var tv_count_photo = holder.tv_count_photo
            var ll_bottom = holder.ll_bottom
            var ll_top = holder.ll_top
            var context = holder.view.context

            iv_profile.setImageResource(feed.post!!.profile)
            iv_photo1.setImageResource(feed.post!!.photos!![0])
            iv_photo2.setImageResource(feed.post!!.photos!![1])
            iv_photo3.setImageResource(feed.post!!.photos!![2])
            iv_photo4.setImageResource(feed.post!!.photos!![3])
            iv_photo5.setImageResource(feed.post!!.photos!![4])

            tv_fullname.text = feed.post!!.fullname
            val count_photos: Int = feed.post!!.photos!!.size - 5
            tv_count_photo.setText("+$count_photos")

            setLinearHeight(context, ll_bottom, 3)
            setLinearHeight(context, ll_top, 2)

        }



        if (holder is PostViewHolder) {
            var iv_profile = holder.iv_profile
            var iv_photo = holder.iv_photo
            var tv_fullname = holder.tv_fullname
            iv_profile.setImageResource(feed.post!!.profile)
            iv_photo.setImageResource(feed.post!!.photo!!)
            tv_fullname.text = feed.post!!.fullname
        }



        if (holder is UpdatedViewHolder) {
            var iv_profile = holder.iv_profile
            var iv_updated_profile = holder.iv_updated_profile
            var tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(feed.post!!.profile)
            iv_updated_profile.setImageResource(feed.post!!.profile)

            val upd_fullName: String =
                feed.post!!.fullname + "  updated his profile picture."

            val spannable: Spannable = SpannableString(upd_fullName)
            spannable.setSpan(
                ForegroundColorSpan(Color.parseColor("#90000000")),
                feed.post!!.fullname.length,
                upd_fullName.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            tv_fullname.setText(spannable, TextView.BufferType.SPANNABLE)

        }
    }

    fun refreshAdapter(stories: ArrayList<StoryModel>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(context, stories)
        recyclerView!!.adapter = adapter
    }

    class HeadViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {

    }

    class StoryViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.setLayoutManager(manager)
        }
    }

    class PostViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_photo: ImageView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_photo = view.findViewById(R.id.iv_photo)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }
    class UpdatedViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_updated_profile: ShapeableImageView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_updated_profile = view.findViewById(R.id.iv_updated_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }
    class PhotosViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_photo1: ImageView
        var iv_photo2: ImageView
        var iv_photo3: ImageView
        var iv_photo4: ImageView
        var iv_photo5: ImageView
        var tv_fullname: TextView
        var tv_count_photo: TextView
        var ll_bottom: LinearLayout
        var ll_top: LinearLayout

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_photo1 = view.findViewById(R.id.iv_photo1)
            iv_photo2 = view.findViewById(R.id.iv_photo2)
            iv_photo3 = view.findViewById(R.id.iv_photo3)
            iv_photo4 = view.findViewById(R.id.iv_photo4)
            iv_photo5 = view.findViewById(R.id.iv_photo5)
            tv_fullname = view.findViewById(R.id.tv_fullname)
            tv_count_photo = view.findViewById(R.id.tv_count_photo)
            ll_bottom = view.findViewById(R.id.ll_bottom)
            ll_top = view.findViewById(R.id.ll_top)
        }
    }

    fun setLinearHeight(context: Context, layout: LinearLayout, parts: Int) {
        // Get screen width programmatically
        val displayMetrics = context.resources.displayMetrics
        val pxWidth = displayMetrics.widthPixels
        val dpWidth = pxWidth / displayMetrics.density
        val pxHeight = displayMetrics.heightPixels
        val dpHeight = pxHeight / displayMetrics.density

        // Set layout width programmatically
        val params = layout.layoutParams
        params.height = (pxWidth - 5 * (parts - 1)) / parts
        layout.layoutParams = params
    }
}