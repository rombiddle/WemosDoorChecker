# Door Safety
Door Safety with a Wemos

## Requirements:
You will need the following items to implement this project:
- Wemos D1 mini
- MPU-6050
- 1 photoresistor
- 1 resistor of 10kΩ for the photoresistor


## How it works

First, you need to stick the device on a door.

This project use an API on our personal VPS.
Once the project is setted up, the wemos send data from the MPU-6050 to our server every 2.5 seconds.
Then, you can check on the Android App (wherever you are), if a door got opened and someone is inside the room or not.


## Circuit Diagram

![HODOR](https://github.com/rombiddle/WemosDoorChecker/blob/master/images/Capture%20d%E2%80%99%C3%A9cran%202018-04-18%20%C3%A0%2010.49.54.png?raw=true "Hodor")

## Android App

![HODOR](https://github.com/rombiddle/WemosDoorChecker/blob/master/images/Capture%20d%E2%80%99%C3%A9cran%202018-04-18%20%C3%A0%2011.29.50.png?raw=true "My Beautiful App")


## Library

ESP8266WiFi / ESP8266HTTPClient to connect to the Wifi and make http request
Wire to communicate with I2C / TWI devices
ArduinoJson.h to creare JSON object to send to the API

## Extra feature

We could add a sound sensor in order to make sure someone is in the room.

# License

Wemos Door Safety by Romain BRUNIE, David FOURNIER.
MIT License.