package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GameConfiguration extends Properties {
    private static final GameConfiguration instance = new GameConfiguration();

    boolean loaded = false;

    //config
    public void loadConfiguratinon() {
        ArgumentLoader p = ArgumentLoader.getInstance();
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

    public static GameConfiguration getInstance() {
        return instance;
    }


}
