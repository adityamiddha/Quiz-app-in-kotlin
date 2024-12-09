package com.example.quiz2

import java.util.ArrayList

object Constant {
    const val USER_NAME : String = "user_name"
    const val Total_question :String = "total_question"
    const val Correct_ans : String ="Correct_ans"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val ques1=Question(
            1,
            "What country Does this Flag belong to ?",
            R.drawable.ic_flag_of_australia,
            "New Zealand",
            "Australia",
            "England",
            "Argentina",
            2
        )
        questionList.add(ques1)
        val ques2=Question(
            2,
            "What country Does this Flag belong to ?",
            R.drawable.ic_flag_of_argentina,
            "New Zealand",
            "Australia",
            "England",
            "Argentina",
            4
        )
        questionList.add(ques2)
        val ques3=Question(
            3,
            "What country Does this Flag belong to ?",
            R.drawable.ic_flag_of_belgium,
            "New Zealand",
            "Australia",
            "belgium",
            "Argentina",
            3
        )
        questionList.add(ques3)
        val ques4=Question(
            4,
            "What country Does this Flag belong to ?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Australia",
            "England",
            "Argentina",
            1
        )
        questionList.add(ques4)
        val ques5=Question(
            5,
            "What country Does this Flag belong to ?",
            R.drawable.ic_flag_of_denmark,
            "Switzerland",
            "Denmark",
            "Sweden",
            "Argentina",
            2
        )
        questionList.add(ques5)
        val ques6=Question(
            6,
            "What country Does this Flag belong to ?",
            R.drawable.ic_flag_of_fiji,
            "New Zealand",
            "Australia",
            "America",
            "Fiji",
            4
        )
        questionList.add(ques6)
        val ques7=Question(
            7,
            "What country Does this Flag belong to ?",
            R.drawable.ic_flag_of_germany,
            "New Zealand",
            "China",
            "Germany",
            "Tokyo",
            3
        )
        questionList.add(ques7)
        val ques8=Question(
            8,
            "What country Does this Flag belong to ?",
            R.drawable.ic_flag_of_india,
            "India",
            "Iran",
            "Pakistan ka Father",
            "all world ka Father",
            3
        )
        questionList.add(ques8)
        val ques9=Question(
            9,
            "What country Does this Flag belong to ?",
            R.drawable.ic_flag_of_kuwait,
            "Zimbawe",
            "Dubai",
            "Iraq",
            "Kuwait",
            4
        )
        questionList.add(ques9)
        val ques10=Question(
            1,
            "What country Does this Flag belong to ?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand",
            "Australia",
            "America",
            "Switzerland",
            1
        )
        questionList.add(ques10)

        return questionList








    }
}