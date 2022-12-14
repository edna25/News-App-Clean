package com.newsappclean.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.widget.ANImageView
import com.newsappclean.R
import com.newsappclean.domain.ArticleData

class ViewHolderAdapter(var context: Context, var articles: List<ArticleData>): RecyclerView.Adapter<ViewHolderAdapter.ViewHolder>() {
    class ViewHolder(view:View): RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var itemClicked : MainContract.ItemClicked
        var title : TextView = view.findViewById(R.id.title_id)
        var description : TextView = view.findViewById(R.id.description_id)
        var contributorDate : TextView = view.findViewById(R.id.contributorDate)
        var image : ANImageView = view.findViewById(R.id.image_id)
        init{
            view.setOnClickListener(this)
        }
        fun setItemClicked(itemClicked: MainContract.ItemClicked){
            this.itemClicked = itemClicked
        }
        override fun onClick(v: View?) {
            itemClicked.onClicked(v!!, adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentArticleData : ArticleData = articles[position]
        holder.title.text = currentArticleData.title
        holder.description.text = currentArticleData.description
        val author = currentArticleData.author
        val datePublish = currentArticleData.publishedAt?.substring(0, 10)
        if(author == null){
            holder.contributorDate.text = datePublish
        }else{
            holder.contributorDate.text = author.plus("| $datePublish")
        }
        holder.image.setImageUrl(currentArticleData.urlToImage)
        holder.image.setErrorImageResId(R.mipmap.ic_launcher_error)
        holder.image.setDefaultImageResId(R.mipmap.ic_launcher_error)
        holder.setItemClicked(object : MainContract.ItemClicked{
            override fun onClicked(view: View, position: Int) {
                val intent = Intent(context, WebActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra("url_key", currentArticleData.url)
                context.startActivity(intent)
            }

        })
    }

    override fun getItemCount(): Int = articles.size
}