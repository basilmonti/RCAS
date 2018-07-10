package main.java.rcas.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Member {
    private RC[] rc;

    @JsonProperty("rc")
    public RC[] getRC() { return rc; }
    @JsonProperty("rc")
    public void setRC(RC[] value) { this.rc = value; }
}