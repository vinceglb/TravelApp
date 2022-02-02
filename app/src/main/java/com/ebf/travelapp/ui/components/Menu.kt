package com.ebf.travelapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconButtonMenu(icon: ImageVector, onClick: () -> Unit= {}) {
    Surface(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colors.surface
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(44.dp)
        ) {
            Icon(
                icon,
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun Menu(
    modifier: Modifier = Modifier,
    title: String? = null,
    pressBack: () -> Unit = {},
    pressBookmark: () -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        IconButtonMenu(icon = Icons.Rounded.ArrowBackIosNew, onClick = pressBack)
        if (title != null) {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
            )
        }
        IconButtonMenu(icon = Icons.Rounded.Bookmark, onClick = pressBookmark)
    }
}
