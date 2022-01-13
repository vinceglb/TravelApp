package com.ebf.travelapp

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults.textFieldColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ebf.travelapp.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyScreen()
                }
            }
        }
    }
}

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

@Composable
fun PlaceCard(
    name: String,
    location: String,
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
   Card(
       modifier = modifier,
       onClick = {}
   ) {
       Column(
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
               .padding(all = 12.dp)
               .height(IntrinsicSize.Max)
       ) {
           Image(
               painter = painterResource(id = image),
               contentDescription = null,
               contentScale = ContentScale.Crop,
               modifier = Modifier
                   .weight(1f)
                   .aspectRatio(1f)
                   .padding(bottom = 12.dp)
                   .clip(MaterialTheme.shapes.medium)
           )
           Text(text = name, style = MaterialTheme.typography.body1)
           Spacer(modifier = Modifier.height(4.dp))
           TextLocation(location = location)
       }
   }
}

@Composable
fun Title(text: String) {
    Text(text = text, style = MaterialTheme.typography.h6)
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun CategoryItem(
    color: Color,
    icon: ImageVector,
    text: String
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(width = 1.dp, color = color.copy(alpha = 0.1f)),
        color = MaterialTheme.colors.background,
        onClick = {}
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(all = 12.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(color = color)
            ) {
                Icon(icon, contentDescription = null, tint = Color.White)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = text, style = MaterialTheme.typography.body2)
        }
    }
}

@Composable
fun CategorySection() {
    Column {
        Title(text = "Category")
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            CategoryItem(color = BlueNice, icon = Icons.Rounded.GridView, text = "All")
            CategoryItem(color = OrangeNice, icon = Icons.Rounded.Landscape, text = "Hill")
            CategoryItem(color = PurpleNice, icon = Icons.Rounded.KingBed, text = "Hotel")
            CategoryItem(color = GreenNice, icon = Icons.Rounded.BeachAccess, text = "Beach")
        }
    }
}

@Composable
fun SearchSection() {
    val borderColor = if (MaterialTheme.colors.isLight) {
        MaterialTheme.colors.onSurface.copy(alpha = 0.1f)
    } else {
        MaterialTheme.colors.surface
    }

    Row(modifier = Modifier.height(IntrinsicSize.Min)) {
        OutlinedTextField(
            value = "Search",
            onValueChange = {},
            shape = MaterialTheme.shapes.medium,
            trailingIcon = { Icon(Icons.Rounded.Search, contentDescription = null) },
            colors = textFieldColors(unfocusedIndicatorColor = borderColor),
            singleLine = true,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Surface(
            onClick = {},
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colors.primary.copy(alpha = 0.1f),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            ) {
                Icon(
                    Icons.Rounded.FilterList,
                    contentDescription = null,
                    tint = MaterialTheme.colors.primary
                )
            }
        }
    }
}

@Preview
@Composable
fun SearchSectionPreview() {
    TravelAppTheme {
        SearchSection()
    }
}

@Composable
fun PopularPlace() {
    Column {
        Title(text = "Popular Place")
        Row {
            PlaceCard(
                modifier = Modifier.weight(1f),
                name = "Borobudur",
                location = "Indonésie",
                image = R.drawable.landscape01
            )
            Spacer(modifier = Modifier.width(16.dp))
            PlaceCard(
                modifier = Modifier.weight(1f),
                name = "Monte Civetta",
                location = "Alpes",
                image = R.drawable.landscape02
            )
        }
    }
}

@Composable
fun RecommendedSection() {
    Column {
        Title(text = "Recommended")
        Image(
            painter = painterResource(id = R.drawable.landscape03),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                // .aspectRatio(1f)
                .clip(MaterialTheme.shapes.medium)
        )

    }
}

@Composable
fun TravelAppTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Rounded.Menu, contentDescription = null)
        }

        TextLocation(location = "France", big = true)

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(36.dp)
        )
    }
}

@Composable
fun MyScreen() {
    val scrollState = rememberScrollState()
    Scaffold {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            TravelAppTopBar()
            CategorySection()
            SearchSection()
            PopularPlace()
            RecommendedSection()
        }
    }
}

@Preview
@Composable
fun TextLocationPreview() {
    TravelAppTheme {
        TextLocation(location = "Paris")
    }
}

@Preview
@Composable
fun CategoryItemPreview() {
    TravelAppTheme {
        CategoryItem(color = BlueNice, icon = Icons.Rounded.GridView, text = "All")
    }
}

@Preview
@Composable
fun PlaceCardPreview() {
    TravelAppTheme {
        PlaceCard(
            modifier = Modifier.width(200.dp),
            name = "Monte Civetta",
            location = "Paris",
            image = R.drawable.landscape01
        )
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MyScreenPreview() {
    TravelAppTheme {
        MyScreen()
    }
}
