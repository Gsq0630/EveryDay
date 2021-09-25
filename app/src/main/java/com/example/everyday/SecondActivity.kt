package com.example.everyday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aninterface.Autowired
import kotlin.properties.Delegates

class SecondActivity : AppCompatActivity() {

  companion object {
    private const val TAG = "SecondActivity"
  }

  @Autowired
  lateinit var word : String

  @Autowired
  lateinit var boos: User

  @Autowired("staff")
  lateinit var list: ArrayList<User>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_second)
    Analyze.analyzed(this)
    Log.d(TAG, "onCreate: word = $word boos = $boos list = $list")
  }
}