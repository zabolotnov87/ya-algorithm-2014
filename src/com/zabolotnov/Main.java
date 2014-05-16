package com.zabolotnov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static double calcInsideRadius(int[] triangle){
        double result = 0;

        int a = triangle[0];
        int b = triangle[1];
        int c = triangle[2];

        double p = 0;

        for(int i = 0; i < 3; ++i){
            p += triangle[i];
        }

        p = p / 2;

        result = Math.sqrt(
                ((p - a) * (p - b) * (p - c)) / p
        );

        return result;
    }

    public static void main(String[] args) throws IOException {
        // read input
        BufferedReader inputRead = new BufferedReader(new InputStreamReader(System.in));

        String s = inputRead.readLine();
        int count_of_triangles = Integer.parseInt(s);

        int[][] triangles = new int[count_of_triangles][3];

        for(int i = 0; i < count_of_triangles; ++i) {
            s = inputRead.readLine();
            String[] chunks = s.split(" ");

            int[] triangle = {
                    Integer.parseInt(chunks[0]),
                    Integer.parseInt(chunks[1]),
                    Integer.parseInt(chunks[2])
            };

            triangles[i] = triangle;
        }


        Map<Double, Integer> count_to_radius = new HashMap<Double, Integer>();
        for(int i = 0; i < count_of_triangles; ++i) {
            double radius = calcInsideRadius(triangles[i]);
            if (count_to_radius.containsKey(radius)){
                int newFrequency = count_to_radius.get(radius) + 1;
                count_to_radius.put(radius, newFrequency);
            } else {
                count_to_radius.put(radius, 1);
            }
        }

        ArrayList<Integer> counts = new ArrayList<Integer>(count_to_radius.values());
        Collections.sort(counts);

        int last = counts.size() - 1;
        int result = counts.get(last);

        System.out.println(String.valueOf(result));
    }
}
