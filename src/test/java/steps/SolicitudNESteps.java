package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import model.ServicioModel;
import org.testng.asserts.SoftAssert;
import services.CommonServicesUtil;
import services.ResponseProyectoNEServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolicitudNESteps {

    @DataTableType
    public ServicioModel convertServiceModel(Map<String, String> entry) throws Exception {
        return ServicioModel.servicioProyectoModel(entry);
    }

    @Then("Validar servicio NE producto POST crear usuario")
    public void validarServicioNEProductoPOSTCrearUsuario(List<ServicioModel> table) {

        SoftAssert sa = new SoftAssert();
        ArrayList<String> listResults = new ArrayList<>();

        for (ServicioModel serviceMod : table) {

            System.out.println("===========================================");
            System.out.println("======== (POST) - Crear usuario ===========");
            System.out.println("===========================================");
            Response response = ResponseProyectoNEServices.postUser();
            String strMessageError = CommonServicesUtil.responseMessage(response, serviceMod.getExp());
            sa.assertEquals(response.getStatusCode(), serviceMod.getExp(), "Escenario [" + serviceMod.getEscenario() + "] Message [" + strMessageError + "]");

            if (response.getStatusCode() == 200) {

            }

            listResults.add("[" + serviceMod.getExp() + "][" + serviceMod.getEscenario() + "]");
        }

        System.out.println("================================================");
        System.out.println("================== Resume test =================");
        System.out.println("================================================");

        for (String result : listResults) {
            System.out.println(result);
        }
        sa.assertAll();
    }

}
