package cn.com.gmcc.sign.db.pojo

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity(tableName = "mission")
@Parcelize
class MissionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    /**
     * 用户id.
     */
    val uid: Int = 0,
    /**
     * 任务名.
     */
    val name: String="",
    /**
     * 链接.
     */
    val url: String,
    /**
     * 状态.
     */
    var state: String="N",
    /**
     * 创建时间.
     */
    val createAt: Date = Date()
) : Parcelable