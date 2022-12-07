package com.newsappclean.ui

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log.e
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newsappclean.databinding.ActivityMainBinding
import com.newsappclean.di.AppContainer
import com.newsappclean.domain.ArticleData

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var binding : ActivityMainBinding
    private lateinit var progressBar : ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter : MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressBar = binding.progressBar
        recyclerView = binding.recycleView

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        val appContainer = AppContainer()
        presenter = appContainer.mainFactory.create()
        presenter.onViewReady(this@MainActivity)
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showArticles(articleList: MutableList<ArticleData>) {
        val adapter = ViewHolderAdapter(this@MainActivity, articleList)
        recyclerView.adapter = adapter
    }

    override fun showDialog(msg: String) {
        e(">>", msg)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("Connection Interrupted: ".plus(msg))
        builder.setPositiveButton("Try Again") { _, _ ->
            // (Dialog Interface, Int) -> Unit this function represented as High-Order Function
            // Dialog Interface instance of the dialog, int the ID of the button clicked
            //_ is used as passed if the arguments aren't used.
            presenter.onViewReady(this@MainActivity)
        }
        builder.setNegativeButton("Cancel") { _, _ ->
            finish()
        }
        builder.show()
    }
}