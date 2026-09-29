package objetos.corpoCeleste;

public class Mass {
    private Double massValue;
    private int massExponent;

    public void setMassValue(Double massValue){
        this.massValue = massValue;
    }

    public Double getMassValue(){
        return this.massValue;
    }

    public void setMassExponent(int massExponent){
        this.massExponent = massExponent;
    }

    public int getMassExponent(){
        return this.massExponent;
    }
}
