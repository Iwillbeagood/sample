package jun.sample.app.designsystem.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import jun.sample.app.designsystem.etc.BooleanProvider
import jun.sample.app.designsystem.theme.Gray5
import jun.sample.app.designsystem.theme.JUNTheme
import jun.sample.app.designsystem.theme.JunTheme
import jun.sample.app.designsystem.theme.White1
import jun.sample.app.designsystem.theme.main

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    checkedColor: Color = main,
    uncheckedColor: Color = Gray5,
) {
    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
        Switch(
            checked = checked,
            colors = SwitchDefaults.colors(
                checkedThumbColor = checkedColor,
                uncheckedThumbColor = uncheckedColor,
                checkedTrackColor = White1,
                uncheckedTrackColor = White1,
                checkedBorderColor = checkedColor,
                uncheckedBorderColor = uncheckedColor
            ),
            thumbContent = {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawCircle(
                        color = if (checked) checkedColor else uncheckedColor,
                        radius = 24f,
                        center = center
                    )
                }
            },
            onCheckedChange = onCheckedChange,
            modifier = modifier
        )
    }
}

@Composable
fun TextSwitch(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    checkedColor: Color = main,
    uncheckedColor: Color = Gray5,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Text(text = text, color = textColor, style = JUNTheme.typography.titleNormalB)
        Spacer(modifier = Modifier.width(6.dp))
        DefaultSwitch(
            checked = checked,
            checkedColor = checkedColor,
            uncheckedColor = uncheckedColor,
            onCheckedChange = onCheckedChange
        )
    }

}


@Preview(showBackground = true)
@Composable
private fun SwitchPreview(
    @PreviewParameter(BooleanProvider::class) checked: Boolean
) {
    JunTheme {
        Column {
            DefaultSwitch(
                checked = checked,
                onCheckedChange = {

                }
            )
        }
    }
}

@Preview
@Composable
private fun TextSwitchPreview(
    @PreviewParameter(BooleanProvider::class) checked: Boolean
) {
    JunTheme {
        Column {
            TextSwitch(
                text = "자동",
                checked = checked,
                onCheckedChange = {

                }
            )
        }
    }
}