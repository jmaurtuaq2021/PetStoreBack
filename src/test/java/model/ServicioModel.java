package model;

import com.soat.pacifico.config.Settings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Map;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ServicioSolicitudModel {

    public int Exp;
    public String Escenario;
    public JSONObject Body;

    public static ServicioSolicitudModel servicioSoatSolicitudModel(Map<String, String> entry) throws Exception {

        ServicioSolicitudModel inOutData = new ServicioSolicitudModel();
        inOutData.setExp(Integer.parseInt(entry.get("exp")));
        inOutData.setEscenario(entry.get("escenario"));
        if (entry.get("body") != null) {
            String localPath = System.getProperty("user.dir") + "/" + Settings.PathConfig + "json/";
            JSONObject ob = (JSONObject) new JSONParser().parse(new FileReader(localPath + entry.get("body")));
            inOutData.setBody(ob);
        }

        return inOutData;
    }

}
