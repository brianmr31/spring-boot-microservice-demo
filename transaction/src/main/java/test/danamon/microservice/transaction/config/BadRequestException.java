package test.danamon.microservice.transaction.config;

public class BadRequestException extends Exception {
    
    public BadRequestException(String message){
        super(message);
    }
}
