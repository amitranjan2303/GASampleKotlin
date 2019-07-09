package com.example.gasamplewithnavigation.tracking

import com.google.firebase.analytics.FirebaseAnalytics
import android.content.Context
import android.os.Bundle


object FireBaseAnalyticsTracker : AppEventTracker {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    fun initializeFATracker(context: Context?): FireBaseAnalyticsTracker {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        return this
    }

    override fun track(eventName: String?) {

    }

    override fun track(eventName: String?, eventAction: HashMap<String, Any>) {
        val bundle = Bundle()
        for (entry in eventAction.entries) {
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, entry.key)
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, entry.value.toString())
            bundle.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, eventName)
        }
        mFirebaseAnalytics?.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }
}