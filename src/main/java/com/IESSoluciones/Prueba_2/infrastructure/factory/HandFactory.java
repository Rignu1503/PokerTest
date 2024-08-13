package com.IESSoluciones.Prueba_2.infrastructure.factory;

import com.IESSoluciones.Prueba_2.api.dto.request.HandRequest;
import com.IESSoluciones.Prueba_2.api.dto.response.HandResponse;
import com.IESSoluciones.Prueba_2.infrastructure.factory.interfaces.IhandFactory;
import com.IESSoluciones.Prueba_2.infrastructure.service.AbstractService.IhandSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HandFactory implements IhandFactory {

    private final IhandSerivce handService;

    @Autowired
    public HandFactory(IhandSerivce handService) {
        this.handService = handService;
    }

    @Override
    public HandResponse ValidatedHand(HandRequest request) {


        return handService.validatedHighCard(request);
    }
}
