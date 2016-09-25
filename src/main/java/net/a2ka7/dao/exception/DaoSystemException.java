package net.a2ka7.dao.exception;

public class DaoSystemException extends DaoException {
    public DaoSystemException(String message){
        super(message);
    }

    public DaoSystemException(String message, Throwable cause){
        super(message, cause);
    }
}
