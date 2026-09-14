package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import com.example.data.model.ChatMessage
import com.example.data.model.TeacherExpert
import com.example.data.repository.StudyRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TeacherChatScreen(
    modifier: Modifier = Modifier
) {
    val teachers = remember { StudyRepository.getExpertTeachers() }
    var selectedTeacher by remember { mutableStateOf(teachers.first()) }
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    var studentInput by remember { mutableStateOf("") }
    var isTeacherTyping by remember { mutableStateOf(false) }

    val chatMessages = remember(selectedTeacher.id) {
        mutableStateListOf(
            ChatMessage(
                id = "m_intro_${selectedTeacher.id}",
                senderName = selectedTeacher.name,
                text = selectedTeacher.welcomeMessage,
                isFromUser = false
            )
        )
    }

    fun sendTeacherQuery(text: String) {
        if (text.isBlank() || isTeacherTyping) return
        val userMsg = ChatMessage(
            id = "user_${System.currentTimeMillis()}",
            senderName = "You",
            text = text.trim(),
            isFromUser = true
        )
        chatMessages.add(userMsg)
        studentInput = ""
        isTeacherTyping = true

        coroutineScope.launch {
            listState.animateScrollToItem(chatMessages.size - 1)
            delay(1200L) // Simulate natural teacher response time

            val reply = when {
                text.contains("time", ignoreCase = true) || text.contains("schedule", ignoreCase = true) ->
                    "Excellent question! For SSC Board, dedicate 2 Pomodoro sessions (50 mins) every morning to Maths numericals, and 2 sessions in the evening to Science diagrams. Consistent daily effort beats last-minute cramming!"
                text.contains("diagram", ignoreCase = true) || text.contains("draw", ignoreCase = true) ->
                    "Always use a sharp HB pencil for board diagrams. Label parts strictly on the right side using a ruler, and write the figure caption below in block letters. Evaluators award 1 full mark for clean labeling!"
                text.contains("mark", ignoreCase = true) || text.contains("score", ignoreCase = true) ->
                    "In 3-mark and 5-mark questions, write in point-wise format (never long paragraphs). In Maths, highlight final answers inside rectangular boxes with correct units like cm² or m/s²."
                else ->
                    "Thank you for reaching out! I reviewed your doubt. Make sure to review the key formulas in Chapter Notes and attempt the previous year board questions. Feel free to send me any specific step you find confusing!"
            }

            chatMessages.add(
                ChatMessage(
                    id = "reply_${System.currentTimeMillis()}",
                    senderName = selectedTeacher.name,
                    text = reply,
                    isFromUser = false
                )
            )
            isTeacherTyping = false
            listState.animateScrollToItem(chatMessages.size - 1)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Teacher Selection Bar
        Surface(
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 2.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = "Select Expert Teacher for Guidance:",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    teachers.forEach { teacher ->
                        val isSelected = selectedTeacher.id == teacher.id
                        TeacherTabCard(
                            teacher = teacher,
                            isSelected = isSelected,
                            onSelect = { selectedTeacher = teacher },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        // Active Teacher Info Banner
        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF10B981))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${selectedTeacher.name} • ${selectedTeacher.experience}",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        // Messages List
        LazyColumn(
            state = listState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(vertical = 10.dp)
        ) {
            items(chatMessages, key = { it.id }) { msg ->
                val isUser = msg.isFromUser
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = if (isUser) Alignment.End else Alignment.Start
                ) {
                    Text(
                        text = msg.senderName,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = if (isUser) MaterialTheme.colorScheme.primary else Color(0xFF059669),
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                    )
                    Card(
                        shape = RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = if (isUser) 16.dp else 4.dp,
                            bottomEnd = if (isUser) 4.dp else 16.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isUser) MaterialTheme.colorScheme.primaryContainer
                            else MaterialTheme.colorScheme.surface
                        ),
                        border = if (!isUser) androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant) else null,
                        modifier = Modifier.widthIn(max = 320.dp)
                    ) {
                        Text(
                            text = msg.text,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }

            if (isTeacherTyping) {
                item {
                    Text(
                        text = "${selectedTeacher.name} is writing advice...",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }

        // Bottom Input
        Surface(
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 4.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = studentInput,
                    onValueChange = { studentInput = it },
                    placeholder = { Text("Ask your teacher for advice...", fontSize = 13.sp) },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(24.dp),
                    maxLines = 3
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = { sendTeacherQuery(studentInput) },
                    enabled = studentInput.isNotBlank() && !isTeacherTyping,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(
                            if (studentInput.isNotBlank() && !isTeacherTyping) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.surfaceVariant
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Send,
                        contentDescription = "Send",
                        tint = if (studentInput.isNotBlank() && !isTeacherTyping) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun TeacherTabCard(
    teacher: TeacherExpert,
    isSelected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
        ),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
        ),
        modifier = modifier.clickable { onSelect() }
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = teacher.avatarInitials,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = teacher.name.substringAfter("Prof. ").substringAfter("Dr. "),
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
            Text(
                text = teacher.subject.split(" ").first(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 10.sp
            )
        }
    }
}
