// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        var textFieldState by remember { mutableStateOf("") }
        Row {
            BasicTextField(
                modifier = Modifier.padding(10.dp).border(1.dp, Color.Gray).fillMaxSize(),
                value = textFieldState,
                onValueChange = { input -> textFieldState = input },
                textStyle = TextStyle(fontSize = 14.sp,),
                maxLines = 1,
            )
        }
    }
}
