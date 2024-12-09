package com.example.quiz2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class finished : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finished)

        val tvName : TextView = findViewById(R.id.tv_name)

        val tvScore : TextView = findViewById(R.id.tv_score)

        val btnFinish : Button = findViewById(R.id.btn_finish)

        tvName.text = intent.getStringExtra(Constant.USER_NAME)
        val totalQuestion = intent.getIntExtra(Constant.Total_question,0)
        val correctAns = intent.getIntExtra(Constant.Correct_ans,0)

        tvScore.text =  "your score is $correctAns / $totalQuestion"

        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }




    }
}