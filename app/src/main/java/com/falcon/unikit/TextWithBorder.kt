package com.falcon.unikit


import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@Composable
fun TextWithBorder(headingValue: String, descriptionValue: String){
    var mSelectedText by remember(descriptionValue) { mutableStateOf(descriptionValue) }
    var mExpanded by remember { mutableStateOf(false) }
    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}
    Column(
        Modifier
            .padding(10.dp, 5.dp)
    ) {
        OutlinedTextField(
            readOnly = true,
            value = mSelectedText.toString(),
            onValueChange = {
                mSelectedText = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                }
            ,
            label = {Text(headingValue, modifier = Modifier
                .clickable {
                    mExpanded = !mExpanded
                })}
        )
    }
}

@Composable
fun TextWithBorderAndCopyIcon(headingValue: String, descriptionValue: String){
    var mSelectedText by remember(descriptionValue) { mutableStateOf(descriptionValue) }
    var mExpanded by remember { mutableStateOf(false) }
    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}
    Column(
        Modifier
            .padding(10.dp, 5.dp)
    ) {
        val clipboardManager = LocalContext.current.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        OutlinedTextField(
            readOnly = true,
            value = mSelectedText.toString(),
            onValueChange = {
                mSelectedText = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                }
            ,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ContentCopy,
                    contentDescription = "Copy",
                    tint = Color.Gray,
                    modifier = Modifier
                        .clickable {
                            clipboardManager.setPrimaryClip(ClipData.newPlainText("Copied Code", descriptionValue))
                        }
                )
            },
            label = {Text(headingValue, modifier = Modifier
                .clickable {
                    mExpanded = !mExpanded
                })}
        )
    }
}