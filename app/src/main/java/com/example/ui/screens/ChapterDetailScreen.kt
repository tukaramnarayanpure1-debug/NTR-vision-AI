package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.*
import com.example.data.repository.ChapterPagesProvider
import com.example.data.repository.UserProgressRepository
import com.example.ui.components.HtmlContentViewer
import com.example.ui.components.MindMapViewer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterDetailScreen(
    chapter: Chapter,
    userProgressRepo: UserProgressRepository,
    onBack: () -> Unit,
    onAskAi: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("25-Page Book", "Scientific Reasons", "Board PYQs & Future", "Mind Map", "Quiz & Flashcards")

    val completedChapters by userProgressRepo.completedChapters.collectAsState()
    val isCompleted = completedChapters.contains(chapter.id)

    val pages = remember(chapter.id) {
        ChapterPagesProvider.get25PagesForChapter(chapter)
    }

    var currentPageIndex by remember { mutableIntStateOf(0) }
    var fontSizeMultiplier by remember { mutableFloatStateOf(1.0f) }
    var showJumpPageDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Ch ${chapter.chapterNumber}: ${chapter.title}",
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 1
                        )
                        Text(
                            text = "${chapter.marathiTitle} • 25 In-Depth Pages • ${chapter.subjectType.displayName}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    // Jump to Page quick action
                    IconButton(onClick = { showJumpPageDialog = true }) {
                        Icon(Icons.Default.AutoStories, contentDescription = "Jump to Page", tint = MaterialTheme.colorScheme.primary)
                    }

                    // Toggle complete
                    IconButton(onClick = { userProgressRepo.toggleChapterCompletion(chapter.id) }) {
                        Icon(
                            imageVector = if (isCompleted) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
                            contentDescription = "Toggle Complete",
                            tint = if (isCompleted) Color(0xFF10B981) else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            val currentCategory = pages.getOrNull(currentPageIndex)?.category ?: "Chapter Concepts"
            ExtendedFloatingActionButton(
                onClick = { onAskAi("Explain chapter '${chapter.title}' ($currentCategory) in detail with important questions and scientific reasons.") },
                icon = { Icon(Icons.Default.AutoAwesome, contentDescription = null) },
                text = { Text("Ask AI Doubt") },
                containerColor = MaterialTheme.colorScheme.primary
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Scrollable Tab Row
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                edgePadding = 12.dp,
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Text(
                                text = title,
                                fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal,
                                color = if (selectedTabIndex == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    )
                }
            }

            // Tab Content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                when (selectedTabIndex) {
                    0 -> PagedNotesReaderView(
                        pages = pages,
                        currentPageIndex = currentPageIndex,
                        onPageChange = { currentPageIndex = it },
                        fontSizeMultiplier = fontSizeMultiplier,
                        onFontSizeChange = { fontSizeMultiplier = it },
                        onOpenJumpDialog = { showJumpPageDialog = true }
                    )
                    1 -> DedicatedScientificReasonsView(
                        pages = pages,
                        chapterTitle = chapter.title,
                        onAskAi = onAskAi
                    )
                    2 -> DedicatedBoardPYQAndFutureView(
                        pages = pages,
                        chapterTitle = chapter.title,
                        onAskAi = onAskAi
                    )
                    3 -> MindMapViewer(rootNode = chapter.mindMapRoot)
                    4 -> QuizAndFlashcardsCombinedView(
                        chapter = chapter,
                        userProgressRepo = userProgressRepo
                    )
                }
            }
        }
    }

    // Jump to Page Dialog (Pages 1 to 25)
    if (showJumpPageDialog) {
        AlertDialog(
            onDismissRequest = { showJumpPageDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.MenuBook, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Jump to Page (1 to 25)", fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 380.dp)
                ) {
                    Text(
                        text = "Select any of the 25 in-depth academic study pages:",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(pages) { page ->
                            val isSelected = page.pageNumber - 1 == currentPageIndex
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                border = if (isSelected) androidx.compose.foundation.BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary) else null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        currentPageIndex = page.pageNumber - 1
                                        selectedTabIndex = 0
                                        showJumpPageDialog = false
                                    }
                            ) {
                                Row(
                                    modifier = Modifier.padding(10.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Surface(
                                        shape = CircleShape,
                                        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Box(contentAlignment = Alignment.Center) {
                                            Text(
                                                text = "${page.pageNumber}",
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.primary
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = page.title,
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                            maxLines = 1
                                        )
                                        Text(
                                            text = page.category,
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showJumpPageDialog = false }) {
                    Text("Close")
                }
            }
        )
    }
}

// -------------------------------------------------------------
// TAB 0: 25-PAGE BOOK READER VIEW
// -------------------------------------------------------------
@Composable
private fun PagedNotesReaderView(
    pages: List<ChapterPage>,
    currentPageIndex: Int,
    onPageChange: (Int) -> Unit,
    fontSizeMultiplier: Float,
    onFontSizeChange: (Float) -> Unit,
    onOpenJumpDialog: () -> Unit
) {
    val page = pages.getOrElse(currentPageIndex) { pages[0] }
    val listState = rememberLazyListState()

    // Reset scroll when page changes
    LaunchedEffect(currentPageIndex) {
        listState.scrollToItem(0)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Page Navigation Top Bar
        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Page Indicator & Category
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { onOpenJumpDialog() }
                ) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text(
                            text = "Page ${page.pageNumber} / ${pages.size}",
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                    Text(
                        text = page.category,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                // Font size adjuster
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = {
                            if (fontSizeMultiplier > 0.85f) onFontSizeChange(fontSizeMultiplier - 0.1f)
                        },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Text("A-", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    }
                    IconButton(
                        onClick = {
                            if (fontSizeMultiplier < 1.35f) onFontSizeChange(fontSizeMultiplier + 0.1f)
                        },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Text("A+", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }
                }
            }
        }

        // Horizontal Quick-Jump Pill Slider (1 to 25)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 10.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            pages.forEachIndexed { idx, p ->
                val isSelected = idx == currentPageIndex
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    modifier = Modifier.clickable { onPageChange(idx) }
                ) {
                    Text(
                        text = "P.${p.pageNumber}",
                        fontSize = 11.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }
        }

        Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

        // Page Body Content
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(top = 12.dp, bottom = 80.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Page Header Card
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "PAGE ${page.pageNumber} OF 25",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "⏱️ ${page.readingTimeMinutes} min study",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = page.title,
                            style = MaterialTheme.typography.titleLarge.copy(fontSize = (20 * fontSizeMultiplier).sp),
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        if (page.subtitle.isNotBlank()) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = page.subtitle,
                                style = MaterialTheme.typography.bodySmall.copy(fontSize = (13 * fontSizeMultiplier).sp),
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            // Page Sections
            items(page.sections) { section ->
                PageSectionCard(
                    section = section,
                    fontSizeMultiplier = fontSizeMultiplier
                )
            }

            // Bottom Navigation Card within page
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (currentPageIndex > 0) {
                        OutlinedButton(
                            onClick = { onPageChange(currentPageIndex - 1) },
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Icon(Icons.Default.ArrowBack, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Page ${page.pageNumber - 1}")
                        }
                    } else {
                        Spacer(modifier = Modifier.width(10.dp))
                    }

                    if (currentPageIndex < pages.size - 1) {
                        Button(
                            onClick = { onPageChange(currentPageIndex + 1) },
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text("Page ${page.pageNumber + 1}")
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
                        }
                    } else {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFF10B981).copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = "🎉 All 25 Pages Completed!",
                                color = Color(0xFF10B981),
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

// Card rendering each section inside a page
@Composable
private fun PageSectionCard(
    section: PageSection,
    fontSizeMultiplier: Float
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header
            Text(
                text = section.sectionHeader,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = (16 * fontSizeMultiplier).sp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Body
            if (section.body.isNotBlank()) {
                Text(
                    text = section.body,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = (14 * fontSizeMultiplier).sp),
                    lineHeight = (22 * fontSizeMultiplier).sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Bullet points
            if (section.bulletPoints.isNotEmpty()) {
                section.bulletPoints.forEach { point ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 3.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = "•",
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            fontSize = (16 * fontSizeMultiplier).sp,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            text = point,
                            style = MaterialTheme.typography.bodyMedium.copy(fontSize = (13.5f * fontSizeMultiplier).sp),
                            lineHeight = (20 * fontSizeMultiplier).sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
            }

            // Formulas or Rules
            if (section.formulasOrRules.isNotEmpty()) {
                section.formulasOrRules.forEach { formula ->
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Default.Functions,
                                contentDescription = null,
                                tint = Color(0xFFD97706),
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = formula,
                                style = MaterialTheme.typography.bodyMedium.copy(fontSize = (13.5f * fontSizeMultiplier).sp),
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }

            // Scientific Reasons Inside Section
            if (section.scientificReasons.isNotEmpty()) {
                Spacer(modifier = Modifier.height(6.dp))
                section.scientificReasons.forEach { sr ->
                    ScientificReasonItemCard(
                        item = sr,
                        fontSizeMultiplier = fontSizeMultiplier
                    )
                }
            }

            // Board Exam Questions Inside Section
            if (section.boardQuestions.isNotEmpty()) {
                Spacer(modifier = Modifier.height(6.dp))
                section.boardQuestions.forEach { q ->
                    BoardExamQuestionCard(
                        item = q,
                        fontSizeMultiplier = fontSizeMultiplier
                    )
                }
            }

            // Topper Note
            if (section.topperNote.isNotBlank()) {
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color(0xFFF59E0B).copy(alpha = 0.12f),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.4f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.Top) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFD97706), modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "Board Examiner Tip / Topper Secret",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = Color(0xFFB45309)
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = section.topperNote,
                                fontSize = (12.5f * fontSizeMultiplier).sp,
                                lineHeight = 18.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------
// SCIENTIFIC REASONS COMPONENT
// -------------------------------------------------------------
@Composable
private fun ScientificReasonItemCard(
    item: ScientificReasonItem,
    fontSizeMultiplier: Float = 1f
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFF059669),
                    modifier = Modifier.padding(bottom = 6.dp)
                ) {
                    Text(
                        text = "Q.2(A) Scientific Reason • 2 Marks",
                        color = Color.White,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
                Text(
                    text = item.examFrequency,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(0xFFD97706),
                    fontWeight = FontWeight.SemiBold
                )
            }

            Text(
                text = item.question,
                style = MaterialTheme.typography.titleSmall.copy(fontSize = (14.5f * fontSizeMultiplier).sp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(10.dp))

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surface,
                border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Prompt Scientific Reasoning (3-Step Board Answer):",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = item.promptReason,
                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = (13.5f * fontSizeMultiplier).sp),
                        lineHeight = (21 * fontSizeMultiplier).sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            if (item.keywords.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Mandatory Keywords: ",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Text(
                        text = item.keywords.joinToString(" • "),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------
// BOARD EXAM QUESTION COMPONENT (PYQ & FUTURE PREDICTED)
// -------------------------------------------------------------
@Composable
private fun BoardExamQuestionCard(
    item: BoardExamQuestionItem,
    fontSizeMultiplier: Float = 1f
) {
    val isFuture = item.isFuturePrediction
    val badgeColor = if (isFuture) Color(0xFF7C3AED) else Color(0xFF2563EB)

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)),
        border = androidx.compose.foundation.BorderStroke(1.dp, if (isFuture) Color(0xFF7C3AED).copy(alpha = 0.4f) else MaterialTheme.colorScheme.outlineVariant),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = badgeColor,
                    modifier = Modifier.padding(bottom = 6.dp)
                ) {
                    Text(
                        text = item.yearTag,
                        color = Color.White,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
                Text(
                    text = "${item.marks} Marks",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = badgeColor
                )
            }

            Text(
                text = item.questionText,
                style = MaterialTheme.typography.titleSmall.copy(fontSize = (14.5f * fontSizeMultiplier).sp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(10.dp))

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surface,
                border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Official Board Model Answer:",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = badgeColor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = item.modelAnswer,
                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = (13.5f * fontSizeMultiplier).sp),
                        lineHeight = (21 * fontSizeMultiplier).sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Marking Scheme: ${item.markingScheme}",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF059669)
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------
// TAB 1: DEDICATED SCIENTIFIC REASONS VIEW
// -------------------------------------------------------------
@Composable
private fun DedicatedScientificReasonsView(
    pages: List<ChapterPage>,
    chapterTitle: String,
    onAskAi: (String) -> Unit
) {
    val allScientificReasons = remember(pages) {
        pages.flatMap { p -> p.sections.flatMap { s -> s.scientificReasons } }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(bottom = 72.dp)
    ) {
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF059669).copy(alpha = 0.12f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Science, contentDescription = null, tint = Color(0xFF059669))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Prompt Scientific Reasons Master Bank",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF065F46)
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "In Question 2(A) of SSC Board exams, each scientific reason carries 2 marks. To score full 2/2, write (1) Principle, (2) Scientific Mechanism, and (3) Result. Here are all high-yield reasons for $chapterTitle:",
                        style = MaterialTheme.typography.bodySmall,
                        lineHeight = 18.sp
                    )
                }
            }
        }

        if (allScientificReasons.isEmpty()) {
            item {
                Text(
                    text = "No standalone scientific reasons for this subject. Check the 25-Page Book for conceptual arguments and proofs.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            items(allScientificReasons) { sr ->
                ScientificReasonItemCard(item = sr)
            }
        }
    }
}

// -------------------------------------------------------------
// TAB 2: DEDICATED BOARD PYQS & FUTURE PREDICTIONS VIEW
// -------------------------------------------------------------
@Composable
private fun DedicatedBoardPYQAndFutureView(
    pages: List<ChapterPage>,
    chapterTitle: String,
    onAskAi: (String) -> Unit
) {
    val allQuestions = remember(pages) {
        pages.flatMap { p -> p.sections.flatMap { s -> s.boardQuestions } }
    }

    val pastQuestions = allQuestions.filter { !it.isFuturePrediction }
    val futureQuestions = allQuestions.filter { it.isFuturePrediction }

    var selectedFilter by remember { mutableIntStateOf(0) }
    val filters = listOf("All Questions (${allQuestions.size})", "Past PYQs (2015-2024)", "Future 2025-26 Probable")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(bottom = 72.dp)
    ) {
        item {
            // Filter chips
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                filters.forEachIndexed { idx, label ->
                    FilterChip(
                        selected = selectedFilter == idx,
                        onClick = { selectedFilter = idx },
                        label = { Text(label) },
                        leadingIcon = if (selectedFilter == idx) {
                            { Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp)) }
                        } else null
                    )
                }
            }
        }

        val displayedQuestions = when (selectedFilter) {
            1 -> pastQuestions
            2 -> futureQuestions
            else -> allQuestions
        }

        if (displayedQuestions.isEmpty()) {
            item {
                Text(
                    text = "No questions available under this filter. Switch filters above.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            items(displayedQuestions) { q ->
                BoardExamQuestionCard(item = q)
            }
        }
    }
}

// -------------------------------------------------------------
// TAB 4: QUIZ & FLASHCARDS COMBINED VIEW
// -------------------------------------------------------------
@Composable
private fun QuizAndFlashcardsCombinedView(
    chapter: Chapter,
    userProgressRepo: UserProgressRepository
) {
    var subTab by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = subTab) {
            Tab(
                selected = subTab == 0,
                onClick = { subTab = 0 },
                text = { Text("Puzzles & Quiz (${chapter.questions.size})") }
            )
            Tab(
                selected = subTab == 1,
                onClick = { subTab = 1 },
                text = { Text("Flashcards (${chapter.flashcards.size})") }
            )
        }

        if (subTab == 0) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                contentPadding = PaddingValues(bottom = 72.dp)
            ) {
                items(chapter.questions) { q ->
                    PracticeQuestionCard(question = q)
                }
            }
        } else {
            FlashcardsTabContent(
                chapter = chapter,
                userProgressRepo = userProgressRepo
            )
        }
    }
}

