package com.sam016.vsflatomation.service.ble;

import java.util.HashMap;
import java.util.UUID;

public class AllGattDescriptors {
    private static HashMap<String, String> attributes = new HashMap();

    static {
        attributes.put("00002900-0000-1000-8000-00805f9b34fb", "Characteristic Extended Properties");
        attributes.put("00002901-0000-1000-8000-00805f9b34fb", "Characteristic User Description");
        attributes.put("00002902-0000-1000-8000-00805f9b34fb", "Client Characteristic Configuration");
        attributes.put("00002903-0000-1000-8000-00805f9b34fb", "Server Characteristic Configuration");
        attributes.put("00002904-0000-1000-8000-00805f9b34fb", "Characteristic Presentation Format");
        attributes.put("00002905-0000-1000-8000-00805f9b34fb", "Characteristic Aggregate Format");
        attributes.put("00002906-0000-1000-8000-00805f9b34fb", "Valid Range");
        attributes.put("00002907-0000-1000-8000-00805f9b34fb", "External Report Reference");
        attributes.put("00002908-0000-1000-8000-00805f9b34fb", "Report Reference");
        attributes.put("00002909-0000-1000-8000-00805f9b34fb", "Number of Digitals");
        attributes.put("0000290a-0000-1000-8000-00805f9b34fb", "Value Trigger Setting");
        attributes.put("0000290b-0000-1000-8000-00805f9b34fb", "Environmental Sensing Configuration");
        attributes.put("0000290c-0000-1000-8000-00805f9b34fb", "Environmental Sensing Measurement");
        attributes.put("0000290d-0000-1000-8000-00805f9b34fb", "Environmental Sensing Trigger Setting");
        attributes.put("0000290e-0000-1000-8000-00805f9b34fb", "Time Trigger Setting");
    }

    public static String lookup(UUID uuid) {
        return lookup(uuid.toString(), "--");
    }

    public static String lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }

}
