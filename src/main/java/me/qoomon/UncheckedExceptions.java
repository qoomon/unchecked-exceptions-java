package me.qoomon;

public class UncheckedExceptions {

    /**
     * throws {@code exception} as unchecked exception, without wrapping exception.
     *
     * @return will never return anything, return type is set to {@code exception} only to be able to write <code>throw unchecked(exception)</code>
     * @throws T {@code exception} as unchecked exception
     */
    @SuppressWarnings("unchecked")
    public static <T extends Throwable> T unchecked(final Throwable exception) throws T {
        throw (T) exception;
    }

    @FunctionalInterface
    public interface UncheckedFunction<R> {
        R call() throws Exception;
    }

    /**
     * Executes given function,
     * catches and rethrows checked exceptions as unchecked exceptions, without wrapping exception.
     *
     * @return result of function
     * @see #unchecked(Throwable)
     */
    public static <R> R unchecked(final UncheckedFunction<R> function) {
        try {
            return function.call();
        } catch (Exception e) {
            throw unchecked(e);
        }
    }

    @FunctionalInterface
    public interface UncheckedMethod {

        void call() throws Exception;
    }

    /**
     * Executes given method,
     * catches and rethrows checked exceptions as unchecked exceptions, without wrapping exception.
     *
     * @see #unchecked(Throwable)
     */
    public static void unchecked(final UncheckedMethod method) {
        try {
            method.call();
        } catch (Exception e) {
            throw unchecked(e);
        }
    }
}