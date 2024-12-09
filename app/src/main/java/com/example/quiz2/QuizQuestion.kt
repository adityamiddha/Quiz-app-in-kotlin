package com.example.quiz2

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.util.ArrayList

class QuizQuestion : AppCompatActivity(), View.OnClickListener {

    private var mCurrentAns : Int = 0
    private var mUserName : String ?=null
    private var mCurrentPosition : Int = 1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOption : Int = 0
    private var progressBar : ProgressBar ?= null
    private var tvProgress : TextView ?= null
    private var tvQuestion : TextView ?= null
    private var ivImage : ImageView ?= null
    private var tvOptionOne : TextView ?= null
    private var tvOptionTwo : TextView ?= null
    private var tvOptionThree : TextView ?= null
    private var tvOptionFour : TextView ?= null
    private var btnSubmit : Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)


        mUserName = intent.getStringExtra(Constant.USER_NAME)
        progressBar = findViewById(R.id.progressbar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_optionOne)
        tvOptionTwo = findViewById(R.id.tv_optionTwo)
        tvOptionThree = findViewById(R.id.tv_optionThree)
        tvOptionFour = findViewById(R.id.tv_optionFour)
        btnSubmit = findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constant.getQuestions()

        setQuestion()
 defaultOptionView ()

    }

    private fun setQuestion()  {

        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
        if (mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text="FINISH"
        }
        else{
            btnSubmit?.text="SUBMIT"
        }
    }
private fun defaultOptionView(){
    val option = ArrayList<TextView>()
    tvOptionOne?.let {
        option.add(0,it)
    }
    tvOptionTwo?.let {
        option.add(1,it)
    }
    tvOptionThree?.let {
        option.add(2,it)
    }
    tvOptionFour?.let {
        option.add(3,it)
    }
    for(i in option){
        i.setTextColor(Color.parseColor("#7A8089"))
        i.typeface = Typeface.DEFAULT
        i.background = ContextCompat.getDrawable(
            this,R.drawable.default_option_border_bg

        )
    }
}
    private fun selectedOptionView(tv:TextView, selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOption=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=  ContextCompat.getDrawable(
            this,R.drawable.selected
        )
    }
    override fun onClick(view: View?) {
       when(view?.id)
       {
           R.id.tv_optionOne->{
               tvOptionOne?.let {
                   selectedOptionView(it,1)
               }
           }
           R.id.tv_optionTwo->{
               tvOptionTwo?.let {
                   selectedOptionView(it,2)
               }
           } R.id.tv_optionThree->{
           tvOptionThree?.let {
               selectedOptionView(it,3)
           }
       } R.id.tv_optionFour->{
           tvOptionFour?.let {
               selectedOptionView(it,4)
           }
       }
           R.id.btn_submit->{
               if(mSelectedOption == 0){
                   mCurrentPosition++
                   when {
                       mCurrentPosition <= mQuestionList!!.size -> {
                           setQuestion()
                       }

                       else -> {
                          val intent = Intent(this,finished::class.java)
                           intent.putExtra(Constant.USER_NAME,mUserName)
                           intent.putExtra(Constant.Correct_ans,mCurrentAns)
                           intent.putExtra(Constant.Total_question,mQuestionList?.size)
                           startActivity(intent)
                           finish()
                       }
                   }
               }
               else{
                   val question = mQuestionList?.get(mCurrentPosition-1)
                   if(question!!.correctAns!= mSelectedOption){
                       answerView(mSelectedOption,R.drawable.wrong_option_border_bg)
                   }
                   else{
                       mCurrentAns++
                   }
                   answerView(question.correctAns,R.drawable.correct_option_border_bg)
                   if(mCurrentPosition == mQuestionList!!.size){
                       btnSubmit?.text = "FINISH"
                   }else{
                     btnSubmit?.text="GO TO NEXT QUESTION"
                   }

                   mSelectedOption=0
               }

           }
       }
    }
    private fun answerView(answer:Int,drawableView : Int){
        when(answer){

            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
        }
    }
}