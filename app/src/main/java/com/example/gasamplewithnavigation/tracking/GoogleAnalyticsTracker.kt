package com.example.gasamplewithnavigation.tracking

import android.content.Context
import com.example.gasamplewithnavigation.R
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.HitBuilders
import com.google.android.gms.analytics.Tracker

/*
* This is GATracker class sends events to google analytics
* */
@Deprecated("This tracking pattern is deprecated because firebase automatically handle and send events on firebase dashboard as well as google analytics dashboard also")
object GoogleAnalyticsTracker : AppEventTracker {

    private var mAnalytics: GoogleAnalytics? = null
    private var mTracker: Tracker? = null

    fun initializeGATracker(context: Context?): GoogleAnalyticsTracker {
        mAnalytics = GoogleAnalytics.getInstance(context)
        return this
    }

    @Synchronized
    private fun getTracker(): Tracker? {
        if (mTracker == null) {
            mTracker = mAnalytics?.newTracker(R.xml.global_tracker);
        }

        return mTracker;
    }

    /*
    * this implemented event recieve events from out side of class in app and sent to google analytics
    * */
    override fun track(eventName: String?) {
        getTracker()?.send(
            HitBuilders.EventBuilder()
                .setCategory(eventName)
                .setAction(null)
                .setLabel(null)
                .build()
        )
    }

    /*
    * this implemented event recieve event name from out side of class in app and sent to google analytics
    * */
    override fun track(eventName: String?, eventActions: HashMap<String, Any>) {

        // Bundle params=new Bundle();
        val gaEventActions = HashMap<String, String>()

        for (entry in eventActions.entries){
            eventActions.put(entry.key,entry.value.toString());
        }
        getTracker()?.send(
            HitBuilders.EventBuilder()
                .setCategory(eventName)
                .setAll(gaEventActions)
                .build()
        )
    }

}