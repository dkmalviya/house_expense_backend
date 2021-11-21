package com.appkode.house.model.response.generic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericResponse {
    private int responseCode;
    private String status;
    private String message;


}
