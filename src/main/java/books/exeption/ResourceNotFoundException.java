package books.exeption;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }

}
