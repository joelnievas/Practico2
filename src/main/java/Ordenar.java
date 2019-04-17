import java.util.Arrays;
import java.util.Comparator;

public class Ordenar  {
    public static <T extends Comparable<T>> void menorMayor(T[] arr)throws ArrayIndexOutOfBoundsException{

        Arrays.sort(arr, Comparator.nullsLast(T::compareTo));
    }

}
