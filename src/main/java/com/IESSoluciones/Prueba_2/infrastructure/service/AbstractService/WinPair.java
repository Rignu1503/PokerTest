package com.IESSoluciones.Prueba_2.infrastructure.service.AbstractService;

import com.IESSoluciones.Prueba_2.api.dto.request.HandRequest;
import com.IESSoluciones.Prueba_2.api.dto.response.HandResponse;

public interface WinPair {
    
    HandResponse validatedPair(HandRequest request);
}
