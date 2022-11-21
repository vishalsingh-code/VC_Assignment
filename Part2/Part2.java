package VintageCircleAssignment.Part2;
import java.util.Arrays;
public class Part2 {

    public static void main(String[] args) {
//        Given an array and a number "n", find two numbers from the array that sums up to "n".
        int arr[]={1, 21, 3, 14, 5, 60, 7, 6};
        Arrays.sort(arr);
        int value=27;
        int low=0;
        int high=arr.length-1;

        while (low < high){

            if (arr[low] +  arr[high] > value){
                high--;
            } if (arr[low]+ arr[high] < value) {
                low++;
            } if (arr[low]+ arr[high]== value) {
                System.out.println("Pair of the array that sums up to \"n\" (" + arr[low] + "," + arr[high] + ")");
                low++;
                high--;
            }
        }
    }
}
