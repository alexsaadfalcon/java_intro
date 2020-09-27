# java_intro
Intro to Java Homework and Tests

## Javadocs Link
I compiled the docs for hw01-hw09 and put them [here](alexsaadfalcon.github.io/java_intro). hw10 is broken since JavaFX is not part of the JRE/JDK anymore. 

## Run Homework/Test
There is a PDF in each directory describing the problem.
You can find which questions have a main by running
```bash
grep main(String *
```

And if Test.java comes back, run
```bash
javac Test.java
java Test
```

## Run Javadoc

To run checkstyle simply run the following in the terminal
```bash
javadoc *.java -d javadoc
```

## Run Checkstyle

To run checkstyle simply run the following in the terminal
```bash
java -jar checkstyle-6.0-all.jar -c cs1331-checkstyle.xml *.java
```