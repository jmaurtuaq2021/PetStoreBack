package services;

import com.proyecto.pacifico.config.Settings;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseProyectoNEServices {

    public static String baseApiUri = Settings.UrlApiBase;
    public static String baseUriServices = Settings.UrlApiNEPath;
    public static String aSubscriptionKey = Settings.SubscriptionKeyApiNE;

    public static Response postUser() {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(baseApiUri, baseUriServices, 0);
        return new RestAssuredConfiguration().getResponsePost(requestSpecification, EndPointProyecto.POST_NOMBRE);
    }
}
