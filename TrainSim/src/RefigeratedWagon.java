
public class RefigeratedWagon extends BasicFreightWagon implements ConnectionToGrid{
    private int temperature = 10;
    private int weight = 25000;
    public RefigeratedWagon(String sender) {
        super(sender);
        Thread thread = new Thread(() -> {
            while (true) {
                double random = Math.random()*10;
                if(random > 5) {
                    temperature += 1;
                }
                else
                    temperature -= 2;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
    public void sensor() throws Exception{
        if(temperature > 15) {
            System.out.println(temperature);
            throw new TemperatureToHighException();
        }
        else
            System.out.println("Temperature OK");
    }
    public void lowerTemperature(){
        temperature = 10;
    }

    @Override
    public String toString() {
        return "RefigeratedWagon{" +
                super.toString() +
                " temperature=" + temperature +
                '}';
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
