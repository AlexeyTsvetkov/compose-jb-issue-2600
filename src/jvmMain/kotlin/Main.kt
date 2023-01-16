// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview
fun App() {
    var textFieldState by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Row {
            BasicTextField(
                modifier = Modifier
                    .padding(10.dp)
                    .border(2.dp, Color.Gray)
                    .height(40.dp)
                    .align(Alignment.CenterVertically)
                    .onPreviewKeyEvent {
                    if(it.key == Key.Enter && it.type == KeyEventType.KeyDown){
                        println("enter down: $textFieldState")
                        true
                    }else {
                        false
                    }
                },
                value = textFieldState,
                onValueChange = { input ->
                    textFieldState = input
                },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                ),
                maxLines = 1,
                decorationBox = { innerTextField ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        if (textFieldState.isEmpty()) {
                            Text(
                                text = "Search with user name.",
                                fontSize = 14.sp,
                                modifier = Modifier.fillMaxWidth()
                                    .align(Alignment.CenterVertically),
                            )
                        }
                    }
                    innerTextField()
                }
            )
        }

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
