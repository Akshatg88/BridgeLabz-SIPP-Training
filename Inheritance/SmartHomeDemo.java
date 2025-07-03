// Device.java
public class Device {
    protected String deviceId;
    protected boolean status;      // true = ON

    public Device(String deviceId) {
        this.deviceId = deviceId;
        this.status = false;
    }

    public void togglePower() { status = !status; }
}

// Thermostat.java
public class Thermostat extends Device {
    private double temperatureSetting;

    public Thermostat(String deviceId, double temp) {
        super(deviceId);
        this.temperatureSetting = temp;
    }

    public void displayStatus() {
        System.out.printf("Thermostat %s → Power:%s  Temp: %.1f °C%n",
                          deviceId, status ? "ON" : "OFF", temperatureSetting);
    }
}

// SmartHomeDemo.java
public class SmartHomeDemo {
    public static void main(String[] args) {
        Thermostat t = new Thermostat("THM-01", 24.0);
        t.togglePower();
        t.displayStatus();
    }
}
