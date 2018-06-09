package gui.additional;

import java.util.ArrayList;

public class GraphControl {
    private ArrayList<String[]> data;
    private int[] preparedData;

    public GraphControl() {
    }

    public boolean prepareData(int column) {
        preparedData = new int[data.size() - 1];
        try {
            Integer.parseInt(data.get(1)[column]);
            for (int i = 1; i < data.size(); i++) {
                preparedData[i - 1] = Integer.parseInt(data.get(i)[column]);
                System.out.println(preparedData[i - 1]);
            }
        } catch (Exception e) {
            System.out.println(data.get(1)[column] + "\t");
            e.printStackTrace();
            preparedData = null;
            return false;
        }
        return true;
    }

    public void addData(ArrayList<String[]> data) {
        this.data = data;
    }

    public int[] getData() {
        prepareData(0);
        return preparedData;
    }
}
