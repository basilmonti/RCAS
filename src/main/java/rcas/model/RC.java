package main.java.rcas.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class RC {
    private String name;
    private long frontTrack;
    private long rearTrack;
    private long wheelbase;
    private long cogHeight;
    private long frontRollDist;
    private long cornerWeightFL;
    private long cornerWeightFR;
    private long cornerWeightRL;
    private long cornerWeightRR;
    private AxleTireModel frontAxleTireModel;
    private AxleTireModel rearAxleTireModel;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("frontTrack")
    public long getFrontTrack() { return frontTrack; }
    @JsonProperty("frontTrack")
    public void setFrontTrack(long value) { this.frontTrack = value; }

    @JsonProperty("rearTrack")
    public long getRearTrack() { return rearTrack; }
    @JsonProperty("rearTrack")
    public void setRearTrack(long value) { this.rearTrack = value; }

    @JsonProperty("wheelbase")
    public long getWheelbase() { return wheelbase; }
    @JsonProperty("wheelbase")
    public void setWheelbase(long value) { this.wheelbase = value; }

    @JsonProperty("cogHeight")
    public long getCogHeight() { return cogHeight; }
    @JsonProperty("cogHeight")
    public void setCogHeight(long value) { this.cogHeight = value; }

    @JsonProperty("frontRollDist")
    public long getFrontRollDist() { return frontRollDist; }
    @JsonProperty("frontRollDist")
    public void setFrontRollDist(long value) { this.frontRollDist = value; }

    @JsonProperty("cornerWeightFL")
    public long getCornerWeightFL() { return cornerWeightFL; }
    @JsonProperty("cornerWeightFL")
    public void setCornerWeightFL(long value) { this.cornerWeightFL = value; }

    @JsonProperty("cornerWeightFR")
    public long getCornerWeightFR() { return cornerWeightFR; }
    @JsonProperty("cornerWeightFR")
    public void setCornerWeightFR(long value) { this.cornerWeightFR = value; }

    @JsonProperty("cornerWeightRL")
    public long getCornerWeightRL() { return cornerWeightRL; }
    @JsonProperty("cornerWeightRL")
    public void setCornerWeightRL(long value) { this.cornerWeightRL = value; }

    @JsonProperty("cornerWeightRR")
    public long getCornerWeightRR() { return cornerWeightRR; }
    @JsonProperty("cornerWeightRR")
    public void setCornerWeightRR(long value) { this.cornerWeightRR = value; }

    @JsonProperty("frontAxleTireModel")
    public AxleTireModel getFrontAxleTireModel() { return frontAxleTireModel; }
    @JsonProperty("frontAxleTireModel")
    public void setFrontAxleTireModel(AxleTireModel value) { this.frontAxleTireModel = value; }

    @JsonProperty("rearAxleTireModel")
    public AxleTireModel getRearAxleTireModel() { return rearAxleTireModel; }
    @JsonProperty("rearAxleTireModel")
    public void setRearAxleTireModel(AxleTireModel value) { this.rearAxleTireModel = value; }
}