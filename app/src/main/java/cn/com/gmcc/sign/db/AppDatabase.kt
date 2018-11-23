package cn.com.gmcc.sign.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cn.com.gmcc.sign.db.converter.DateConverter
import cn.com.gmcc.sign.db.dao.MissionDao
import cn.com.gmcc.sign.db.pojo.MissionEntity

@Database(entities = [MissionEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun missionDao(): MissionDao
}