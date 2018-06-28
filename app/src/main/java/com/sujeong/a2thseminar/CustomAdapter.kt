package com.sujeong.a2thseminar

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.image_item.view.*

class CustomAdapter (context: Context?)  : PagerAdapter() {

    val imageId = arrayOf(R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4)
    var context = context

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

       val v = LayoutInflater.from(context).inflate(R.layout.image_item,container,false) //이런식으로 해서 따로 Layout
        v.imageView.setImageResource(imageId[position])
        container.addView(v)
        return v;
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imageId.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

}