package gui.swing.mvc;

import gui.additional.GraphControl;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Model {

    public static int DATA_INSTANCE = 0;

    public int selectedCell = -1;
    private File dataFile;
    public GraphControl graphControll;

    public Model() {
        graphControll = new GraphControl();
    }

    public File getDataFile() {
        return dataFile;
    }

    public void readFile(JProgressBar bar) {
        ArrayList<String[]> list = new ArrayList<>();

        new Thread(() -> {
            DATA_INSTANCE = 1;
            try (BufferedReader br = new BufferedReader(new FileReader(dataFile.getPath()))) {
                bar.setVisible(true);

                long totalLength = dataFile.length();
                double lengthPerPercent = 100.0 / totalLength;
                long readLength = 0;
                String s;
                while ((s = br.readLine()) != null) {
                    readLength += s.length();
                    list.add(s.split(","));
                    bar.setValue((int) Math.round(lengthPerPercent * readLength));
                }
                graphControll.addData(list);
                bar.setVisible(false);
            } catch (Exception e) {
                DATA_INSTANCE = 0;
            }
        }).start();
    }

    public Object[][] addTitleData() {
        String[][] arr = new String[2][12];
        arr[0] = "id,user_id,opponent_race_result_id,result,type,drift_points,settings,created_at,updated_at,coins_reward,elo_delta,opponent_elo_delta".split(",");
        arr[1] = "129307426,462998,128585740,us,battle,5337,,2017-02-01 00:00:00.156118,,11000,11,-5".split(",");

        System.out.println(Arrays.deepToString(arr));
        return arr;
    }

    public Object[] getEmptyData() {
        return new Object[]{"", "", "", "", "", "", "", "", "", "", "", ""};
    }

    public void setDataFile(File dataFile) {
        this.dataFile = dataFile;
    }
}
