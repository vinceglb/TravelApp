package com.ebf.travelapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ebf.travelapp.ui.theme.BlueNice
import com.ebf.travelapp.ui.theme.PurpleNice
import com.ebf.travelapp.ui.theme.RedNice
import com.ebf.travelapp.ui.theme.TravelAppTheme

@Composable
fun ModalFilter(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    // var skipHalfExpanded by remember { mutableStateOf(false) }
    val state = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    ModalBottomSheetLayout(
        sheetState = state,
        sheetContent = {
            Filter()
        },
        modifier = modifier,
    ) {
        content()
    }
}

@Composable
fun Filter() {
    Column(
        modifier = Modifier.padding(all = 24.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        FilterTypeSection()
        FilterPriceSection()
    }
}

@Composable
fun FilterTypeSection() {
    Column {
        Title(text = "Type")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterTypeButton(text = "Tours", color = BlueNice, modifier = Modifier.weight(1f))
            FilterTypeButton(text = "Hotels", color = PurpleNice, modifier = Modifier.weight(1f))
            FilterTypeButton(text = "Adventures", color = RedNice, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun FilterTypeButton(
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        contentPadding = PaddingValues(
            start = 12.dp,
            end = 12.dp,
            top = 13.dp,
            bottom = 10.dp
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color.copy(alpha = 0.1f),
            contentColor = color
        ),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
        modifier = modifier
    ) {
        Text(text = text, fontSize = 13.sp)
    }
}

@Composable
fun FilterPriceSection() {
    Column {
        Title(text = "Price Range")
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = "Discovered had get considered projection who favourable.",
                style = MaterialTheme.typography.body2,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        FilterPriceSlider()
        Spacer(modifier = Modifier.height(16.dp))
        FilterPriceButton()
    }
}

@Composable
fun FilterPriceSlider() {
    var sliderPosition by remember { mutableStateOf(2000f..4000f) }
    RangeSlider(
        steps = 7,
        values = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 1000f..5000f,
        onValueChangeFinished = {
            // launch some business logic update with the state you hold
            // viewModel.updateSelectedSliderValue(sliderPosition)
        },
    )
}

@Composable
fun FilterPriceButton() {
    val checkedState = remember { mutableStateOf(false) }
    Button(
        onClick = { checkedState.value = checkedState.value.not() },
        shape = MaterialTheme.shapes.medium,
        contentPadding = PaddingValues(all = 18.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Low To High",
                style = MaterialTheme.typography.button,
                modifier = Modifier.weight(1f)
            )

            Switch(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = checkedState.value.not() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterPreview() {
    TravelAppTheme {
        Filter()
    }
}
