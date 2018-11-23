package cn.com.gmcc.sign.db.converter


import androidx.room.TypeConverter

import java.sql.Timestamp
import java.util.*

class DateConverter {

    @TypeConverter
    fun revertDate(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun converterDate(value: Date?): Long? {
        return value?.time
    }

}
