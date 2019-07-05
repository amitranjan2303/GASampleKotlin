# #Google Analytics Sample using Kotlin

 Steps to use google analytics in  project
# * Note for the latest changes please follow Google developer docs

 1. Register project on firebase console using below url
 
    * https://console.firebase.google.com/

 2. After registration firebase will provide `google-services.json` file. download this file and place it into your project inside your app folder

<------------------------- Source code implementation starting from below----------------------------------->

 3. Add classpath dependecy in your project level `build.gradle` like below sample
     ```
      buildscript {
         dependencies {
           // Add this line
            classpath 'com.google.gms:google-services:4.2.0' // please check google docs for latest version
         }
       }

       ```
4. Add dependency in your app level `build.gradle` like below sample
    
    ```
     dependencies {
         // Add this line
         implementation 'com.google.firebase:firebase-core:17.0.0' // please check google docs for latest version
         implementation 'com.google.android.gms:play-services-analytics:17.0.0'  // please check google docs for latest version
      }
      ```

5. Add plugin at the botton of you app level `build.gradle` like below sample
  
  ```
    apply plugin: 'com.google.gms.google-services'
     
   ```

6. Now make the project on google analytics using below url

    * https://analytics.google.com/analytics/
    
    * Choose your project id here which is created on firebase registration

7. Add `ACCESS_NETWORK_STATE` and `Internet permission` in your manifest

8. Create create xml folder in res folder and create here `google_tracker.xml` file and paste below content in this file
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="ga_trackingId" translatable="false">${YOUR_TRACKING_ID}</string>
</resources>
```
10. Tracking id used from google analytics dashboard which is generated during the registration of GA

11. Create you application class by extending Application class

12. Create package with name `tracking`

13. Create `AppEventTracker`' Interface in tracking package

14. Create `GoogleAnalyticsTracker` singleton class in tracking package here make setup for Google analytics tracker

15  Initialise your GA Tracker in your Application class with the help of `AppEventTrackerHelper`

16. `AppEventTrackerHelper` class sends events to all tracker which configutred at the time of initialization

*Take more clear reference form source code

<----------------------------------Enjoy your code--------------------------------->

for more please email at amitranjan2303@gmail.com

