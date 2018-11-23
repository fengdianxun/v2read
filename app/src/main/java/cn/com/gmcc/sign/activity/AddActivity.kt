package cn.com.gmcc.sign.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.com.gmcc.sign.MyApplication
import cn.com.gmcc.sign.R
import cn.com.gmcc.sign.db.dao.MissionDao
import cn.com.gmcc.sign.db.pojo.MissionEntity
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.*
import org.jetbrains.anko.toast

class AddActivity : AppCompatActivity() {
    lateinit var missionDao: MissionDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        missionDao = (application as MyApplication).database.missionDao()
        val url = intent?.getStringExtra(Intent.EXTRA_TEXT)
        if (url != null) {
            init(url)
        } else {
            finish()
        }
    }

    private fun init(url: String) = GlobalScope.launch(Dispatchers.Main) {
        async(Dispatchers.IO) {
            val missionEntity = MissionEntity(url = url)
            missionDao.insert(missionEntity)
        }.await()
        toast("添加成功")
        finish()
    }

}
