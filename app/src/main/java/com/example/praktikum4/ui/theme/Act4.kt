package com.example.praktikum4.ui.theme

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import com.example.praktikum4.R

package com.example.pertemuan5

import android.R.attr.text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp

@Composable
fun FormatDataDiri(modifier: Modifier){
    //variabel-variabel untuk mengingat nilai masukan dari keyboard
    var textName by remember {mutableStateOf("")}
    var textAlamat by remember { mutableStateOf("")}
    var textJK by remember { mutableStateOf("") }
    val gender:List<String> = listOf("Laki-laki", "Perempuan")

    //variabel-variabel untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = textName,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),
            label = {Text(text = "Nama Lengkap")},
            onValueChange = {
                textName = it
            }
        )
        Row() {
            gender.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = textJK == item,
                    onClick = {textJK = item}
                ), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            item
                        })
                    Text(item)
                }
            }
        }
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(250.dp),
            label = {Text("Alamat")},
            onValueChange = {
                textAlamat = it
            }
        )
        HorizontalDivider(
            modifier = Modifier.padding(
                bottom =
                    dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(
                    R.dimen.padding_medium
                )
            ),
            thickness = dimensionResource(R.dimen.divider_tipis),
            color = Color.DarkGray
        )
        Button(
            modifier = Modifier.fillMaxWidth(1f),
            enable = textAlamat.isNotEmpty(),
            onClick = {
                nama = textName
                jenis = textJK
                alamat = textAlamat
            }
        ) {




