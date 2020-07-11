# AmazonMobileDemoFramework
Complete Android OS project testing SDK API with apk test app using Appium with maven & TestNG

Appium project prerequisites:

Install ADB tools
Set up ADB Path to windows
Install Appium Server from http://appium.io/downloads.html and run it!
Load the apk should be under resounce folder (Path should be configure in Basetest class)
Connect the android device via adb
Update the setUP class according to your device (I used Honor 9 lite)
Run the testng.xml or any test from any class you wish
Maven Build command should include mobile parameter  : mvn clean install -DdeviceName="Samsung" -Dudid="3723sa34434d" -DplatformName="andriod" -DplatformVersion="9.0"
