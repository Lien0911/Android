package com.JohnLien.Utility

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View

fun <T: View> Activity.bind(@IdRes id:Int):Lazy<T>{
    return lazy<T>{ findViewById<T>(id)  }
}
fun <T:View> View.bind(@IdRes id:Int):Lazy<T>{
    return lazy<T>{ findViewById<T>(id)  }
}