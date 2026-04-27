import java.util.*;

public class TrainConsistentManagementApp{
    public static void bubbleSort(int[] arr){
        int n=arr.length;

        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void printArray(int[] arr){
        for(int val : arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] capacities={72, 56, 24, 70, 60};

        System.out.println("Before Sorting:");
        printArray(capacities);

        bubbleSort(capacities);

        System.out.println("After Sorting:");
        printArray(capacities);
    }
}