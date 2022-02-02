package com.ebf.travelapp.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ebf.travelapp.R
import com.ebf.travelapp.ui.components.Menu
import com.ebf.travelapp.ui.components.TextLocation
import com.ebf.travelapp.ui.theme.OrangeNice
import com.ebf.travelapp.ui.theme.TravelAppTheme

@Composable
fun SaveItem(
    @DrawableRes image: Int,
    title: String,
    text: String = "Another journey chamber way yet.",
    stars: String,
    location: String
) {
    Card(onClick = {}) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(width = 90.dp, height = 110.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
                Text(text = title, style = MaterialTheme.typography.button, fontSize = 18.sp)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(text = text, style = MaterialTheme.typography.body2, fontSize = 12.sp)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Rounded.Star,
                        contentDescription = null,
                        tint = OrangeNice,
                        modifier = Modifier.padding(end = 2.dp)
                    )
                    Text(
                        text = stars,
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    TextLocation(location = location)
                }
            }
        }
    }
}

data class Place(
    val name: String,
    val location: String,
    val stars: String,
    @DrawableRes val image: Int
)

@Composable
fun Bookmark(
    navBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val places = listOf(
        Place(
            name = "Paris",
            location = "France",
            stars = "4.9",
            image = R.drawable.landscape03
        ),
        Place(
            name = "London",
            location = "UK",
            stars = "4.2",
            image = R.drawable.landscape04
        ),
        Place(
            name = "New York",
            location = "USA",
            stars = "3.9",
            image = R.drawable.landscape05
        ),
        Place(
            name = "Tokyo",
            location = "Japan",
            stars = "4.4",
            image = R.drawable.landscape06
        ),
        Place(
            name = "Sydney",
            location = "Australia",
            stars = "2.1",
            image = R.drawable.landscape01
        ),
        Place(
            name = "Rome",
            location = "Italy",
            stars = "4.5",
            image = R.drawable.landscape02
        ),
        Place(
            name = "New Delhi",
            location = "India",
            stars = "4.1",
            image = R.drawable.landscape05
        ),
    )

    Column(modifier = modifier.padding(all = 16.dp)) {
        Menu(
            pressBack = navBack,
            title = "Save"
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
            items(places) { place ->
                SaveItem(
                    image = place.image,
                    title = place.name,
                    stars = place.stars,
                    location = place.location
                )
            }
        }
    }

}

@Preview
@Composable
fun SaveItemPreview() {
    TravelAppTheme {
        SaveItem(
            image = R.drawable.landscape02,
            title = "The Great Wall of China",
            stars = "4.5",
            location = "China"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SaveScreenPreview() {
    TravelAppTheme {
        Bookmark(navBack = {})
    }
}