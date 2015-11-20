import java.util.Arrays;

/**
 * Created by jiazhong on 11/20/15.
 */
public class SelectKth {

    public static int SIZE_MAX = 100;

    public static void main(String[] args) {

        int size = SIZE_MAX, max =SIZE_MAX;
        int kTh = size/2;

        long startTime = System.currentTimeMillis();
        int [] arrays = SortUtils.genArrays(size,max);
//        int kThValue = bubbleNCutK(arrays, kTh);
//        int[] arrays = new int[] {3,7,4,2,1,9,11,11,20,20};
        int kThValue = bubbleKth(arrays,kTh);
        long endTime = System.currentTimeMillis();
        System.out.println("Kth Value: ("+kThValue+")");
        System.out.println("Duration:"+Long.valueOf(endTime-startTime)+"(ms)");

    }

    public static int bubbleNCutK(int [] arr,int k){
        int [] bubbles = SortUtils.bubbleSort(arr);
        int index = arr.length - arr.length/2;
        return bubbles[index];
    }

    public static int bubbleKth(int[] arr, int k){
        int[] kArray = Arrays.copyOfRange(arr, 0, k);
        int[] holdArray = Arrays.copyOfRange(arr,k,arr.length);

        int[] bubbleSortedK = SortUtils.bubbleSort(kArray);
        for(int i=0;i<holdArray.length;i++){
            int wrestler = holdArray[i];
            for(int j=bubbleSortedK.length-1;j>=0;j--){
                if(j!=0){
                    int challenger = bubbleSortedK[j];
                    int challenger2 = bubbleSortedK[j-1];
                    if(challenger<wrestler && wrestler<=challenger2){
                        for(int m=bubbleSortedK.length-1;m>j;m--){
                            bubbleSortedK[m] = bubbleSortedK[m-1];
                        }
                        bubbleSortedK[j] = wrestler;
                        break;
                    }
                }
                else{
                    int challenger = bubbleSortedK[0];
                    if(challenger<wrestler){
                        for(int m=bubbleSortedK.length-1;m>j;m--){
                            bubbleSortedK[m] = bubbleSortedK[m-1];
                        }
                        bubbleSortedK[j] = wrestler;
                        break;
                    }

                }
            }
        }

        return bubbleSortedK[k-1];

    }

}
