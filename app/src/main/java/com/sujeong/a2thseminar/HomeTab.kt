package com.sujeong.a2thseminar

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sujeong.a2thseminar.CustomAdapter
import com.sujeong.a2thseminar.R


class HomeTab : android.support.v4.app.Fragment() { //상속자가 들어가야한다. 별도의 상속자 키워드를 쓰지않아도 이렇게 표시함으로써 생성자를 쓸수 있다.
    lateinit var viewPager: ViewPager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {//함수 만들때 fun이라는 키워드를 쓴다.
       // return super.onCreateView(inflater, container, savedInstanceState) //이 뷰를 붙여줄것이라는거.
        val v = inflater.inflate(R.layout.fragment_form,container,false) //코틀린은 타입을 따로 지정하진 않음. 일단 선언하고 가장 최초로 넣어진 값에 의해서 그 변수의 타입이 결정된다.
        val adapter = CustomAdapter(context)

        viewPager = v.findViewById(R.id.swipeViewpager)
        viewPager.adapter = adapter //()이런식으로 안하고 요로케 하넹


        return v //VIew타입으로 v가 바뀌었기때문에 return이 되는것임.

    }
}