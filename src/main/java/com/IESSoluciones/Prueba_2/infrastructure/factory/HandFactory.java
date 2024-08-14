package com.IESSoluciones.Prueba_2.infrastructure.factory;

import com.IESSoluciones.Prueba_2.api.dto.request.HandRequest;
import com.IESSoluciones.Prueba_2.api.dto.response.HandResponse;
import com.IESSoluciones.Prueba_2.infrastructure.factory.interfaces.IHandFactory;
import com.IESSoluciones.Prueba_2.infrastructure.service.AbstractService.IHandSerivce;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HandFactory implements IHandFactory {

    private final IHandSerivce handService;

    @Override
    public HandResponse ValidatedHand(HandRequest request) {
        
        if(this.handService.validatedPoker(request) != null){
            return this.handService.validatedPoker(request);

        } else if (this.handService.validatedWinThreeOfAKind(request) != null){
            return handService.validatedWinThreeOfAKind(request);

         } else if (this.handService.validatedTwoPair(request) != null){
            return this.handService.validatedTwoPair(request);
            
         }  else if (this.handService.validatedPair(request) != null) {
            return this.handService.validatedPair(request);
        }

        return this.handService.validatedHighCard(request);
    }
}
