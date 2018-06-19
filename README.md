# Spring boot react gcloud

> SpringBoot, React/Redux application 

## Install
1. `git clone https://github.com/giopeto/react-spring-boot-maven-google-cloud.git`
2. `mvn clean install`

## Run on localhost

- Change ITEMS_URL in ui/client/src/items/index.js to 'http://localhost:8080/items'

- install datastore emulator: [Running the Cloud Datastore Emulator](https://cloud.google.com/datastore/docs/tools/datastore-emulator)
	- Command 'gcloud beta emulators datastore env-init' only print the variables to console. You need to manually execute them.

- Run 'gcloud beta emulators datastore start' in terminal to start the datastore emulator

## Deploy

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

## Live preview

- [https://react-spring-boot-maven-gcloud.appspot.com](https://react-spring-boot-maven-gcloud.appspot.com/)