package configuration;

public class ArgumentLoader {
    private String configPath = "";

    private String initialState = "";

    private String timeBetweenTicks = "";

    private String boardType = "";

    private String rules = "";
    private static final ArgumentLoader instance = new ArgumentLoader();

    private String steps = "";

    public static ArgumentLoader getInstance() {
        return instance;
    }

    public void loadArgs(String[] params) {
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

    protected String getConfigPath() {
        return configPath;
    }

    protected String getInitialState() {
        return initialState;
    }

    protected String getTimeBetweenTicks() {
        return timeBetweenTicks;
    }

    protected String getBoardType() {
        return boardType;
    }

    protected String getRules() {
        return rules;
    }

    protected String getSteps() {
        return steps;
    }
}
