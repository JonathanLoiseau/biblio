package com.it.jloiseau.backendbibliorestapi.model.enumaration;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Post {
    @JsonProperty("employee")
    EMPLOYEE,
    @JsonProperty("customer")
    CUSTOMER
}
