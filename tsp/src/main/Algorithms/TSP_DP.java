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
        //store solution for sub-problems
        minCurrentStage = new Double[numberOfVertices][column];
        //store picked vertices in sub-problems
        pickedVertex = new Integer[numberOfVertices][column];

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                minCurrentStage[j][i] = -1.0;
                pickedVertex[j][i] = 0;
            }
        }

    }


    public double solve() throws NotSolvableException {
        Double[][] result = computeRoutes();
        return result[0][column-1];
    }
    public Double[][] computeRoutes() throws NotSolvableException{

        //filing value first column----base case
        for (int j = 0; j < numberOfVertices; j++) {
            minCurrentStage[j][0] = g.getEdge(j, 0);
        }

        // filing value for other cells, except last column and the first row
        for (int i = 1; i < column - 1; i++) {
            for (int j = 1; j < numberOfVertices; j++) {
                //check whether j (belongs to S) appears in REM(i) with one vertex
                if (((int) Math.pow(2, j - 1) & i) != 0) {
                    continue;
                }
                //traversal for every vertex(binary digit) in subset
                double min = Double.MAX_VALUE;
                double temp;
                for (int k = 1; k < numberOfVertices; k++) {
                    if (((int) Math.pow(2, k - 1) & i) == 0) {
                        continue;
                    }

                    if(g.hasEdge(j,k)) {
                        //other vertices in the subset
                        int w = i - (int) Math.pow(2, k - 1);
                        if (minCurrentStage[k][w] < 0) {
                            //throw new NotSolvableException("No solution");
                            continue;
                        }
                        //recursion
                        temp = g.getEdge(j, k) + minCurrentStage[k][ w];
                        //picked minimum to store in sub-problem
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
                //traversal every vertex
                double temp = g.getEdge(0, k) + minCurrentStage[k][column - 1 - (int) Math.pow(2, k - 1)];

                if (temp < min) {
                    min = temp;
                    minCurrentStage[0][column - 1] = min;
                    pickedVertex[0][column - 1] = k;
                }
            }
        }

        //adding picked vertices to shortest path
        shortestPath.add(0);
        int j = 0;
        for (int i = column - 1; i > 0; ) {
            j = pickedVertex[j][i];
            i = i - (int) Math.pow(2, j - 1);

            shortestPath.add(j);
        }
        shortestPath.add(0);

        //check if there has solution
        if(minCurrentStage[0][column - 1] < 0) {
            throw new NotSolvableException("No solution.");
        }

        System.out.println("distance_DP: " + minCurrentStage[0][column - 1]);
        System.out.println("route_DP: " + getShortestRoute());
        return minCurrentStage;
    }
    // get path
    public String getShortestRoute() {
        return shortestPath.toString();
    }

}
