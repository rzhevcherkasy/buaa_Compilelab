FROM openjdk:14
COPY . /myapp/
WORKDIR /myapp/
RUN javac -encoding UTF-8 -cp src/ src/Main.java -d dst/
