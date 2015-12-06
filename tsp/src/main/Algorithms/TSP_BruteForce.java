package Algorithms;

import Graph.*;

import java.util.*;
import java.util.stream.Collectors;

public class TSP_BruteForce {
    Graph g;
    int startPoint = 0;
    ArrayList<Integer> travelingVertices;
    ArrayList<Integer> shortestRoute;

    // Constructor
    // Set graph and startPoint of route
    public TSP_BruteForce(Graph g, int startPoint) {
        this.g = g;
        this.startPoint = startPoint;
        travelingVertices = new ArrayList<Integer>();
        for (int i = 0; i < g.getsize(); i++) {
            if (i != startPoint) {
                travelingVertices.add(i);
            }
        }
    }
    public TSP_BruteForce(Graph g) {
        this(g,0);
    }

    // This is to generate all permutations of a given list of vertices.
    // nums: a list of remaining vertices.
    // route: intermediate routes generated using vertices that have been pulled from 'nums'
    // return value is all permutations of routes.
    private ArrayList<ArrayList<Integer>> computeRoutes(ArrayList<Integer> route, ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums.size() == 0) {
            result.add(route);
        } else {
            for (Integer num : nums) {
                if(nums.size() == 1) {
                    if(!g.hasEdge(num, startPoint)) {
                        continue;
                    }
                }
                int pre = route.size() == 0 ? startPoint : route.get(route.size() - 1);
                if (g.hasEdge(pre, num)) {
                    ArrayList<Integer> r = (ArrayList<Integer>) route.clone();
                    ArrayList<Integer> n = (ArrayList<Integer>) nums.clone();
                    n.remove(num);
                    r.add(num);
                    result.addAll(computeRoutes(r, n));
                }
            }
        }
        return result;
    }

    // solve
    public double solve() throws NotSolvableException {
        ArrayList<Integer> array = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> routes = computeRoutes(array, travelingVertices);
        if(routes.size() == 0) {
            throw new NotSolvableException("No solution.");
        }
        double min = Double.MAX_VALUE;

        for (ArrayList<Integer> route : routes) {
            double dist = calculateRouteDistance(route);
            if (dist < min) {
                shortestRoute = route;
                shortestRoute.add(0, startPoint);
                shortestRoute.add(startPoint);
                min = dist;
            }
        }
        System.out.println("distance: " + min);
        System.out.println("route: " + getShortestRoute());

        return min;
    }

    public String getShortestRoute(){
        return shortestRoute.toString();
    }


    // helper function to determine a distance to a route.
    private double calculateRouteDistance(ArrayList<Integer> route) {
        double total = 0.0;
        total += g.getEdge(startPoint, route.get(0));
        for (int i = 0; i < route.size() - 1; i++) {
            double dis = g.getEdge(route.get(i), route.get(i + 1));
            total += dis;
        }
        total += g.getEdge(route.get(route.size() - 1),startPoint);
        return total;
    }

}
