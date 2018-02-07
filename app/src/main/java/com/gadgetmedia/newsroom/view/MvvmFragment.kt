package com.gadgetmedia.newsroom.view

import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class MvvmFragment : DaggerFragment() {
    private val compositeDisposable by lazy { CompositeDisposable() }

    fun subscribe(disposable: Disposable): Disposable {
        compositeDisposable.add(disposable)
        return disposable
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}