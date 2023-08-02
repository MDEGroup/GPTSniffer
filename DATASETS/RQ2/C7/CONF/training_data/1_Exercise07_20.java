



public class nan {

    public static void main(String[] args) {
        double[] arr = new double[10];

        Scanner in = new Scanner(System.in);
        System.out.println("Enter ten decimal numbers: ");
        for (int i = 0; i < 10; i++) {
            arr[i] = in.nextDouble();
        }
        selectionSort(arr);
        System.out.println("Sorted high to low: ");
        System.out.println(Arrays.toString(arr));


    }

    
    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            
            double currentMax = list[i];
            int currentMaxIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMax < list[j]) {
                    currentMax = list[j];
                    currentMaxIndex = j;
                }
            }
            
            if (currentMaxIndex != i) {
                list[currentMaxIndex] = list[i];
                list[i] = currentMax;
            }
        }
    }
}
