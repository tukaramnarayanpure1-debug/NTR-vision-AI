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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Chapter
import com.example.data.model.SubjectType
import com.example.data.repository.StudyRepository
import com.example.data.repository.UserProgressRepository

@Composable
fun ChaptersListScreen(
    userProgressRepo: UserProgressRepository,
    onChapterSelected: (Chapter) -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedSubject by remember { mutableStateOf<SubjectType?>(null) }

    val allChapters = remember { StudyRepository.getAllChapters() }
    val completedChapters by userProgressRepo.completedChapters.collectAsState()

    val filteredChapters = remember(searchQuery, selectedSubject) {
        allChapters.filter { ch ->
            val matchesSubject = selectedSubject == null || ch.subjectType == selectedSubject
            val matchesQuery = searchQuery.isBlank() ||
                    ch.title.contains(searchQuery, ignoreCase = true) ||
                    ch.marathiTitle.contains(searchQuery, ignoreCase = true) ||
                    ch.summary.contains(searchQuery, ignoreCase = true) ||
                    ch.keyFormulas.any { it.contains(searchQuery, ignoreCase = true) }
            matchesSubject && matchesQuery
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Search bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search any chapter, formula, or law...", fontSize = 13.sp) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(Icons.Default.Clear, contentDescription = "Clear")
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Subject Horizontal Filters
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                FilterChip(
                    selected = selectedSubject == null,
                    onClick = { selectedSubject = null },
                    label = { Text("All (${allChapters.size})", fontSize = 12.sp) }
                )
            }
            items(SubjectType.entries.toTypedArray()) { sub ->
                val count = allChapters.count { it.subjectType == sub }
                FilterChip(
                    selected = selectedSubject == sub,
                    onClick = { selectedSubject = sub },
                    label = { Text("${sub.shortName} ($count)", fontSize = 12.sp) }
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Subject Overview Progress Banner
        val totalCount = filteredChapters.size
        val completedCount = filteredChapters.count { completedChapters.contains(it.id) }
        val completionPercent = if (totalCount > 0) (completedCount * 100) / totalCount else 0

        Surface(
            shape = RoundedCornerShape(12.dp),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Progress: $completedCount of $totalCount Chapters Finished ($completionPercent%)",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold
                )
                LinearProgressIndicator(
                    progress = { if (totalCount > 0) completedCount.toFloat() / totalCount else 0f },
                    modifier = Modifier
                        .width(72.dp)
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp)),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Chapters List
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 72.dp)
        ) {
            items(filteredChapters, key = { it.id }) { chapter ->
                val isCompleted = completedChapters.contains(chapter.id)
                ChapterCardItem(
                    chapter = chapter,
                    isCompleted = isCompleted,
                    onToggleComplete = { userProgressRepo.toggleChapterCompletion(chapter.id) },
                    onClick = { onChapterSelected(chapter) }
                )
            }
        }
    }
}

@Composable
private fun ChapterCardItem(
    chapter: Chapter,
    isCompleted: Boolean,
    onToggleComplete: () -> Unit,
    onClick: () -> Unit
) {
    val subjectBadgeColor = when (chapter.subjectType) {
        SubjectType.SCIENCE_1 -> Color(0xFF3B82F6)
        SubjectType.SCIENCE_2 -> Color(0xFF10B981)
        SubjectType.MATH_1 -> Color(0xFFF59E0B)
        SubjectType.MATH_2 -> Color(0xFF8B5CF6)
        SubjectType.MARATHI -> Color(0xFFEC4899)
        SubjectType.ENGLISH -> Color(0xFF06B6D4)
        SubjectType.HISTORY -> Color(0xFFEA580C)
        SubjectType.GEOGRAPHY -> Color(0xFF14B8A6)
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isCompleted) MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
            else MaterialTheme.colorScheme.surface
        ),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            if (isCompleted) Color(0xFF10B981).copy(alpha = 0.4f) else MaterialTheme.colorScheme.outlineVariant
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = subjectBadgeColor.copy(alpha = 0.15f)
                ) {
                    Text(
                        text = chapter.subjectType.displayName,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = subjectBadgeColor,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

                IconButton(
                    onClick = onToggleComplete,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = if (isCompleted) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
                        contentDescription = "Completed",
                        tint = if (isCompleted) Color(0xFF10B981) else MaterialTheme.colorScheme.outline
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .clip(CircleShape)
                        .background(subjectBadgeColor.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${chapter.chapterNumber}",
                        fontWeight = FontWeight.Bold,
                        color = subjectBadgeColor,
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = chapter.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = chapter.marathiTitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = chapter.summary,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Action row tags
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)
                    ) {
                        Text(
                            text = "📖 25 Pages",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFF059669).copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = "🔬 Scientific Reasons",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF059669),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFF7C3AED).copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = "🎯 PYQ & Future",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF7C3AED),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }

                Text(
                    text = "Open Notes ➔",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
