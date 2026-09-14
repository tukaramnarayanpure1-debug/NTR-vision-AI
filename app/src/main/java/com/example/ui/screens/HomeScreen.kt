package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Chapter
import com.example.data.model.SubjectType
import com.example.data.repository.StudyRepository
import com.example.data.repository.UserProgressRepository

@Composable
fun HomeScreen(
    userProgressRepo: UserProgressRepository,
    onNavigateToSubject: (SubjectType) -> Unit,
    onNavigateToChapter: (Chapter) -> Unit,
    onNavigateToAi: () -> Unit,
    onNavigateToPomodoro: () -> Unit,
    onNavigateToPyq: () -> Unit,
    onNavigateToTeachers: () -> Unit,
    onNavigateToCommunity: () -> Unit,
    onOpenSubscriptionDialog: () -> Unit,
    onNavigateToAccount: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val streakDays by userProgressRepo.streakDays.collectAsState()
    val totalMinutes by userProgressRepo.totalStudyMinutes.collectAsState()
    val completedChapters by userProgressRepo.completedChapters.collectAsState()
    val isSubscribed by userProgressRepo.isSubscribed.collectAsState()
    val studentName by userProgressRepo.studentName.collectAsState()

    val avatarInitials = remember(studentName) {
        studentName.split(" ")
            .filter { it.isNotBlank() }
            .mapNotNull { it.firstOrNull()?.uppercase() }
            .take(2)
            .joinToString("")
            .ifEmpty { "TN" }
    }

    val allChapters = remember { StudyRepository.getAllChapters() }
    val featuredChapter = remember { allChapters.firstOrNull() ?: allChapters[0] }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 80.dp)
    ) {
        // App Header & VIP Badge
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "NTR Vision AI",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Powered by NTR vision AI • Maharashtra SSC",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.Medium
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = if (isSubscribed) Color(0xFF10B981).copy(alpha = 0.15f) else Color(0xFFF59E0B).copy(alpha = 0.15f),
                        border = androidx.compose.foundation.BorderStroke(
                            1.dp,
                            if (isSubscribed) Color(0xFF10B981) else Color(0xFFF59E0B)
                        ),
                        modifier = Modifier.clickable { onOpenSubscriptionDialog() }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
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
                                text = if (isSubscribed) "VIP Pro" else "Get VIP",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = if (isSubscribed) Color(0xFF10B981) else Color(0xFFD97706)
                            )
                        }
                    }

                    // Account Profile Avatar Button
                    Surface(
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier
                            .size(36.dp)
                            .clickable { onNavigateToAccount() }
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = avatarInitials,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }
                }
            }
        }

        // Daily Streak & Progress Banner
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFF59E0B)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocalFireDepartment,
                                    contentDescription = "Streak",
                                    tint = Color.White,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = "$streakDays Days Streak",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Daily learning goal active",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "${completedChapters.size}/${allChapters.size}",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "Chapters done",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    LinearProgressIndicator(
                        progress = { completedChapters.size.toFloat() / allChapters.size.coerceAtLeast(1) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
            }
        }

        // Quick Feature Shortcuts (AI Tutor, Pomodoro, PYQs, Teachers)
        item {
            Text(
                text = "Study Tools & Boosters",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                QuickActionCard(
                    title = "AI Doubt Solver",
                    subtitle = "24/7 Textbook AI",
                    icon = Icons.Default.AutoAwesome,
                    iconBgColor = Color(0xFF2563EB),
                    onClick = onNavigateToAi,
                    modifier = Modifier.weight(1f)
                )
                QuickActionCard(
                    title = "Pomodoro Timer",
                    subtitle = "Boost 25m Focus",
                    icon = Icons.Default.Timer,
                    iconBgColor = Color(0xFFD97706),
                    onClick = onNavigateToPomodoro,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                QuickActionCard(
                    title = "Board Papers",
                    subtitle = "Model Answers & PYQs",
                    icon = Icons.Default.Assignment,
                    iconBgColor = Color(0xFF059669),
                    onClick = onNavigateToPyq,
                    modifier = Modifier.weight(1f)
                )
                QuickActionCard(
                    title = "Expert Teachers",
                    subtitle = "1-on-1 Guidance",
                    icon = Icons.Default.SupportAgent,
                    iconBgColor = Color(0xFF7C3AED),
                    onClick = onNavigateToTeachers,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // 4 Core Subject Pillars
        item {
            Text(
                text = "Maharashtra SSC Subjects",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        items(SubjectType.entries.toTypedArray()) { subject ->
            val chapters = allChapters.filter { it.subjectType == subject }
            val completedInSubject = chapters.count { completedChapters.contains(it.id) }

            SubjectCard(
                subject = subject,
                chapterCount = chapters.size,
                completedCount = completedInSubject,
                onClick = { onNavigateToSubject(subject) }
            )
        }

        // Today's Recommended Topic Card
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onNavigateToChapter(featuredChapter) }
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Recommended Focus for Today",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = featuredChapter.title,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${featuredChapter.marathiTitle} • Mind map & formulas ready",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun QuickActionCard(
    title: String,
    subtitle: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconBgColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = modifier.clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(iconBgColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconBgColor,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1
            )
        }
    }
}

@Composable
private fun SubjectCard(
    subject: SubjectType,
    chapterCount: Int,
    completedCount: Int,
    onClick: () -> Unit
) {
    val (badgeBg, accentColor) = when (subject) {
        SubjectType.SCIENCE_1 -> Pair(Color(0xFF3B82F6), Color(0xFF1D4ED8))
        SubjectType.SCIENCE_2 -> Pair(Color(0xFF10B981), Color(0xFF047857))
        SubjectType.MATH_1 -> Pair(Color(0xFFF59E0B), Color(0xFFD97706))
        SubjectType.MATH_2 -> Pair(Color(0xFF8B5CF6), Color(0xFF6D28D9))
        SubjectType.MARATHI -> Pair(Color(0xFFEC4899), Color(0xFFBE185D))
        SubjectType.ENGLISH -> Pair(Color(0xFF06B6D4), Color(0xFF0E7490))
        SubjectType.HISTORY -> Pair(Color(0xFFEA580C), Color(0xFFC2410C))
        SubjectType.GEOGRAPHY -> Pair(Color(0xFF14B8A6), Color(0xFF0F766E))
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(badgeBg.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = when (subject) {
                        SubjectType.SCIENCE_1 -> Icons.Default.Science
                        SubjectType.SCIENCE_2 -> Icons.Default.Biotech
                        SubjectType.MATH_1 -> Icons.Default.Calculate
                        SubjectType.MATH_2 -> Icons.Default.SquareFoot
                        SubjectType.MARATHI -> Icons.Default.AutoStories
                        SubjectType.ENGLISH -> Icons.Default.Translate
                        SubjectType.HISTORY -> Icons.Default.AccountBalance
                        SubjectType.GEOGRAPHY -> Icons.Default.Public
                    },
                    contentDescription = null,
                    tint = badgeBg,
                    modifier = Modifier.size(26.dp)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = subject.displayName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$chapterCount Chapters • 25 In-Depth Pages per Chapter",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Prompt Scientific Reasons • 10-Yr PYQs & Future Qs",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "Open",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
