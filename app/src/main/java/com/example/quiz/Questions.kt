package com.example.quiz

class Questions {
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val ques1 = Question(
            1,
            "Highest grossing anime movie of all time",
            "Suzume",
            "Your Name",
            "Demon Slayer",
            "Spirited Away",
            "Demon Slayer",
            ""
        )
        questionsList.add(ques1)

        val ques2 = Question(
            2,
            "Bald anime MC",
            "Goku",
            "Saitama",
            "Rimuru",
            "Luffy",
            "Saitama",
            ""
        )
        questionsList.add(ques2)

        val ques3 = Question(
            3,
            "Most powerful Hashira",
            "Gyomei Himejima",
            "Giyu Tomioka",
            "Sanemi Shinazugawa",
            "Tengen Uzui",
            "Gyomei Himejima",
            ""
        )
        questionsList.add(ques3)

        val ques4 = Question(
            4,
            "Who is the youngest Hashira?",
            "Shinobu Kocho",
            "Kyojuro Rengoku",
            "Mitsuri Kanroji",
            "Muichiro Tokito",
            "Muichiro Tokito",
            ""
        )
        questionsList.add(ques4)

        val ques5 =  Question(
            5,
            "Who killed Toji Fushiguro?",
            "Yuji Itadori",
            "Gojo Satoru",
            "Sukuna",
            "Megumi Fushiguro",
            "Gojo Satoru",
            ""
        )
        questionsList.add(ques5)

        val ques6 =  Question(
            6,
            "Most powerful subordinate of Rimuru Tempest",
            "Shion",
            "Diablo",
            "Benimaru",
            "Veldora",
            "Diablo",
            ""
        )
        questionsList.add(ques6)

        val ques7 =  Question(
            7,
            "Who is the first wife of Rudeus Greyrat?",
            "Sylphie",
            "Elinalese",
            "Roxy",
            "Eris",
            "Sylphie",
            ""
        )
        questionsList.add(ques7)

        val ques8 =  Question(
            8,
            "Who is not a demon lord in Tensura?",
            "Dino",
            "Milim Nava",
            "Rimuru Tempest",
            "Hinata Sakaguchi",
            "Hinata Sakaguchi",
            ""
        )
        questionsList.add(ques8)

        val ques9 =  Question(
            9,
            "How many fingers did Sukuna had?",
            "16",
            "24",
            "20",
            "30",
            "20",
            ""
        )
        questionsList.add(ques9)

        val ques10 =  Question(
            10,
            "After how many years titan shifters die due to the curse of Ymir?",
            "8",
            "15",
            "13",
            "17",
            "13",
            ""
        )
        questionsList.add(ques10)

        return questionsList
    }
}