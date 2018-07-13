package rcas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {
    private RC[] rc;

    @JsonProperty("rc")
    public RC[] getRC() { return rc; }
    @JsonProperty("rc")
    public void setRC(RC[] value) { this.rc = value; }
}