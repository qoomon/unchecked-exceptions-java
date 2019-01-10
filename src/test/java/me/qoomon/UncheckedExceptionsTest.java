package me.qoomon;

import static me.qoomon.UncheckedExceptions.unchecked;

import org.junit.Test;

public class UncheckedExceptionsTest {

    class BoomException extends Exception {
        BoomException() {
            super("Boom!");
        }
    }

    @Test(expected = BoomException.class)
    public void unchecked_exception() {
        throw unchecked(new BoomException());
    }


    private Object errorFunction() throws BoomException {
        throw new BoomException();
    }

    private void errorMethod() throws BoomException {
        throw new BoomException();
    }


    @Test(expected = BoomException.class)
    public void unchecked_method() {
        unchecked(this::errorMethod);
    }

    @Test(expected = BoomException.class)
    public void unchecked_function() {
        unchecked(this::errorFunction);
    }


    private Object successFunction(){
        return null;
    }

    private void successMethod(){
    }

    @Test
    public void unchecked_function_exception() {
        unchecked(this::successFunction);
    }

    @Test
    public void unchecked_method_exception() {
        unchecked(this::successMethod);
    }



}


