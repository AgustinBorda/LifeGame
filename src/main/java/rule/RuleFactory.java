package rule;

public class RuleFactory {
    public static Rule createDeathRule() {
        return new DeathRule();
    }

    public static Rule createBirthRule(int neighbors) {
        if(neighbors == 3)
            return new B3Rule();
        throw new IllegalArgumentException("No such rule");
    }

    public static Rule createSurviveRule(int neighbors) {
        if(neighbors == 2)
            return new S2Rule();
        if(neighbors == 3)
            return new S3Rule();
        throw new IllegalArgumentException("No such rule");
    }
}
