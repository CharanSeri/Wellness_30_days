package com.example.wellness30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wellness30days.data.DayDataSource
import com.example.wellness30days.data.DayDetails
import com.example.wellness30days.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DayDataSource.listDays.sortBy { it.dayNumber }
                    Column {
                        CenterAlignedTopAppBar(
                            title = {
                                Text("30 Day List")
                            },
                        )
                        DisplayCardsList(listOfDays = DayDataSource.listDays, modifier = Modifier)
                    }

                }
            }
        }
    }
}

@Composable
fun DisplayCardsList(listOfDays: List<DayDetails>, modifier: Modifier) {
    LazyColumn {
        items(listOfDays.size) { it ->
            DayDetailsCard(dayDetails = listOfDays[it], modifier)
        }
    }

}

@Composable
fun DayDetailsCard(dayDetails: DayDetails, modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = modifier
            .wrapContentSize()
            .padding(16.dp)
            .animateContentSize()
            .height(if (expanded) 350.dp else 250.dp)
            .background(color = MaterialTheme.colorScheme.background)
            .clickable { expanded = !expanded }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Day ${dayDetails.dayNumber}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
            )
            Image(
                painter = painterResource(id = dayDetails.imageDetails),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
            )
            if (expanded) {
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = stringResource(dayDetails.dayHeader),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = stringResource(
                            dayDetails?.dayDescribtion ?: R.string.nulldescription
                        )
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    DayDataSource.listDays.sortBy { it.dayNumber }
    AppTheme {
        DisplayCardsList(DayDataSource.listDays, Modifier)
    }
}