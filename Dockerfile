FROM openjdk:17
COPY ./* /app/
WORKDIR /app/
ENV CLASSPATH=/app:/app/antlr-4.9.2-complete.jar
RUN javac -cp src/ src/Main.java
