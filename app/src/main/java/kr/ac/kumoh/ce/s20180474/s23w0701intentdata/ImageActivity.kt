package kr.ac.kumoh.ce.s20180474.s23w0701intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.lifecycle.MutableLiveData
import kr.ac.kumoh.ce.s20180474.s23w0701intentdata.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity(),OnClickListener {
    companion object{
        const val IMAGE_NAME="image name"
        const val IMAGE_RESULT="image result"
        const val LIKE=100
        const val DISLIKE=101
        const val NONE=0
    }
    private lateinit var main: ActivityImageBinding
    private lateinit var location: String?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_image)
        main=ActivityImageBinding.inflate(layoutInflater)
        setContentView(main.root)
        location=intent.getStringExtra(MainActivity.KEYNAME)

        val res=when(location){
            MainActivity.m1->R.drawable.marmot1
            MainActivity.m2->R.drawable.marmot2
            else->R.drawable.ic_launcher_background
        }
        main.image.setImageResource(res)
//        Log.i("image",intent.getStringExtra("location")?:"없음")
        //main에서 string형으로 put해주었기에 StringExtra를 씀
        //앞에 있는게 null이면 없음을 찍어라
    }

    override fun onClick(v: View?) {
        val intent= Intent()
        val value=when(v?.id){
            main.btnLike.id->LIKE
            main.btnDislike.id->DISLIKE
            else->NONE
        }
        intent.putExtra(IMAGE_NAME,location)
        intent.putExtra(IMAGE_RESULT,value)
        setResult(RESULT_OK,intent)//RESULT_OK???
        finish()
    }
}
//이미지 파일의 이름의 첫 문자는 영어,소문자여야 한다