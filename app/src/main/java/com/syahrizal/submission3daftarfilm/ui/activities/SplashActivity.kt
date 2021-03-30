package com.syahrizal.submission3daftarfilm.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.syahrizal.submission3daftarfilm.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(2000.toLong())
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
        thread.start()
    }
}
