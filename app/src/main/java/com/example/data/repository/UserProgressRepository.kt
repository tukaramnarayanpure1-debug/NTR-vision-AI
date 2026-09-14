package com.example.data.repository

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class UserProgressRepository(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("ntr_student_prefs", Context.MODE_PRIVATE)

    private val _studentEmail = MutableStateFlow(
        prefs.getString("student_email", "tukaramnarayanpure1@gmail.com") ?: "tukaramnarayanpure1@gmail.com"
    )
    val studentEmail: StateFlow<String> = _studentEmail.asStateFlow()

    private val _studentName = MutableStateFlow(
        prefs.getString("student_name", "Tukaram Narayanpure") ?: "Tukaram Narayanpure"
    )
    val studentName: StateFlow<String> = _studentName.asStateFlow()

    private val _streakDays = MutableStateFlow(prefs.getInt("streak_days", 12))
    val streakDays: StateFlow<Int> = _streakDays.asStateFlow()

    private val _totalStudyMinutes = MutableStateFlow(prefs.getInt("study_minutes", 185))
    val totalStudyMinutes: StateFlow<Int> = _totalStudyMinutes.asStateFlow()

    private val _pomodoroSessions = MutableStateFlow(prefs.getInt("pomodoro_sessions", 6))
    val pomodoroSessions: StateFlow<Int> = _pomodoroSessions.asStateFlow()

    private val _isSubscribed = MutableStateFlow(prefs.getBoolean("is_subscribed", false))
    val isSubscribed: StateFlow<Boolean> = _isSubscribed.asStateFlow()

    private val _isVipByCode = MutableStateFlow(prefs.getBoolean("is_vip_by_code", false))
    val isVipByCode: StateFlow<Boolean> = _isVipByCode.asStateFlow()

    private val _completedChapters = MutableStateFlow(
        prefs.getStringSet("completed_chapters", setOf("sci1_ch1", "m1_ch1", "sci2_ch1")) ?: setOf()
    )
    val completedChapters: StateFlow<Set<String>> = _completedChapters.asStateFlow()

    private val _masteredFlashcards = MutableStateFlow(
        prefs.getStringSet("mastered_cards", setOf("fc_g1", "fc_le1")) ?: setOf()
    )
    val masteredFlashcards: StateFlow<Set<String>> = _masteredFlashcards.asStateFlow()

    private val _darkModeEnabled = MutableStateFlow(prefs.getBoolean("dark_mode", true))
    val darkModeEnabled: StateFlow<Boolean> = _darkModeEnabled.asStateFlow()

    init {
        checkDailyStreak()
    }

    private fun checkDailyStreak() {
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        val lastStudyDay = prefs.getString("last_study_day", "")
        if (lastStudyDay != today) {
            // Updated for new session
            prefs.edit().putString("last_study_day", today).apply()
        }
    }

    fun addStudyMinutes(minutes: Int) {
        val updated = _totalStudyMinutes.value + minutes
        _totalStudyMinutes.value = updated
        prefs.edit().putInt("study_minutes", updated).apply()
    }

    fun incrementPomodoroSession(sessionMinutes: Int = 25) {
        val updatedCount = _pomodoroSessions.value + 1
        _pomodoroSessions.value = updatedCount
        prefs.edit().putInt("pomodoro_sessions", updatedCount).apply()
        addStudyMinutes(sessionMinutes)
    }

    fun toggleChapterCompletion(chapterId: String) {
        val current = _completedChapters.value.toMutableSet()
        if (current.contains(chapterId)) {
            current.remove(chapterId)
        } else {
            current.add(chapterId)
        }
        _completedChapters.value = current
        prefs.edit().putStringSet("completed_chapters", current).apply()
    }

    fun markFlashcardMastered(cardId: String, mastered: Boolean) {
        val current = _masteredFlashcards.value.toMutableSet()
        if (mastered) {
            current.add(cardId)
        } else {
            current.remove(cardId)
        }
        _masteredFlashcards.value = current
        prefs.edit().putStringSet("mastered_cards", current).apply()
    }

    fun applySubscriptionCode(rawCode: String): Boolean {
        val cleaned = rawCode.trim().lowercase(Locale.getDefault()).replace("\\s+".toRegex(), " ")
        // Expected code: "28 ntr vision" or "28ntrvision"
        if (cleaned == "28 ntr vision" || cleaned == "28ntrvision") {
            _isSubscribed.value = true
            _isVipByCode.value = true
            prefs.edit()
                .putBoolean("is_subscribed", true)
                .putBoolean("is_vip_by_code", true)
                .apply()
            return true
        }
        return false
    }

    fun activateDirectSubscription() {
        _isSubscribed.value = true
        prefs.edit().putBoolean("is_subscribed", true).apply()
    }

    fun toggleDarkMode() {
        val next = !_darkModeEnabled.value
        _darkModeEnabled.value = next
        prefs.edit().putBoolean("dark_mode", next).apply()
    }

    fun updateProfile(name: String, email: String) {
        _studentName.value = name
        _studentEmail.value = email
        prefs.edit()
            .putString("student_name", name)
            .putString("student_email", email)
            .apply()
    }

    fun resetProgress() {
        _streakDays.value = 1
        _totalStudyMinutes.value = 0
        _pomodoroSessions.value = 0
        prefs.edit()
            .putInt("streak_days", 1)
            .putInt("study_minutes", 0)
            .putInt("pomodoro_sessions", 0)
            .apply()
    }
}
