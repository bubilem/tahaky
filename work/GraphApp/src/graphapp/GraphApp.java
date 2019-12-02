package graphapp;

public class GraphApp {

    public static void main(String[] args) {
        
        RowGraph rg = new RowGraph("Konzumace ovoce Q3'2019");
        rg.add(new IntItem("jablka", 200));
        rg.add(new IntItem("hrusky", 20));
        rg.add(new IntItem("melouny", 150));
        rg.print();
    }
    
}
