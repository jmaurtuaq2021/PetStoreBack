package services;

import com.soat.pacifico.config.Settings;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class ResponseSoatNESolicitudServices {

    public static String baseApiUri = Settings.UrlSoatApiBase;
    public static String baseUriServices = Settings.UrlSoatApiNESolicitudPath;
    public static String aSubscriptionKey = Settings.SubscriptionKeySoatApiNE;

    public static Response postSolicitud() {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(baseApiUri, baseUriServices, 0);
        requestSpecification.header("ocp-apim-subscription-key", aSubscriptionKey);
        return new RestAssuredConfiguration().getResponsePost(requestSpecification, EndPointSoat.POST_SOLICITUD);
    }

    public static Response getSolicitud(String globalIdSolicitud) {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(baseApiUri, baseUriServices, 0);
        requestSpecification.header("ocp-apim-subscription-key", aSubscriptionKey);
        requestSpecification.pathParam("parameterId", globalIdSolicitud);
        return new RestAssuredConfiguration().getResponseGet(requestSpecification, EndPointSoat.GET_SOLICITUD);
    }

    public static Response getSolicitudes() {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(baseApiUri, baseUriServices, 0);
        requestSpecification.header("ocp-apim-subscription-key", aSubscriptionKey);
        return new RestAssuredConfiguration().getResponseGet(requestSpecification, EndPointSoat.GET_SOLICITUDES);
    }

    public static Response patchSolicitud(String globalIdSolicitud, JSONObject strBody) {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(baseApiUri, baseUriServices, 0);
        requestSpecification.pathParam("parameterId", globalIdSolicitud);
        requestSpecification.header("ocp-apim-subscription-key", aSubscriptionKey);
        return new RestAssuredConfiguration().getResponsePatch(requestSpecification.body(strBody), EndPointSoat.PATCH_SOLICITUD);
    }
}
