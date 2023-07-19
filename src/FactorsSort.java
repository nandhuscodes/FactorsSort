import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class FactorsSort {
    static int noOfFactors(int n) {
        int count = 0;
        for(int i = 1; i*i <= n; i++){
            if(n%i == 0){
                if(n/i == i){
                    count++;
                }else{
                    count+=2;
                }
            }
        }
        return count;
    }
    static int[] factorSort(int[] A){
        for(int i = 0; i < A.length-1; i++){
            for(int j = i+1; j < A.length; j++){
                if(noOfFactors(A[i])==noOfFactors(A[j])){
                    int max = Math.max(A[i], A[j]), min = Math.min(A[i], A[j]);
                    A[i] = min;
                    A[j] = max;
                }
                if(noOfFactors(A[i])>noOfFactors(A[j])){
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
        return A;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A[] = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(factorSort(A)));
    }
}
