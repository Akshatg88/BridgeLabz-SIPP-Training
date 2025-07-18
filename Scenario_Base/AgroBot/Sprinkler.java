public class Sprinkler extends IrrigationUnit implements SensorReadable {
    public Sprinkler(String unitId) {
        super(unitId);
    }

    @Override
    public void startWatering() {
        System.out.println(unitId + " sprinkling water...");
    }

    @Override
    public void readSensorData() {
        System.out.println(unitId + " reading humidity sensor...");
    }
}
