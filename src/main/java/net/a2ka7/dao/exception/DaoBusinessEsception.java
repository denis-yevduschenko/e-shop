package net.a2ka7.dao.exception;

public class DaoBusinessEsception extends DaoException{

    public DaoBusinessEsception(String message){
        super(message);
    }

    public DaoBusinessEsception(String message, Throwable cause){
        super(message, cause);
    }
}
