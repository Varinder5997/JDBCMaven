FROM openjdk:8
EXPOSE 8080
ADD /target/WatchStoreMavan-0.0.1-SNAPSHOT.jar WatchStoreMavan-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/WatchStoreMavan-0.0.1-SNAPSHOT.jar"]
