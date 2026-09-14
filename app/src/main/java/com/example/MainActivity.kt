package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Chapter
import com.example.data.model.SubjectType
import com.example.data.repository.StudyRepository
import com.example.data.repository.UserProgressRepository
import com.example.ui.components.SubscriptionDialog
import com.example.ui.screens.*
import com.example.ui.theme.MyApplicationTheme

enum class NavDestination(val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    HOME("Home", Icons.Default.Home),
    CHAPTERS("Chapters", Icons.Default.MenuBook),
    AI_TUTOR("AI Doubt", Icons.Default.AutoAwesome),
    POMODORO("Focus", Icons.Default.Timer),
    PAPERS("PYQs", Icons.Default.Assignment),
    ACCOUNT("Account", Icons.Default.AccountCircle)
}

class MainActivity : ComponentActivity() {
    private lateinit var userProgressRepo: UserProgressRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        userProgressRepo = UserProgressRepository(applicationContext)

        setContent {
            val darkModeEnabled by userProgressRepo.darkModeEnabled.collectAsState()

            MyApplicationTheme(darkTheme = darkModeEnabled) {
                MainAppScreen(userProgressRepo = userProgressRepo)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScreen(userProgressRepo: UserProgressRepository) {
    var currentDestination by remember { mutableStateOf(NavDestination.HOME) }
    var activeChapter by remember { mutableStateOf<Chapter?>(null) }
    var showTeacherChat by remember { mutableStateOf(false) }
    var showCommunity by remember { mutableStateOf(false) }
    var showSubscriptionDialog by remember { mutableStateOf(false) }
    var aiInitialPrompt by remember { mutableStateOf("") }

    val darkModeEnabled by userProgressRepo.darkModeEnabled.collectAsState()
    val isSubscribed by userProgressRepo.isSubscribed.collectAsState()

    // Handle Android system back press
    BackHandler(enabled = activeChapter != null || showTeacherChat || showCommunity) {
        when {
            activeChapter != null -> activeChapter = null
            showTeacherChat -> showTeacherChat = false
            showCommunity -> showCommunity = false
        }
    }

    if (showSubscriptionDialog) {
        SubscriptionDialog(
            userProgressRepo = userProgressRepo,
            onDismiss = { showSubscriptionDialog = false }
        )
    }

    Scaffold(
        topBar = {
            if (activeChapter == null) {
                TopAppBar(
                    title = {
                        Column {
                            Text(
                                text = when {
                                    showTeacherChat -> "Expert Teacher Guidance"
                                    showCommunity -> "Toppers & Community"
                                    currentDestination == NavDestination.HOME -> "NTR Vision AI"
                                    currentDestination == NavDestination.CHAPTERS -> "Maharashtra SSC Chapters"
                                    currentDestination == NavDestination.AI_TUTOR -> "AI Doubt Solver"
                                    currentDestination == NavDestination.POMODORO -> "Pomodoro Focus"
                                    currentDestination == NavDestination.PAPERS -> "Board Previous Papers"
                                    currentDestination == NavDestination.ACCOUNT -> "My Account & Profile"
                                    else -> "NTR Vision AI"
                                },
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Powered by NTR vision AI",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    },
                    navigationIcon = {
                        if (showTeacherChat || showCommunity) {
                            IconButton(onClick = {
                                showTeacherChat = false
                                showCommunity = false
                            }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                            }
                        }
                    },
                    actions = {
                        // VIP status button
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = if (isSubscribed) Color(0xFF10B981).copy(alpha = 0.15f) else Color(0xFFF59E0B).copy(alpha = 0.15f),
                            border = androidx.compose.foundation.BorderStroke(
                                1.dp,
                                if (isSubscribed) Color(0xFF10B981) else Color(0xFFF59E0B)
                            ),
                            modifier = Modifier
                                .clickable { showSubscriptionDialog = true }
                                .padding(end = 4.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = if (isSubscribed) Icons.Default.WorkspacePremium else Icons.Default.Stars,
                                    contentDescription = null,
                                    tint = if (isSubscribed) Color(0xFF10B981) else Color(0xFFF59E0B),
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = if (isSubscribed) "VIP" else "PRO",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSubscribed) Color(0xFF10B981) else Color(0xFFD97706)
                                )
                            }
                        }

                        // Community & Leaderboard icon
                        IconButton(onClick = {
                            showCommunity = true
                            showTeacherChat = false
                        }) {
                            Icon(Icons.Default.Leaderboard, contentDescription = "Leaderboard")
                        }

                        // My Account icon
                        IconButton(onClick = {
                            currentDestination = NavDestination.ACCOUNT
                            showTeacherChat = false
                            showCommunity = false
                        }) {
                            Icon(
                                Icons.Default.AccountCircle,
                                contentDescription = "My Account",
                                tint = if (currentDestination == NavDestination.ACCOUNT) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                            )
                        }

                        // Dark Mode Toggle
                        IconButton(onClick = { userProgressRepo.toggleDarkMode() }) {
                            Icon(
                                imageVector = if (darkModeEnabled) Icons.Default.LightMode else Icons.Default.DarkMode,
                                contentDescription = "Toggle Dark Mode"
                            )
                        }
                    }
                )
            }
        },
        bottomBar = {
            if (activeChapter == null) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 4.dp
                ) {
                    NavDestination.entries.forEach { destination ->
                        val isSelected = currentDestination == destination && !showTeacherChat && !showCommunity
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                currentDestination = destination
                                showTeacherChat = false
                                showCommunity = false
                            },
                            icon = {
                                Icon(
                                    imageVector = destination.icon,
                                    contentDescription = destination.label
                                )
                            },
                            label = {
                                Text(
                                    text = destination.label,
                                    fontSize = 11.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                        )
                    }
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when {
                activeChapter != null -> {
                    ChapterDetailScreen(
                        chapter = activeChapter!!,
                        userProgressRepo = userProgressRepo,
                        onBack = { activeChapter = null },
                        onAskAi = { prompt ->
                            aiInitialPrompt = prompt
                            activeChapter = null
                            currentDestination = NavDestination.AI_TUTOR
                        }
                    )
                }

                showTeacherChat -> {
                    TeacherChatScreen()
                }

                showCommunity -> {
                    CommunityScreen(userProgressRepo = userProgressRepo)
                }

                currentDestination == NavDestination.HOME -> {
                    HomeScreen(
                        userProgressRepo = userProgressRepo,
                        onNavigateToSubject = {
                            currentDestination = NavDestination.CHAPTERS
                        },
                        onNavigateToChapter = { chapter ->
                            activeChapter = chapter
                        },
                        onNavigateToAi = {
                            currentDestination = NavDestination.AI_TUTOR
                        },
                        onNavigateToPomodoro = {
                            currentDestination = NavDestination.POMODORO
                        },
                        onNavigateToPyq = {
                            currentDestination = NavDestination.PAPERS
                        },
                        onNavigateToTeachers = {
                            showTeacherChat = true
                        },
                        onNavigateToCommunity = {
                            showCommunity = true
                        },
                        onOpenSubscriptionDialog = {
                            showSubscriptionDialog = true
                        },
                        onNavigateToAccount = {
                            currentDestination = NavDestination.ACCOUNT
                        }
                    )
                }

                currentDestination == NavDestination.CHAPTERS -> {
                    ChaptersListScreen(
                        userProgressRepo = userProgressRepo,
                        onChapterSelected = { chapter ->
                            activeChapter = chapter
                        }
                    )
                }

                currentDestination == NavDestination.AI_TUTOR -> {
                    AiTutorScreen(initialPrompt = aiInitialPrompt)
                }

                currentDestination == NavDestination.POMODORO -> {
                    PomodoroScreen(userProgressRepo = userProgressRepo)
                }

                currentDestination == NavDestination.PAPERS -> {
                    PreviousYearsPapersScreen()
                }

                currentDestination == NavDestination.ACCOUNT -> {
                    AccountScreen(
                        userProgressRepo = userProgressRepo,
                        onOpenSubscriptionDialog = { showSubscriptionDialog = true },
                        onNavigateToChapters = { currentDestination = NavDestination.CHAPTERS },
                        onNavigateToPapers = { currentDestination = NavDestination.PAPERS },
                        onNavigateToTeacherChat = { showTeacherChat = true }
                    )
                }
            }
        }
    }
}

