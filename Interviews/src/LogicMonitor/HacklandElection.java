package LogicMonitor;

import java.util.*;

/**
 * @author: basavakanaparthi
 * on 05,Oct,2016 at 1:35 AM.
 */
public class HacklandElection
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int votes = in.nextInt();
        in.nextLine();
        HashMap<String, Integer> votesReceived = new HashMap<>();
        while (votes > 0)
        {
            String candidate = in.next();
            if (votesReceived.containsKey(candidate))
                votesReceived.put(candidate, votesReceived.get(candidate)+1);
            else
                votesReceived.put(candidate,1);
            votes--;
        }
        System.out.println(getWinner(votesReceived));
    }

    private static String getWinner(HashMap<String, Integer> votesReceived) {
        String winner = null;
        int numVotes = 0;
        for(Map.Entry<String, Integer> e: votesReceived.entrySet())
        {
            if (winner == null)
            {
                winner = e.getKey();
                numVotes =  e.getValue();
            }
            if (numVotes < e.getValue())
            {
                winner = e.getKey();
                numVotes = e.getValue();
            }
            else if (numVotes == e.getValue())
            {
                if (winner.compareTo(e.getKey()) < 0)
                    winner = e.getKey();
            }
        }
        return winner;
    }
    private static String getWinner(String[] votes) {
        int n = votes.length;
        HashMap<String, Integer> map = new HashMap<>();
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(votes[i])) {
                int temp = map.get(votes[i]);
                map.put(votes[i], temp + 1);
            } else {
                map.put(votes[i], 1);
            }
        }
        int max_votes = 0;
        for (String s : map.keySet()) {
            int vote = map.get(s);
            if (vote > max_votes) {
                winners.clear();
                winners.add(s);
                max_votes = vote;
            } else if (vote == max_votes) {
                for (String temp : winners) {
                    if (map.get(temp) != vote) {
                        winners.remove(temp);
                    }
                }
                winners.add(s);
            }
        }
        Collections.sort(winners);
        return winners.get(winners.size() - 1);
    }
}
