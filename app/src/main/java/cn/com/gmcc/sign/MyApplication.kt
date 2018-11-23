package cn.com.gmcc.sign

import android.app.Application
import android.content.Context
import androidx.room.Room
import cn.com.gmcc.sign.db.AppDatabase

class MyApplication : Application() {

    val database: AppDatabase by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java, "v2read.db").build()
    }
}