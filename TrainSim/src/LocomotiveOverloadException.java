public class LocomotiveOverloadException extends Exception{
    public LocomotiveOverloadException() {
        super("Locomotive overloaded, can't add another wagon");
    }
}
