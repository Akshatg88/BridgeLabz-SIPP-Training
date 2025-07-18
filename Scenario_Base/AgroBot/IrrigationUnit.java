public class IrrigationUnit {
    protected String unitId;

    public IrrigationUnit(String unitId) {
        this.unitId = unitId;
    }

    public void calibrate() {
        System.out.println(unitId + " calibrating...");
    }

    public void startWatering() {
        System.out.println(unitId + " starting basic watering...");
    }
}
