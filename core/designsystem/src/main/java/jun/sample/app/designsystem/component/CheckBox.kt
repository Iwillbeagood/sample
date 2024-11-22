package jun.sample.app.designsystem.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jun.sample.app.designsystem.theme.Gray8
import jun.sample.app.designsystem.theme.JUNTheme
import jun.sample.app.designsystem.theme.JunTheme
import jun.sample.app.designsystem.theme.White1

@Composable
fun TextCheckBox(
    modifier: Modifier = Modifier,
    text: String = "",
    textStyle: TextStyle = JUNTheme.typography.titleNormalM,
    checked: Boolean = false,
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Checkbox(
            checked = checked,
            enabled = enabled,
            colors = CheckboxDefaults.colors(
                uncheckedColor = Gray8,
                checkmarkColor = White1,
            ),
            onCheckedChange = onCheckedChange
        )
        if (text.isNotEmpty())
            Text(
                text = text,
                style = textStyle,
                modifier = Modifier
            )
    }
}

@Composable
fun CheckBox(
    checked: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides 0.dp) {
        Checkbox(
            checked = checked,
            enabled = enabled,
            colors = CheckboxDefaults.colors(
                uncheckedColor = Gray8,
                checkmarkColor = White1,
            ),
            onCheckedChange = onCheckedChange,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CheckBoxPreview(
) {
    JunTheme {
        TextCheckBox(
            checked = true,
            text = "가입자 정보 동일"
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EmptyCheckBoxPreview(
) {
    JunTheme {
        TextCheckBox(
            checked = false,
            text = ""
        ) {

        }
    }
}