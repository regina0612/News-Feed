package com.example.myapplication

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsViewModel {

    private val scope = CoroutineScope(Dispatchers.Default)

    private val allNews = listOf(
        News(
            1,
            "Android Studio Rilis Versi Baru",
            "Teknologi",
            "Android Studio menghadirkan fitur baru untuk developer."
        ),

        News(
            2,
            "Tim Nasional Menang Pertandingan",
            "Olahraga",
            "Tim nasional berhasil memenangkan pertandingan."
        ),

        News(
            3,
            "Perkembangan Teknologi AI",
            "Teknologi",
            "Artificial Intelligence semakin berkembang."
        ),

        News(
            4,
            "Kebijakan Baru Pemerintah",
            "Politik",
            "Pemerintah mengumumkan kebijakan baru."
        ),

        News(
            5,
            "Turnamen Sepak Bola Dimulai",
            "Olahraga",
            "Turnamen sepak bola antar daerah resmi dimulai."
        )
    )

    private val _newsList =
        MutableStateFlow<List<News>>(emptyList())

    val newsList: StateFlow<List<News>> =
        _newsList.asStateFlow()

    private val _selectedCategory =
        MutableStateFlow("Semua")

    val selectedCategory: StateFlow<String> =
        _selectedCategory.asStateFlow()
    private val _readCount =
        MutableStateFlow(0)

    val readCount: StateFlow<Int> =
        _readCount.asStateFlow()

    init {
        startNewsFlow()
    }

    private fun newsFlow(): Flow<News> = flow {

        for (news in allNews) {

            delay(2000)

            emit(news)
        }
    }

    private fun startNewsFlow() {

        scope.launch {

            newsFlow().collect { news ->

                _newsList.update {
                    it + news
                }
            }
        }
    }

    fun increaseReadCount() {

        _readCount.update {
            it + 1
        }
    }
    fun setCategory(category: String) {

        _selectedCategory.value = category

        _newsList.value = allNews
            .filter {
                category == "Semua" ||
                        it.category == category
            }
    }
}