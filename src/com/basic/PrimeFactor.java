import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;

public class PrimeFactor {
    public static void main(String[] args) {
        int n = 36;
        ArrayList<Integer> list = printPrimeFactor(n);
        
        Iterator iterator = list.iterator();
        
        while(iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }
    
    /*
    
    Algo: 1) if n%2=0 then divide n by 2 and print 2 and repeat the process. -> O(n/2)
          2) loop i thru 3 to square-root of n -> O(n)
          3)   if n%i = 0 then set n = n/i and print i
          4) check final n and if n > 2 print it
          
          Total ~ O(n)
          Auxiliary Space = O(d)
    
    */
    public static ArrayList<Integer> printPrimeFactor(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int sqrtVal = (int) Math.sqrt(n);
        
        while(n%2 == 0) {
            list.add(2);
            n = n / 2;
        }
        
        for(int i = 3; i <= sqrtVal; i++) {
            if(n % i == 0) {
                list.add(i);
                n = n / i;
            }
        }
        
        if(n > 2)
            list.add(n);
        
        Collections.sort(list, (a,b) -> a.compareTo(b));
        
        return list;
    }
}
