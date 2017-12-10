package me.panpf.tool4a.sample.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import me.panpf.tool4a.sample.BindContentView
import me.panpf.tool4a.sample.MyFragment
import me.panpf.tool4a.sample.R
import me.panpf.tool4a.sample.bindView
import me.panpf.tool4a.widget.CheckAdapter
import java.util.*

@BindContentView(R.layout.fragment_list)
class CheckAdapterSampleFragment : MyFragment() {

    private val listView: ListView by bindView(R.id.list_listFragment)

    override fun onInitViews(savedInstanceState: Bundle?) {
        val items = ArrayList<Item>()
        items.add(Item("诺基亚"))
        items.add(Item("摩托罗拉"))
        items.add(Item("黑莓"))
        items.add(Item("小米"))
        items.add(Item("三星"))
        items.add(Item("HTC"))
        items.add(Item("联想"))
        items.add(Item("华为"))
        items.add(Item("苹果"))
        items.add(Item("金立"))
        items.add(Item("OPPO"))
        items.add(Item("步步高"))
        items.add(Item("朵唯"))
        items.add(Item("酷派"))
        items.add(Item("魅族"))
        items.add(Item("中兴"))
        items.add(Item("索尼"))
        items.add(Item("LG"))
        items.add(Item("TCL"))
        items.add(Item("海信"))
        items.add(Item("神舟"))
        items.add(Item("天语"))
        val stringAdapter = StringAdapter(activity, items)
        listView.adapter = stringAdapter

        listView.onItemClickListener = OnItemClickListener { arg0, arg1, arg2, arg3 -> stringAdapter.clickItem(arg2) }

        listView.onItemLongClickListener = OnItemLongClickListener { arg0, arg1, arg2, arg3 ->
            if (stringAdapter.isEnabledCheckMode) {
                stringAdapter.cancelCheckMode()
            } else {
                stringAdapter.enableCheckMode()
                stringAdapter.clickItem(arg2)
            }
            true
        }
    }

    override fun onInitData(savedInstanceState: Bundle?) {
    }

    override fun onLoadData(savedInstanceState: Bundle?) {
    }

    private inner class StringAdapter(private val context: Context, items: List<Item>) : CheckAdapter<Item>(items) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val realConvertView: View
            val viewHolder: ViewHolder
            if (convertView == null) {
                realConvertView = LayoutInflater.from(context).inflate(R.layout.list_item_check, parent, false)

                viewHolder = ViewHolder()
                viewHolder.titleTextView = realConvertView.findViewById(R.id.text_checkItem_title) as TextView
                viewHolder.checkBox = realConvertView.findViewById(R.id.check_checkItem_check) as CheckBox
                realConvertView.tag = viewHolder
            } else {
                realConvertView = convertView

                viewHolder = realConvertView.tag as ViewHolder
            }

            val item = items[position]
            viewHolder.titleTextView!!.text = item.title
            viewHolder.checkBox!!.isChecked = item.isChecked

            handleCompoundButton(viewHolder.checkBox, item)

            return realConvertView
        }

        inner class ViewHolder {
            var titleTextView: TextView? = null
            var checkBox: CheckBox? = null
        }
    }

    inner class Item(var title: String?) : CheckAdapter.CheckItem {
        private var checked: Boolean = false

        override fun isChecked(): Boolean {
            return checked
        }

        override fun setChecked(checked: Boolean) {
            this.checked = checked
        }
    }
}
