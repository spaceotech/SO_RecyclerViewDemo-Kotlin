package com.spaceo.recyclerviewdemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.row.view.*

/**
 * Created by Amit Patoliya on 16/11/18.
 */

class NewsAdapter(private val itemList: List<NewsModel>, private val itemClick: (NewsModel) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder((layoutInflater.inflate(R.layout.row, parent, false)), itemClick)
    }

    override fun getItemCount() = itemList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(itemList[position])

    }


    class ViewHolder(view: View, private val itemClick: (NewsModel) -> Unit) : RecyclerView.ViewHolder(view) {

        val yourview = view

        fun bindForecast(mBean: NewsModel) {

            yourview.txtName.text = mBean.title
            yourview.txtDate.text = mBean.date

            with(mBean) {

                yourview.setOnClickListener { itemClick(this) }
            }

        }

    }
}