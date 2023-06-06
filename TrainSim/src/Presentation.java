public class Presentation {
    public static void main(String[] args) throws Exception {
        Locomotive locomotive = new Locomotive();


        PassengerWagon paswag = new PassengerWagon("PKP");
        paswag.kickOutPassengers();
        paswag.turnOnClimatizotion();

        MailWagon mailWagon = new MailWagon("Poczta Polska");
        mailWagon.burnMails();
        mailWagon.guardMail("gun");
        mailWagon.loadMail();

        BaggageAndMailWagon bam = new BaggageAndMailWagon("Poczta Polska");
        bam.loadBaggageAndMail();
        bam.sort();
        bam.alarm();

        DiningWagon din = new DiningWagon("InterCity");
        din.buyFood();

        BasicFreightWagon bfw = new BasicFreightWagon("PKPCargo");
        bfw.loadWagon();

        HeavyFreightWagon hbfw = new HeavyFreightWagon("PKPCargo");
        hbfw.loadWagon();

        RefigeratedWagon rw = new RefigeratedWagon("PKPCargo");
        rw.sensor();
        rw.lowerTemperature();

        LiquidMaterialWagon liquid = new LiquidMaterialWagon("PKPCargo");
        liquid.loadWagon();
        liquid.throwSugarToLiquid();

        GasMaterialsWagon gas = new GasMaterialsWagon("PKPCargo");
        gas.loadWagon();
        gas.checkPressure();

        ExplosivesWagon expl = new ExplosivesWagon("PKPCargo");
        expl.loadWagon();
        expl.detonateWagon();

        ToxicMaterialWagon toxic = new ToxicMaterialWagon("PKPCargo");
        toxic.callMyEx();
        toxic.loadWagon();

        LiquidToxicMaterialsWagon ltoxic = new LiquidToxicMaterialsWagon("PKPCargo");
        ltoxic.loadWagon();


    }
}
