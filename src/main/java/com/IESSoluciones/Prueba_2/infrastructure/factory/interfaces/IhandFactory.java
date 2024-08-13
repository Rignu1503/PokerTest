package com.IESSoluciones.Prueba_2.infrastructure.factory.interfaces;

import com.IESSoluciones.Prueba_2.api.dto.request.HandRequest;
import com.IESSoluciones.Prueba_2.api.dto.response.HandResponse;

public interface IhandFactory {

    HandResponse ValidatedHand(HandRequest request);
}
