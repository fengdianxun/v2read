package cn.com.gmcc.sign.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import cn.com.gmcc.sign.db.pojo.MissionEntity

@Dao
interface MissionDao {

    @Insert
    fun insert(mission: MissionEntity)

    @Query("select * from mission where uid=:uid order by state desc")
    fun missions(uid:Int = 0): LiveData<List<MissionEntity>>

    @Update
    fun updateMission(mission: MissionEntity)

}