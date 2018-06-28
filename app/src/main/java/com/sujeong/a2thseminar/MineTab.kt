package com.sujeong.a2thseminar

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_mine.*
import kotlinx.android.synthetic.main.fragment_mine.view.*

class MineTab : Fragment(),View.OnClickListener {

    override fun onClick(v: View?) {

       when(v){
           btn_mine_all -> {
               clearSelected()
               btn_mine_all.isSelected=true
               replaceFragment(MineAll())

           }
           btn_mine_align -> {
               clearSelected()
               btn_mine_align.isSelected=true
               replaceFragment(MineAlign())
           }
           btn_mine_save -> {
               val intent = Intent(activity!!.applicationContext,SaveActivity::class.java)
               intent.putExtra("img_mine_save",R.drawable.my_save_off)
               startActivity(intent)
           }
       }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_mine,container,false)
        addFragment((MineAll()))
        v.btn_mine_all.setOnClickListener(this)
        v.btn_mine_all.isSelected = true

        v.btn_mine_align.setOnClickListener(this)
        v.btn_mine_save.setOnClickListener(this)
        return v



    }

     fun addFragment(fragment:Fragment) {
        //: Unit //자바와 다르게 매개변수에 변수명을 넣고 :다음에 타입을 표기함,unit은 자바의 void와 비슷함. 생략가능

        val fm = activity!!.supportFragmentManager
        val transaction = fm.beginTransaction()

        transaction.add(R.id.mine_frame,fragment)
        transaction.commit()

    }

    fun replaceFragment(fragment: Fragment) {
        val fm = activity!!.supportFragmentManager
        val transaction = fm.beginTransaction()

        // transaction.addToBackStack(null)//백버튼 눌렀을때 전에 방문했던 프래그먼트들이 지워지지않고 그 프래그먼트로 돌아가게됨.
        transaction.replace(R.id.mine_frame,fragment)
        transaction.commit()
    }

    fun clearSelected(){
        btn_mine_all.isSelected = false

        btn_mine_align.isSelected = false
    }
}

