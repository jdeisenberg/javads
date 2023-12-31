public class Searcher<T> { 
        
    public int search(T[] arr, T target) {
        int index = 0;
        while (index < arr.length && !arr[index].equals(target)) {
            index++;
        }
        return (index != arr.length) ? index : -1;
    }
    
    public static void main(String[]  args) {
        Searcher<Integer> searchInt = new Searcher<>();
        Integer [] arr = {3, 5, 7, 2, 9};
        int found = searchInt.search(arr, 9);
        System.out.println("9 found at index " + found);
        
        Searcher<String> searchStr = new Searcher<>();
        String[] words = {"cat", "elk", "dog", "fox"};
        found = searchStr.search(words, "elk");
        System.out.println("elk found at index " + found);
    }
    
}
