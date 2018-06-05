# unchecked-exceptions-java 
[![Maven Central](https://img.shields.io/maven-central/v/me.qoomon/unchecked-exceptions.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22me.qoomon%22%20AND%20a%3A%22unchecked-exceptions%22) [![Build Status](https://travis-ci.org/qoomon/unchecked-exceptions-java.svg?branch=master)](https://travis-ci.org/qoomon/unchecked-exceptions-java)

This lib can be used to throw checked exceptions without actually declaring this in your method's head throws clause.

## Methods

Rethrow exception as unchecked exception, without wrapping exception.
```java
  unchecked(exception);
```

Catch and rethrow exception from lambda function as unchecked exception, without wrapping exception.
```java
  unchecked(() -> ...)
```

## Usage Examples
**With a Try-Catch Block**
```java
  import static me.qoomon.UncheckedExceptions.*;

  public class Example {
      
      void example() { // 'throws Exception' not needed anymore
          try {
            throw new Exception("boom!");
          } catch (Exception e) {
            throw unchecked(e);
          }
      }
  }
```
**Within a Stream**
```java
  
    import static me.qoomon.UncheckedExceptions.*;
  
    public class Example {
        
        void example() {
            Stream.of("https:/www.example.org")
                .map(url -> unchecked(() -> new URL(url))); // try-catch-block not needed anymore
            }
    }
```

 
