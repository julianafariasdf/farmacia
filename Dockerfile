FROM adoptopenjdk/openjdk11:ubi

WORKDIR /app

COPY target/Farmacia-0.0.1-SNAPSHOT.jar /app/Farmacia.jar

ENTRYPOINT ["java", "-jar", "Farmacia.jar"]


