# Spring boot react gcloud
===========================

How to deploy
-----
- cd to project

mvn clean install

- cd api

gcloud config set project {PROJECT_ID}

gcloud app create --region us-central

- Deploy to Google App Engine app

mvn appengine:deploy

- Open in browser

gcloud app browse

- Update project

mvn appengine:deploy

Link to project
-----
[https://react-spring-boot-maven-gcloud.appspot.com](https://react-spring-boot-maven-gcloud.appspot.com/)