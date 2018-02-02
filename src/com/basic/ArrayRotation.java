/*

Problem: Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements.

*/
public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int size = arr.length;
        int rotation = 2;
        
        //Before Array Rotation
        System.out.println(java.util.Arrays.toString(arr));
        
        //Rotate Array Method
        method2(arr, size, rotation);
    }
    
    /*
    
    Algo: 1) create temp array using rotation #
          2) copy arr[i] to temp[i] looping rotation O(n)
          3) move arr element by the rotation O(n)
          4) add temp array data at the end of the original array O(n)
          
          Consideration:
          rotation# < size of array
          
          Total =~ O(n)
          Auxiliary Space = O(d)
    
    */
    public static void method1(int[] arr, int n, int d) {
        
        int[] temp = new int[d];
        
        for(int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        
        for(int i = 0; i < n-d; i++) {
            arr[i] = arr[i+d];
        }
        
        for(int i = (n-d), j = 0; i < n; i++, j++) {
            arr[i] = temp[j];
        }
        
        //Final array after rotation
        System.out.println(java.util.Arrays.toString(arr));
    }
    
    /*
    
    Algo: Rotate the array by one
          1) temp = arr[0] -> O(1)
          2) rotate the array by one in left direction i.e arr[i] = arr[i+1] until i+1 = n -> O(n)
          3) place the temp into rightmost array position i.e. arr[n-1] = temp -> O(1)
          4) Repeat the step 1 and 3 based on rotation # -> O(d)
          
          Total ~ O(n*d)
          Auxiliary Space = O(1)
    */
    public static void method2(int[] arr, int n, int d) {
        int temp;
        for(int i = 0; i < d; i++) {
            temp = arr[0];
            rotateByOne(arr);
            arr[n-1] = temp;
            System.out.println(java.util.Arrays.toString(arr));
        }
    }
    
    /*
    
    Rotate the array element by one
    
    */
    
    public static void rotateByOne(int[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
    }
}
