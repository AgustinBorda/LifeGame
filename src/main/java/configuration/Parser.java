package configuration;

import board.BoardType;
import rule.RuleList;
import timedelayer.TimeDelayerData;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public String getInitialState() {
        return GameConfiguration.getInstance().getProperty("INITIAL_STATE");
    }
    public BoardType getBoardType() {
        String type = GameConfiguration.getInstance().getProperty("BOARD_TYPE");
        if(type.equalsIgnoreCase("finite"))
            return BoardType.FINITE;
        if(type.equalsIgnoreCase("toroidal"))
            return BoardType.TOROIDAL;
        throw new IllegalStateException("Board configuration option doesn't exist");

    }
    public int getSteps() {
        return Integer.parseInt(GameConfiguration.getInstance().getProperty("SIMULATION_STEPS"));
    }

    public RuleList getRules() {
        GameConfiguration g = GameConfiguration.getInstance();
        RuleList result = new RuleList();
        boolean birth;
        String[] rules = g.getProperty("RULES").split("/");
        Pattern pattern = Pattern.compile("[1-9]");
        for (String rule : rules) {
            Matcher matcher = pattern.matcher(rule);
            birth = rule.charAt(0) == 'B';
            while (matcher.find()) {
                if (birth)
                    result.addBirthRule(Integer.parseInt(matcher.group()));
                else
                    result.addSurviveRule(Integer.parseInt(matcher.group()));
            }
        }
        return result;
    }
    public TimeDelayerData getDelayer() {
        GameConfiguration g = GameConfiguration.getInstance();
        String coolDown = g.getProperty("TIME_BETWEEN_TICKS");
        int i = coolDown.length();
        do
            i--;
        while(!Character.isDigit(coolDown.charAt(i)));
        i++;
        i = coolDown.length() - i;
        int number = Integer.parseInt(coolDown.substring(0,coolDown.length()-i));
        String mode = coolDown.substring(coolDown.length()-i);
        TimeUnit unit = null;
        if(mode.equals("m"))
            unit = TimeUnit.MINUTES;
        if(mode.equals("s"))
            unit = TimeUnit.SECONDS;
        if(mode.equals("ms"))
            unit = TimeUnit.MILLISECONDS;
        if(unit == null)
            throw new IllegalStateException("Bad time scale for delayer");
        return new TimeDelayerData(unit, number);
    }
}
