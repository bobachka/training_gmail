package by.helmes.gmail.core.driver;

public enum DriverFactory {
    CHROME {
        @Override
        public DriverManager getDriverManager() {
            return new ChromeDriverManager();
        }
    },
    FIREFOX {
        @Override
        public DriverManager getDriverManager() {
            return new FirefoxDriverManager();
        }
    },
    SERVER {
        @Override
        public DriverManager getDriverManager() {
            return new RemoteDriverManager();
        }
    };

    public abstract DriverManager getDriverManager();
}
