


public class ReplaceObjectIds {

    private static final String SEARCH_PATTERN = "@Override\\s+public\\s+int\\[\\]\\s+getObjectIds\\(\\)\\s*\\{\\s*return\\s+new\\s+int\\[\\]\\{([0-9,\\s]+)\\};\\s*\\}";
    private static final String REPLACE_PATTERN = "ObjectId.$0";
    private static final String FILE_EXTENSION = ".java";
    private static final String CHARSET = "UTF-8";
    private static final Pattern ID_PATTERN = Pattern.compile("\\d+");

    public static void main(String[] args) throws IOException {
        
        File directory = new File(args[0]);

        
        File[] files = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION) && new File(dir, name).isFile());

        
        Pattern searchPattern = Pattern.compile(SEARCH_PATTERN);

        
        for (File file : files) {
            
            StringBuilder sb = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append(System.lineSeparator());
                }
            }

            
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

            
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(sb.toString());
            }
        }
    }

    private static String getJavaNameForId(int id) {
        
        String javaName = "UNKNOWN";
        try {
            
            Class<?> objectIdClass = Class.forName("com.zenyte.game.world.object.ObjectId");

            
            Field[] fields = objectIdClass.getFields();
            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers()) &&
                        Modifier.isPublic(field.getModifiers()) &&
                        Modifier.isFinal(field.getModifiers()) &&
                        field.getType() == int.class &&
                        field.getInt(null) == id) {
                    
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
