# Door Safety
Door Safety with a Wemos

## Requirements:
You will need the following items to implement this project:
- Wemos D1 mini
- MPU-6050
- 1 photoresistor
- 1 resistor of 10kΩ for the photoresistor

We also made an Android app that get

## How it works

First, you need to stick the device on a door.

This project use an API on our personal VPS.
Once the project is setted up, the wemos send data from the MPU-6050 to our server every 2.5 seconds.
Then, you can check on the Android App (wherever you are), if a door got opened and someone is inside the room or not.


The device checks :
	- if the door opens and the Android app tells you if someone is in the room.
	- if the opens again and the Android app tells you that no one is inside the room.

## Circuit Diagram

![Snake](https://github.com/rombiddle/SnakeArduinoLeonardo/blob/master/images/29830725_10208761236147876_843359766_o.png?raw=true "Snake")

## Video

[![Snake](https://github.com/rombiddle/SnakeArduinoLeonardo/blob/master/images/29883488_10208761250068224_692720117_o.png?raw=true)](https://www.youtube.com/watch?v=Qi7nh-p-SI8 "Snake")

## Library

ESP8266WiFi / ESP8266HTTPClient to connect to the Wifi and make http request
Wire to communicate with I2C / TWI devices
ArduinoJson.h to creare JSON object to send to the API

## Extra feature

We could add a sound sensor in order to make sure someone is in the room.

# License

Wemos Door Safety by Romain BRUNIE, David FOURNIER.
MIT License.