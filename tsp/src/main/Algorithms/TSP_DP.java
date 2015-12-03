/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import static java.lang.Math.pow;
import java.util.ArrayList;

/**
 *
 * @author miaodonghan
 */
public class TSP_DP {

    int numberOfVertices;
    int column;
    
    Double[][] minCurrentStage;
    Integer[][] pickedVertex;
    ArrayList<Double>[][] g_matrix;
    UndirectedGraph g;
    
    
    public TSP_DP(UndirectedGraph g) {
        numberOfVertices = g.getsize();
        column =(int)pow(2,numberOfVertices);


        minCurrentStage = new Double[numberOfVertices][column];
        pickedVertex = new Integer[numberOfVertices][column];
        
        for(int i = 0; i < column; i++){
            for(int j=0; j < numberOfVertices; j++){
                minCurrentStage[j][i]= -1.0;
                pickedVertex[j][i]= -1;   
            }
        }

    }
    
    public Double[][] computeRoutes( UndirectedGraph g) 
     {
              
        //filing value first column
        for(int j = 0; j < numberOfVertices; j++){
             minCurrentStage[j][0]=g.getEdge(j, 0);
        }
        
        // filing value for other cells, except last column and the first row
        for(int i = 1; i < column; i++){
            
            for(int j = 1; j < numberOfVertices; j++){
                
                if(((int)pow(2,j-1) & i) == 0){
                    double min = Double.MAX_VALUE;
                    double temp;
                    for(int k = 1; k < numberOfVertices; k++){
                        if(((int)pow(2,k-1) & i) !=0){
                            temp = g.getEdge(j, 0) + minCurrentStage[k][i - (int)pow(2,k-1)];
                            if(temp < min){
                                min = temp;
                                minCurrentStage[j][i] = min;
                                pickedVertex[j][i] = k;
                            }
                        }
                    }
                }
            }   
        }
        
        // calculating last column, actually only minCurrentStage[0][column -1]
        for(int k = 1; k < numberOfVertices; k++){
            double min = Double.MAX_VALUE;
            double temp;
             temp = g.getEdge(0,k) + minCurrentStage[k][column -1 - (int)pow(2,k-1)];
                            if(temp < min){
                                min = temp;
                                minCurrentStage[0][column -1 ] = min;
                                pickedVertex[0][column -1 ] = k;
                            }
        }
        System.out.println("Shortest path:"+minCurrentStage[0][column -1 ]);
        
        return minCurrentStage;
    }
    

    
}
