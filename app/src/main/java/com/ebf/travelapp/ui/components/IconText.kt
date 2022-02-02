package com.ebf.travelapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ebf.travelapp.ui.theme.TravelAppTheme

@Composable
fun IconText(
    icon: ImageVector,
    color: Color,
    text: String,
    textColored: Boolean,
    big: Boolean = false
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(if (!big) 16.dp else 18.dp),
            tint = color
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            style = if (!big) MaterialTheme.typography.overline else MaterialTheme.typography.body1,
            color = if (textColored) color else MaterialTheme.colors.onSurface
        )
    }
}

@Composable
fun TextLocation(location: String, big: Boolean = false) {
    IconText(
        icon = Icons.Rounded.Place,
        color = MaterialTheme.colors.primary,
        text = location,
        textColored = true,
        big = big
    )
}

@Preview
@Composable
fun TextLocationPreview() {
    TravelAppTheme {
        TextLocation(location = "Paris")
    }
}
