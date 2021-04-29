/*
 * MIT License
 *
 * Copyright (c) 2020 Giorgos Neokleous
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.example.securityaplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.securityaplication.R
import java.util.concurrent.TimeUnit

class MainActivityAbacate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.abacate)

        findViewById<Button>(R.id.showFullScreenIntentButton).setOnClickListener {
            showNotificationWithFullScreenIntent()
        }

        findViewById<Button>(R.id.showFullScreenIntentWithDelayButton).setOnClickListener {
            scheduleNotification(false)
        }

        findViewById<Button>(R.id.showFullScreenIntentLockScreenWithDelayButton).setOnClickListener {
            scheduleNotification(true)
        }
        var sd: Long = TimeUnit.SECONDS.toMillis(SCHEDULE_TIME)
        val duration = Toast.LENGTH_SHORT
        var  text: String = sd.toString()

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
}
