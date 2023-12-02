package rule;

import java.util.ArrayList;
import java.util.List;

public class RuleList {

    private List<Integer> surviveList;
    private List<Integer> birthList;

    public RuleList() {
        surviveList = new ArrayList<>();
        birthList = new ArrayList<>();
    }

    public void addBirthRule(int neighbors) {
        birthList.add(neighbors);
    }

    public void addSurviveRule(int neighbors) {
        surviveList.add(neighbors);
    }

    public List<Integer> getSurviveList() {
        return surviveList;
    }

    public List<Integer> getBirthList() {
        return birthList;
    }
}
