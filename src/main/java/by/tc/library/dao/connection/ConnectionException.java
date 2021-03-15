package by.tc.library.dao.connection;

public class ConnectionException extends Exception{

    private static final long serialVersionUID = - 5945854859940390434L;
    public ConnectionException(){
        super();
    }
    public ConnectionException(String message){
        super(message);
    }
    public ConnectionException(Throwable e){
        super(e);
    }
    public ConnectionException(String message, Throwable e){
        super(message,e);
    }
}
