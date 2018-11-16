package com.spaceo.recyclerviewdemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private var newsList = ArrayList<NewsModel>()
    lateinit var mAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        mAdapter = NewsAdapter(newsList) {
            startActivity(
                Intent(this@MainActivity, NewsDetailActivity::class.java).putExtra(
                    "title",
                    it.title
                ).putExtra("date", it.date)
            )
        }

        //Set Layout to recyclerview
        val mLayoutManager = LinearLayoutManager(this)
        //Set divider
        val dividerItemDecoration = DividerItemDecoration(recyclerview?.getContext(), DividerItemDecoration.VERTICAL)
        recyclerview?.addItemDecoration(dividerItemDecoration)
        recyclerview?.setLayoutManager(mLayoutManager)
        //Give animation
        recyclerview?.setItemAnimator(DefaultItemAnimator())
        recyclerview?.setAdapter(mAdapter)
        setNewsData()
    }

    private fun setNewsData() {
        //Set news data
        var news = NewsModel("Gupshup brings Microsoft Cognitive Services Intelligent APIs to InterBot", "05-12-2017")
        newsList.add(news)

        news = NewsModel("Decks cleared for Snapdeal to land in Flipkart's basket", "05-11-2017")
        newsList.add(news)

        news = NewsModel("The Apple Watch could help doctors spot the leading cause of hear", "05-10-2017")
        newsList.add(news)

        news = NewsModel("Microsoft's new strategy: A deeper meaning", "05-10-2017")
        newsList.add(news)

        news = NewsModel("Mario Andretti vs. semi-autonomous tech on the track", "05-09-2017")
        newsList.add(news)

        news = NewsModel("What to bring on a plane if your laptop is banned", "05-08-2017")
        newsList.add(news)

        news = NewsModel("Risky to chase growth over unit economics: Liew, Lightspeed Venture Partners", "05-07-2017")
        newsList.add(news)

        news = NewsModel("OnePlus 5 shows up on GeekBench, beats Galaxy S8+ and iPhone 7 Plus", "05-06-2017")
        newsList.add(news)

        news = NewsModel("Google Pixel smartphone available at discount of Rs 13,000", "05-05-2017")
        newsList.add(news)

        news = NewsModel("Oppo planning to export handsets from India", "05-04-2017")
        newsList.add(news)

        news = NewsModel("OnePlus 5 smartphone is arriving this summer", "05-04-2017")
        newsList.add(news)

        news = NewsModel("Decoupled solutions with Hybris", "05-03-2017")
        newsList.add(news)

        mAdapter.notifyDataSetChanged()

    }
}
