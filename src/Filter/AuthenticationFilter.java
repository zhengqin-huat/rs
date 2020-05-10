package Filter;

public class AuthenticationFilter {

    public void execute(String request){
        System.out.println("Authenticating request: " + request);
    }

}
