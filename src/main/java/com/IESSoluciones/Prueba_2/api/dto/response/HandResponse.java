package com.IESSoluciones.Prueba_2.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HandResponse {

    private String winnerHand;
    private String winnerHandType;
    private List<String> compositionWinnerHand;

}
