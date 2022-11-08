package rapido.bike.paathshaala.instagrammvparchitecture.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.squareup.picasso.Picasso
import rapido.bike.paathshaala.instagrammvparchitecture.R
import rapido.bike.paathshaala.instagrammvparchitecture.model.PostCard

class PostFeedAdapter(private val context: Context, private val postList: List<PostCard>): Adapter<PostFeedAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.post_card, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = postList[position]
        Picasso.get().load(post.userPicture).into(holder.profilePicture)
        Picasso.get().load(post.postPicture).into(holder.postPictures)
        holder.userName.text = post.userName
        holder.likeCount.text = context.resources.getString(R.string.likes, post.likeCount.toString())
        holder.postDescription.text = context.resources.getString(R.string.description, post.userName, post.postDescription)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val profilePicture: ImageView = itemView.findViewById(R.id.userDisplayPic)
        val userName: TextView = itemView.findViewById(R.id.userName)
        val postPictures: ImageView = itemView.findViewById(R.id.userPostPics)
        val likeCount:TextView = itemView.findViewById(R.id.likeCount)
        val postDescription:TextView = itemView.findViewById(R.id.postDescription)
    }
}