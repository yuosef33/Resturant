package com.project.resturant.Dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class BundleMessage {

    @JsonProperty("message_en")
    private String en_message;

    @JsonProperty("message_ar")
    private String ar_message;

    public BundleMessage(String en_message) {
        this.en_message = en_message;
    }

    public BundleMessage(String en_message, String ar_message) {
        this.en_message = en_message;
        this.ar_message = ar_message;
    }
}
