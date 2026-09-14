package com.example.data.repository

import com.example.data.model.*

object StudyRepository {
    fun getAllChapters(): List<Chapter> {
        return Science1Data.getChapters() +
               Science2Data.getChapters() +
               Math1Data.getChapters() +
               Math2Data.getChapters() +
               MarathiData.getChapters() +
               EnglishData.getChapters() +
               HistoryData.getChapters() +
               GeographyData.getChapters()
    }

    fun getChaptersBySubject(subjectType: SubjectType): List<Chapter> {
        return when (subjectType) {
            SubjectType.SCIENCE_1 -> Science1Data.getChapters()
            SubjectType.SCIENCE_2 -> Science2Data.getChapters()
            SubjectType.MATH_1 -> Math1Data.getChapters()
            SubjectType.MATH_2 -> Math2Data.getChapters()
            SubjectType.MARATHI -> MarathiData.getChapters()
            SubjectType.ENGLISH -> EnglishData.getChapters()
            SubjectType.HISTORY -> HistoryData.getChapters()
            SubjectType.GEOGRAPHY -> GeographyData.getChapters()
        }
    }

    fun getChapterById(id: String): Chapter? {
        return getAllChapters().find { it.id == id }
    }

    fun getPreviousYearPapers(): List<PreviousYearPaper> {
        return PYQData.getPapers()
    }

    fun getExpertTeachers(): List<TeacherExpert> = listOf(
        TeacherExpert(
            id = "t_sci",
            name = "Prof. S. Kulkarni",
            subject = "Science 1 & 2 Specialist",
            experience = "18+ Years Board Evaluator",
            avatarInitials = "SK",
            status = "Online • Instant Help",
            welcomeMessage = "Namaskar! I am Prof. Kulkarni. Feel free to ask any conceptual doubts in Physics, Chemistry, Biology, or Scientific Reasons for SSC Board exams!"
        ),
        TeacherExpert(
            id = "t_math",
            name = "Prof. R. Deshmukh",
            subject = "Mathematics 1 & 2 Gold Medalist",
            experience = "15+ Years Board Trainer",
            avatarInitials = "RD",
            status = "Online • Fast Response",
            welcomeMessage = "Hello Students! Struggling with Quadratic roots, Cramer's Rule, or Circle Tangent theorems? Ask me step-by-step questions and let's score 100/100!"
        ),
        TeacherExpert(
            id = "t_marathi",
            name = "सौ. मीना जोशी मॅडम",
            subject = "मराठी कुमारभारती व व्याकरण तज्ज्ञ",
            experience = "२०+ वर्षे बोर्ड परीक्षक",
            avatarInitials = "MJ",
            status = "Online • व्याकरण मार्गदर्शन",
            welcomeMessage = "नमस्कार! मी प्रा. मीना जोशी. समास, अलंकार, वाक्प्रचार किंवा उपयोजित लेखनातील पत्र व सारांश लेखनात काहीही शंका असल्यास नक्की विचारा!"
        ),
        TeacherExpert(
            id = "t_english",
            name = "Prof. David Ferns",
            subject = "English Language & Writing Skills",
            experience = "16+ Years Board Trainer",
            avatarInitials = "DF",
            status = "Online • Instant Grammar",
            welcomeMessage = "Greetings! I can help you conquer Tenses, Direct/Indirect Voice, Poetic Appreciations, and 25 marks Writing Skills easily."
        ),
        TeacherExpert(
            id = "t_social",
            name = "प्रा. व्ही. एन. गायकवाड",
            subject = "इतिहास, राज्यशास्त्र व भूगोल",
            experience = "१४+ वर्षे बोर्ड मार्गदर्शक",
            avatarInitials = "VG",
            status = "Online • नकाशा व संकल्पना",
            welcomeMessage = "सस्नेह नमस्कार! इतिहासलेखन, प्रसारमाध्यमे तसेच भारत व ब्राझील तुलनात्मक भूगोल आणि नकाशा वाचनातील सर्व ट्रिक्ससाठी मी उपलब्ध आहे."
        ),
        TeacherExpert(
            id = "t_counselor",
            name = "Dr. Ananya Patil",
            subject = "Board Exam Counselor & Memory Coach",
            experience = "12+ Years Student Psychology",
            avatarInitials = "AP",
            status = "Online • Study Tips",
            welcomeMessage = "Welcome! I can help you with revision time tables, Pomodoro schedules, exam anxiety, and scientifically proven memory mnemonics."
        )
    )

    fun getStudyGroups(): List<StudyGroup> = listOf(
        StudyGroup(
            id = "sg_1",
            name = "Maharashtra 10th Toppers 2025/2026",
            description = "Active revision group discussing daily chapter challenges and hard numericals.",
            membersCount = 1420,
            recentActivity = "Rohan posted a solved proof of B.P.T. Theorem with alternate segment logic"
        ),
        StudyGroup(
            id = "sg_2",
            name = "Science Olympiad & SSC 95%+ Club",
            description = "Deep dive into chemical equations, genetics, and electric motor/generator working.",
            membersCount = 980,
            recentActivity = "Pooja shared a formula sheet for Gravitation & Lenses"
        ),
        StudyGroup(
            id = "sg_3",
            name = "Maths 100/100 Mission (Pune & Mumbai)",
            description = "Geometry constructions, trigonometry height/distance, and statistics pie charts.",
            membersCount = 1150,
            recentActivity = "Aditya discussed quadratic equation word problem shortcuts"
        )
    )

    fun getLeaderboard(): List<LeaderboardEntry> = listOf(
        LeaderboardEntry(1, "Aditya Kadam", "Pune", 3450, 19),
        LeaderboardEntry(2, "Sneha Joshi", "Nagpur", 3280, 17),
        LeaderboardEntry(3, "Tanmay Shinde", "Nashik", 3120, 15),
        LeaderboardEntry(4, "You (Student)", "Maharashtra", 2850, 12, isCurrentUser = true),
        LeaderboardEntry(5, "Priya Patil", "Kolhapur", 2790, 14),
        LeaderboardEntry(6, "Omkar More", "Thane", 2640, 11),
        LeaderboardEntry(7, "Aniket Sawant", "Aurangabad", 2510, 10),
        LeaderboardEntry(8, "Rutuja Gaikwad", "Solapur", 2430, 9)
    )

    fun getDailyStudyTips(): List<String> = listOf(
        "NTR Vision Secret: For Science Part 1, draw labeled ray diagrams with proper arrows for incident and refracted rays to avoid losing marks.",
        "Topper Trick: Write 'Given', 'Formula', 'Substitution', 'Calculation', and 'Final Answer with Units' in all Physics numericals for guaranteed step-marks.",
        "Biology Tip: In classification questions, always write the Phylum name, Symmetry, Germ layers, and Coelom as mandatory bullet points.",
        "Maths Secret: In Coordinate Geometry, test collinearity using Slope formula [m = (y₂ - y₁)/(x₂ - x₁)] — it is 3x faster than distance formula!",
        "Exam Hack: For Quadratic word problems, always check if your answer makes physical sense (e.g. speed, age, or dimensions cannot be negative)."
    )
}
