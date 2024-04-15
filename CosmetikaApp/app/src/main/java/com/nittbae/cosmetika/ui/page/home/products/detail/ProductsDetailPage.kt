package com.nittbae.cosmetika.ui.page.home.products.detail

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nittbae.cosmetika.R
import com.nittbae.cosmetika.ui.components.base.CKGroupItems
import com.nittbae.cosmetika.ui.components.base.CKOutlinedTextField
import com.nittbae.cosmetika.ui.components.base.CKScaffold
import com.nittbae.cosmetika.ui.components.base.CKSubtitle
import com.nittbae.cosmetika.ui.page.home.products.CKSettingListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsDetailPage(
    navController: NavController
) {
    CKScaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = "7Belo Body Splash QDB dcd 200ml",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                }
            )
        }
    ) {
        var state by remember { mutableIntStateOf(0) }
        var avaliable by remember { mutableStateOf(true) }
        var toSell by remember { mutableStateOf(true) }
        var toBuy by remember { mutableStateOf(true) }
        val titles = listOf("Dados", "Valores", "Estoque")

        PrimaryTabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = index == state,
                    onClick = { state = index },
                    text = { Text(text = title) }
                )
            }
        }

        LazyColumn {
            item {
                CKOutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = "Nome *",
                    value = "",
                    imeAction = ImeAction.Next,
                    onValueChange = {}
                )
                CKOutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = "Nome Interno",
                    value = "",
                    imeAction = ImeAction.Next,
                    onValueChange = {}
                )
                CKOutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = "Referência/Cód. Interno",
                    value = "",
                    imeAction = ImeAction.Done,
                    onValueChange = {}
                )

            }

            item {
                CKGroupItems (
                    groupTitle = {
                        CKSubtitle(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Dados Complementares"
                        )
                    }
                ) {
                    CKOutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        label = "Código de Barras",
                        value = "",
//                    trailingIcon = { Icon(imageVector = Icons.Default.Info, contentDescription = "") },
                        trailingIcon = {
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.outline_camera_alt_24),
                                    contentDescription = ""
                                )
                            }
                        },
                        onValueChange = {}
                    )
                }
            }

            item {
                CKGroupItems (
                    groupTitle = {
                        CKSubtitle(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Validações Extras"
                        )
                    }
                ) {
                    CKSettingListItem(
                        modifier = Modifier
                            .fillMaxWidth(),
                        headline = "Disponível",
                        supportingText = "Disponível para realizar movimentações de compras, vendas etc.",
                        onClick = { avaliable = !avaliable }
                    ) {
                        Switch(checked = avaliable, onCheckedChange = { avaliable = it })
                    }

                    HorizontalDivider()

                    CKSettingListItem(
                        modifier = Modifier
                            .fillMaxWidth(),
                        headline = "Disponível",
                        supportingText = "Disponível para realizar movimentações de compras, vendas etc.",
                        onClick = { toSell = !toSell }
                    ) {
                        Switch(checked = toSell, onCheckedChange = { toSell = it })
                    }

                    HorizontalDivider()

                    CKSettingListItem(
                        modifier = Modifier
                            .fillMaxWidth(),
                        headline = "Disponível",
                        supportingText = "Disponível para realizar movimentações de compras, vendas etc.",
                        onClick = { toBuy = !toBuy }
                    ) {
                        Switch(checked = toBuy, onCheckedChange = { toBuy = it })
                    }
                }
            }
        }
    }
}