package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun App() {

    // Membuat ViewModel
    val viewModel = remember {
        NewsViewModel()
    }

    // Mengambil data dari StateFlow
    val newsList by viewModel.newsList.collectAsState()
    val readCount by viewModel.readCount.collectAsState()

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            // Judul
            Text(
                text = "📰 News Feed Simulator",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            // Jumlah berita yang sudah dibaca
            Text(
                text = "Berita dibaca: $readCount"
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // Filter kategori
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Button(
                    onClick = {
                        viewModel.setCategory("Semua")
                    }
                ) {
                    Text("Semua")
                }

                Button(
                    onClick = {
                        viewModel.setCategory("Teknologi")
                    }
                ) {
                    Text("Teknologi")
                }

                Button(
                    onClick = {
                        viewModel.setCategory("Olahraga")
                    }
                ) {
                    Text("Olahraga")
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // Menampilkan berita
            if (newsList.isEmpty()) {

                Text(
                    text = "Menunggu berita baru..."
                )

            } else {

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    items(newsList) { news ->

                        NewsCard(
                            news = news,
                            onRead = {
                                viewModel.increaseReadCount()
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NewsCard(
    news: News,
    onRead: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = news.category,
                style = MaterialTheme.typography.labelMedium
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = news.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = news.description
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Button(
                onClick = onRead
            ) {
                Text("Baca Detail")
            }
        }
    }
}