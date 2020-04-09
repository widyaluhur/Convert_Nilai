public class Error extends Throwable{
    private String exception;

    public Error(String e) {
        super();
        this.exception = e;
    }
    
    public String getMessage(){
        return this.exception;
    }
}