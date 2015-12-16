package Algorithms;


public class NotSolvableException extends Exception {
    String msg;
    public NotSolvableException(String msg){
        super(msg);
        this.msg = msg;
    }

    @Override
    public String getMessage(){
        return msg;
    }
}
