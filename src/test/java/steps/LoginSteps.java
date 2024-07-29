package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.config.ConfigProperties;
import org.example.constants.Credentials;
import org.example.driver.DriverFactory;
import org.example.pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    
    @When("Lleno los datos de login")
    public void llenoLosDatosDeLogin() {
       loginPage.fillLogin(Credentials.USERNAME, Credentials.PASSWORD);
    }

    @And("Hago click en el boton Log In")
    public void hagoClickEnElBotonLogIn() {
        loginPage.clickBtnLogIn();
    }

    @Then("Visualizo los datos de mi cuenta")
    public void visualizoLosDatosDeMiCuenta() {
        loginPage.viewTblAccount();
    }

    @When("No lleno los datos de login")
    public void noLlenoLosDatosDeLogin() {
        loginPage.fillLogin("","");
    }

    @When("Lleno el login con datos incorrectos")
    public void llenoElLoginConDatosIncorrectos() {
        String randomPassword = "random_password";
        loginPage.fillLogin(Credentials.USERNAME, randomPassword);
    }
}
