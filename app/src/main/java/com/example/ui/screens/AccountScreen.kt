package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.repository.UserProgressRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(
    userProgressRepo: UserProgressRepository,
    onOpenSubscriptionDialog: () -> Unit,
    onNavigateToChapters: () -> Unit,
    onNavigateToPapers: () -> Unit,
    onNavigateToTeacherChat: () -> Unit,
    modifier: Modifier = Modifier
) {
    val streak by userProgressRepo.streakDays.collectAsState()
    val isSubscribed by userProgressRepo.isSubscribed.collectAsState()
    val darkModeEnabled by userProgressRepo.darkModeEnabled.collectAsState()
    val completedSessions by userProgressRepo.pomodoroSessions.collectAsState()
    val totalMinutes by userProgressRepo.totalStudyMinutes.collectAsState()
    val studentName by userProgressRepo.studentName.collectAsState()
    val userEmail by userProgressRepo.studentEmail.collectAsState()

    var showEditProfileDialog by remember { mutableStateOf(false) }
    var targetPercentage by remember { mutableFloatStateOf(95f) }
    var showResetConfirmation by remember { mutableStateOf(false) }
    var studyReminderActive by remember { mutableStateOf(true) }

    val avatarInitials = remember(studentName) {
        studentName.split(" ")
            .filter { it.isNotBlank() }
            .mapNotNull { it.firstOrNull()?.uppercase() }
            .take(2)
            .joinToString("")
            .ifEmpty { "TN" }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("account_screen")
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 80.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Profile Header Card
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("account_profile_card")
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    // Decorative gradient background strip
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(72.dp)
                            .background(
                                Brush.horizontalGradient(
                                    listOf(Color(0xFF2563EB), Color(0xFF7C3AED), Color(0xFFDB2777))
                                )
                            )
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 28.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Avatar
                        Box(contentAlignment = Alignment.BottomEnd) {
                            Surface(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primary,
                                border = androidx.compose.foundation.BorderStroke(3.dp, MaterialTheme.colorScheme.surface),
                                modifier = Modifier.size(80.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = avatarInitials,
                                        color = Color.White,
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            if (isSubscribed) {
                                Surface(
                                    shape = CircleShape,
                                    color = Color(0xFF10B981),
                                    modifier = Modifier
                                        .size(26.dp)
                                        .offset(x = 2.dp, y = 2.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = "Verified VIP",
                                            tint = Color.White,
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = studentName,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = userEmail,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            SuggestionChip(
                                onClick = {},
                                label = { Text("Maharashtra State Board") },
                                colors = SuggestionChipDefaults.suggestionChipColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                                )
                            )
                            SuggestionChip(
                                onClick = {},
                                label = { Text("Class 10th (SSC)") },
                                colors = SuggestionChipDefaults.suggestionChipColors(
                                    containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Edit Profile button
                        OutlinedButton(
                            onClick = { showEditProfileDialog = true },
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp)
                        ) {
                            Icon(Icons.Default.Edit, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Edit Profile Details", fontSize = 13.sp)
                        }
                    }
                }
            }
        }

        // VIP Subscription Banner
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isSubscribed) Color(0xFFECFDF5) else Color(0xFFFFFBEB)
                ),
                border = androidx.compose.foundation.BorderStroke(
                    1.dp,
                    if (isSubscribed) Color(0xFF10B981) else Color(0xFFF59E0B)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onOpenSubscriptionDialog() }
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = CircleShape,
                        color = if (isSubscribed) Color(0xFF10B981) else Color(0xFFF59E0B),
                        modifier = Modifier.size(46.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = if (isSubscribed) Icons.Default.WorkspacePremium else Icons.Default.Stars,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(26.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (isSubscribed) "NTR Vision AI Pro Active" else "Upgrade to NTR Vision Pro",
                            fontWeight = FontWeight.Bold,
                            color = if (isSubscribed) Color(0xFF065F46) else Color(0xFF92400E),
                            fontSize = 16.sp
                        )
                        Text(
                            text = if (isSubscribed)
                                "Lifetime Access • All 10 Years Papers & AI Tutor Unlocked"
                            else
                                "Use free code '28 NTR vision' for free VIP activation",
                            fontSize = 12.sp,
                            color = if (isSubscribed) Color(0xFF047857) else Color(0xFFB45309)
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Details",
                        tint = if (isSubscribed) Color(0xFF10B981) else Color(0xFFF59E0B)
                    )
                }
            }
        }

        // Academic Target & Exam Countdown
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.TrackChanges,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "SSC Board Target Score",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                        Text(
                            text = "${targetPercentage.toInt()}%",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Slider(
                        value = targetPercentage,
                        onValueChange = { targetPercentage = it },
                        valueRange = 70f..100f,
                        steps = 5,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("70% First Class", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text("85% Distinction", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text("100% State Ranker", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }

                    Divider(modifier = Modifier.padding(vertical = 12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.15f),
                            modifier = Modifier.padding(end = 12.dp)
                        ) {
                            Icon(
                                Icons.Default.Event,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        Column {
                            Text(
                                text = "Maharashtra SSC Board Exams March 2025",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 13.sp
                            )
                            Text(
                                text = "Preparation status: 8 Subjects active • 10 Years papers ready",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }

        // Student Study Stats Grid
        item {
            Text(
                text = "Study Activity & Performance",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                StatCard(
                    title = "Daily Streak",
                    value = "$streak Days 🔥",
                    subtitle = "Consistent daily study",
                    icon = Icons.Default.LocalFireDepartment,
                    iconColor = Color(0xFFEA580C),
                    modifier = Modifier.weight(1f)
                )
                StatCard(
                    title = "Pomodoro Sessions",
                    value = "$completedSessions Focus ⏱️",
                    subtitle = "Deep work sessions",
                    icon = Icons.Default.Timer,
                    iconColor = Color(0xFF2563EB),
                    modifier = Modifier.weight(1f)
                )
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                StatCard(
                    title = "Covered Subjects",
                    value = "8 / 8 Subjects",
                    subtitle = "Sci, Math, Marathi, Eng, Hist, Geo",
                    icon = Icons.Default.MenuBook,
                    iconColor = Color(0xFF10B981),
                    modifier = Modifier.weight(1f)
                )
                StatCard(
                    title = "10 Years Papers",
                    value = "2015 - 2024",
                    subtitle = "Marking schemes & answers",
                    icon = Icons.Default.Assignment,
                    iconColor = Color(0xFF7C3AED),
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Quick Shortcuts
        item {
            Text(
                text = "Quick Study Shortcuts",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    AccountOptionRow(
                        title = "All Subject Chapters & Mind Maps",
                        subtitle = "Science, Math, Marathi, English, इतिहास, भूगोल",
                        icon = Icons.Default.AutoStories,
                        onClick = onNavigateToChapters
                    )
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                    AccountOptionRow(
                        title = "10 Years Board Papers (2015-2024)",
                        subtitle = "Official question sets with model step answers",
                        icon = Icons.Default.FolderShared,
                        onClick = onNavigateToPapers
                    )
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                    AccountOptionRow(
                        title = "1-on-1 Expert Teacher Guidance",
                        subtitle = "Connect with board paper checkers for doubts",
                        icon = Icons.Default.School,
                        onClick = onNavigateToTeacherChat
                    )
                }
            }
        }

        // Preferences & App Settings
        item {
            Text(
                text = "App Settings & Offline Access",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    // Dark Mode
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                if (darkModeEnabled) Icons.Default.DarkMode else Icons.Default.LightMode,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text("Dark Mode", fontWeight = FontWeight.SemiBold)
                                Text("High contrast for night revision", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                        Switch(
                            checked = darkModeEnabled,
                            onCheckedChange = { userProgressRepo.toggleDarkMode() }
                        )
                    }

                    Divider(modifier = Modifier.padding(vertical = 12.dp))

                    // Study Reminder
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Default.NotificationsActive,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text("Daily Study Notification", fontWeight = FontWeight.SemiBold)
                                Text("Remind me for evening study sessions", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                        Switch(
                            checked = studyReminderActive,
                            onCheckedChange = { studyReminderActive = it }
                        )
                    }

                    Divider(modifier = Modifier.padding(vertical = 12.dp))

                    // Offline Material Status
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.CloudDone,
                            contentDescription = null,
                            tint = Color(0xFF10B981)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text("Offline Study Content", fontWeight = FontWeight.SemiBold)
                            Text("100% offline access to all notes, formulas & mind maps", fontSize = 12.sp, color = Color(0xFF059669))
                        }
                    }

                    Divider(modifier = Modifier.padding(vertical = 12.dp))

                    // Reset Data Button
                    OutlinedButton(
                        onClick = { showResetConfirmation = true },
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.error),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.RestartAlt, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Reset Study Streak & Progress")
                    }
                }
            }
        }

        // Branding
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "NTR Vision AI",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Maharashtra State Board SSC Complete Learning Companion",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Version 2.0.0 • Offline Ready",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }
    }

    // Edit Profile Dialog
    if (showEditProfileDialog) {
        var tempName by remember { mutableStateOf(studentName) }
        var tempEmail by remember { mutableStateOf(userEmail) }

        AlertDialog(
            onDismissRequest = { showEditProfileDialog = false },
            title = { Text("Edit Student Profile") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    OutlinedTextField(
                        value = tempName,
                        onValueChange = { tempName = it },
                        label = { Text("Student Name") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = tempEmail,
                        onValueChange = { tempEmail = it },
                        label = { Text("Email Address") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "Board: Maharashtra State Board • SSC Class 10th",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val finalName = if (tempName.isNotBlank()) tempName.trim() else studentName
                        val finalEmail = if (tempEmail.isNotBlank()) tempEmail.trim() else userEmail
                        userProgressRepo.updateProfile(finalName, finalEmail)
                        showEditProfileDialog = false
                    }
                ) {
                    Text("Save Changes")
                }
            },
            dismissButton = {
                TextButton(onClick = { showEditProfileDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    // Reset Progress Confirmation Dialog
    if (showResetConfirmation) {
        AlertDialog(
            onDismissRequest = { showResetConfirmation = false },
            title = { Text("Reset Study Progress?") },
            text = { Text("Are you sure you want to reset your daily streak and Pomodoro study count? Your notes and saved materials will remain intact.") },
            confirmButton = {
                Button(
                    onClick = {
                        userProgressRepo.resetProgress()
                        showResetConfirmation = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Yes, Reset")
                }
            },
            dismissButton = {
                TextButton(onClick = { showResetConfirmation = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun StatCard(
    title: String,
    value: String,
    subtitle: String,
    icon: ImageVector,
    iconColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text(text = value, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = subtitle, fontSize = 11.sp, color = MaterialTheme.colorScheme.outline)
        }
    }
}

@Composable
fun AccountOptionRow(
    title: String,
    subtitle: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
            modifier = Modifier.size(40.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(14.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
            Text(text = subtitle, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }

        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.outline,
            modifier = Modifier.size(20.dp)
        )
    }
}
