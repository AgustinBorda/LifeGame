package configuration;

public class Parser {
    private String configPath = "";

    private String initialState = "";

    private String timeBetweenTicks = "";

    private String boardType = "";

    private String rules = "";
    private static final Parser instance = new Parser();

    private String steps = "";

    public static Parser getInstance() {
        return instance;
    }

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
