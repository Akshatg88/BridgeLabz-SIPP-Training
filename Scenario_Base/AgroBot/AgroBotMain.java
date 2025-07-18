public class AgroBotMain {
    public static void main(String[] args) {
        Sprinkler sprinkler = new Sprinkler("SPK-01");
        DripSystem drip = new DripSystem("DRP-01");

        sprinkler.calibrate();
        sprinkler.readSensorData();
        sprinkler.startWatering();

        drip.calibrate();
        drip.readSensorData();
        drip.startWatering();
    }
}
