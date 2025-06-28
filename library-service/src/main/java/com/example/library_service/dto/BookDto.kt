package com.example.library_service.dto

data class BookDto @JvmOverloads constructor(
    val bookId: BookIdDto? = null,
    val title : String? = "",
    val year: Int? = 0,
    val author: String? = "",
    val pressName: String? = ""){}
