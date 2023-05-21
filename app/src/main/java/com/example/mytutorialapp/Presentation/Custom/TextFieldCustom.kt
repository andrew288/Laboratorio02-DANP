package com.example.mytutorialapp.Presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldCustom(
    modifier:Modifier = Modifier,
    textFieldValue: MutableState<String>,
    textLabel: String,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    keyboardType: KeyboardType,
    keyboardActions: KeyboardActions,
    imeAction: ImeAction,
){
    TextField(modifier = modifier.fillMaxWidth(),
        value = textFieldValue.value,
        onValueChange = {textFieldValue.value = it},
        label = {
            Text(text = textLabel)
        },
        keyboardOptions = KeyboardOptions(
            capitalization = capitalization,
            keyboardType = keyboardType
        ),
        keyboardActions = keyboardActions,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.DarkGray
        )
    )
}