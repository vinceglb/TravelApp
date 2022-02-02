package com.ebf.travelapp.ui.placedetail

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.KingBed
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ebf.travelapp.R
import com.ebf.travelapp.ui.components.IconText
import com.ebf.travelapp.ui.components.Menu
import com.ebf.travelapp.ui.components.TextLocation
import com.ebf.travelapp.ui.components.Title
import com.ebf.travelapp.ui.theme.GreenNice
import com.ebf.travelapp.ui.theme.OrangeNice
import com.ebf.travelapp.ui.theme.PurpleNice
import com.ebf.travelapp.ui.theme.TravelAppTheme

@Composable
fun PlaceCard(modifier: Modifier = Modifier) {
    Card(
        shape = MaterialTheme.shapes.large,
        elevation = 8.dp,
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 18.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Quseer Suez", style = MaterialTheme.typography.h5)
                TextLocation(location = "France")
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            ) {
                IconText(
                    icon = Icons.Rounded.KingBed,
                    color = GreenNice,
                    text = "2 Day",
                    textColored = false
                )
                IconText(
                    icon = Icons.Rounded.Star,
                    color = OrangeNice,
                    text = "4.5",
                    textColored = false
                )
                IconText(
                    icon = Icons.Rounded.Explore,
                    color = PurpleNice,
                    text = "12 MPH France",
                    textColored = false
                )
            }
        }
    }
}

@Composable
fun GreatPlaceSection() {
    Column {
        Title(text = "Great Place To Visit")
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = "Words window one downs few age every seven. If miss part by fact he park just shew discovered.",
                style = MaterialTheme.typography.body2,
            )
        }
    }
}

@Composable
fun PictureSection() {
    val tabImages = listOf(
        R.drawable.landscape01,
        R.drawable.landscape02,
        R.drawable.landscape03,
        R.drawable.landscape05
    )
    Column {
        Title(text = "Picture")
        Row {
            for (i in 0..3) {
                Image(
                    painter = painterResource(id = tabImages[i]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .clip(MaterialTheme.shapes.medium)
                )

                if (i < 3) {
                    Spacer(modifier = Modifier.width(12.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Image(
            painter = painterResource(id = R.drawable.landscape04),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(MaterialTheme.shapes.medium)
        )
    }
}

@Composable
fun PlaceDetailsContent() {
    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = Modifier.padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        GreatPlaceSection()
        PictureSection()
    }
}

@Composable
fun BookNow() {
    Surface {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 10.dp)
        ) {
            Column(
                modifier = Modifier.weight(0.4f)
            ) {
                Text(
                    text = "$2000",
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.SemiBold)
                )
                Text(text = "Total Cost", style = MaterialTheme.typography.overline)
            }
            Button(
                onClick = { /*TODO*/ },
                shape = MaterialTheme.shapes.medium,
                contentPadding = PaddingValues(
                    start = 12.dp,
                    end = 12.dp,
                    top = 13.dp,
                    bottom = 10.dp
                ),
                modifier = Modifier.weight(0.6f)
            ) {
                Text(text = "Book Now")
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun BookNowPreview() {
    TravelAppTheme {
        BookNow()
    }
}

@Composable
fun PlaceDetailsScreen(
    navBack: () -> Unit,
    navigateToBookmark: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Scaffold(
        bottomBar = { BookNow() },
        modifier = modifier
    ) { innerPadding ->
        ConstraintLayout(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            val (image, card, content, menu) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.landscape06),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(370.dp)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            val cornerSize = 32.dp
            Surface(
                color = MaterialTheme.colors.background,
                modifier = Modifier
                    .clip(RoundedCornerShape(cornerSize))
                    .constrainAs(content) {
                        top.linkTo(image.bottom, margin = -cornerSize)
                    }
            ) {
                PlaceDetailsContent()
            }

            PlaceCard(
                modifier = Modifier.constrainAs(card) {
                    centerAround(content.top)
                    start.linkTo(parent.start, margin = 40.dp)
                    end.linkTo(parent.end, margin = 40.dp)
                    width = Dimension.fillToConstraints
                }
            )

            Menu(
                modifier = Modifier.constrainAs(menu) {
                    top.linkTo(parent.top, margin = 24.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                    width = Dimension.fillToConstraints
                },
                pressBack = navBack,
                pressBookmark = navigateToBookmark
            )
        }
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PlaceDetailsScreenPreview() {
    TravelAppTheme {
        PlaceDetailsScreen(
            navBack = {},
            navigateToBookmark = {}
        )
    }
}
