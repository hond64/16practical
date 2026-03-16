//Miguel Wentzel
//4478677
//Practical 16
import java.util.Arrays;

public class tryHeapsort{
    static String[] heap;
    static int size;

    public static void main(String[] args){
        String[] words = {"cat","dog","banana","zebra","lion","goat","fish","human"};
        String[] bottomUpArray = Arrays.copyOf(words, words.length);
        String[] topDownArray = Arrays.copyOf(words, words.length);
        System.out.println("Original array: " + Arrays.toString(words));
        System.out.println(Arrays.toString(words));
    }
}

