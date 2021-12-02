FROM openjdk:17
COPY ./* /app/
WORKDIR /app/
ENV CLASSPATH=".:./antlr-4.9.2-complete.jar:$CLASSPATH"
RUN javac Main.java
