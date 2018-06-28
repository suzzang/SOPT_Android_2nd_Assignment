package com.sujeong.a2thseminar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    //변수는 val 상수는 var
    var image : Int = 0
    //자바에선 이표현이 int name = 0; :int안해도 된다. 벗 명시를 권장

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        image = intent.getIntExtra("add_image",0)
        add_image.setImageResource(image)
    }
}
