package com.example.everyday

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.aninterface.Autowired

object Analyze {

  private const val TAG = "Analyze"

  fun analyzed(activity: AppCompatActivity) {
    val targetClass = activity.javaClass
    val fields = targetClass.declaredFields
    val intent = activity.intent
    val extras = intent.extras ?: return
    fields.forEach { field ->
      Log.d(TAG, "analyzed: field = $field")
      field.isAccessible = true
      if (field.isAnnotationPresent(Autowired::class.java)) {
        val annotation = field.getAnnotation(Autowired::class.java)
        Log.d(TAG, "analyzed: annotation = $annotation")
        if(annotation is Autowired) {
          val key = if (annotation.a.isBlank()) {
            field.name
          } else annotation.a
          Log.d(TAG, "analyzed: key = $key")
          val value = extras.get(key)
          Log.d(TAG, "analyzed: value = $value")
          value.let {
            field.set(activity, value)
          }
        }
      }
    }
  }
}