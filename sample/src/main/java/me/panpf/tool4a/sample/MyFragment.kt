package me.panpf.tool4a.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class MyFragment : Fragment() {
    var pageName: String? = null

    override final fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val bindContentView = javaClass.getAnnotation(BindContentView::class.java)
        return if (bindContentView != null) {
            inflater!!.inflate(bindContentView.value, container, false)
        } else super.onCreateView(inflater, container, savedInstanceState)
    }

    override final fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onInitViews(savedInstanceState)
        onInitData(savedInstanceState)
        onLoadData(savedInstanceState)
    }

    abstract fun onInitViews(savedInstanceState: Bundle?)
    abstract fun onInitData(savedInstanceState: Bundle?)
    abstract fun onLoadData(savedInstanceState: Bundle?)

    override fun onResume() {
        super.onResume()

        if (userVisibleHint) {
            onVisibilityChangedToUser(true, false)
        }
    }

    override fun onPause() {
        super.onPause()

        if (userVisibleHint) {
            onVisibilityChangedToUser(false, false)
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        if (isResumed) {
            onVisibilityChangedToUser(isVisibleToUser, true)
        }
    }

    /**
     * 当Fragment对用户的可见性发生了改变的时候就会回调此方法
     *
     * @param isVisibleToUser                      true：用户能看见当前Fragment；false：用户看不见当前Fragment
     * @param isHappenedInSetUserVisibleHintMethod true：本次回调发生在setUserVisibleHintMethod方法里；false：发生在onResume或onPause方法里
     */
    protected fun onVisibilityChangedToUser(isVisibleToUser: Boolean, isHappenedInSetUserVisibleHintMethod: Boolean) {
        if (isVisibleToUser) {
            if (pageName != null) {
                Log.i("UmengPageTrack", pageName + " - display - " + if (isHappenedInSetUserVisibleHintMethod) "setUserVisibleHint" else "onResume")
            }
        } else {
            if (pageName != null) {
                Log.w("UmengPageTrack", pageName + " - hidden - " + if (isHappenedInSetUserVisibleHintMethod) "setUserVisibleHint" else "onPause")
            }
        }
    }
}
