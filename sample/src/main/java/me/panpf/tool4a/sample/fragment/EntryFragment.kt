package me.panpf.tool4a.sample.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.gson.Gson
import me.panpf.tool4a.sample.BindContentView
import me.panpf.tool4a.sample.MyFragment
import me.panpf.tool4a.sample.R
import me.panpf.tool4a.sample.bindView

@BindContentView(R.layout.fragment_list)
class EntryFragment : MyFragment() {

    private var entryItem: EntryItem? = null
    private val listView: ListView by bindView(R.id.list_listFragment)

    private val titles: Array<String?>
        get() {
            val titles = arrayOfNulls<String>(entryItem!!.getChildItems()!!.size)
            var w = 0
            val length = entryItem!!.getChildItems()!!.size
            while (w < length) {
                titles[w] = entryItem!!.getChildItems()!![w].title
                w++
            }
            return titles
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            val itemJson = arguments.getString(PARAM_STRING_JSON_ENTRY_ITEM)
            if (itemJson != null && "" != itemJson) {
                entryItem = Gson().fromJson(itemJson, EntryItem::class.java)
                pageName = entryItem!!.title
            }
        }
    }

    override fun onInitData(savedInstanceState: Bundle?) {

    }

    override fun onInitViews(savedInstanceState: Bundle?) {
        listView.adapter = ArrayAdapter(activity, R.layout.list_item_text, titles)
        listView.onItemClickListener = OnItemClickListener { arg0, arg1, arg2, arg3 ->
            val index = arg2 - listView.headerViewsCount
            val clickEntryItem = entryItem!!.getChildItems()!![index]
            val targetClass = clickEntryItem.targetClass

            if (targetClass == null) {
                Toast.makeText(activity, "未知类型", Toast.LENGTH_SHORT).show()
                return@OnItemClickListener
            }

            when {
                Fragment::class.java.isAssignableFrom(targetClass) -> try {
                    val fragment = targetClass.newInstance() as Fragment
                    if (clickEntryItem.getChildItems() != null) {
                        val bundle = Bundle()
                        bundle.putString(PARAM_STRING_JSON_ENTRY_ITEM, Gson().toJson(clickEntryItem))
                        fragment.arguments = bundle
                    }
                    val transaction = fragmentManager.beginTransaction()
                    transaction.addToBackStack(null)
                    transaction.setCustomAnimations(R.anim.window_enter, R.anim.window_exit, R.anim.window_pop_enter, R.anim.window_pop_exit)
                    transaction.add(R.id.frame_main_content, fragment)
                    transaction.commitAllowingStateLoss()
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
                }
                Activity::class.java.isAssignableFrom(targetClass) -> startActivity(Intent(activity, targetClass))
                else -> Toast.makeText(activity, "未知类型", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onLoadData(savedInstanceState: Bundle?) {

    }

    class EntryItem {
        var title: String? = null
        private var targetClassName: String? = null
        private var childItems: MutableList<EntryItem>? = null

        var targetClass: Class<*>?
            get() {
                try {
                    return if (targetClassName != null) javaClass.classLoader.loadClass(targetClassName) else null
                } catch (e: ClassNotFoundException) {
                    e.printStackTrace()
                    return null
                }

            }
            set(targetClass) {
                this.targetClassName = targetClass?.name
            }

        constructor(title: String, targetClass: Class<*>?, childItems: MutableList<EntryItem>) {
            this.title = title
            this.targetClassName = targetClass?.name
            this.childItems = childItems
        }

        constructor(title: String, targetClass: Class<*>?) {
            this.title = title
            this.targetClassName = targetClass?.name
        }

        fun getChildItems(): List<EntryItem>? {
            return childItems
        }
    }

    companion object {
        val PARAM_STRING_JSON_ENTRY_ITEM = "PARAM_STRING_JSON_ENTRY_ITEM"
    }
}
