# WiFi_AP_RSSI_Calculator
This application measures the RSSI values of all neighboring WiFi APs and stores these values along with the GPS coordinates and timestamp in a database.
## Environment
This application is built for Android Devices. Thus, in order to use this application, you must have access to an Android Device. The Database portion of the application is implemented using SQLite.
## Installation/Running
In order to install this application on your Android Device, you must install Android Studio. Once you have installed Android Studio, clone into this repository and open it in Android Studio. The application can then 
be run on a device. In order for the application to run as intended, make sure that the device has granted the application the following permissions:
* ACCESS_FINE_LOCATION
* ACCESS_COARSE_LOCATION
* ACCESS_WIFI_STATE
* CHANGE_WIFI_STATE
## Adjustable Parameters
For this application, there are no adjustable parameters.
## Important Functions/Methods
* LocationManager.requestLocationUpdates: This is a built-in Android function that forces the application to constantly check for changes in location. This allows the application to log new RSSI values when the user has changed locations.
* onLocationChanged: This function is called everytime the user's location is changed. When this happens, the RSSI values of nearby WiFi APs are gathered and entered into the database, alongside the GPS coordinates and the timestamp.
* DatabaseHandler.addLocationRSSI: This function enters the latitude, longitude, SSID, RSSI value, and timestamp into the SQLite database.
## Bottlenecks/Bugs
One known bottleneck of the current implementation is that the database is a local database. Thus, there are natural limits to how much data can be stored.
## Future Work
The main goal for the future of this project should be to use a more robust database and to migrate the database to the cloud. SQLite, while good for proof-of-concept purposes, should not be incorporated for widespread use. 
Remote-hosting the database would allow for the data found by other devices to be accessed by all users.
