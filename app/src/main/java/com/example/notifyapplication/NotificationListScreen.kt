package com.example.notifyapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

// Data class representing a notification
data class NotificationItemData(val title: String, val description: String, val time: String, val frequency: String)

// A list of notifications for preview purposes
val sampleNotifications = mutableStateListOf(
    NotificationItemData("Morning Alarm", "Lorem ipsum dolor sit amet consectetur. Suspendisse in amet pellentesque...", "07:00 AM", "Daily"),
    NotificationItemData("Noon Reminder", "Lorem ipsum dolor sit amet consectetur. Suspendisse in amet pellentesque...", "10:30 AM", "Weekly: Mon, Wed, Fri"),
    NotificationItemData("Noon Reminder", "Lorem ipsum dolor sit amet consectetur. Suspendisse in amet pellentesque...", "10:30 AM", "Weekly: Mon, Wed, Fri"),
    NotificationItemData("Noon Reminder", "Lorem ipsum dolor sit amet consectetur. Suspendisse in amet pellentesque...", "10:30 AM", "Weekly: Mon, Wed, Fri"),
    NotificationItemData("Noon Reminder", "Lorem ipsum dolor sit amet consectetur. Suspendisse in amet pellentesque...", "10:30 AM", "Weekly: Mon, Wed, Fri"),
    NotificationItemData("Office", "Lorem ipsum dolor sit amet consectetur. Suspendisse in amet pellentesque...","06:00 PM", "Daily")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationListScreen(navController: NavController, notificationList: List<NotificationItemData>) {
    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Gray,
                titleContentColor = Color.Black,
            ),
                title = { Text("Local Notifications",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()) },
                actions = {
                    IconButton(onClick = { /* TODO: Implement settings action */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("reminder_creation") }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(notificationList) { notification ->
                NotificationItem(notification)
            }
        }
    }
}

@Composable
fun NotificationItem(notification: NotificationItemData) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .width(200.dp)
                    .align(Alignment.Top)
            ) {
                Text(
                    text = notification.title,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = notification.description,
                    fontSize = 16.sp
                )
            }
            Column(
                modifier = Modifier
                    .align(Alignment.Top)
                    .width(140.dp)
                    .padding(start = 16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = notification.time,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Refresh"
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = notification.frequency,
                    fontSize = 14.sp
                )
            }
        }
    }
}
// Dummy NavController for preview purposes
@Composable
fun PreviewNavController() = rememberNavController()

@Preview(showBackground = true)
@Composable
fun PreviewNotificationListScreen() {
    val dummyNavController = PreviewNavController()
    NotificationListScreen(dummyNavController, sampleNotifications)
}
//@Preview(showBackground = true)
//@Composable
//fun PreviewNotificationListScreen() {
//    NotificationListScreen(sampleNotifications)
//}