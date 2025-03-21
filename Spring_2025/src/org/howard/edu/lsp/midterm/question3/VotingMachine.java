package org.howard.edu.lsp.midterm.question3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VotingMachine {

    private List<String> candidates;

    private Map<String, Integer> votes;

    public VotingMachine() {
        this.candidates = new ArrayList<>();
        this.votes = new HashMap<>();
    }
    public void addCandidate(String candidate) {
        this.candidates.add(candidate);

    }
    public boolean  castVote(String candidate) {
        if (this.candidates.contains(candidate)) {
            if (this.votes.containsKey(candidate)) {
                this.votes.put(candidate, this.votes.get(candidate) + 1);
            } else {
                this.votes.put(candidate, 1);
            }
            return true;
        }
        return false;
    }
    public String getWinner() {
        int maxVotes = 0;
        String winner = "";
        for (Map.Entry<String, Integer> entry : this.votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner + " WINS with " + votes.get(winner) + " votes!!";

    }
}
