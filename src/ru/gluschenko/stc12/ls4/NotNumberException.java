package ru.gluschenko.stc12.ls4;

/***
 * Класс для исключения
 */
public class NotNumberException extends Exception{

    private String message = "Element %s is not a Number";
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   element   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public NotNumberException(String element) {
        super();
        this.message = String.format(this.message, element);

    }

    /***
     * перегружаем метод для сообщения
     * @return сообщение с ошибкой
     */
    public String toString(){
        return "Message from NotNumberException:"+this.message;
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return  the detail message string of this {@code Throwable} instance
     *          (which may be {@code null}).
     */
    public String getMessage() {
        return "Message from NotNumberException:"+this.message;
    }
}
