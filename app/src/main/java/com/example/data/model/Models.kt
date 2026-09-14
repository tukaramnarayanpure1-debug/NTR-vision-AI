package com.example.data.model

enum class SubjectType(val id: String, val title: String, val subtitle: String, val part: String) {
    SCIENCE_1("sci_1", "Science & Technology", "Part 1 - Physics & Chemistry", "Part 1"),
    SCIENCE_2("sci_2", "Science & Technology", "Part 2 - Biology & Environment", "Part 2"),
    MATH_1("math_1", "Mathematics (Algebra)", "Part 1 - Algebra & Statistics", "Part 1"),
    MATH_2("math_2", "Mathematics (Geometry)", "Part 2 - Geometry & Trigonometry", "Part 2"),
    MARATHI("marathi", "मराठी (अक्षरभारती/कुमारभारती)", "गद्य, पद्य, व्याकरण व उपयोजित लेखन", "मराठी"),
    ENGLISH("english", "English (Kumarbharati)", "Prose, Poetry, Grammar & Writing Skills", "English"),
    HISTORY("history", "इतिहास व राज्यशास्त्र", "इतिहासलेखन, प्रसारमाध्यमे, पर्यटन, राज्यशास्त्र", "इतिहास"),
    GEOGRAPHY("geography", "भूगोल (भारत व ब्राझील)", "स्थान, प्राकृतिक, जलप्रणाली, हवामान, लोकसंख्या", "भूगोल");

    val displayName: String get() = when (this) {
        SCIENCE_1 -> "Science 1"
        SCIENCE_2 -> "Science 2"
        MATH_1 -> "Math 1 (Algebra)"
        MATH_2 -> "Math 2 (Geometry)"
        MARATHI -> "मराठी (Marathi)"
        ENGLISH -> "English"
        HISTORY -> "इतिहास (History)"
        GEOGRAPHY -> "भूगोल (Geography)"
    }

    val shortName: String get() = when (this) {
        SCIENCE_1 -> "Sci 1"
        SCIENCE_2 -> "Sci 2"
        MATH_1 -> "Math 1"
        MATH_2 -> "Math 2"
        MARATHI -> "मराठी"
        ENGLISH -> "English"
        HISTORY -> "इतिहास"
        GEOGRAPHY -> "भूगोल"
    }
}

data class MindMapNode(
    val id: String,
    val title: String,
    val description: String = "",
    val children: List<MindMapNode> = emptyList()
)

data class PracticeQuestion(
    val id: String,
    val question: String,
    val options: List<String> = emptyList(),
    val correctOptionIndex: Int = 0,
    val explanation: String,
    val isPuzzle: Boolean = false,
    val hint: String = ""
) {
    val correctAnswerIndex: Int get() = correctOptionIndex
}

data class Flashcard(
    val id: String,
    val title: String,
    val front: String,
    val back: String,
    val keyPoints: List<String> = emptyList()
) {
    val term: String get() = title
    val question: String get() = front
    val answer: String get() = back
}

data class ScientificReasonItem(
    val id: String,
    val question: String,
    val promptReason: String, // Point-by-point prompt scientific reasoning
    val scientificPrinciple: String = "",
    val keywords: List<String> = emptyList(),
    val examFrequency: String = "Board Frequently Asked"
)

data class BoardExamQuestionItem(
    val id: String,
    val questionText: String,
    val yearTag: String, // e.g. "[Board March 2024 - 3 Marks]" or "[Predicted 2025-2026 - High Probability]"
    val questionType: String, // "Give Scientific Reason", "Solved Numerical", "Distinguish Between", "Short Answer (2M)", "Brief Answer (3M)", "Long Answer (5M)", "Activity/Diagram"
    val marks: Int,
    val modelAnswer: String,
    val markingScheme: String,
    val isFuturePrediction: Boolean = false
)

data class PageSection(
    val sectionHeader: String,
    val body: String,
    val bulletPoints: List<String> = emptyList(),
    val formulasOrRules: List<String> = emptyList(),
    val scientificReasons: List<ScientificReasonItem> = emptyList(),
    val boardQuestions: List<BoardExamQuestionItem> = emptyList(),
    val topperNote: String = ""
)

data class ChapterPage(
    val pageNumber: Int, // 1 to 25
    val title: String,
    val subtitle: String,
    val category: String, // e.g., "Board Blueprint", "Scientific Reasons", "PYQs", "Future Predictions"
    val readingTimeMinutes: Int = 4,
    val sections: List<PageSection>
)

data class Chapter(
    val id: String,
    val chapterNumber: Int,
    val title: String,
    val marathiTitle: String,
    val subjectType: SubjectType,
    val summary: String,
    val keyFormulas: List<String>,
    val importantLawsOrTheorems: List<String>,
    val fullNotesMarkdown: String,
    val htmlContent: String,
    val mindMapRoot: MindMapNode,
    val questions: List<PracticeQuestion>,
    val flashcards: List<Flashcard>,
    val topperTips: List<String>
)

data class PreviousYearPaper(
    val id: String,
    val year: String,
    val subjectType: SubjectType,
    val title: String,
    val totalMarks: Int,
    val timeAllowed: String,
    val questionSets: List<PaperSection>
)

data class PaperSection(
    val sectionName: String,
    val totalMarks: Int,
    val instructions: String,
    val questions: List<PaperQuestion>
)

data class PaperQuestion(
    val qNum: String,
    val questionText: String,
    val marks: Int,
    val modelAnswer: String,
    val markingScheme: String
)

data class TeacherExpert(
    val id: String,
    val name: String,
    val subject: String,
    val experience: String,
    val avatarInitials: String,
    val status: String,
    val welcomeMessage: String
)

data class ChatMessage(
    val id: String,
    val sender: String,
    val message: String,
    val timestamp: Long = System.currentTimeMillis(),
    val isFromUser: Boolean
) {
    constructor(id: String, senderName: String, text: String, isFromUser: Boolean) :
        this(id, senderName, text, System.currentTimeMillis(), isFromUser)

    val senderName: String get() = sender
    val text: String get() = message
}

data class StudyGroup(
    val id: String,
    val name: String,
    val description: String,
    val membersCount: Int,
    val recentActivity: String
)

data class LeaderboardEntry(
    val rank: Int,
    val name: String,
    val district: String,
    val xp: Int,
    val streakDays: Int,
    val isCurrentUser: Boolean = false
) {
    val city: String get() = district
    val score: Int get() = xp
    val streak: Int get() = streakDays
}

