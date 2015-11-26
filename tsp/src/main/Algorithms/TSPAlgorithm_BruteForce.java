package Algorithms;

import Graph.UndirectedGraph;

import java.util.*;

public class TSPAlgorithm_BruteForce {
    int startPoint = 0;
    ArrayList<Integer> travelingVertices;
    UndirectedGraph g;

    public TSPAlgorithm_BruteForce(UndirectedGraph g, int startPoint) {
        this.g = g;
        this.startPoint = startPoint;
        travelingVertices = new ArrayList<Integer>();
        for (int i = 0; i < g.getsize(); i++) {
            if (i != startPoint)
                travelingVertices.add(i);
        }
    }

    private ArrayList<ArrayList<Integer>> computeRoutes(ArrayList<Integer> route, ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums.size() == 0) {
            result.add(route);
        } else {
            for (Integer num : nums) {
                ArrayList<Integer> r = (ArrayList<Integer>) route.clone();
                ArrayList<Integer> n = (ArrayList<Integer>) nums.clone();
                n.remove(num);
                r.add(num);
                result.addAll(computeRoutes(r, n));
            }
        }
        return result;
    }

    public double solve() {
        ArrayList<Integer> array = new ArrayList<Integer>();

        ArrayList<ArrayList<Integer>> routes = computeRoutes(array, travelingVertices);
        double min = Double.MAX_VALUE;
        ArrayList<Integer> shortestRoute = new ArrayList<Integer>();

        for (ArrayList<Integer> route : routes) {
            double dist = cacluateRouteDistance(route);
            if (dist < min) {
                shortestRoute = route;
                min = dist;
            }
        }
        return min;
    }

    private double cacluateRouteDistance(ArrayList<Integer> route) {
        double total = 0.0;
        total += g.getEdge(startPoint, route.get(0));
        for (int i = 0; i < route.size() - 1; i++) {
            double dis = g.getEdge(route.get(i), route.get(i + 1));
        }
        total += g.getEdge(startPoint, route.get(route.size() - 1));
        return total;
    }

}
