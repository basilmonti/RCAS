package main.java.rcas.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class RC {
    private String name;
    private double frontTrack;
    private double rearTrack;
    private double wheelbase;
    private double cogHeight;
    private double frontRollDist;
    private double cornerWeightFL;
    private double cornerWeightFR;
    private double cornerWeightRL;
    private double cornerWeightRR;
    private AxleTireModel frontAxleTireModel;
    private AxleTireModel rearAxleTireModel;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("frontTrack")
    public double getFrontTrack() { return frontTrack; }
    @JsonProperty("frontTrack")
    public void setFrontTrack(double value) { this.frontTrack = value; }

    @JsonProperty("rearTrack")
    public double getRearTrack() { return rearTrack; }
    @JsonProperty("rearTrack")
    public void setRearTrack(double value) { this.rearTrack = value; }

    @JsonProperty("wheelbase")
    public double getWheelbase() { return wheelbase; }
    @JsonProperty("wheelbase")
    public void setWheelbase(double value) { this.wheelbase = value; }

    @JsonProperty("cogHeight")
    public double getCogHeight() { return cogHeight; }
    @JsonProperty("cogHeight")
    public void setCogHeight(double value) { this.cogHeight = value; }

    @JsonProperty("frontRollDist")
    public double getFrontRollDist() { return frontRollDist; }
    @JsonProperty("frontRollDist")
    public void setFrontRollDist(double value) { this.frontRollDist = value; }

    @JsonProperty("cornerWeightFL")
    public double getCornerWeightFL() { return cornerWeightFL; }
    @JsonProperty("cornerWeightFL")
    public void setCornerWeightFL(double value) { this.cornerWeightFL = value; }

    @JsonProperty("cornerWeightFR")
    public double getCornerWeightFR() { return cornerWeightFR; }
    @JsonProperty("cornerWeightFR")
    public void setCornerWeightFR(double value) { this.cornerWeightFR = value; }

    @JsonProperty("cornerWeightRL")
    public double getCornerWeightRL() { return cornerWeightRL; }
    @JsonProperty("cornerWeightRL")
    public void setCornerWeightRL(double value) { this.cornerWeightRL = value; }

    @JsonProperty("cornerWeightRR")
    public double getCornerWeightRR() { return cornerWeightRR; }
    @JsonProperty("cornerWeightRR")
    public void setCornerWeightRR(double value) { this.cornerWeightRR = value; }

    @JsonProperty("frontAxleTireModel")
    public AxleTireModel getFrontAxleTireModel() { return frontAxleTireModel; }
    @JsonProperty("frontAxleTireModel")
    public void setFrontAxleTireModel(AxleTireModel value) { this.frontAxleTireModel = value; }

    @JsonProperty("rearAxleTireModel")
    public AxleTireModel getRearAxleTireModel() { return rearAxleTireModel; }
    @JsonProperty("rearAxleTireModel")
    public void setRearAxleTireModel(AxleTireModel value) { this.rearAxleTireModel = value; }

    public RaceCar toRaceCar()
    {
        RaceCar racecar = new RaceCar();

        racecar.setName(this.getName());
        racecar.setFrontTrack(this.getFrontTrack());
        racecar.setRearTrack(this.getRearTrack());
        racecar.setWheelbase(this.getWheelbase());
        racecar.setCogHeight(this.getCogHeight());
        racecar.setFrontRollDist(this.getFrontRollDist());
        racecar.setCornerWeightFL(this.getCornerWeightFL());
        racecar.setCornerWeightFR(this.getCornerWeightFR());
        racecar.setCornerWeightRL(this.getCornerWeightRL());
        racecar.setCornerWeightRR(this.getCornerWeightRR());

        MagicFormulaTireModel frontAxle = new MagicFormulaTireModel(this.getFrontAxleTireModel().getSlipAngleCoefficientC(), this.getFrontAxleTireModel().getSlipAngleCoefficientB(), this.getFrontAxleTireModel().getSlipAngleCoefficientE(), this.getFrontAxleTireModel().getLoadCoefficientKA(), this.getFrontAxleTireModel().getLoadCoefficientKB());
        frontAxle.setName(this.getFrontAxleTireModel().getName());

        MagicFormulaTireModel rearAxle = new MagicFormulaTireModel(this.getRearAxleTireModel().getSlipAngleCoefficientC(), this.getRearAxleTireModel().getSlipAngleCoefficientB(), this.getRearAxleTireModel().getSlipAngleCoefficientE(), this.getRearAxleTireModel().getLoadCoefficientKA(), this.getRearAxleTireModel().getLoadCoefficientKB());
        frontAxle.setName(this.getFrontAxleTireModel().getName());

        racecar.setFrontAxleTireModel(frontAxle);
        racecar.setRearAxleTireModel(rearAxle);
        return racecar;
    }
}