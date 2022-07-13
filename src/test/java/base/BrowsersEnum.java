package base;

public enum BrowsersEnum {
    CHROME("chrome"), FIREFOX("firefox"), EDGE("edge");

    private String browserName;
    BrowsersEnum(String browserName) {
        this.browserName = browserName;
    }

    String getName() {
        return browserName;
    }

}
