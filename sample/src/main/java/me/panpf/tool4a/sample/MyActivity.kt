package me.panpf.tool4a.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class MyActivity : AppCompatActivity() {
    override final fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bindContentView = javaClass.getAnnotation(BindContentView::class.java)
        if (bindContentView != null) {
            setContentView(bindContentView.value)
        }

        onInitViews(savedInstanceState)
        onInitData(savedInstanceState)
        onLoadData(savedInstanceState)
    }

    abstract fun onInitViews(savedInstanceState: Bundle?)
    abstract fun onInitData(savedInstanceState: Bundle?)
    abstract fun onLoadData(savedInstanceState: Bundle?)
}