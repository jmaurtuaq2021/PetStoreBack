package steps;


import com.proyecto.petstore.config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class TestInitialize {

    @Before
    public void Initialize(Scenario scenario) throws IOException {
        ConfigReader.PopulateSettings();
    }

    @After
    public void TearDown(Scenario scenario) {
    }
}
