package com.example.gasamplewithnavigation

import android.app.Application
import com.example.gasamplewithnavigation.tracking.AppEventTrackerHelper
import com.example.gasamplewithnavigation.tracking.FireBaseAnalyticsTracker
import com.example.gasamplewithnavigation.tracking.GoogleAnalyticsTracker
/**
 * @author Amit Ranjan
 * **/
class GASampleWithNavigationApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //initialize GA event tracker
       // AppEventTrackerHelper.addTrackers(GoogleAnalyticsTracker.initializeGATracker(this))
        AppEventTrackerHelper.addTrackers(FireBaseAnalyticsTracker.initializeFATracker(this))
    }
}