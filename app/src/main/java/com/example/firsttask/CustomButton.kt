package com.example.firsttask

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class CustomButton(val bgColor: Color, val tintColor: Color) {
}

@Composable
fun CustomButtonView(customButton: CustomButton, onClick: () -> Unit){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = customButton.bgColor,
            contentColor = customButton.tintColor
    ),
        modifier = Modifier.padding(18.dp)
    ){
            Text(text = "Save")
    }
}