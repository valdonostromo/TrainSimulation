public class TemperatureToHighException extends Exception{

    public TemperatureToHighException() {
        super("Temperature in wagon is to high, you have to cool it down!");
    }
}
