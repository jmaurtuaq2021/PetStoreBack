package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import model.ServicioModel;
import org.testng.asserts.SoftAssert;
import services.CommonServicesUtil;
import services.ResponsePetStore;

import java.util.ArrayList;
import java.util.List;

public class StepObtenerMascota {







  @Then("buscar mascota con id inexistente validar campos del response del error")
  public void buscarMascotaConIdInexistenteValidarCamposDelResponseDelError(List<ServicioModel> table) {

    SoftAssert sa = new SoftAssert();
    ArrayList<String> listResults = new ArrayList<>();
    for (ServicioModel serviceMod : table) {

      System.out.println("======================================================");
      System.out.println("========- Consultar Mascota Registrada ===========");
      System.out.println("======================================================");
      Response response = ResponsePetStore.getMascota(serviceMod.getId());
      String strMessageError = CommonServicesUtil.responseMessage(response, serviceMod.getExp());
      sa.assertEquals(response.getStatusCode(), serviceMod.getExp(), "Escenario [" + serviceMod.getEscenario() + "] Message [" + strMessageError + "]");

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
