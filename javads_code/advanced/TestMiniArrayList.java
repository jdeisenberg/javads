public class TestMiniArrayList {

    public static void main(String[] args) {
        MiniArrayList<String> list = new MiniArrayList<>(5);
        
        list.append("ant");
        list.append("bee");
        list.append("cat");
        list.append("dog");
        list.append("elk");
        list.append("fox");
        list.append("gnu");
        list.append("hen");
        System.out.println(list);
        System.out.println(list.size());
        
        String s = list.getItem(2);
        System.out.println(s);
        
        list.setItem(2, "cow");
        System.out.println(list);
        list.insert(0, "-->");
        list.insert(5, "|middle|");
        list.insert(list.size(), "<--");
        System.out.println(list);
    }
}

