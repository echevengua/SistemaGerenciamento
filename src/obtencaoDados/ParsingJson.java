package obtencaoDados;

import objetos.corpoCeleste.CorpoCeleste;
import objetos.corpoCeleste.Mass;
import objetos.corpoCeleste.Vol;
import org.json.JSONArray;
import org.json.JSONObject;
import estruturaDeDados.MeuHashMap.MeuHashMap;

import java.io.IOException;

public class ParsingJson {

    String jsonString;

    {
        try {
            jsonString = HttpClientMain.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void carregaDados(MeuHashMap hashMap){
        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray bodies = jsonObject.getJSONArray("bodies");

        for(int i = 0;i < bodies.length();i++){
            JSONObject body = bodies.getJSONObject(i);

            CorpoCeleste corpoCeleste = new CorpoCeleste();
            Mass massCL = new Mass();
            Vol volCL = new Vol();

            massCL.setMassValue(null);
            massCL.setMassExponent(0);
            volCL.setVolValue(null);
            volCL.setVolExponent(0);

            String id = body.getString("id");
            String name = body.getString("name");
            Boolean isPlanet = body.getBoolean("isPlanet");

            if(!body.isNull("mass")){
                JSONObject mass = body.getJSONObject("mass");

                if(mass.has("massValue")){
                    massCL.setMassValue(mass.getDouble("massValue"));
                    massCL.setMassExponent(mass.getInt("massExponent"));
                }
            }

            if(!body.isNull("vol")){
                JSONObject vol = body.getJSONObject("vol");
                if(vol.has("volValue")){
                    volCL.setVolValue(vol.getDouble("volValue"));
                    volCL.setVolExponent(vol.getInt("volExponent"));
                }
            }

            Double density = body.getDouble("density");
            Double gravity = body.getDouble("gravity");
            Double sideralOrbit = body.getDouble("sideralOrbit");
            Double sideralRotation = body.getDouble("sideralRotation");
            int avgTemp = body.getInt("avgTemp");
            String bodyType = body.getString("bodyType");

            corpoCeleste.setId(id);
            corpoCeleste.setName(name);
            corpoCeleste.setIsPlanet(isPlanet);
            corpoCeleste.setMass(massCL);
            corpoCeleste.setVol(volCL);
            corpoCeleste.setDensity(density);
            corpoCeleste.setGravity(gravity);
            corpoCeleste.setSideralOrbit(sideralOrbit);
            corpoCeleste.setSideralRotation(sideralRotation);
            corpoCeleste.setAvgTemp(avgTemp);
            corpoCeleste.setBodyType(bodyType);

            hashMap.inserir(corpoCeleste);
        }
        System.out.println("DADOS CARREGADOS COM SUCESSO!");
    }
}
