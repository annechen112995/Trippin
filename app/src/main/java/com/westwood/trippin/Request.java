package com.westwood.trippin;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Westwood on 3/4/17.
 */

public class Request {
    @SerializedName("name")
    String name;

    @SerializedName("location")
    String location;

    public Request(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Request(String location) {
        this.location = location;
    }
}
