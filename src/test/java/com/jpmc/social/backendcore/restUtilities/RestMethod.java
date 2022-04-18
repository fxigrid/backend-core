package com.jpmc.social.backendcore.restUtilities;

import java.util.Arrays;

public enum RestMethod {

    GET("GET"), POST("POST"), PATCH("PATCH"), PUT("PUT"), DELETE("DELETE");

    public final String methodName;

    RestMethod(String variable) {
        this.methodName = variable;
    }

     public static RestMethod getMethodName(String passedMethodeName) throws IllegalArgumentException {
        return Arrays.stream(RestMethod.values())
                .filter(value -> value.methodName.equalsIgnoreCase(passedMethodeName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + passedMethodeName));
    }
}
