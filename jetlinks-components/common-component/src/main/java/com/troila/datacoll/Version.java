package com.troila.datacoll;

import lombok.Getter;

@Getter
public class Version {
    public static Version current = new Version();

    private final String edition = "community";

    private final String version = "1.8.0";

}