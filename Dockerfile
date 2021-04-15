# Start with a base image containing Java runtime
FROM java:8

# Add Author info
LABEL maintainer="f.softwareengineer@gmail.com"

# Add a volume to /tmp
VOLUME /tmp

# Make port 49005 available to the world outside this container
EXPOSE 49005

# The application's jar file
ARG JAR_FILE=build/libs/MySpringApp-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} to-do-springboot.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/to-do-springboot.jar"]