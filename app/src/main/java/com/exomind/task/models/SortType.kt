package com.exomind.task.models

sealed class SortType {
    object SortByName : SortType()
    object SortByValue : SortType()
}