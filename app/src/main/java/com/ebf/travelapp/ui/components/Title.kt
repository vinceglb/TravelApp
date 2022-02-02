package com.ebf.travelapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Title(text: String) {
    Text(text = text, style = MaterialTheme.typography.h6)
    Spacer(modifier = Modifier.height(16.dp))
}
