



public class RevisedQuickSort {
    public static void quickSort(int[] list) {
        
        int medianIdx = indexOfMedian(list);
        quickSort(list, medianIdx, list.length - 1);
    }

    public static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    
    public static int partition(int[] list, int first, int last) {
        int pivot = list[first]; 
        int low = first + 1; 
        int high = last; 

        while (high > low) {
            
            while (low <= high && list[low] <= pivot)
                low++;

            
            while (low <= high && list[high] > pivot)
                high--;

            
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    
    static int indexOfMedian(int[] list) {
        int[] temp = {list[0], list[list.length / 2], list[list.length - 1]};
        Arrays.sort(temp);
        if (list[0] == temp[1]) {
            return 0;
        }
        else if (list[list.length / 2] == temp[1]) {
            return list.length / 2;
        }

        return list.length - 1;
    }

    
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        quickSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}


