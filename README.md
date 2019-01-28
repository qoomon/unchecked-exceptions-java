# Unchecked Exception 

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

[![Snyk Vulnerabilities](https://snyk.io/test/github/qoomon/unchecked-exceptions-java/badge.svg)](https://snyk.io/test/github/qoomon/unchecked-exceptions-java)

[![Codacy Maintainability](https://img.shields.io/codeclimate/maintainability/qoomon/unchecked-exceptions-java.svg)](https://codeclimate.com/github/qoomon/unchecked-exceptions-java)

[![Codacy Coverage](https://img.shields.io/codeclimate/coverage/qoomon/unchecked-exceptions-java.svg)](https://codeclimate.com/github/qoomon/unchecked-exceptions-java)

[![Travis](https://img.shields.io/travis/com/qoomon/unchecked-exceptions-java.svg)](https://travis-ci.com/qoomon/unchecked-exceptions-java)

[![Maven Central](https://img.shields.io/maven-central/v/me.qoomon/unchecked-exceptions.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22me.qoomon%22%20AND%20a%3A%22unchecked-exceptions%22) 

This lib can be used to throw checked exceptions without actually declaring this in your method's head `throws` clause.
And without wrapping `Exception` into a `RuntimeException`. Basically you can throw any `Exception` everywhere without catching them, happy throwing :-D

## Methods

`unchecked(Exception)` rethrows any exception as unchecked exception, without wrapping exception.
```java
  throw unchecked(checkedException);
```

`unchecked(LambdaFunction)` returns result or rethrows exception from lambda function as unchecked exception, without wrapping exception.
```java
  return unchecked(() -> methodThrowingCheckedException())
```

## Usage Examples
### Try-Catch Block
#### Regular Code 
```java
  import static me.qoomon.UncheckedExceptions.*;

  public class Example {
      
      void example() {
          URL url;
          // code polition with try catch block
          try {
            url = new URL("https:/www.example.org");
          } catch (MalformedURLException e) {
            // ugly exception wrapping
            throw RuntimeException(e); 
          }
          System.out(url);
      }
  }
```
#### Unchecked Exception Code
```java
  import static me.qoomon.UncheckedExceptions.*;

  public class Example {
      
      void example() {
        // get rid of code polition with try catch block
        // and ugly exception wrapping
        URL url = unchecked(() -> new URL("https:/www.example.org"));
        System.out(url);
      }
  }
```
### Stream
#### Regular Code 
```java
  
    import static me.qoomon.UncheckedExceptions.*;
  
    public class Example {
        
        void example() {
          Stream.of("https:/www.example.org")
            .map(url -> {
              // code polition with try catch block
              try {
                return new URL(url);
              } catch (MalformedURLException e) {
                // ugly exception wrapping
                throw new RuntimeException(e);
              }
            });
        }
    }
```
#### Unchecked Exception Code
```java
  
    import static me.qoomon.UncheckedExceptions.*;
  
    public class Example {
        
        void example() {
            Stream.of("https:/www.example.org")
                // get rid of code polition with try catch block
                // and ugly exception wrapping
                .map(url -> unchecked(() -> new URL(url)));
            }
    }
```

 
