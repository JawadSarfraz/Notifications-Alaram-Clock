package com.example.notifyapplication

import ReminderCreationScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notifyapplication.ui.theme.NotifyApplicationTheme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                // Instantiate a NavController
                val navController = rememberNavController()
                // Set up the NavHost
                NavHost(navController = navController, "welcome") {
                    composable("welcome") {
                        WelcomeScreen(onCreateReminderClicked = {
                            navController.navigate("reminder_creation")
                        })
                    }
                    composable("reminder_creation") {
                        ReminderCreationScreen(navController)
                    }
                    composable("notification_list") {
                        NotificationListScreen(navController,sampleNotifications)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(onCreateReminderClicked: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text(
                        text = "Local Notifications",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                actions = {
                    // This IconButton is the icon on the right side
                    IconButton(onClick = { /* handle click */ }) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "Info",
                            tint = Color.White
                        )
                    }
                }

            )
        },floatingActionButton = {
            FloatingActionButton(onClick =
            // Need to navigate
            onCreateReminderClicked) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },

    )
    {padding ->
        Column(modifier = Modifier
            .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Spacer(modifier = Modifier.width(200.dp).height(200.dp))
            Image(
                painter = painterResource(id = R.drawable.notification_bell),
                contentDescription = "Create Notification",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Create a new reminder",
                style = TextStyle(
                    fontWeight = FontWeight.W400,
                    fontSize = 24.sp,
                    lineHeight = 32.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Set up a notification to never miss an appointment again!",
                style = TextStyle(
                    fontWeight = FontWeight.W400, // Weight: 400
                    fontSize = 14.sp, // Size: 14px
                ),
                textAlign = TextAlign.Center, // Align: Center
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

//@Composable
//fun BottomButtonSection() {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        horizontalArrangement = Arrangement.End
//    ) {
//        FloatingActionButton(
//            onClick = { /* Handle click here */ },
//            modifier = Modifier.size(56.dp) // Standard size for a FAB
//        ) {
//            Icon(
//                painter = painterResource(R.drawable.notification),
//                contentDescription = "Add",
//                modifier = Modifier.size(24.dp)
//            )
//        }
//    }
//}
//
//@Composable
//fun MiddleSection() {
//    Column(
//        modifier = Modifier
//            //.weight(1f) // Makes this Column fill the available space
//            .padding(horizontal = 16.dp, vertical = 166.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Image(
//            painter = painterResource(R.drawable.notification),
//            contentDescription = "Bell Icon",
//            modifier = Modifier.size(120.dp)
//        )
//
//        Text(
//            text = "Create a new reminder",
//            color = MaterialTheme.colorScheme.onBackground,
//            style = TextStyle(
//                fontWeight = FontWeight.W400,
//                fontSize = 22.sp,
//                lineHeight = 28.sp
//            ),
//            textAlign = TextAlign.Center,
//            modifier = Modifier.padding(top = 24.dp)
//        )
//        Text(
//            text = "Set up a notification to never miss an appointment again!",
//            color = MaterialTheme.colorScheme.onBackground,
//            style = TextStyle(
//                fontWeight = FontWeight.Normal,
//                fontSize = 16.sp,
//                lineHeight = 20.sp
//            ),
//            textAlign = TextAlign.Center,
//            modifier = Modifier.padding(top = 8.dp)
//        )
//    }
//}

//@Composable
//fun ReminderCreationScreen() {
//    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//        Column(
//            modifier = Modifier.padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text("Reminder Details", style = MaterialTheme.typography.headlineMedium)
//            Spacer(modifier = Modifier.height(16.dp))
//            OutlinedTextField(
//                value = "",
//                onValueChange = {},
//                label = { Text("Title") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            OutlinedTextField(
//                value = "",
//                onValueChange = {},
//                label = { Text("Description") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = { /* Placeholder for create action */ }) {
//                Text("Save Reminder")
//            }
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun PreviewWelcomeScreen() {
    MainTheme {
        WelcomeScreen(onCreateReminderClicked = {})
    }
}


@Composable
fun MainTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = Typography(),
        content = content
    )
}