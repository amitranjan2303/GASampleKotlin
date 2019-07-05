package com.example.gasamplewithnavigation.tracking

/*
* This is common tracker class which sends events to all related tracker class
* */
object AppEventTrackerHelper {

    private var mAllTrackersList = ArrayList<AppEventTracker>()

    fun addTrackers(tracker: AppEventTracker) {
        mAllTrackersList.add(tracker)
    }


    /*
    * this method use to send event name only
    * */
    fun track(eventName: String?) {
        for (tracker in mAllTrackersList) {
            tracker.track(eventName)
        }
    }

    /*
    * this method use to send events with name and actions
    * */
    fun track(eventName: String, eventAction: HashMap<String, Any>) {
        for (tracker in mAllTrackersList) {
            tracker.track(eventName, eventAction)
        }
    }
}