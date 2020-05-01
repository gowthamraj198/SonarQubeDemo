# HouseHold-Appliances
As a user, I want to be able to manage my household appliances so that I could properly document and maintain them.
In Local (non-docker env)

After cloning the repo, Build using the below commands:

    mvn clean install
    mvn clean package

Bring the service up by executing the command

    mvn spring-boot:run

To do sonarqube analysis

     mvn sonar:sonar
     
Prerequisite:

     sonarqube docker image
     
To run sonarqube docker image:

    1. pull the latest image -> docker pull sonarqube:latest
    2. Run the container in 9000 port -> docker container run -d --name sonarqube -p 9000:9000 sonarqube:latest
    3. Run the command -> mvn sonar:sonar
    4. See the reaults in browser -> http://localhost:9000/projects?sort=-analysis_date