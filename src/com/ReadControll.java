package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadControll {

    private static final String path = "C:\\Users\\Barracuda\\IdeaProjects\\Graphss\\data\\race_results.csv";
    private GraphControll graphControll;

    public ReadControll() {
    }

    public ReadControll(GraphControll graphControll) {
        this.graphControll = graphControll;
    }

    public void readData() {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                br.readLine();
                System.out.println(Arrays.toString(br.readLine().split(",")));
                String[] lineData;
                while ((line = br.readLine()) != null) {
                    lineData = br.readLine().split(",");
                    graphControll.getData().add(lineData[8]);
                }
                System.out.println(graphControll.getData().get(0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
