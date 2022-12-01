package com.newsappclean.di

interface Factory<T> {
    fun create():T
}