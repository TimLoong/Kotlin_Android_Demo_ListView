package blog.feihu.android.kotlin.demo1.util

import android.util.Log

class LogUtil {
    companion object {

        var TAG = "Kotlin_Demo"

        fun <T> e(obj: T) {
            Log.e(TAG, obj.toString())
        }
    }
}