@Composable
private fun PracticeQuestionCard(question: PracticeQuestion) {
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    var showExplanation by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = question.question,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(12.dp))

            question.options.forEachIndexed { index, opt ->
                val isChosen = selectedOption == index
                val isCorrect = question.correctAnswerIndex == index

                val (bgColor, borderColor, textColor) = when {
                    selectedOption == null -> Triple(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f), MaterialTheme.colorScheme.outlineVariant, MaterialTheme.colorScheme.onSurface)
                    isChosen && isCorrect -> Triple(Color(0xFF10B981).copy(alpha = 0.2f), Color(0xFF10B981), Color(0xFF10B981))
                    isChosen && !isCorrect -> Triple(Color(0xFFEF4444).copy(alpha = 0.2f), Color(0xFFEF4444), Color(0xFFEF4444))
                    isCorrect -> Triple(Color(0xFF10B981).copy(alpha = 0.1f), Color(0xFF10B981), Color(0xFF10B981))
                    else -> Triple(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f), MaterialTheme.colorScheme.outlineVariant, MaterialTheme.colorScheme.onSurfaceVariant)
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(bgColor)
                        .border(1.dp, borderColor, RoundedCornerShape(10.dp))
                        .clickable {
                            selectedOption = index
                            showExplanation = true
                        }
                        .padding(horizontal = 12.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "${('A'.code + index).toChar()}.",
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = opt,
                        style = MaterialTheme.typography.bodyMedium,
                        color = textColor
                    )
                }
            }

            AnimatedVisibility(visible = showExplanation) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .background(
                            MaterialTheme.colorScheme.surfaceVariant,
                            RoundedCornerShape(8.dp)
                        )
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Scientific Explanation:",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = question.explanation,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun FlashcardsTabContent(
    chapter: Chapter,
    userProgressRepo: UserProgressRepository
) {
    val masteredCards by userProgressRepo.masteredFlashcards.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(bottom = 72.dp)
    ) {
        items(chapter.flashcards) { fc ->
            val isMastered = masteredCards.contains(fc.id)
            FlashcardItem(
                card = fc,
                isMastered = isMastered,
                onToggleMastered = { userProgressRepo.markFlashcardMastered(fc.id, !isMastered) }
            )
        }
    }
}

@Composable
private fun FlashcardItem(
    card: Flashcard,
    isMastered: Boolean,
    onToggleMastered: () -> Unit
) {
    var isRevealed by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isMastered) Color(0xFF10B981).copy(alpha = 0.1f) else MaterialTheme.colorScheme.surface
        ),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            if (isMastered) Color(0xFF10B981) else MaterialTheme.colorScheme.outlineVariant
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isRevealed = !isRevealed }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = card.term,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
                IconButton(onClick = onToggleMastered) {
                    Icon(
                        imageVector = if (isMastered) Icons.Default.CheckCircle else Icons.Default.CheckCircleOutline,
                        contentDescription = "Mastered",
                        tint = if (isMastered) Color(0xFF10B981) else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = card.question,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(12.dp))
            if (isRevealed) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = card.answer,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            } else {
                Text(
                    text = "Tap to reveal answer ➔",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
