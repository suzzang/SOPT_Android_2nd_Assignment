package com.sujeong.a2thseminar

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sujeong.a2thseminar.R

class MineAlign : Fragment(), View.OnClickListener {
    override fun onClick(p0: View?) {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.f_fragment_mine_align,container,false)

        return v
    }

}