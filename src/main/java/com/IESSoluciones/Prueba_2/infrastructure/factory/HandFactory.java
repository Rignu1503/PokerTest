package com.IESSoluciones.Prueba_2.infrastructure.factory;

import com.IESSoluciones.Prueba_2.api.dto.request.HandRequest;
import com.IESSoluciones.Prueba_2.api.dto.response.HandResponse;
import com.IESSoluciones.Prueba_2.infrastructure.factory.interfaces.IhandFactory;
import com.IESSoluciones.Prueba_2.infrastructure.service.AbstractService.IhandSerivce;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HandFactory implements IhandFactory {

    private final IhandSerivce handService;


    @Override
    public HandResponse ValidatedHand(HandRequest request) {

        HandResponse pairResponse = handService.validatedPair(request);

        
        if (pairResponse != null) {
            return pairResponse;
        }


        return handService.validatedHighCard(request);
    }
}
