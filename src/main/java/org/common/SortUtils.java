import java.util.Random;

/**
 * Created by jiazhong on 11/20/15.
 */
public class SortUtils {

    /*
    * baskets,wrestler,strongHolder
    */
    public static int[] bubbleSort(int arr[]) {
        int result[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int wrestler = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (wrestler < arr[j]) {
                    int strongHolder = arr[j];
                    arr[j] = wrestler;
                    wrestler = strongHolder;
                }
            }
            result[i] = wrestler;
        }
        return result;
    }

    public static int[] genArrays(int size, int max) {
        int[] arrays = new int[size];
        Random rd = new Random();
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = rd.nextInt(max);
        }
        return arrays;
    }

}
