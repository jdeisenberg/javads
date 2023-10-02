public class TestVertex {
    
    public static void main(String[] args) {
        Vertex<String> v1 = new Vertex<>("Japan");
        Vertex<String> v2 = new Vertex<>("China");
        Vertex<String> v3 = new Vertex<>("France");
        Vertex<String> v4 = new Vertex<>("Germany");
        
        v1.setNeighbor(v2, 3);
        v1.setNeighbor(v3, 10);
        v3.setNeighbor(v4, 1);
        v4.setNeighbor(v3, 1);
        
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
    }
}
