package helpers;

import org.testng.annotations.DataProvider;

public class AuthorizationDataProvider {
    @DataProvider(name = "AuthorizationDataProvider")
    public static Object[][] getAuthorizationData() {

        Object[][] authorizationData = {
                {"Test", "Test", "Test", false},
                {"Andrey", "Rublev", "Painter", false},
                {"angular", "password", "Some description", true},
                {"angular", "password", "test", true}
        };
        return authorizationData;
    }
}
