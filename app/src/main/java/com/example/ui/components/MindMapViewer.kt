package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.MindMapNode

@Composable
fun MindMapViewer(
    rootNode: MindMapNode,
    modifier: Modifier = Modifier
) {
    var selectedNode by remember { mutableStateOf(rootNode) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        // Banner
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.AccountTree,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "Interactive Concept Mind Map",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Tap on branches to explore sub-concepts and recall effortlessly",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Selected Node Quick Inspector
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = selectedNode.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                if (selectedNode.description.isNotBlank()) {
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = selectedNode.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Mind Map Branches Tree
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                // Root Node Button
                MindMapNodeView(
                    node = rootNode,
                    isSelected = selectedNode.id == rootNode.id,
                    level = 0,
                    onSelect = { selectedNode = it }
                )
            }
        }
    }
}

@Composable
private fun MindMapNodeView(
    node: MindMapNode,
    isSelected: Boolean,
    level: Int,
    onSelect: (MindMapNode) -> Unit
) {
    var isExpanded by remember { mutableStateOf(true) }

    val levelColor = when (level) {
        0 -> Color(0xFF2563EB)
        1 -> Color(0xFF059669)
        2 -> Color(0xFFD97706)
        else -> Color(0xFF7C3AED)
    }

    Column(modifier = Modifier.padding(start = (level * 18).dp, top = 6.dp, bottom = 6.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (isSelected) levelColor.copy(alpha = 0.2f)
                    else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                )
                .border(
                    width = if (isSelected) 1.5.dp else 1.dp,
                    color = if (isSelected) levelColor else MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(10.dp)
                )
                .clickable {
                    onSelect(node)
                    if (node.children.isNotEmpty()) {
                        isExpanded = !isExpanded
                    }
                }
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(levelColor)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = node.title,
                style = if (level == 0) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyMedium,
                fontWeight = if (level == 0) FontWeight.Bold else FontWeight.SemiBold,
                color = if (isSelected) levelColor else MaterialTheme.colorScheme.onSurface
            )
            if (node.children.isNotEmpty()) {
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        if (isExpanded && node.children.isNotEmpty()) {
            Column(modifier = Modifier.padding(top = 4.dp)) {
                node.children.forEach { child ->
                    MindMapNodeView(
                        node = child,
                        isSelected = false,
                        level = level + 1,
                        onSelect = onSelect
                    )
                }
            }
        }
    }
}
