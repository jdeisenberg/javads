public class GenericSearchMethod { 
        
    public static <T> int search(T[] arr, T target) {
        int index = 0;
        while (index < arr.length && !arr[index].equals(target)) {
            index++;
        }
        return (index != arr.length) ? index : -1;
    }
    
    public static void main(String[]  args) {
        Integer [] arr = {3, 5, 7, 2, 9};
        int found = search(arr, 9);
        System.out.println("9 found at index " + found);
        
        String[] words = {"cat", "elk", "dog", "fox"};
        found = search(words, "elk");
        System.out.println("elk found at index " + found);
    }
}
