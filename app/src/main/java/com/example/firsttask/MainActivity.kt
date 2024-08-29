package com.example.firsttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firsttask.ui.theme.FirstTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { paddingValues ->
                // Use paddingValues to adjust the content
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues) // Apply padding to the Column
                ) {

                    //I here created three intial states with empty initialization.
                    val textFieldValue1 = remember { mutableStateOf(TextFieldValue("")) }
                    val textFieldValue2 = remember { mutableStateOf(TextFieldValue("")) }
                    val textFieldValue3 = remember { mutableStateOf(TextFieldValue("")) }

                    //Here I created multiple objects, and passed title and placeholders in each.
                    val customTextField1 = CustomTextField("Enter Name Here", "Full Name")
                    val customTextField2 = CustomTextField("Enter Email Here", "Email")
                    val customTextField3 =
                        CustomTextField("Enter Phone Number Here", "Phone Number")


                    //Object creation for button class.
                    val customButtonObj = CustomButton(Color.Red, Color.White)

                    //Column to display on view/activity.
                    Column {
                        //Here I am calling composables, passing state value, and P/H and title.
                        CustomTextFieldView(
                            customTextField = customTextField1,
                            userInput = textFieldValue1
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomTextFieldView(
                            customTextField = customTextField2,
                            userInput = textFieldValue2
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomTextFieldView(
                            customTextField = customTextField3,
                            userInput = textFieldValue3
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        //When pressing this button, it print following in logcat console.
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center // Center content within the Box
                        ) {
                            CustomButtonView(customButtonObj) {
                                println("Name: ${textFieldValue1.value.text}")
                                println("Email: ${textFieldValue2.value.text}")
                                println("Phone: ${textFieldValue3.value.text}")
                            }
                        }

                    }
                }
            }
        }
    }
}
