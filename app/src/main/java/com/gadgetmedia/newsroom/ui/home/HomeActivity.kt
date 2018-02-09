package com.gadgetmedia.newsroom.ui.home

import android.os.Bundle
import com.gadgetmedia.newsroom.R
import com.gadgetmedia.newsroom.ui.home.dummy.DummyContent
import com.gadgetmedia.newsroom.util.replaceFragmentInActivity
import com.gadgetmedia.newsroom.util.setupActionBar
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class HomeActivity : DaggerAppCompatActivity(), HomeFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DummyContent.DummyItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    lateinit var injectedHomeFragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupActionBar(R.id.toolbar) {
            setTitle(R.string.app_name)
        }

        findOrCreateViewFragment()

    }

    private fun findOrCreateViewFragment() =
            supportFragmentManager.findFragmentById(R.id.contentFrame)
                    ?: injectedHomeFragment.also {
                        replaceFragmentInActivity(it, R.id.contentFrame)
                    }
}
