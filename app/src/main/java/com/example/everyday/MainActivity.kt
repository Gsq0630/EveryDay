package com.example.everyday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aninterface.Autowired

class MainActivity : AppCompatActivity() {

//  @Autowired
//  lateinit var word : String
//
//  @Autowired
//  lateinit var boos: User
//
//  @Autowired("staff")
//  lateinit var list: ArrayList<User>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val user = User().apply {
      name = "A"
      age = 12
    }
    val user1 = User().apply {
      name = "B"
      age = 13
    }
    Intent(this, SecondActivity::class.java).also {
      it.putExtra("word", "word")
      it.putExtra("boos", user)
      it.putExtra("staff", arrayListOf(user, user1))
      startActivity(it)
    }

  }


}