package me.qoomon;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static me.qoomon.UncheckedExceptions.unchecked;

public class UncheckedExceptionsTest {

    class BoomException extends Exception {
        BoomException() {
            super("Boom!");
        }
    }


    Object boomFunction() throws BoomException {
        throw new BoomException();
    }

    void boomMethod() throws BoomException {
        throw new BoomException();
    }


    @Test(expected = BoomException.class)
    public void unchecked_exception() {
        throw unchecked(new BoomException());
    }

    @Test(expected = BoomException.class)
    public void unchecked_exception_catch() {
        try {
            throw unchecked(new BoomException());
        } catch (Exception e) {
            if (e instanceof BoomException) {
                throw e;
            }
        }
    }

    @Test(expected = BoomException.class)
    public void unchecked_function() {
        unchecked(this::boomFunction);
    }

    @Test(expected = MalformedURLException.class)
    public void unchecked_function_in_stream() throws MalformedURLException {
        Stream.of("MalformedURL")
                .map(url -> unchecked(() -> new URL(url)))
                .collect(Collectors.toList());
    }

    @Test(expected = BoomException.class)
    public void unchecked_method() {
        unchecked(this::boomMethod);
    }

}


