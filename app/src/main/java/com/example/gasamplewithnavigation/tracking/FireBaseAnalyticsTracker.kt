package com.example.gasamplewithnavigation.tracking

import com.google.firebase.analytics.FirebaseAnalytics
import android.content.Context
import android.os.Bundle

/*
* This is FATracker class sends events to google analytics
* @author Amit Ranjan
* */
object FireBaseAnalyticsTracker : AppEventTracker {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    /** Need application context to initialize firebase analytics service
     * @param context Application context
     **/

    fun initializeFATracker(context: Context?): FireBaseAnalyticsTracker {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        return this
    }

    /** Need only event name and sent events to google analytics and firebase event dashboard
     * @param eventName The Application event activity name
     **/
    override fun track(eventName: String?) {

    }

    /** Need event name and actions hashmap and sent events to google analytics and firebase event dashboard
     * @param eventName The Application event activity name
     * @param eventAction The Application activity events actions hashmap
     **/
    override fun track(eventName: String?, eventAction: HashMap<String, Any>) {
        val bundle = Bundle()
        for (entry in eventAction.entries) {
            bundle.putString(entry.key, entry.value.toString())
            /*    bundle.putString(FirebaseAnalytics.Param.ITEM_ID, entry.key)
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, entry.value.toString())*/

        }
        bundle.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, eventName)
        mFirebaseAnalytics?.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }
}