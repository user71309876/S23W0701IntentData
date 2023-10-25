package kr.ac.kumoh.ce.s20180474.s23w0701intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import kr.ac.kumoh.ce.s20180474.s23w0701intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),OnClickListener {
    private lateinit var main: ActivityMainBinding
    companion object{
        const val KEYNAME="locatoin"
        const val m1="marmot1"
        const val m2="marmot2"
    }
    //compaion object : static같은거임, static 변수의 모음들
    //const는 함수 인자값으로 쓰지 못함
    //final은 변수를 overloading하지 못하게 함
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        main=ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)
        main.btn1.setOnClickListener(this)
        main.btn2.setOnClickListener(this)
        //TODO:하드코딩 없애
//        main.btn1.setImageResource(R.drawable.marmot1)
//        main.btn2.setImageResource(R.drawable.marmot2)
    }

    override fun onClick(v: View?) {
        val value=when(v?.id){
            main.btn1.id-> {
                Toast.makeText(this,"마멋이재일귀여워",Toast.LENGTH_SHORT).show()
                m1
            }
            main.btn2.id-> {
                Toast.makeText(this,"마멋들이재일귀여워",Toast.LENGTH_SHORT).show()
                m2
            }
            else->return
        }
        intent.putExtra(KEYNAME, value)
        //putExtra는 첫번째 arg는 string으로 넣어야 한다. 뒤에는 리소스 이름
        //해쉬맵 형태로 넣어줌
        startActivity(intent)
    }


}