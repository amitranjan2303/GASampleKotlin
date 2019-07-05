package com.example.gasamplewithnavigation.tracking

interface AppEventTracker {

    fun track(eventName: String?)

    fun track(eventName: String?, eventAction: HashMap<String, Any>)
}