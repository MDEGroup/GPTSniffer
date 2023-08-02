package com.zenyte.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceObjectIds {

    private static final String SEARCH_PATTERN = "@Override\\s+public\\s+int\\[\\]\\s+getObjectIds\\(\\)\\s*\\{\\s*return\\s+new\\s+int\\[\\]\\{([0-9,\\s]+)\\};\\s*\\}";
    private static final String REPLACE_PATTERN = "ObjectId.$0";
    private static final String FILE_EXTENSION = ".java";
    private static final String CHARSET = "UTF-8";
    private static final Pattern ID_PATTERN = Pattern.compile("\\d+");

    public static void main(String[] args) throws IOException {
        // Get the directory to search in as a command-line argument
        File directory = new File(args[0]);

        // Find all Java files in the directory and its subdirectories
        File[] files = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION) && new File(dir, name).isFile());

        // Compile the search pattern
        Pattern searchPattern = Pattern.compile(SEARCH_PATTERN);

        // Iterate over the files
        for (File file : files) {
            // Read the contents of the file
            StringBuilder sb = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append(System.lineSeparator());
                }
            }

            // Search for the method in the file
            Matcher matcher = searchPattern.matcher(sb.toString());
            while (matcher.find()) {
                String idsString = matcher.group(1);
                String[] ids = idsString.split(",");
                for (String id : ids) {
                    int objectId = Integer.parseInt(id.trim());
                    String javaName = getJavaNameForId(objectId);
                    sb.replace(matcher.start(), matcher.end(), REPLACE_PATTERN.replace("$0", javaName));
                }
            }

            // Write the modified contents back to the file
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(sb.toString());
            }
        }
    }

    private static String getJavaNameForId(int id) {
        // Look up the Java name for the ID in the ObjectId class
        String javaName = "UNKNOWN";
        try {
            // Load the ObjectId class using reflection
            Class<?> objectIdClass = Class.forName("com.zenyte.game.world.object.ObjectId");

            // Look for a public static final field with the given ID
            Field[] fields = objectIdClass.getFields();
            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers()) &&
                        Modifier.isPublic(field.getModifiers()) &&
                        Modifier.isFinal(field.getModifiers()) &&
                        field.getType() == int.class &&
                        field.getInt(null) == id) {
                    // Found a matching field, use its name
                    javaName = field.getName();
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Could not find the ObjectId class.");
        } catch (IllegalAccessException e) {
            System.err.println("Could not access the ObjectId fields.");
        }

        return javaName;
    }
}
