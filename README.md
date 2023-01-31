# Berlin Clock (Mengenlehreclock or Berlin Uhr)

# Rules & Requirements

The Berlin clock consists of 24 lights which are divided into one circular blinking yellow light on top to denote the seconds, two top rows denoting the hours and two bottom rows denoting the minutes.

The clock is read from the top row to the bottom. 

The top row of four red fields denote five full hours each, alongside the second row, also of four red fields, which denote one full hour each, displaying the hour value in 24-hour format. 

The third row consists of eleven yellow-and-red fields, which denote five full minutes each (the red ones also denoting 15, 30 and 45 minutes past), and the bottom row has another four yellow fields, which mark one full minute each. 

The round yellow light on top blinks to denote odd- (when unlit) or even-numbered (when lit) seconds.

# Setup

Clone the project using below command

```bash
https://github.com/rajesh-udhayan/berlin-clock.git
```

Here are some useful Gradle/adb commands for executing this project:

 * `./gradlew runApp` - Builds and install the debug apk on the current connected device.
 * `./gradlew compileApp` - Builds the debug apk.
 * `./gradlew runUnitTests` - Execute unit tests (both unit and integration).
 * `./gradlew executeScreenshotTests` - Execute and verify UI screenshot tests.
 * `./gradlew executeScreenshotTest -Precord` - Record the executed UI screenshot tests.
 
 # Prerequisites
 
 - Android Studio Dolphin (2021.3.1)
 
 - Gradle 7.4
 
 
 # Dependencies used
 
 - Jetpack Compose
 
 - Koin

 - Shot
 
 - Mockk
 
 - Google Truth 
 
 
 # Approaches followed 
 
- Test Driven Development (TDD)

- UI Tests & Unit Tests

- MVVM architecture

- Dependency Injection

# Observations
- All the libraries declared in Gradle are latest version except Desugar JDK library. Latest version for Desugar libary is 2.0.0 which needs gradle plugin version of 7.4.0-alpha10. Since aplha version of gradles are not 100% stable, used the Desugar version of 1.2.0 which will work on the latest stable version of Gradle plugin (7.3.1).
- Uploaded the goldens of screen shot test (app/screenshots/debug). Only for reference, test result may vary on the emulator based on the configuration. Please refer the gradle commands above to run the screenshot tests.
