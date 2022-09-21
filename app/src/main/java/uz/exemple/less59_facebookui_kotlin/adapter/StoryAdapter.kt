package uz.exemple.less59_facebookui_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import uz.exemple.less59_facebookui_kotlin.R
import uz.exemple.less59_facebookui_kotlin.model.StoryModel

class StoryAdapter(var context: Context, var items: ArrayList<StoryModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var ITEM_CREATE = 0
    var ITEM_STORY = 1
    override fun getItemViewType(position: Int): Int {
        val item = items[position]
       if (item.fullname == null) {
           return  ITEM_CREATE
        }
        return ITEM_STORY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == ITEM_CREATE) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_story_create, parent, false)
            return CreateViewHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_story_view, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if (holder is StoryViewHolder) {
            var iv_background = holder.iv_background
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname

            iv_background.setImageResource(story.profile)
            iv_profile.setImageResource(story.profile)
            tv_fullname.text = story.fullname
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_background: ShapeableImageView
        var iv_profile: ShapeableImageView
        var tv_fullname: TextView

        init {
            iv_background = view.findViewById(R.id.iv_background)
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }
    class CreateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

}