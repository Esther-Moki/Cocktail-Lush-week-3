# Cocktail Lush

The Cocktail Lush project happens to be a simple cocktail app written in java using android studio that allows
you to search for recipes, images of specific cocktails, ingredients, filter by alcoholic, non alcoholic and more by fetching data from the
Cocktails DB API,an API where one get data on alcohol & cocktails.When a cocktail is clicked a new fragment
appears that gives the user the drink name, ingredients , and directions on how to make the cocktail.The app is also linked to firebase 
to store the users previously searched and saved cocktails


* By Esther Moki
* Date of current version:24/10/2021

## Description
This project helps one when they are looking for any cocktail of which one just only knows the name,
 type, some ingredient or even an image inshort any of the listed above, then one can surely find that cocktail here.


## Setup/Installation Requirement

* 1.Clone this repo to your android projects folder.
* 2.Run ubuntu to install all the dependencies which include android studio.
* 3.Open the project on your android studio.
* 4.Lastly build the project on gradle then run the app.
* 5.Use the cocktailDB API IN retrieving data about the cocktails.
*6.Use FirebaseUI for Android which is an open-source library for Android that allows you to quickly 
  connect common UI elements to Firebase APIs.
*7.FirebaseUI is published as a collection of libraries separated by the Firebase API they target. 
  Each FirebaseUI library has a transitive dependency on the appropriate Firebase SDK so there is no need to include those separately in your app.
  In your app/build.gradle file add a dependency on one of the FirebaseUI libraries.

     dependencies {
     // FirebaseUI for Firebase Realtime Database
     implementation 'com.firebaseui:firebase-ui-database:8.0.0' dependencies {
 // FirebaseUI for Firebase Realtime Database
 implementation 'com.firebaseui:firebase-ui-database:8.0.0'
 
     // FirebaseUI for Cloud Firestore
     implementation 'com.firebaseui:firebase-ui-firestore:8.0.0'
 
     // FirebaseUI for Firebase Auth
     implementation 'com.firebaseui:firebase-ui-auth:8.0.0'
 
     // FirebaseUI for Cloud Storage
     implementation 'com.firebaseui:firebase-ui-storage:8.0.0'
 }

     
         // FirebaseUI for Cloud Firestore
         implementation 'com.firebaseui:firebase-ui-firestore:8.0.0'
     
         // FirebaseUI for Firebase Auth
         implementation 'com.firebaseui:firebase-ui-auth:8.0.0'
     
         // FirebaseUI for Cloud Storage
         implementation 'com.firebaseui:firebase-ui-storage:8.0.0'
     }

If you're including the firebase-ui-auth dependency, there's a little more setup required.

After the project is synchronized, we're ready to start using Firebase functionality in our app.

## Known Bugs

There are no known bugs yet.

## Technologies Used

Languages used include:

* 1.Java
* 2.Android-Studio
*3.FirebaseUI for Android

## Build

Run build.gradle to build the project. The build artifacts will be stored in the build.gradle.

## Support and Contact details

If you run into any issues or have questions, ideas,concerns or even want to make a contribution to
 the code,you can drop me an email on esther.moki@student.moringaschool.com.

### License

This document comes with <a href="https://github.com/Esther-Moki/Cocktail-Lush/blob/master/LICENSE" target="_blank">MIT Licence</a> . Find the License document attached to it to learn more about it.
* Copyright (c) [2021] [Esther Moki]

