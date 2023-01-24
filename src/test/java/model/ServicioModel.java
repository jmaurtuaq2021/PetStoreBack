package model;

import com.proyecto.petstore.config.Settings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Map;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ServicioModel {

    public  JSONObject Body;
    public int Exp;
    public String Escenario;
    public String id;
    public String status;
    public String message;
    public String code;

    public static ServicioModel servicioProyectoModel(Map<String, String> entry) throws Exception {

        ServicioModel inOutData = new ServicioModel();
        inOutData.setExp(Integer.parseInt(entry.get("exp")));
        inOutData.setEscenario(entry.get("escenario"));
        inOutData.setId(entry.get("id"));
        inOutData.setCode((entry.get("code")));
        inOutData.setStatus(entry.get("status"));
      inOutData.setMessage(entry.get("message")== null ? "" : entry.get("message"));

      if (entry.get("body") !=null){
        String localPath= System.getProperty("user.dir") + "/" + Settings.PathConfig + "json/";
        JSONObject ob =(JSONObject) new JSONParser().parse(new FileReader(localPath + entry.get("body")));
        inOutData.setBody(ob);

      }
        return inOutData;
    }

}
