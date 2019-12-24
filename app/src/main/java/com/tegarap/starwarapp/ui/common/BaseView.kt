package com.tegarap.starwarapp.ui.common

interface BaseView {
    fun showProgress()
    fun hideProgress()
    fun showProgressLoadMore()
    fun hideProgressLoadMore()
    fun showError()
}