package com.example.firsttask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


//This is like data class, which store data that is received from main activity.
class CustomTextField(val placeholder: String, val title: String)

@Composable
//parameters get P/H and title from class, second parameter get state
fun CustomTextFieldView(
    customTextField: CustomTextField,
    userInput: MutableState<TextFieldValue>)
{
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)){
        Text(text = customTextField.title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 8.dp)
            )
        TextField(
            value = userInput.value,
            onValueChange = {newValue -> userInput.value = newValue},
            placeholder = { Text(text = customTextField.placeholder)},
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth() // Ensure TextField takes full width
                .padding(vertical = 4.dp)
            )

    }
}