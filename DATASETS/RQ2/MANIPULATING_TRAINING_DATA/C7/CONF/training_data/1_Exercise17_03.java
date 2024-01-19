





public class SumInteger {
    public static void main(String[] args) {

        String[] packageParts = Exercise17_01.class.getPackage().getName().split("\\.");
        String filePath = packageParts[0] + File.separator + packageParts[1] + File.separator + "Exercise17_03.dat";
        if (!(new File(filePath).exists())) {
            try (FileOutputStream fis = new FileOutputStream(filePath)) {
                DataOutputStream dos = new DataOutputStream(fis);
                runCreateTestDatFile(dos);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getLocalizedMessage());
            }

        }
        try (FileInputStream fis = new FileInputStream(filePath)) {
            DataInputStream dis = new DataInputStream(fis);

            int sum = 0;
            int numIntegers = dis.available() / 4; 

            System.out.print("The sum of: ");
            for (int i = 0; i < numIntegers; i++) {
                int n = dis.readInt();
                if (i == 0) {
                    System.out.print(n + "");
                } else {
                    System.out.print(" + " + n);
                }
                sum += n;
            }
            System.out.println(" = " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void runCreateTestDatFile(DataOutputStream dos) throws IOException {
        for (int i = 0; i < 10; i++) {
            int n = (int) (1 + Math.random() * 10);
            dos.writeInt(n);
        }
        dos.flush();
        dos.close();

    }
}
