package cn.com.gmcc.sign.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import cn.com.gmcc.sign.R
import kotlinx.android.synthetic.main.activity_host.*

class HostActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
        setSupportActionBar(toolbar)
        val nav = findNavController(R.id.navi_host_fragment)
        toolbar.setupWithNavController(nav)


    }

    override fun onBackPressed() {
        if (!findNavController(R.id.navi_host_fragment).navigateUp())
            super.onBackPressed()

    }
}
