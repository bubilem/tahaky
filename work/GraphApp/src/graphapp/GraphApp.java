package graphapp;

public class GraphApp {

    public static void main(String[] args) {

        RowGraph.configure('#', 30);

        RowGraph rg = new RowGraph("Ovoce 2020");
        rg.add(new IntItem("jablka", 2));
        rg.add(new IntItem("hrusky", 5));
        rg.add(new IntItem("melouny", 20));
        //rg.add(new StringItem("víno", "150 kg"));
        rg.print();

        RowGraph g = new RowGraph("Auta 2020");
        g.add(new IntItem("audi", 200));
        g.add(new IntItem("skoda", 523));
        g.add(new IntItem("vw", 74));
        g.print();

    }

}
