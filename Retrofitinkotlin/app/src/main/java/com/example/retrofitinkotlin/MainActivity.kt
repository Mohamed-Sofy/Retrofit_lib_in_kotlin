package com.example.retrofitinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitinkotlin.Adapter.postAdapter
import com.example.retrofitinkotlin.Retrofit.API
import com.example.retrofitinkotlin.Retrofit.RetrofitClient
import com.example.retrofitinkotlin.model.post
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.disposables.ArrayCompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal lateinit var jsonAPI : API
      var compositeDisposable= CompositeDisposable()
    // lateinit var recycler_posts : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init API
        val retrofit = RetrofitClient.instance
        jsonAPI = retrofit.create(API::class.java)

        //view
        Recycler_posts.setHasFixedSize(true)
        Recycler_posts.layoutManager =LinearLayoutManager(this)
        fetchData()
    }

    private fun fetchData(){
        compositeDisposable.add(jsonAPI.posts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{posts->displayData(posts)})

    }

    private fun displayData(posts: List<post>?) {
        val adapter = postAdapter(this,posts!!)
        Recycler_posts.adapter = adapter

    }
}
