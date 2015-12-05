/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.ArrayList;
import java.lang.Math;
import Graph.*;

public class TSP_DP {

    int numberOfVertices;
    int column;

    Double[][] minCurrentStage;
    Integer[][] pickedVertex;
    ArrayList<Double>[][] g_matrix;
    Graph g;

    public TSP_DP(Graph g) {
        numberOfVertices = g.getsize();
        column = (int) Math.pow(2, (numberOfVertices - 1));

        minCurrentStage = new Double[numberOfVertices][column];
        pickedVertex = new Integer[numberOfVertices][column];

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                minCurrentStage[j][i] = 0.0;
                pickedVertex[j][i] = 0;
            }
        }

    }

    public Double[][] computeRoutes(Graph g) {

        //filing value first column
        System.out.println("first column: (and number of column " + column);
        for (int j = 0; j < numberOfVertices; j++) {
            minCurrentStage[j][0] = g.getEdge(j, 0);
        }

        // filing value for other cells, except last column and the first row
        for (int i = 1; i < column - 1; i++) {
            for (int j = 1; j < numberOfVertices; j++) {
                if (((int) Math.pow(2, j - 1) & i) != 0) {
                    continue;
                }
                double min = Double.MAX_VALUE;
                double temp;
                for (int k = 1; k < numberOfVertices; k++) {
                    if (((int) Math.pow(2, k - 1) & i) == 0) {
                        continue;
                    }
                    /*
                    please review and see if this is correct.
                    if(!g.hasEdge(j,k)) {
                        continue;
                    }
                    */
                    temp = g.getEdge(j, k) + minCurrentStage[k][i - (int) Math.pow(2, k - 1)];
                    if (temp < min) {
                        min = temp;
                        minCurrentStage[j][i] = min;
                        pickedVertex[j][i] = k;
                    }

                }

            }
        }

        // calculating last column, actually only minCurrentStage[0][column -1]
        double min = Double.MAX_VALUE;
        for (int k = 1; k < numberOfVertices; k++) {

            double temp;
            temp = g.getEdge(0, k) + minCurrentStage[k][column - 1 - (int) Math.pow(2, k - 1)];

            if (temp < min) {
                min = temp;
                minCurrentStage[0][column - 1] = min;
                pickedVertex[0][column - 1] = k;
            }
        }

        int j = 0;
        System.out.print(1 + "->");
        for (int i = column - 1; i > 0; ) {
            j = pickedVertex[j][i];
            i = i - (int) Math.pow(2, j - 1);

            System.out.print(j + 1 + "->");
        }

        System.out.println(1);
        System.out.println("Shortest path:" + minCurrentStage[0][column - 1]);

        return minCurrentStage;
    }

}
