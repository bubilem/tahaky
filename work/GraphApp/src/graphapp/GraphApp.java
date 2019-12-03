package graphapp;

public class GraphApp {

    public static void main(String[] args) {

        RowGraph.configure('#', 50);
        RowGraph rg = new RowGraph("Ovoce 2019");
        rg.add(new IntItem("jablka", 200));
        rg.add(new IntItem("hrusky", 20));
        rg.add(new IntItem("melouny", 150));
        rg.add(new StringItem("víno", "150 kg"));
        rg.print();

    }

}
