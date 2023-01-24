package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import model.ServicioModel;
import org.testng.asserts.SoftAssert;
import services.CommonServicesUtil;
import services.ResponsePetStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StepRegistrarMascota {

  String globalIdSolicitud = "id";
    @DataTableType
    public ServicioModel convertServiceModel(Map<String, String> entry) throws Exception{
        return ServicioModel.servicioProyectoModel(entry);
    }


  @Then("Validar el servicio del registro de una mascota")
  public void validarElServicioDelRegistroDeUnaMascota(List<ServicioModel> table) {
    SoftAssert sa = new SoftAssert();
    ArrayList<String> listResults = new ArrayList<>();

    for (ServicioModel serviceMod : table) {

      System.out.println("===========================================");
      System.out.println("======== (POST) - Registrar Mascota ===========");
      System.out.println("===========================================");
      Response response = ResponsePetStore.postMascota(serviceMod.getBody());
      String strMessageError = CommonServicesUtil.responseMessage(response, serviceMod.getExp());
      sa.assertEquals(response.getStatusCode(), serviceMod.getExp(), "Escenario [" + serviceMod.getEscenario() + "] Message [" + strMessageError + "]");
      if (response.getStatusCode() == 200) {
        Object strId = response.path("id");
        sa.assertFalse(strId == null, "Valor id es nulo");
        sa.assertFalse(strId.toString().isEmpty(), "Valor id esta vacio");
        globalIdSolicitud = strId.toString();
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
  @Then("Obtener mascota de la tienda por medio de su id")
  public void obtenerMascotaDeLaTiendaPorMedioDeSuId(List<ServicioModel> table) {
    SoftAssert sa = new SoftAssert();
    ArrayList<String> listResults = new ArrayList<>();
    for (ServicioModel serviceMod : table) {

      System.out.println("======================================================");
      System.out.println("========- Consultar Mascota Registrada ===========");
      System.out.println("======================================================");
      Response response = ResponsePetStore.getMascota(globalIdSolicitud);
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

  @Then("Verifico los mandatorios del request del servicio")
  public void verificoLosMandatoriosDelRequestDelServicio(List<ServicioModel> table) {

    SoftAssert sa = new SoftAssert();
    ArrayList<String> listResults = new ArrayList<>();
    for (ServicioModel serviceMod : table) {

      System.out.println("======================================================");
      System.out.println("======== Registro de Mascota ===========");
      System.out.println("======================================================");
      Response response = ResponsePetStore.postMascota(serviceMod.getBody());
      String strMessageError = CommonServicesUtil.responseMessage(response, serviceMod.getExp());
      sa.assertEquals(response.getStatusCode(), serviceMod.getExp(), "Escenario [" + serviceMod.getEscenario() + "] Message [" + strMessageError + "]");
      sa.assertEquals(response.getBody().jsonPath().get("status"), serviceMod.getStatus(), "ERROR: NO COINCIDE EL CAMPO STATUS ");
      if (response.getStatusCode() == 200) {
        Object strId = response.path("id");
        sa.assertFalse(strId == null, "Valor id es nulo");
        sa.assertFalse(strId.toString().isEmpty(), "Valor id esta vacio");
        globalIdSolicitud = strId.toString();
      }
      listResults.add("[" + serviceMod.getStatus() + "][" + serviceMod.getExp() + "]" );

      System.out.println("================================================");
      System.out.println("================== Resume test =================");
      System.out.println("================================================");

      for (String result : listResults) {
        System.out.println(result);
      }
      sa.assertAll();
    }
  }

  @Given("Validar el servicio de actualización de una mascota")
  public void validarElServicioDeActualizaciónDeUnaMascota(List<ServicioModel> table) {
    SoftAssert sa = new SoftAssert();
    ArrayList<String> listResults = new ArrayList<>();
    for (ServicioModel serviceMod : table) {

      System.out.println("======================================================");
      System.out.println("========- Actualizar Mascota Registrada ===========");
      System.out.println("======================================================");
      Response response = ResponsePetStore.puttMascota(serviceMod.getBody());
      String strMessageError = CommonServicesUtil.responseMessage(response, serviceMod.getExp());
      sa.assertEquals(response.getStatusCode(), serviceMod.getExp(), "Escenario [" + serviceMod.getEscenario() + "] Message [" + strMessageError + "]");
      if (response.getStatusCode() == 200) {
        Object strId = response.path("id");
        sa.assertFalse(strId == null, "Valor id es nulo");
        sa.assertFalse(strId.toString().isEmpty(), "Valor id esta vacio");
        globalIdSolicitud = strId.toString();
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


  @Then("Obtener mascota actualizada de la tienda por medio de su id")
  public void obtenerMascotaActualizadaDeLaTiendaPorMedioDeSuId(List<ServicioModel> table) {
    SoftAssert sa = new SoftAssert();
    ArrayList<String> listResults = new ArrayList<>();
    for (ServicioModel serviceMod : table) {

      System.out.println("======================================================");
      System.out.println("========- Consultar Mascota Actualizada ===========");
      System.out.println("======================================================");
      Response response = ResponsePetStore.getMascota(globalIdSolicitud);
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

