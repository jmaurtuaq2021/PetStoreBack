package services;

import com.proyecto.petstore.config.Settings;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
public class ResponsePetStore {

  public static String baseApiUri = Settings.UrlApiBase;
  public static String baseUriServices = Settings.UrlApiNEPath;

  public static Response postMascota( JSONObject strBody) {
   RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(baseApiUri, baseUriServices, 0);
    requestSpecification.header("Content-Type", "application/json");
    return new RestAssuredConfiguration().getResponsePost(requestSpecification.body(strBody), EndPointProyecto.POST_MASCOTA);
  }

  public static Response getMascota(String id) {

    RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(baseApiUri, baseUriServices, 0);
    requestSpecification.pathParam("id", id);
    return new RestAssuredConfiguration().getResponseGet(requestSpecification, EndPointProyecto.GET_MASCOTA);

  }

  public static Response puttMascota( JSONObject strBody) {
    RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(baseApiUri, baseUriServices, 0);
    requestSpecification.header("Content-Type", "application/json");
    return new RestAssuredConfiguration().getResponsePut(requestSpecification.body(strBody), EndPointProyecto.POST_MASCOTA);
  }
}
