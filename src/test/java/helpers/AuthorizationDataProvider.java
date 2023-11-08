package helpers;

import org.testng.annotations.DataProvider;

public class AuthorizationDataProvider {
    @DataProvider(name = "AuthorizationValidDataProvider")
    public static Object[][] getValidAuthorizationData() {

        Object[][] validAuthorizationData = {
                {"angular", "password", "Some description"},
                {"angular", "password", "test"}
        };
        return validAuthorizationData;
    }

    @DataProvider(name = "AuthorizationInvalidDataProvider")
    public static Object[][] getInvalidAuthorizationData() {
        Object[][] invalidAuthorizationData= {
            {"Test", "Test", "Test"},
            {"Andrey", "Rublev", "Painter"},
        };
        return invalidAuthorizationData;
    }
}
