package main.java.rcas.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class AxleTireModel {
    private String name;
    private long slipAngleCoefficientC;
    private long slipAngleCoefficientB;
    private long slipAngleCoefficientE;
    private long loadCoefficientKA;
    private long loadCoefficientKB;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("slipAngleCoefficientC")
    public long getSlipAngleCoefficientC() { return slipAngleCoefficientC; }
    @JsonProperty("slipAngleCoefficientC")
    public void setSlipAngleCoefficientC(long value) { this.slipAngleCoefficientC = value; }

    @JsonProperty("slipAngleCoefficientB")
    public long getSlipAngleCoefficientB() { return slipAngleCoefficientB; }
    @JsonProperty("slipAngleCoefficientB")
    public void setSlipAngleCoefficientB(long value) { this.slipAngleCoefficientB = value; }

    @JsonProperty("slipAngleCoefficientE")
    public long getSlipAngleCoefficientE() { return slipAngleCoefficientE; }
    @JsonProperty("slipAngleCoefficientE")
    public void setSlipAngleCoefficientE(long value) { this.slipAngleCoefficientE = value; }

    @JsonProperty("loadCoefficientKA")
    public long getLoadCoefficientKA() { return loadCoefficientKA; }
    @JsonProperty("loadCoefficientKA")
    public void setLoadCoefficientKA(long value) { this.loadCoefficientKA = value; }

    @JsonProperty("loadCoefficientKB")
    public long getLoadCoefficientKB() { return loadCoefficientKB; }
    @JsonProperty("loadCoefficientKB")
    public void setLoadCoefficientKB(long value) { this.loadCoefficientKB = value; }
}