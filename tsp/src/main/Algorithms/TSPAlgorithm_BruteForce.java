package Algorithms;

import Graph.UndirectedGraph;

import java.util.*;

public class TSPAlgorithm_BruteForce {
    private static ArrayList<ArrayList<Integer>> computeRoutes(ArrayList<Integer> route, ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums.size() == 0) {
            result.add(route);
        }
        else {
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

    public double getShortRoute(UndirectedGraph g) {
        double shortest = Double.MAX_VALUE;


        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        System.out.println(computeRoutes(array, nums));

    }

}
