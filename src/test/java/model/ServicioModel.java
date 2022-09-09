package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ServicioModel {

    public String Body;
    public int Exp;
    public String Escenario;

    public static ServicioModel servicioProyectoModel(Map<String, String> entry){

        ServicioModel inOutData = new ServicioModel();
        inOutData.setBody(entry.get("body"));
        inOutData.setExp(Integer.parseInt(entry.get("exp")));
        inOutData.setEscenario(entry.get("escenario"));

        return inOutData;
    }

}
