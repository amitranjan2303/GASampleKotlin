package com.example.gasamplewithnavigation.tracking

/**
 * This is common tracker class which sends events to all related tracker class
 * @author Amit Ranjan
 **/
object AppEventTrackerHelper {

    private var mAllTrackersList = ArrayList<AppEventTracker>()

    /**
     * This method need tracker objects by which events will be sends to events dashboard
     * @param tracker The Application event tracker name
     **/
    fun addTrackers(tracker: AppEventTracker) {
        mAllTrackersList.add(tracker)
    }


    /**
     * this method use to send event name only
     * @param eventName The Application event activity name
     **/
    fun track(eventName: String?) {
        for (tracker in mAllTrackersList) {
            tracker.track(eventName)
        }
    }

    /**
     * this method use to send events with name and actions
     * @param eventName The Application event activity name
     * @param eventAction The Application activity events actions hashmap
     **/
    fun track(eventName: String, eventAction: HashMap<String, Any>) {
        for (tracker in mAllTrackersList) {
            tracker.track(eventName, eventAction)
        }
    }
}