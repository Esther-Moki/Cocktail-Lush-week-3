# Cocktail Lush

The Cocktail Lush project happens to be a simple cocktail app written in java using android studio that allows
you to search for recipes, images of specific cocktails, ingredients, filter by alcoholic, non alcoholic and more by fetching data from the
Cocktails DB API,an API where one get data on alcohol & cocktails.When a cocktail is clicked a new fragment
appears that gives the user the drink name, ingredients , and directions on how to make the cocktail.The app is also linked to firebase 
to store the users previously searched and saved cocktails.


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
* 6.Use FirebaseUI for Android which is an open-source library for Android that allows you to quickly 
  connect common UI elements to Firebase APIs.
* 7.FirebaseUI is published as a collection of libraries separated by the Firebase API they target. 
  Each FirebaseUI library has a transitive dependency on the appropriate Firebase SDK so there is no need to 
  include those separately in your app.
* 8.In your app/build.gradle file add a dependency on one of the FirebaseUI libraries.
  
        dependencies {
  
        // FirebaseUI for Firebase Realtime Database
        implementation 'com.firebaseui:firebase-ui-database:7.2.0'
        implementation 'com.firebaseui:firebase-ui-database:8.0.0'
        // FirebaseUI for Cloud Firestore
        implementation 'com.firebaseui:firebase-ui-firestore:7.2.0'
        implementation 'com.firebaseui:firebase-ui-firestore:8.0.0'
        // FirebaseUI for Firebase Auth
        implementation 'com.firebaseui:firebase-ui-auth:7.2.0'
        implementation 'com.firebaseui:firebase-ui-auth:8.0.0'
        // FirebaseUI for Cloud Storage
        implementation 'com.firebaseui:firebase-ui-storage:7.2.0'
        implementation 'com.firebaseui:firebase-ui-storage:8.0.0'
        }


If you're including the firebase-ui-auth dependency, there's a little more setup required.

After the project is synchronized, we're ready to start using Firebase functionality in our app.

# Upgrading

If you are using an old version of FirebaseUI and upgrading, please see the appropriate migration guide:

         Upgrade from 7.2.0 to 8.x.x
         Upgrade from 6.4.0 to 7.x.x
         Upgrade from 5.1.0 to 6.x.x
         Upgrade from 4.3.2 to 5.x.x
         Upgrade from 3.3.1 to 4.x.x    
         Upgrade from 2.3.0 to 3.x.x
         Upgrade from 1.2.0 to 2.x.x

# Dependencies

# Compatibility with Firebase / Google Play Services libraries

FirebaseUI libraries have the following transitive dependencies on the Firebase SDK:

        //firebase-ui-auth
         |--- com.google.firebase:firebase-auth
         |--- com.google.android.gms:play-services-auth
        
        //firebase-ui-database
         |--- com.google.firebase:firebase-database
        
       // firebase-ui-firestore
         |--- com.google.firebase:firebase-firestore
        
       // firebase-ui-storage
         |--- com.google.firebase:firebase-storage

You can see the specific dependencies associated with each release on the Releases page.

## Upgrading dependencies

If you would like to use a newer version of one of FirebaseUI's transitive dependencies, such as Firebase, Play services, or the Android support libraries, you need to add explicit implementation declarations in your build.gradle for all of FirebaseUI's dependencies at the version you want to use. Here are some examples listing all of the critical dependencies:

# Auth
     implementation "com.google.firebase:firebase-auth:$X.Y.Z"
     implementation "com.google.android.gms:play-services-auth:$X.Y.Z"
     implementation "androidx.lifecycle:lifecycle-extensions:$X.Y.Z"
     implementation "androidx.browser:browser:$X.Y.Z"
     implementation "androidx.cardview:cardview:$X.Y.Z"
     implementation "androidx.constraintlayout:constraintlayout:$X.Y.Z"
     implementation "androidx.legacy:legacy-support-v4:$X.Y.Z"
     implementation "com.google.android.material:material:$X.Y.Z"

# Firestore
     implementation "com.google.firebase:firebase-firestore:$X.Y.Z"
     implementation "androidx.legacy:legacy-support-v4:$X.Y.Z"
     implementation "androidx.recyclerview:recyclerview:$X.Y.Z"

# Realtime Database
     implementation "com.google.firebase:firebase-database:$X.Y.Z"
     implementation "androidx.legacy:legacy-support-v4:$X.Y.Z"
     implementation "androidx.recyclerview:recyclerview:$X.Y.Z"

# Storage
     implementation "com.google.firebase:firebase-storage:$X.Y.Z"
     implementation "androidx.legacy:legacy-support-v4:$X.Y.Z"

## Contributing

# Installing locally

You can download FirebaseUI and install it locally by cloning this repository and running:

    ./gradlew :library:prepareArtifacts publishToMavenLocal

## Known Bugs

There are no known bugs yet.

## Technologies Used

Languages used include:

* 1.Java
* 2.Android-Studio
* 3.FirebaseUI for Android

## Build

Run build.gradle to build the project. The build artifacts will be stored in the build.gradle.

## Support and Contact details

If you run into any issues or have questions, ideas,concerns or even want to make a contribution to
 the code,you can drop me an email on esther.moki@student.moringaschool.com.

### License

This document comes with <a href="https://github.com/Esther-Moki/Cocktail-Lush/blob/master/LICENSE" target="_blank">MIT Licence</a> . Find the License document attached to it to learn more about it.
* Copyright (c) [2021] [Esther Moki]

