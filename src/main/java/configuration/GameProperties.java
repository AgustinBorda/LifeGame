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
    private static final GameProperties instance = new GameProperties();

    boolean loaded = false;

    //config
    public void loadParams() {
        Parser p = Parser.getInstance();
        load(p.getConfigPath());
        setProperty("INITIAL_STATE",getProperty("INITIAL_STATE").replaceAll("\\|", ""));
        if(!p.getInitialState().isEmpty())
            setProperty("INITIAL_STATE", p.getInitialState());
        if(!p.getTimeBetweenTicks().isEmpty())
            setProperty("TIME_BETWEEN_TICKS", p.getTimeBetweenTicks());
        if(!p.getBoardType().isEmpty())
            setProperty("BOARD_TYPE", p.getBoardType());
        if(!p.getRules().isEmpty())
            setProperty("RULES", p.getRules());
        if(!p.getSteps().isEmpty())
            setProperty("SIMULATION_STEPS", p.getSteps());
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

    public String getInitialState() {
        return getProperty("INITIAL_STATE");
    }

    public String getBoardType() {
        return getProperty("BOARD_TYPE");
    }

    public String getTimeBetweenTicks() {
        return getProperty("TIME_BETWEEN_TICKS");
    }

    public String getRules() {
        return getProperty("RULES");
    }

    public int getSteps() {
        return Integer.parseInt(getProperty("SIMULATION_STEPS"));
    }


}
