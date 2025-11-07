package com.example.tugaspratikum6.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanListPeserta(
    pesertaList: List<PesertaData>,
    onFormClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF9C27B0))
                    .padding(bottom = 40.dp)
            ) {
                TopAppBar(
                    title = {
                        Text(
                            text = "List Daftar Peserta",
                            color = Color.White,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.fillMaxWidth(),
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )
            }
        },
        containerColor = Color(0xFFF8F3FF)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(pesertaList) { peserta ->
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        CardItem(label = "Nama Lengkap", value = peserta.nama)
                        CardItem(label = "Jenis Kelamin", value = peserta.jenisKelamin)
                        CardItem(label = "Status Perkawinan", value = peserta.status)
                        CardItem(label = "Alamat", value = peserta.alamat)
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp), // sebelumnya 10.dp → sekarang lebih atas
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = onHomeClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF9C27B0)
                    ),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text(text = "Beranda", color = Color.White, fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = onFormClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF9C27B0)
                    ),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text(text = "Formulir Pendaftaran", color = Color.White, fontSize = 18.sp)
                }
            }
        }
    }
}

@Composable
fun CardItem(label: String, value: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(22.dp)) {
            Text(
                text = label,
                fontSize = 17.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold // label tebal
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = value,
                fontSize = 18.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Normal // isi normal
            )
        }
    }
}
