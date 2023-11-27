package rule;

public class RuleFactory {
    public static Rule createDeathRule() {
        return new DeathRule();
    }

    public static Rule createBirthRule(int neighbors) {
        if(neighbors < 0 || neighbors > 8)
            throw new IllegalArgumentException("Invalid neighbors number");
        return new BirthRule(neighbors);
    }

    public static Rule createSurviveRule(int neighbors) {
        if(neighbors < 0 || neighbors > 8)
            throw new IllegalArgumentException("Invalid neighbors number");
        return new SurviveRule(neighbors);
    }
}