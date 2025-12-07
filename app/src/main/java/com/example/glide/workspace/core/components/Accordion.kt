package com.example.glide.workspace.core.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Accordion() {
    val accordionItems = listOf(
        AccordionData(
            title = "Account Settings",
            content = "Manage your profile, security, and privacy settings",
            icon = Icons.Filled.Person
        ),
        AccordionData(
            title = "Notifications",
            content = "Configure email, push, and SMS notification preferences",
            icon = Icons.Filled.ShoppingCart
        ),
        AccordionData(
            title = "Payment Methods",
            content = "Add or remove credit cards, bank accounts, and wallets",
            icon = Icons.Filled.Favorite
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        accordionItems.forEachIndexed { index, item ->
            AdvancedAccordionItem(
                data = item,
                isLast = index == accordionItems.lastIndex
            )
        }
    }
}

data class AccordionData(
    val title: String,
    val content: String,
    val icon: ImageVector
)

@Composable
fun AdvancedAccordionItem(
    data: AccordionData,
    isLast: Boolean = false
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = if (!isLast) 8.dp else 0.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Clickable Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = data.icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = data.title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.weight(1f)
                )

                AnimatedContent(
                    targetState = expanded,
                    transitionSpec = {
                        fadeIn() + slideInVertically() togetherWith
                                fadeOut() + slideOutVertically()
                    }
                ) { isExpanded ->
                    Icon(
                        imageVector = if (isExpanded)
                            Icons.Filled.Close
                        else
                            Icons.Filled.Add,
                        contentDescription = if (isExpanded) "Collapse" else "Expand",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            // Animated Content
            AnimatedVisibility(
                visible = expanded,
                enter = slideInVertically() + fadeIn(),
                exit = slideOutVertically() + fadeOut()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    Divider(
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 0.5.dp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = data.content,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = MaterialTheme.typography.bodyMedium.lineHeight * 1.2
                    )

                    // Optional: Add action button
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedButton(
                        onClick = { /* Handle action */ },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Manage")
                    }
                }
            }
        }
    }
}