# Parking Lot

## Introduction
This project is for personal training. Inspired by the parking lot project shared in thoughtworks.

## Quick Start
use `./mvnw spring-boot:run` to run this project.

## Tech stack
- Java
- Springboot
- Webflux
- Vavr
- Minikube
- ArgoCD
- Docker

## Practice requirements
- Pair
- TDD
- Refactoring
- Simple Design
- Design pattern

## Requirements
### Step 1
Parking lots enabling parking and picking up cars.

### Step 2
A ```ParkingBoy``` 
- Can manage multiple parking lots.
- Park the car to the **first** parking lot with available position(s). 

### Step 3
A ```SmartParkingBoy```
- Can manage multiple parking lots.
- Park the car to the parking lot with most available position(s).

### Step 4
A ```SuperParkingBoy```
- Can manage multiple parking lots.
- Park the car to the parking lot with the highest unoccupied rate.

### Step 5
A ```ParkingManager```
- Can manage multiple parking lots.
- Can manage multiple parking boys.
- Can ask their subordinates to park the car or park the car themselves.

### Step 6
A ```ParkingDirector```
- Can manage multiple parking lots.
- Can manage multiple parking boys and managers.
- Can print out the managed valets and their assigned parking lots, and the parking lots directly managed. 
- The information of parking lots should contain their name, capacity, number of available positions and
  utilization rate.

## Requirements Created By Siqi
### Director's people administration
- Can Create Any type of valets

### Inconsistent inputs
- Scanned handwriting, where information is presented in a flattened way
- Digital input, where customer's concept has been created but others not
- Smart input, where information is consistent with our system

### Customized basicValet
- Different valets have different strategies of parking. We want a basicValet who can handle all kinds of parking. 

## Progress
- Functionalities:
  - [x] parking boy
  - [x] smart parking boy
  - [x] super parking boy
  - [x] parking manager
  - [x] parking director
- Deployment:
  - [x] Docker image
  - [x] Deploy to argoCD

## How to run
At first, run ```json-server --watch parking-lot.json --port 3001``` to launch the json server, then run the app.
Try `http://localhost:8080/parking-lot/1` to see if you can get the data.