package com.nittbae.cosmetika.ui.page.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.nittbae.cosmetika.ui.components.base.CKScaffold
import com.nittbae.cosmetika.ui.components.ckswitch.CKSwitchBar
import com.nittbae.cosmetika.ui.components.ckswitch.CKSwitchTile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentsPage(
    navController: NavController
) {
    CKScaffold(
        topBar = {
            Column {
                var sw1 by remember { mutableStateOf(true) }

                TopAppBar(title = { Text(text = "Bluetooth") })
                CKSwitchBar(
                    labelChecked = "Ativado",
                    labelUnchecked = "Desativado",
                    checked = sw1,
                    onClick = { sw1 = !sw1 }
                )
            }
        }
    ) {


    }
}