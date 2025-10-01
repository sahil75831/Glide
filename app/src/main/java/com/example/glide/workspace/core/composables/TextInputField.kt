package com.example.glide.workspace.core.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextInputField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    textColor: Color = Color.Black,
    placeholderColor: Color = Color.Gray,
    labelColor: Color = Color.Gray,
    backgroundColor: Color = Color.Transparent,
    focusedBorderColor: Color = Color.Blue,
    unfocusedBorderColor: Color = Color.Gray,
    cursorColor: Color = Color.Blue,
    singleLine: Boolean = true
) {
    var isFocused by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor, RoundedCornerShape(0.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        // Label above input
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = if (isFocused) focusedBorderColor else labelColor,
            modifier = Modifier.padding(bottom = 2.dp)
        )

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(color = textColor, fontSize = 16.sp),
            singleLine = singleLine,
            cursorBrush = SolidColor(cursorColor),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState -> isFocused = focusState.isFocused },
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = if (isFocused) focusedBorderColor else unfocusedBorderColor,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = TextStyle(color = placeholderColor, fontSize = 16.sp)
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun InputPreview() {
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        TextInputField(
            value = text,
            onValueChange = { text = it },
            label = "Email",
            placeholder = "Enter your email",
            textColor = Color.Black,
            placeholderColor = Color.LightGray,
            labelColor = Color.DarkGray,
            backgroundColor = Color.White,
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Gray,
            cursorColor = Color.Red
        )

        TextInputField(
            value = text,
            onValueChange = { text = it },
            label = "Password",
            placeholder = "Enter password",
            textColor = Color.White,
            backgroundColor = Color(0xFF222222),
            focusedBorderColor = Color.Cyan,
            unfocusedBorderColor = Color.Gray,
            cursorColor = Color.Cyan
        )
    }
}
