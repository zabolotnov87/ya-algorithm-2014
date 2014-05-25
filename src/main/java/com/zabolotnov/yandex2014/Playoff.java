package com.zabolotnov.yandex2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Playoff {

    private static final BufferedReader inputReader = getInputReader();

    private static BufferedReader getInputReader(){
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] strings) throws IOException {
        int count_of_teams = readCountOfTeams();
        Map<String, Integer> team_to_point = new HashMap<String, Integer>(count_of_teams);

        String[] play;

        for(int i = 0; i < count_of_teams - 1; i++){
            play = readPlay();
            String team1 = play[0];
            String team2 = play[1];

            if (team_to_point.containsKey(team1)){
                int result = team_to_point.get(team1);
                team_to_point.put(team1, result + 1);
            } else {
                team_to_point.put(team1, 1);
            }

            if (!team_to_point.containsKey(team2)) {
                team_to_point.put(team2, 0);
            }
        }

        String winner = getWinner(team_to_point);

        System.out.println(winner);
    }

    private static String[] readPlay() throws IOException {
        String str = inputReader.readLine();
        return str.split(" ");
    }

    private static String getWinner(Map<String, Integer> team_to_point){
        int max_point = 0;
        String winner = "";

        for(Map.Entry<String, Integer> entry : team_to_point.entrySet()){
            int point = entry.getValue();
            if (point > max_point){
                max_point = point;
                winner = entry.getKey();
            }
        }

        return winner;
    }

    private static int readCountOfTeams() throws IOException {
        String count_of_teams = inputReader.readLine();
        return Integer.parseInt(count_of_teams);
    }
}
