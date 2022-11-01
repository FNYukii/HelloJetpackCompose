package com.example.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hellojetpackcompose.ui.theme.HelloJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloJetpackComposeTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun  MyApp() {

    var isShouldShowOnboarding by remember { mutableStateOf(true) }

    if (isShouldShowOnboarding) { // Where does this come from?
        OnboardingScreen(onContinueClicked = { isShouldShowOnboarding = false })
    } else {
        Greetings()
    }
}

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {

    Surface {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to the Basics Codelab!")

            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Composable
private fun Greetings(names: List<String> = listOf("World", "Compose")) {

    Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {

    val isExpanded = remember { mutableStateOf(false) }

    val extraPadding = if (isExpanded.value) 48.dp else 0.dp

    Surface(color = MaterialTheme.colors.primary) {

        Row(modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()) {

            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "Hello,")
                Text(text = name)
            }

            OutlinedButton(
                onClick = { isExpanded.value = !isExpanded.value }
            ) {
                Text(if (isExpanded.value) "Show less" else "Show more")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    HelloJetpackComposeTheme {
        MyApp()
    }
}