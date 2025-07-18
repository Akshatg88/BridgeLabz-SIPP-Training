public class DripSystem extends IrrigationUnit implements SensorReadable {
    public DripSystem(String unitId) {
        super(unitId);
    }

    @Override
    public void startWatering() {
        System.out.println(unitId + " starting drip irrigation...");
    }

    @Override
    public void readSensorData() {
        System.out.println(unitId + " reading soil moisture sensor...");
    }
}
