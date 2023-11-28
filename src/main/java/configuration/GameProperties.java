package configuration;

import board.Board;
import board.BoardFactory;
import rule.Rule;
import rule.RuleFactory;
import timedelayer.TimeDelayer;
import timedelayer.TimeDelayerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameProperties extends Properties {
    private String configPath = "";

    private String initialState = "";

    private String timeBetweenTicks = "";

    private String boardType = "";

    private String rules = "";
    private static final GameProperties instance = new GameProperties();

    boolean loaded = false;
    public void parseParams(String[] params) {
        for(String param : params) {
            if(param.startsWith("-config="))
                configPath = param.replace("-config=","");
            if(param.startsWith("-initial_state="))
                initialState = param.replace("-initial_state=","");
            if(param.startsWith("-time="))
                timeBetweenTicks = param.replace("-time=","");
            if(param.startsWith("-board="))
                boardType = param.replace("-board=","");
            if(param.startsWith("-rules="))
                rules = param.replace("-rules=","");
        }
    }

    public void loadParams() {
        GameProperties p = GameProperties.getInstance();
        p.load(configPath);
        if(!initialState.isEmpty())
            p.setProperty("INITIAL_STATE", initialState);
        if(!timeBetweenTicks.isEmpty())
            p.setProperty("TIME_BETWEEN_TICKS", initialState);
        if(!boardType.isEmpty())
            p.setProperty("BOARD_TYPE", initialState);
        if(!rules.isEmpty())
            p.setProperty("RULES", initialState);
    }

    public void load(String path) {
        if(loaded)
            return;
        loaded = true;
        instance.load(path);
    }

    public static GameProperties getInstance() {
        return instance;
    }

    public Board getBoard() {
        return BoardFactory.makeBoard(getProperty("BOARD_TYPE"), getProperty("INITIAL_STATE"));
    }

    public List<Rule> getRules() {
        List<Rule> result = new ArrayList<>();
        boolean birth;
        String[] rules = getProperty("RULES").split("/");
        Pattern pattern = Pattern.compile("[1-9]");
        for (String rule : rules) {
            Matcher matcher = pattern.matcher(rule);
            birth = rule.charAt(0) == 'B';
            while (matcher.find()) {
                if (birth)
                    result.add(RuleFactory.createBirthRule(Integer.parseInt(matcher.group())));
                else
                    result.add(RuleFactory.createSurviveRule(Integer.parseInt(matcher.group())));
            }
        }
        return result;
    }

    public TimeDelayer getDelayer() {
        String coolDown = getProperty("TIME_BETWEEN_TICKS");
        int number = Integer.parseInt(coolDown.substring(0,coolDown.length()-1));
        String mode = String.valueOf(coolDown.charAt(coolDown.length()-1));
        return TimeDelayerFactory.makeTimeDelayer(mode, number);
    }
}
