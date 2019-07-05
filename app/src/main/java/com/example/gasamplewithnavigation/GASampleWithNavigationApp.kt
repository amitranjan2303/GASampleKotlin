package com.example.gasamplewithnavigation

import android.app.Application
import com.example.gasamplewithnavigation.tracking.AppEventTrackerHelper
import com.example.gasamplewithnavigation.tracking.GoogleAnalyticsTracker

class GASampleWithNavigationApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //initialize GA event tracker
        AppEventTrackerHelper.addTrackers(GoogleAnalyticsTracker.initializeGATracker(this))
    }
}