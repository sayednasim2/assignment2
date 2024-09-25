package com.sayednasim.assgn2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sayednasim.assgn2.ui.theme.Assgn2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assgn2Theme {
                MyApp()
            }
        }
    }
}


@Composable
fun MyApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // CheckBox example
        var checked by remember { mutableStateOf(false) }
        CheckBoxItem(checked) { checked = it }

        // RadioButton example
        var selectedOption by remember { mutableStateOf("Option 1") }
        RadioButtonGroup(selectedOption) { selectedOption = it }

        // RatingBar example
        var rating by remember { mutableStateOf(3f) }
        RatingBarItem(rating) { rating = it }

        // SeekBar (Slider in Compose) example
        var seekValue by remember { mutableStateOf(0f) }
        SeekBarItem(seekValue) { seekValue = it }

        // Switch example
        var isSwitched by remember { mutableStateOf(false) }
        SwitchItem(isSwitched) { isSwitched = it }
    }
}

@Composable
fun CheckBoxItem(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange(it) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = if (checked) "Checked" else "Unchecked")
    }
}

@Composable
fun RadioButtonGroup(selectedOption: String, onOptionSelected: (String) -> Unit) {
    Column {
        Text(text = "Choose an option:")
        Row {
            RadioButton(
                selected = selectedOption == "Option 1",
                onClick = { onOptionSelected("Option 1") }
            )
            Text(text = "Option 1")
        }
        Row {
            RadioButton(
                selected = selectedOption == "Option 2",
                onClick = { onOptionSelected("Option 2") }
            )
            Text(text = "Option 2")
        }
    }
}

@Composable
fun RatingBarItem(rating: Float, onRatingChange: (Float) -> Unit) {
    Column {
        Text(text = "Rating: ${rating.toInt()} stars")
        Slider(
            value = rating,
            onValueChange = { onRatingChange(it) },
            valueRange = 1f..5f,
            steps = 3
        )
    }
}

@Composable
fun SeekBarItem(value: Float, onValueChange: (Float) -> Unit) {
    Column {
        Text(text = "Seek value: ${value.toInt()}")
        Slider(
            value = value,
            onValueChange = { onValueChange(it) },
            valueRange = 0f..100f,
        )
    }
}

@Composable
fun SwitchItem(isSwitched: Boolean, onSwitchChange: (Boolean) -> Unit) {
    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
        Switch(
            checked = isSwitched,
            onCheckedChange = { onSwitchChange(it) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = if (isSwitched) "ON" else "OFF")
    }
}

