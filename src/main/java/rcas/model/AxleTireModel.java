package main.java.rcas.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class AxleTireModel {
    private String name;
    private double slipAngleCoefficientC;
    private double slipAngleCoefficientB;
    private double slipAngleCoefficientE;
    private double loadCoefficientKA;
    private double loadCoefficientKB;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("slipAngleCoefficientC")
    public double getSlipAngleCoefficientC() { return slipAngleCoefficientC; }
    @JsonProperty("slipAngleCoefficientC")
    public void setSlipAngleCoefficientC(double value) { this.slipAngleCoefficientC = value; }

    @JsonProperty("slipAngleCoefficientB")
    public double getSlipAngleCoefficientB() { return slipAngleCoefficientB; }
    @JsonProperty("slipAngleCoefficientB")
    public void setSlipAngleCoefficientB(double value) { this.slipAngleCoefficientB = value; }

    @JsonProperty("slipAngleCoefficientE")
    public double getSlipAngleCoefficientE() { return slipAngleCoefficientE; }
    @JsonProperty("slipAngleCoefficientE")
    public void setSlipAngleCoefficientE(double value) { this.slipAngleCoefficientE = value; }

    @JsonProperty("loadCoefficientKA")
    public double getLoadCoefficientKA() { return loadCoefficientKA; }
    @JsonProperty("loadCoefficientKA")
    public void setLoadCoefficientKA(double value) { this.loadCoefficientKA = value; }

    @JsonProperty("loadCoefficientKB")
    public double getLoadCoefficientKB() { return loadCoefficientKB; }
    @JsonProperty("loadCoefficientKB")
    public void setLoadCoefficientKB(double value) { this.loadCoefficientKB = value; }
}