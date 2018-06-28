package com.sujeong.a2thseminar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_save.*

class SaveActivity : AppCompatActivity() {

    var image : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)
        image = intent.getIntExtra("img_mine_save",0)
        img_mine_save.setImageResource(image)
    }
}
