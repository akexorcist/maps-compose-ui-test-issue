
# Maps Compose UI Test Issue

This project demonstrates an issue with UI testing on a screen that contains a Google Map composable from the `com.google.maps.android:maps-compose` library. The issue is documented in the following GitHub issue:

[https://github.com/googlemaps/android-maps-compose/issues/211](httpss://github.com/googlemaps/android-maps-compose/issues/211)

## Project Setup

To run this project, you will need to provide a Google Maps API key.

1. Create a file named `secret.properties` in the root of the project.
2. Add your Google Maps API key to this file as follows:

```properties
# secret.properties
MAPS_API_KEY=YOUR_API_KEY
```

To enable the Google Maps API key, you need to provide the package name and the SHA-1 certificate fingerprint.

The package name for this project is `dev.akexorcist.mapscomposeuitestissue`.

To get your debug SHA-1 fingerprint, run the following command in your terminal:

```bash
keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android
```

## UI Test

The UI test in this project is located in the `app/src/androidTest/java/com/akexorcist/mapscomposeuitestissue` directory. The `MapScreenTest` class contains a single test that launches the `MainActivity` and verifies that the `MapScreen` is displayed.

This test is designed to reproduce the issue where the test fails when running on a device or emulator with Google Play Services, but passes when run on a device or emulator without Google Play Services.

### Expected Result

When the UI test is run, it should pass successfully. This indicates that the `MapScreen` is displayed correctly and the UI test is able to interact with the composables on the screen.
