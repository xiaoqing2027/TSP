/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.ArrayList;
import java.lang.Math;
import java.util.List;

import Graph.*;
import com.sun.tools.corba.se.idl.constExpr.Not;

public class TSP_DP {
    Graph g;
    int numberOfVertices;
    int column;

    Double[][] minCurrentStage;
    Integer[][] pickedVertex;
    ArrayList<Double>[][] g_matrix;
    List<Integer> shortestPath = new ArrayList<Integer>();


    public TSP_DP(Graph g) {
        this.g  = g;
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

    public double solve() throws NotSolvableException {
        System.out.println("number of column " + column);
        Double[][] result = computeRoutes();
        return result[0][column-1];
    }
    public Double[][] computeRoutes() throws NotSolvableException{

        //filing value first column
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

                    if(g.hasEdge(j,k)) {
                        int w = i - (int) Math.pow(2, k - 1);
                        if (minCurrentStage[k][w] == -1.0) {
                            throw new NotSolvableException("No solution");
                        }
                        temp = g.getEdge(j, k) + minCurrentStage[k][ w];
                        if (temp < min) {
                            min = temp;
                            minCurrentStage[j][i] = min;
                            pickedVertex[j][i] = k;
                        }
                    }

                }

            }
        }

        // calculating last column, actually only minCurrentStage[0][column -1]
        double min = Double.MAX_VALUE;
        for (int k = 1; k < numberOfVertices; k++) {
            if(g.hasEdge(0,k)) {

                double temp = g.getEdge(0, k) + minCurrentStage[k][column - 1 - (int) Math.pow(2, k - 1)];

                if (temp < min) {
                    min = temp;
                    minCurrentStage[0][column - 1] = min;
                    pickedVertex[0][column - 1] = k;
                }
            }
        }

        shortestPath.add(0);
        int j = 0;
        for (int i = column - 1; i > 0; ) {
            j = pickedVertex[j][i];
            i = i - (int) Math.pow(2, j - 1);

            shortestPath.add(j);
        }
        shortestPath.add(0);

        if(minCurrentStage[0][column - 1] == -1.0) {
            throw new NotSolvableException("No solution.");
        }
        System.out.println("Shortest path:" + minCurrentStage[0][column - 1]);

        return minCurrentStage;
    }

    public String getShortestPath() {
        return shortestPath.toString();
    }

}
