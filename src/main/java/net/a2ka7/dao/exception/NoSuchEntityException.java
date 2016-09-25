package net.a2ka7.dao.exception;

public class NoSuchEntityException  extends DaoBusinessEsception{

    public NoSuchEntityException(String message){
        super(message);
    }

    public NoSuchEntityException(String message, Throwable cause){
        super(message, cause);
    }
}
