pipeline {
     agent any
     stages {
          stage("Checkout") {
               steps {
                    git 'https://github.com/example/test.git'
               }
          }
          stage("Build") {
               steps {
                    sh "mvn clean install -DskipTests"
               }
          }
          stage("Test") {
               steps {
                    sh "mvn test -Punit"
               }
          }
          stage("Deploy") {
              steps{
                    sh "cp target/1.0.0-SNAPSHOT.jar ~/.m2 "
                  }
              }
          }
     }
