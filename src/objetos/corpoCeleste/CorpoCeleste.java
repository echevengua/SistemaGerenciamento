package objetos.corpoCeleste;

public class CorpoCeleste {
    private String id;
    private String name;
    private Boolean isPlanet;
    private Mass mass;
    private Vol vol;
    private Double density;
    private Double gravity;
    private Double sideralOrbit;
    private Double sideralRotation;
    private int avgTemp;
    private String bodyType;

    public CorpoCeleste(){
        this.mass = new Mass();
        this.vol = new Vol();
    }

    public String getId(){
        return id;
    }

    public String getBodyType(){
        return this.bodyType;
    }

    public Double getDensity(){
        return this.density;
    }

    public Double getGravity(){
        return this.gravity;
    }

    public Double getSideralOrbit(){
        return this.sideralOrbit;
    }

    public Double getSideralRotation(){
        return this.sideralRotation;
    }

    public int getAvgTemp(){
        return this.avgTemp;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setIsPlanet(Boolean isPlanet){
        this.isPlanet = isPlanet;
    }

    public void setMass(Mass mass){
        this.mass = mass;
    }

    public void setMassValue(Double massValue){
        this.mass.setMassValue(massValue);
    }

    public void setMassExponent(int massExponent){
        this.mass.setMassExponent(massExponent);
    }

    public void setVol(Vol vol){
        this.vol = vol;
    }

    public void setVolValue(Double volValue){
        this.vol.setVolValue(volValue);
    }

    public void setVolExponent(int volExponent){
        this.vol.setVolExponent(volExponent);
    }

    public void setDensity(Double density){
        this.density = density;
    }

    public void setGravity(Double gravity){
        this.gravity = gravity;
    }

    public void setSideralOrbit(Double sideralOrbit){
        this.sideralOrbit = sideralOrbit;
    }

    public void setSideralRotation(Double sideralRotation){
        this.sideralRotation = sideralRotation;
    }

    public void setAvgTemp(int avgTemp){
        this.avgTemp = avgTemp;
    }

    public void setBodyType(String bodyType){
        this.bodyType = bodyType;
    }

    public void imprimirDados(){
        System.out.print("=====================================\n");
        System.out.printf("|id: %s\n", this.id);
        System.out.printf("|name: %s\n", this.name);
        System.out.printf("|isPlanet: %s\n", this.isPlanet ? "true" : "false");
        System.out.printf("|massValue: %s\n", this.mass.getMassValue() == null ? "NAO INFORMADO" : this.mass.getMassValue());
        System.out.printf("|massExponent: %s\n", this.mass.getMassValue() == null ? "NAO INFORMADO" : this.mass.getMassExponent());
        System.out.printf("|volValue: %s\n", this.vol.getVolValue() == null ? "NAO INFORMADO" : this.vol.getVolValue());
        System.out.printf("|volExponent: %s\n", this.vol.getVolValue() == null ? "NAO INFORMADO" : this.vol.getVolExponent());
        System.out.printf("|density: %f\n", this.density);
        System.out.printf("|gravity: %f\n", this.gravity);
        System.out.printf("|sideralOrbit: %f\n", this.sideralOrbit);
        System.out.printf("|sideralRotation: %f\n", this.sideralRotation);
        System.out.printf("|avgTemp: %d\n", this.avgTemp);
        System.out.printf("|bodyType: %s\n\n", this.bodyType);
    }



}
