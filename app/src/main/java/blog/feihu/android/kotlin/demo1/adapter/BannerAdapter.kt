package blog.feihu.android.kotlin.demo1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import blog.feihu.android.kotlin.demo1.R
import blog.feihu.android.kotlin.demo1.bean.resp.Banner

/**
 *@author by Tim飞虎  on  2018/4/6 17:18
 */
class BannerAdapter constructor(var list: List<Banner>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var holder: ViewHolder
        var convertView2 = convertView
        if (null == convertView2) {
            holder = ViewHolder()
            convertView2 = LayoutInflater.from(parent!!.context).inflate(R.layout.item_banner, null)
            holder.image = convertView2.findViewById(R.id.image)
            holder.title = convertView2.findViewById(R.id.title)
            convertView2.tag = holder
        } else {
            holder = convertView2.tag as ViewHolder
        }

        val banner = getItem(position)

        holder.title.text = banner.title
        Glide.with(parent!!)
                .asBitmap()
                .load("https://www.izhongmao.cn/" + banner.image)
                .apply(RequestOptions().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).priority(Priority.HIGH))//设置默认及错误图片
                .into(holder.image)

        return convertView2
    }

    override fun getItem(position: Int): Banner {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

}

class ViewHolder {
    lateinit var image: ImageView
    lateinit var title: TextView

}