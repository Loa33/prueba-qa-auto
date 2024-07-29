package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.constants.Credentials;
import org.example.driver.DriverFactory;
import org.example.models.User;
import org.example.pages.RegisterPage;

import java.util.HashMap;
import java.util.Map;

public class RegisterSteps {


    RegisterPage registerPage = new RegisterPage(DriverFactory.getDriver());


    @Given("^Estoy en la pagina de inicio de ParaBank$")
    public void estoyEnLaPaginaDeInicioDeParaBank() {
        registerPage.navigateUrl();
    }

    @And("^Hago click en el link Register$")
    public void hagoClickEnElLinkRegister() {
        registerPage.clickLinkRegister();
    }

    @And("^Lleno el formulario de registro con mis datos$")
    public void llenoElFormularioDeRegistroConMisDatos(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        User user = new User(
                data.get("First Name"),
                data.get("Last Name"),
                data.get("Address"),
                data.get("City"),
                data.get("State"),
                data.get("Zip Code"),
                data.get("Phone #"),
                data.get("SSN"),
                Credentials.USERNAME,
                Credentials.PASSWORD,
                Credentials.PASSWORD
        );
        registerPage.fillFormRegister(user);

    }

    @When("^Hago click en el boton Register$")
    public void hagoClickEnElBotonRegister() {

        registerPage.clickBtnRegister();
    }

    @Then("Visualizo un mensaje que dice {string}")
    public void visualizoUnMensajeQueDice(String mensaje) {
        registerPage.viewSuccessMessage(mensaje);
    }

    @And("Soy redirigido a la pagina de registro")
    public void soyRedirigidoALaPaginaDeRegistro() {
        registerPage.redirectRegisterPage();
    }

    @And("Lleno el formulario de registro con contraseña de confirmación no coincidente")
    public void llenoElFormularioDeRegistroConContraseñaDeConfirmaciónNoCoincidente(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String mismatchPassword = "wrongconfirmpassword";

        User user = new User(
                data.get("First Name"),
                data.get("Last Name"),
                data.get("Address"),
                data.get("City"),
                data.get("State"),
                data.get("Zip Code"),
                data.get("Phone #"),
                data.get("SSN"),
                Credentials.USERNAME,
                Credentials.PASSWORD,
                mismatchPassword
        );
        registerPage.fillFormRegister(user);
    }

    @Then("Visualizo un mensaje de error que dice {string}")
    public void visualizoUnMensajeDeErrorQueDice(String mensaje) {
        registerPage.viewErrorMessage(mensaje);
    }

    @When("Lleno el formulario de registro excepto el campo {string}")
    public void llenoElFormularioDeRegistroExceptoElCampo(String campo, DataTable dataTable) {
        Map<String, String> data = new HashMap<>(dataTable.asMap(String.class, String.class));
        data.put(campo, "");
        User user = new User(
                data.get("First Name"),
                data.get("Last Name"),
                data.get("Address"),
                data.get("City"),
                data.get("State"),
                data.get("Zip Code"),
                data.get("Phone #"),
                data.get("SSN"),
                data.get("Username"),
                data.get("Password"),
                data.get("Password Confirmation")
        );
        registerPage.fillFormRegister(user);


    }
}
