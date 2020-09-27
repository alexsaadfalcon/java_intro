# java_intro
Intro to Java Homework and Tests

## Javadocs Links
[hw01 docs](https://cdn.rawgit.com/alexsaadfalcon/java_intro/master/javadocs/hw01docs/index-all.html)

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