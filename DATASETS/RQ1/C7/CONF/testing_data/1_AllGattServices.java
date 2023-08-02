


public class AllGattServices {
    private static HashMap<String, String> attributes = new HashMap();

    public static String HEART_RATE_MEASUREMENT = "00002a37-0000-1000-8000-00805f9b34fb";

    static {
        attributes.put("00001800-0000-1000-8000-00805f9b34fb", "Generic Access");
        attributes.put("00001801-0000-1000-8000-00805f9b34fb", "Generic Attribute");
        attributes.put("00001802-0000-1000-8000-00805f9b34fb", "Immediate Alert");
        attributes.put("00001803-0000-1000-8000-00805f9b34fb", "Link Loss");
        attributes.put("00001804-0000-1000-8000-00805f9b34fb", "Tx Power");
        attributes.put("00001805-0000-1000-8000-00805f9b34fb", "Current Time Service");
        attributes.put("00001806-0000-1000-8000-00805f9b34fb", "Reference Time Update Service");
        attributes.put("00001807-0000-1000-8000-00805f9b34fb", "Next DST Change Service");
        attributes.put("00001808-0000-1000-8000-00805f9b34fb", "Glucose");
        attributes.put("00001809-0000-1000-8000-00805f9b34fb", "Health Thermometer");
        attributes.put("0000180a-0000-1000-8000-00805f9b34fb", "Device Information");
        attributes.put("0000180d-0000-1000-8000-00805f9b34fb", "Heart Rate");
        attributes.put("0000180e-0000-1000-8000-00805f9b34fb", "Phone Alert Status Service");
        attributes.put("0000180f-0000-1000-8000-00805f9b34fb", "Battery Service");
        attributes.put("00001810-0000-1000-8000-00805f9b34fb", "Blood Pressure");
        attributes.put("00001811-0000-1000-8000-00805f9b34fb", "Alert Notification Service");
        attributes.put("00001812-0000-1000-8000-00805f9b34fb", "Human Interface Device");
        attributes.put("00001813-0000-1000-8000-00805f9b34fb", "Scan Parameters");
        attributes.put("00001814-0000-1000-8000-00805f9b34fb", "Running Speed and Cadence");
        attributes.put("00001815-0000-1000-8000-00805f9b34fb", "Automation IO");
        attributes.put("00001816-0000-1000-8000-00805f9b34fb", "Cycling Speed and Cadence");
        attributes.put("00001818-0000-1000-8000-00805f9b34fb", "Cycling Power");
        attributes.put("00001819-0000-1000-8000-00805f9b34fb", "Location and Navigation");
        attributes.put("0000181a-0000-1000-8000-00805f9b34fb", "Environmental Sensing");
        attributes.put("0000181b-0000-1000-8000-00805f9b34fb", "Body Composition");
        attributes.put("0000181c-0000-1000-8000-00805f9b34fb", "User Data");
        attributes.put("0000181d-0000-1000-8000-00805f9b34fb", "Weight Scale");
        attributes.put("0000181e-0000-1000-8000-00805f9b34fb", "Bond Management Service");
        attributes.put("0000181f-0000-1000-8000-00805f9b34fb", "Continuous Glucose Monitoring");
        attributes.put("00001820-0000-1000-8000-00805f9b34fb", "Internet Protocol Support Service");
        attributes.put("00001821-0000-1000-8000-00805f9b34fb", "Indoor Positioning");
        attributes.put("00001822-0000-1000-8000-00805f9b34fb", "Pulse Oximeter Service");
        attributes.put("00001823-0000-1000-8000-00805f9b34fb", "HTTP Proxy");
        attributes.put("00001824-0000-1000-8000-00805f9b34fb", "Transport Discovery");
        attributes.put("00001825-0000-1000-8000-00805f9b34fb", "Object Transfer Service");
        attributes.put("00001826-0000-1000-8000-00805f9b34fb", "Fitness Machine");
        attributes.put("00001827-0000-1000-8000-00805f9b34fb", "Mesh Provisioning Service");
        attributes.put("00001828-0000-1000-8000-00805f9b34fb", "Mesh Proxy Service");
        attributes.put("00001829-0000-1000-8000-00805f9b34fb", "Reconnection Configuration");


        
        attributes.put(HEART_RATE_MEASUREMENT, "Heart Rate Measurement");
        attributes.put("00002a29-0000-1000-8000-00805f9b34fb", "Manufacturer Name String");

        attributes.put("00002a00-0000-1000-8000-00805f9b34fb", "Device Name");
        attributes.put("00002a01-0000-1000-8000-00805f9b34fb", "Appearance");
        attributes.put("00002a02-0000-1000-8000-00805f9b34fb", "Peripheral Privacy Flag");
        attributes.put("00002a03-0000-1000-8000-00805f9b34fb", "Reconnection Address");
        attributes.put("00002a04-0000-1000-8000-00805f9b34fb", "Manufacturer Name String");
        attributes.put("00002a05-0000-1000-8000-00805f9b34fb", "Service Changed");
        attributes.put("00002A06-0000-1000-8000-00805f9b34fb", "Alert level");
    }

    public static String lookup(UUID uuid) {
        return lookup(uuid.toString(), "--");
    }

    public static String lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }

}
