import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notifyapplication.NotificationItemData
import com.example.notifyapplication.sampleNotifications
import androidx.navigation.NavController

@Composable
fun ReminderCreationScreen(navController: NavController) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var newTime by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text("Create New Reminder", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = newTime,
            onValueChange = { newTime = it },
            label = { Text("Time") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Add new notification to list
                sampleNotifications.add(NotificationItemData(title, description, newTime, "Daily"))
                println("Reminder saved: Title - '$title', Description - '$description', Time - '$newTime'")
                navController.navigate("notification_list")
            }
        ) {
            Text("Save")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ReminderCreationScreenPreview() {
//    ReminderCreationScreen()
//}