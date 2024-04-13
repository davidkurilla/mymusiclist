# MyMusicList
![MyMusicList Logo](src/main/resources/static/images/logo.png)

## Project Properties
- Author: David Kurilla
- Class: SDEV372
- Winter 2024 Quarter

## Milestones
- Project Creation
- Writing a Web API
- Consuming a Web API
- Integrating Public APIs
- Deploying to the Cloud

## Project Description
MyMusicList is a Java Spring Boot SaaS application
that allows users to discover their favorite music.
I picked this topic because I myself am a big fan of various
types of music and I hope to learn to write web APIs and cloud applications.

## Links

DockerHub Image: https://hub.docker.com/repository/docker/davidkurilla/music/general

** NOTICE: These Links are no longer active as my application is no longer being hosted by Google Cloud Platform. Please see the Local Install section for more information.

Compute Engine Deploy: http://34.125.73.21:8080/home.html

App Engine Deploy: https://graphic-boulder-417118.uc.r.appspot.com/home.html

GKE Deploy: http://34.135.15.26:8081/home.html

## Local Install

#### Step 01: Pull Docker Image from DockerHub
You can download Docker Desktop from [here](https://www.docker.com/get-started/):
```bash
docker pull davidkurilla/music
```

#### Step 02: Start Docker Container
```bash
docker run -p 8081:8080 -d davidkurilla/music
```

#### Step 03: Navigate to Application
Paste the link below in a web browser to access the application.
```
http://localhost:8081/home.html
```
