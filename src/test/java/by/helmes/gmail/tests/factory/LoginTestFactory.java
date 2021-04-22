package by.helmes.gmail.tests.factory;

import org.testng.annotations.Factory;

public class LoginTestFactory {
    @Factory
    public Object[] factoryMethod() {
        return new Object[]{
                new LoginTestForFactory("chrome"), new LoginTestForFactory("firefox")
        };
    }
}
