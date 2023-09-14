public class HotPotatoSimulation {

    public static String hotPotato(String[] nameList, int num) {
        Queue<String> simQueue = new Queue<>();
        
        for (String name: nameList) {
            simQueue.enqueue(name);
        }
        
        while (simQueue.size() > 1) {
            // pass the potato: move person at head to tail
            for (int pass = 0; pass < num; pass++) {
                simQueue.enqueue(simQueue.dequeue());
            }
            
            String removed = simQueue.dequeue(); // remove person at head
            System.out.println(removed + " is out of the game.");
        }
        return simQueue.dequeue();
    }
    
    public static void main(String[] args) {
        String[] people = {"Bill", "David", "Susan", "Jane",
            "Kent", "Brad"};
        String lastPerson = hotPotato(people, 7);
        System.out.println("Last person is " + lastPerson + ".");
    }
}   
