package com.example.ui.screens

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.repository.UserProgressRepository
import kotlinx.coroutines.delay

@Composable
fun PomodoroScreen(
    userProgressRepo: UserProgressRepository,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var selectedDurationMinutes by remember { mutableIntStateOf(25) }
    var secondsLeft by remember { mutableIntStateOf(25 * 60) }
    var isRunning by remember { mutableStateOf(false) }

    val totalSessions by userProgressRepo.pomodoroSessions.collectAsState()
    val totalMinutes by userProgressRepo.totalStudyMinutes.collectAsState()

    // Countdown effect
    LaunchedEffect(isRunning, secondsLeft) {
        if (isRunning && secondsLeft > 0) {
            delay(1000L)
            secondsLeft -= 1
        } else if (isRunning && secondsLeft == 0) {
            isRunning = false
            userProgressRepo.incrementPomodoroSession(selectedDurationMinutes)
            // Trigger gentle vibration alert
            val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator?.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                @Suppress("DEPRECATION")
                vibrator?.vibrate(500)
            }
            secondsLeft = selectedDurationMinutes * 60
        }
    }

    val totalSeconds = selectedDurationMinutes * 60
    val progress = if (totalSeconds > 0) (totalSeconds - secondsLeft).toFloat() / totalSeconds else 0f
    val animatedProgress by animateFloatAsState(targetValue = progress, label = "pomo_progress")

    val minutes = secondsLeft / 60
    val seconds = secondsLeft % 60
    val timeFormatted = String.format("%02d:%02d", minutes, seconds)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Header
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$totalSessions",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Sessions Done",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Divider(
                    modifier = Modifier
                        .height(36.dp)
                        .width(1.dp),
                    color = MaterialTheme.colorScheme.outlineVariant
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "$totalMinutes m",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Text(
                        text = "Focus Time",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Mode Selector (25m Focus / 5m Break / 15m Deep Break)
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(4.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            listOf(
                25 to "25m Focus",
                5 to "5m Break",
                15 to "15m Long Break"
            ).forEach { (dur, label) ->
                val isSelected = selectedDurationMinutes == dur
                Button(
                    onClick = {
                        if (!isRunning) {
                            selectedDurationMinutes = dur
                            secondsLeft = dur * 60
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                        contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    shape = RoundedCornerShape(16.dp),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp),
                    elevation = null
                ) {
                    Text(text = label, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal, fontSize = 13.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Large Circular Timer
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(240.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
        ) {
            CircularProgressIndicator(
                progress = { animatedProgress },
                modifier = Modifier.size(230.dp),
                strokeWidth = 10.dp,
                color = if (selectedDurationMinutes == 25) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.tertiary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = timeFormatted,
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = if (isRunning) "Deep Focus Active" else "Ready to Study",
                    style = MaterialTheme.typography.bodySmall,
                    color = if (isRunning) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Timer Controls
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    isRunning = false
                    secondsLeft = selectedDurationMinutes * 60
                },
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Icon(Icons.Default.Refresh, contentDescription = "Reset", tint = MaterialTheme.colorScheme.onSurface)
            }

            Button(
                onClick = { isRunning = !isRunning },
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isRunning) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                ),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 14.dp)
            ) {
                Icon(
                    imageVector = if (isRunning) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = if (isRunning) "Pause" else "Start",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (isRunning) "Pause Focus" else "Start Session",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Daily Motivation Card
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Lightbulb,
                    contentDescription = null,
                    tint = Color(0xFFF59E0B),
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "Pomodoro Academic Secret",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = "4 cycles of 25-minute uninterrupted study increases memory retention by 60% according to cognitive science.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
