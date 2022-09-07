package services;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class CommonServicesUtil {

    public static String responseMessage(Response response, int statusExpected) {

        String strMessageError = "Error don't expected";

        if (response.getStatusCode() != statusExpected) {

            if (response.getStatusCode() != 200) {
                if (response.contentType().equals("text/html") || response.contentType().equals("")) {
                    strMessageError = response.htmlPath().get().toString();
                } else {
                    String respMsg = response.path("message") != null ? response.path("message").toString() : response.asString();
                    strMessageError = response.getStatusCode() != statusExpected ? respMsg : null;
                }
            }
        }


        return strMessageError;
    }

    public static String getBody(String pBody) {
        JSONObject jsonParams = new JSONObject(pBody);
        return jsonParams.toString();
    }

    public static String getBodyList(String body) {
        JSONArray jsonParams = new JSONArray(body);
        return jsonParams.toString();
    }

}
