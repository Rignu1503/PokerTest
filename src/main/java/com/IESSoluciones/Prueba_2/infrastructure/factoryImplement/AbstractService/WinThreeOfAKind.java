package com.IESSoluciones.Prueba_2.infrastructure.factoryImplement.AbstractService;

import com.IESSoluciones.Prueba_2.api.dto.request.HandRequest;
import com.IESSoluciones.Prueba_2.api.dto.response.HandResponse;

public interface WinThreeOfAKind {
    
    HandResponse validatedWinThreeOfAKind(HandRequest request);
}
