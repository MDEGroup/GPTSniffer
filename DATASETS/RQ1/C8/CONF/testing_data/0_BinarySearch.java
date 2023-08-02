public class BinarySearch {  public static int binarySearch(int[] array, int key) {    int low = 0;    int high = array.length - 1;    while (low <= high) {      int mid = (low + high) / 2;      if (array[mid] == key) {        return mid;      } else if (array[mid] < key) {        low = mid + 1;      } else {        high = mid - 1;      }    }    return -1;  }  public static void main(String[] args) {    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};    int key = 5;    int index = binarySearch(array, key);    if (index == -1) {      System.out.println(key + " is not present in the array.");    } else {      System.out.println(key + " is present at index " + index + " in the array.");    }  }}