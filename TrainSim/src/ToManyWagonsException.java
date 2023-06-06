public class ToManyWagonsException extends Exception{
    public ToManyWagonsException() {
        super("Locomotive can't handle this much wagons");
    }
}
