package obtencaoDados;

import objetos.corpoCeleste.CorpoCeleste;
import objetos.corpoCeleste.Mass;
import objetos.corpoCeleste.Vol;
import org.json.JSONArray;
import org.json.JSONObject;
import estruturaDeDados.MeuHashMap.MeuHashMap;

import java.io.IOException;

public class ParsingJson {

    public void parsingCorpoCeleste(MeuHashMap hashMap,String jsonString){
        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray bodies = jsonObject.getJSONArray("bodies");

        for(int i = 0;i < bodies.length();i++){
            JSONObject body = bodies.getJSONObject(i);

            CorpoCeleste corpoCeleste = new CorpoCeleste();

            corpoCeleste.setMassValue(null);
            corpoCeleste.setMassExponent(0);
            corpoCeleste.setVolValue(null);
            corpoCeleste.setVolExponent(0);

            corpoCeleste.setId(body.getString("id"));
            corpoCeleste.setName(body.getString("name"));
            corpoCeleste.setIsPlanet(body.getBoolean("isPlanet"));

            if(!body.isNull("mass")){
                JSONObject mass = body.getJSONObject("mass");

                if(mass.has("massValue")){
                    corpoCeleste.setMassValue(mass.getDouble("massValue"));
                    corpoCeleste.setMassExponent(mass.getInt("massExponent"));
                }
            }

            if(!body.isNull("vol")){
                JSONObject vol = body.getJSONObject("vol");

                if(vol.has("volValue")){
                    corpoCeleste.setVolValue(vol.getDouble("volValue"));
                    corpoCeleste.setVolExponent(vol.getInt("volExponent"));
                }
            }

            corpoCeleste.setDensity(body.getDouble("density"));
            corpoCeleste.setGravity(body.getDouble("gravity"));
            corpoCeleste.setSideralOrbit(body.getDouble("sideralOrbit"));
            corpoCeleste.setSideralRotation(body.getDouble("sideralRotation"));
            corpoCeleste.setAvgTemp(body.getInt("avgTemp"));
            corpoCeleste.setBodyType(body.getString("bodyType"));

            hashMap.inserir(corpoCeleste);
        }
    }

    public void parsingKnowCount(){

    }
}
