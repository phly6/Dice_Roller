package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),  // Fills the screen
                    color = MaterialTheme.colorScheme.background    // Use theme's background color
                ) {
                    DiceRollerApp() // Calls the main composable function
                }
            }
        }
    }
}

//Preview function
@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()  // Fills the screen
            .wrapContentSize(Alignment.Center)  // Centers the content
    )
}

//Composable function
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(1) } // Variable that holds current roll result
    val imageResource = when (result) { // Makes sure UI updates when state changes

        // Chooses corresponding image for roll result
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    // Arranges dice image and button in a column
    Column(
        modifier = modifier,    // Pass modifier to column
        horizontalAlignment = Alignment.CenterHorizontally  // Aligns items to center horizontally
    ) {
        // Shows the dice image
        Image(
            painter = painterResource(imageResource),   // Loads the resource for images
            contentDescription = "Result is $result"    // Content description (accessibility feature)
        )

        // Spacing between dice image and button
        Spacer(modifier = Modifier.height(16.dp))

        // Button that rolls the dice
        Button(onClick = { result = (1..6).random() }) {
            // This displays the button text from the strings.xml file
            Text(stringResource(R.string.roll))
        }
    }

}