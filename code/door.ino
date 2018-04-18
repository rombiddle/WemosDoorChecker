#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiServer.h>
#include <WiFiClient.h>
#include<Wire.h>
#include <time.h>/* time_t, time (for timestamp in second) */
#include <string.h>
#include "stdio.h"
#include <ArduinoJson.h>

int lightPin = 0;


char * ssid = "ESGI"; // Put your WiFi SSID here
char * pass = "Reseau-GES"; // Put your Wifi Password here


const int MPU_addr=0x68;  // I2C address of the MPU-6050
int16_t AcX,AcY,AcZ,Tmp,GyX,GyY,GyZ,light;

boolean wifiConnected = false;
boolean doorMovement = false;

void setup() {
  Serial.begin(9600);
  // Connect to WiFi network
  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);
  
  WiFi.begin(ssid, pass);
  
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected");
  
  Wire.begin();
  Wire.beginTransmission(MPU_addr);
  Wire.write(0x6B);  // PWR_MGMT_1 register
  Wire.write(0);     // set to zero (wakes up the MPU-6050)
  Wire.endTransmission(true);

  delay(500);

}

void loop() {

  Wire.beginTransmission(MPU_addr);
  Wire.write(0x3B);  // starting with register 0x3B (ACCEL_XOUT_H)
  Wire.endTransmission(false);
  Wire.requestFrom(MPU_addr,14,true);  // request a total of 14 registers
  AcX=Wire.read()<<8|Wire.read();  // 0x3B (ACCEL_XOUT_H) & 0x3C (ACCEL_XOUT_L)    
  AcY=Wire.read()<<8|Wire.read();  // 0x3D (ACCEL_YOUT_H) & 0x3E (ACCEL_YOUT_L)
  AcZ=Wire.read()<<8|Wire.read();  // 0x3F (ACCEL_ZOUT_H) & 0x40 (ACCEL_ZOUT_L)
  Tmp=Wire.read()<<8|Wire.read();  // 0x41 (TEMP_OUT_H) & 0x42 (TEMP_OUT_L)
  GyX=Wire.read()<<8|Wire.read();  // 0x43 (GYRO_XOUT_H) & 0x44 (GYRO_XOUT_L)
  GyY=Wire.read()<<8|Wire.read();  // 0x45 (GYRO_YOUT_H) & 0x46 (GYRO_YOUT_L)
  GyZ=Wire.read()<<8|Wire.read();  // 0x47 (GYRO_ZOUT_H) & 0x48 (GYRO_ZOUT_L)

  char result[50];

  StaticJsonBuffer<300> JSONbuffer;
  JsonObject& JSONencoder = JSONbuffer.createObject();
  JSONencoder["acx"] = AcX;
  JSONencoder["acy"] = AcY;
  JSONencoder["acz"] = AcZ;
  JSONencoder["tmp"] = Tmp/340.00+36.53;
  JSONencoder["gyx"] = GyX;
  JSONencoder["gyy"] = GyY;
  JSONencoder["gyz"] = GyZ;
  JSONencoder["light"] = analogRead(lightPin);

  char JSONmessageBuffer[300];
  JSONencoder.prettyPrintTo(JSONmessageBuffer, sizeof(JSONmessageBuffer));
  if(!doorMovement){
    Serial.println("doorMovement est false");
    if(AcZ > 1000){
      Serial.println(AcZ);
      Serial.println(analogRead(lightPin));
      delay(1000);
      doorMovement = true;
      if (WiFi.status() == WL_CONNECTED) { //Check WiFi connection status
     
        HTTPClient http;  //Declare an object of class HTTPClient
     
        http.begin("http://vps455628.ovh.net/wemosi");  //Specify request destination
        http.addHeader("Content-Type", "application/json");
        int httpCode = http.POST(JSONmessageBuffer);//JSON goes here
        Serial.print("httpCode : ");
    Serial.println(httpCode);
        http.end();   //Close connection
     
      }
      
    }
  }else{
      Serial.println("doorMovement est vrai");
      if(AcZ < 0){
        Serial.println("doorMovement est false");
      doorMovement = false;
      }
    }
  
 
  //delay(000);    //Send a request every 30 seconds
}