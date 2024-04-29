package test.danamon.microservice.user.config;

public class BadRequestException extends Exception {
    
    public BadRequestException(String message){
        super(message);
    }
}
