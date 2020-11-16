pipeline {
     agent any
     stages {
          stage("Checkout") {
               steps {
                    git 'https://github.com/BilalGill/ArithmeticCalcultor.git'
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
                    sh "cp target/server-1.0.0.jar ~/.m2 "
                  }
              }
          }
     }
