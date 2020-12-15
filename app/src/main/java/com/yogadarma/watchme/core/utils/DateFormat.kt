package com.yogadarma.watchme.core.utils

import android.os.Build
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

object DateFormat {
    fun format(date: String): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val dateParse = formatter.parse(date)
            DateTimeFormatter.ofPattern("dd MMM yyyy").format(dateParse)
        } else {
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val dateParse = formatter.parse(date)
            SimpleDateFormat("dd MMM yyyy").format(dateParse)
        }
    }
}