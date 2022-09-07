package model;

import com.proyecto.pacifico.config.Settings;
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
public class ServicioModel {

    public int Exp;
    public String Escenario;

    public static ServicioModel servicioProyectoModel(Map<String, String> entry) throws Exception {

        ServicioModel inOutData = new ServicioModel();
        inOutData.setExp(Integer.parseInt(entry.get("exp")));
        inOutData.setEscenario(entry.get("escenario"));

        return inOutData;
    }

}
