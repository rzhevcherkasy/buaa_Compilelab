FROM openjdk:14
COPY . /myapp/
WORKDIR /myapp/
RUN javac -encoding UTF-8 -cp src/ src/Main.java src/cal/Add.java src/cal/StringIter.java src/cal/Tokenizer.java -d dst/
RUN java -cp dst/ Main