package com.example.bookservice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "books")
data class Book @JvmOverloads constructor(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
    val title: String,
    val bookYear: String,
    val author: String,
    val pressName: String,
    val isbn: String
){
    constructor(): this("", "", "", "","","")
}
