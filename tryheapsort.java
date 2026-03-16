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

        long startTime = System.nanoTime();
        buildHeapBottomUp(bottomUpArray);
        heapsort(bottomUpArray);
        long endTime = System.nanoTime();
        System.out.println("Bottom-up Heapsort: " + Arrays.toString(bottomUpArray));
        System.out.println("Bottom-up Heapsort Time: " + (endTime - startTime) + " nanoseconds");       

        long startTime2 = System.nanoTime();
        buildHeapTopDown(topDownArray);
        heapsort(topDownArray);
        long endTime2 = System.nanoTime();
        System.out.println("Top-down Heapsort: " + Arrays.toString(topDownArray));
        System.out.println("Top-down Heapsort Time: " + (endTime2 - startTime2) + " nanoseconds");


    }
    public static void buildHeapBottomUp(String[] array){
        size = array.length;
        heap = Arrays.copyOf(array, size);
        for(int i = size / 2 - 1; i >= 0; i--){
            heapify(heap, size, i);
        }
    }
    public static void buildHeapTopDown(String[] array){
        size = 0;
        heap = new String[array.length];
        for(String word : array){
            insert(word);
        }
        for (int i = size / 2 - 1; i >= 0; i--){
            heapify(heap, size, i);
        }
    }
    public static void insert(String word){
        if(size == heap.length){
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = word;
        size++;
        int currentIndex = size - 1;
        while(currentIndex > 0){
            int parentIndex = (currentIndex - 1) / 2;
            if(heap[currentIndex].compareTo(heap[parentIndex]) > 0){
                String temp = heap[currentIndex];
                heap[currentIndex] = heap[parentIndex];
                heap[parentIndex] = temp;
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }
    public static void heapify(String[] array, int n, int i){
        int largest = i;    
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < n && array[left].compareTo(array[largest]) > 0){
            largest = left;
        }
        if(right < n && array[right].compareTo(array[largest]) > 0){
            largest = right;
        }
        if(largest != i){
            String temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, n, largest); 
        }
    }   



        
}   

