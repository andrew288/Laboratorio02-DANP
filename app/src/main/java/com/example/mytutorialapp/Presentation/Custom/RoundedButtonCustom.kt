package com.example.mytutorialapp.Presentation

import android.icu.number.NumberFormatter.DecimalSeparatorDisplay
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RoundedButtonCustom(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    color: Color = Color.Cyan
){
    Button(
        onClick = onClick,
        modifier = modifier
        .background(color = color, shape = RoundedCornerShape(8.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(text = text)
    }
}