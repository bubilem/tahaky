package graphapp;

public class RowGraph extends Graph {

    private static char symbol = '#';
    private static int maxValueSymbolCount = 70;

    public RowGraph(String value) {
        super(value);
    }

    public RowGraph() {
        super("");
    }

    public static void configure(char symbol, int maxValueSymbolCount) {
        RowGraph.symbol = symbol;
        RowGraph.maxValueSymbolCount = maxValueSymbolCount;
    }

    @Override
    public void print() {
        System.out.println(getCaption());
        for (Item item : items) {
            System.out.print(String.format("%" + getItemMaxNameLength() + "s", item.getName()) + "|");
            int symbolCount = (int) ((item.getValue() * maxValueSymbolCount) / getItemMaxValue());
            for (int i = 0; i < symbolCount; i++) {
                System.out.print(symbol);
            }
            System.out.println(" " + item.getValueString());
        }
    }

}
