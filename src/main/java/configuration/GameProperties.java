package configuration;

import board.Board;
import board.BoardFactory;
import rule.Rule;
import rule.RuleFactory;
import timedelayer.TimeDelayer;
import timedelayer.TimeDelayerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    private String steps = "";
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
            if(param.startsWith("-steps="))
                steps = param.replace("-steps=","");
        }
    }

    public void loadParams() {
        load(configPath);
        setProperty("INITIAL_STATE",getProperty("INITIAL_STATE").replaceAll("\\|", ""));
        if(!initialState.isEmpty())
            setProperty("INITIAL_STATE", initialState);
        if(!timeBetweenTicks.isEmpty())
            setProperty("TIME_BETWEEN_TICKS", timeBetweenTicks);
        if(!boardType.isEmpty())
            setProperty("BOARD_TYPE", boardType);
        if(!rules.isEmpty())
            setProperty("RULES", rules);
        if(!steps.isEmpty())
            setProperty("SIMULATION_STEPS", steps);
    }

    public void load(String path) {
        if(loaded)
            return;
        loaded = true;
        try {
            instance.load(new FileInputStream(path));
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
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
        int i = coolDown.length();
        do
            i--;
        while(!Character.isDigit(coolDown.charAt(i)));
        i++;
        i = coolDown.length() - i;
        int number = Integer.parseInt(coolDown.substring(0,coolDown.length()-i));
        String mode = coolDown.substring(coolDown.length()-i);
        return TimeDelayerFactory.makeTimeDelayer(mode, number);
    }

    public int getSteps() {
        return Integer.parseInt(getProperty("SIMULATION_STEPS"));
    }
}
