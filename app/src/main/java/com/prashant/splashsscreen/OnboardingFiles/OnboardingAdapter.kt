package com.prashant.splashsscreen.OnboardingFiles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prashant.splashsscreen.R

class OnboardingAdapter(private val pages: List<OnboardingPage>):  RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>()  {
    class OnboardingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val desc: TextView = itemView.findViewById(R.id.description)
        val image: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_onboarding, parent, false)
        return OnboardingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        val page = pages[position]
        holder.title.text = page.title
        holder.desc.text = page.description
        holder.image.setImageResource(page.imageResId)
    }

    override fun getItemCount() = pages.size
}
