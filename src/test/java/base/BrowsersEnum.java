package base;

public enum BrowsersEnum {
    CHROME("chrome"), FIREFOX("firefox"), EDGE("edge"),CHROMEHEADLESS("chromeheadless"),EDGEHEADLESS("edgeheadless"),FIREFOXHEADLESS("firefoxheadless");

    private String browserName;
    BrowsersEnum(String browserName) {
        this.browserName = browserName;
    }

    String getName() {
        return browserName;
    }

}
