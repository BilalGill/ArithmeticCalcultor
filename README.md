# Arithmethic Calculator
A simple boot server and its respective client in java 
that perform arithmetic calculation. 

## Features

- Performs addition on input list
- Performs subtraction on input list
- Performs multiplication on input list
- Performs division on input list

## Requirements

- Spring Boot 2.3.2
- JDK 1.8
- Jenkins

## Installation

To builds project execute command below 
- mvn clean install -DskipTests

To run test cases execute command below
- sh "mvn test -Punit"

To deploy server execute command below
- java -jar target/server-1.0.0.jar

**Note:** The server is listening on port "9090" you can change this port in /main/resources/application.properties file

## Usage Examples (on localhost)

- http://localhost:9090/v1/add

Post Body: [1, 2]

## Assumptions

- I have assumed that there should be atleast 2 operands to get desired arithmetic calculation otherwise you will get 422 error.

## Assignment Specific Work Directories:
  
**Server Architecture** 
- |-- src
-        |-- main
                 |-- java
                         |--com.pm.arithmetics
                                              |--controllers
                                              |--exceptions
                                              |--services
                                              |--validators
                                              Application
                 |-- resources
                              application.properties                              
-        |-- test
                 |-- java
                         |--com.pm.arithmetics
                                              ArithmeticOpsControllerTests
                                              ArithmeticOpsServiceTest
- |--pom.xml                                              
            

**Client Architecture**

- |-- src
-        |-- main
                 |-- java
                         |--com.pm.arithmetics
                                              ArithmeticOpsClient.java
                         
         |-- test
                 |-- java
                         |--com.pm.arithmetics
                                              ArithmeticOpsClientTest.java

## Unit Test Code Coverage

- Unit test code coverage report is also configured in the project using well renowed library "jacoco".
- After building the project you can view the unit test coverage report at the path below
***/target/site/jacoco/index.html***

## Jenkin Pipeline

- Jenkins pipeline is placed in the file named "Jenkinsfile"

**Automatic Increment Version**

You can achieve this by the steps below
- Using ${env.BUILD_NUMBER} of the jenkins
- Sending ${env.BUILD_NUMBER} to mvn while building the application
  e.g. mvn clean install -DskipTests --Drevision=${env.BUILD_NUMBER}
- Update the ${env.BUILD_NUMBER} in a file to git from which maven could update its pom.xml version


 
