package com.sujeong.a2thseminar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        //자바의 스위치가 when이다.
        when(v) {
            btn_main_home -> {
                clearSelected()
                btn_main_home.isSelected = true
                replaceFragment(HomeTab())
            }
            btn_main_mine -> {
                clearSelected()
                btn_main_mine.isSelected = true
                replaceFragment(MineTab())
            }
            btn_main_add -> {
                //인텐트
                val intent = Intent(applicationContext, AddActivity::class.java)
                intent.putExtra("add_image", R.drawable.add_image)//레이아웃의 id는 다 int형임-->즉 add_image라는 키네임을 가지고 R.drawable.add_imge라는 int형을 넘겨주겠다는 것임
                startActivity(intent)
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(HomeTab())
        //= addFragment(new HomeTab())
        btn_main_home.isSelected=true
        btn_main_home.setOnClickListener(this)
        btn_main_mine.setOnClickListener(this)
        btn_main_add.setOnClickListener(this)





        //버튼이벤트시 레이아웃 아이디 그냥 이렇게 쓰면된다.
//        btn_main_home.setOnClickListener {
//            replaceFragment(HomeTab())
//        }
//        btn_main_mine.setOnClickListener {
//            replaceFragment(MineTab())
//        }

        //온크리에잇을 깔끔하게 하기위해 이렇게 쓰지말구 그냥 클릭리스너를 상속받아 오버라이딩된Onclick메소드안에 when을 이용해 각각의 뷰에 따른 리스너를 설정해준다.
    }


    fun addFragment(fragment: Fragment) {
        //: Unit //자바와 다르게 매개변수에 변수명을 넣고 :다음에 타입을 표기함,unit은 자바의 void와 비슷함. 생략가능

        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()

        transaction.add(R.id.main_frame,fragment)
        transaction.commit()

    }

    fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()

        // transaction.addToBackStack(null)//백버튼 눌렀을때 전에 방문했던 프래그먼트들이 지워지지않고 그 프래그먼트로 돌아가게됨.
        transaction.replace(R.id.main_frame,fragment)
        transaction.commit()
    }

    fun clearSelected(){
        btn_main_home.isSelected = false
        //btn_main_search.isSelected = false
        //btn_main_news.isSelected = false
        btn_main_mine.isSelected = false
    }

}