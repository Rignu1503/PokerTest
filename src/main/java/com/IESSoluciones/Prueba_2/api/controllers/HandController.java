package com.IESSoluciones.Prueba_2.api.controllers;

import com.IESSoluciones.Prueba_2.api.dto.request.HandRequest;
import com.IESSoluciones.Prueba_2.api.dto.response.HandResponse;
import com.IESSoluciones.Prueba_2.infrastructure.factory.interfaces.IhandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("poker")
public class HandController {

    @Autowired
    private IhandFactory handFactory;

    @PostMapping("/validation")
    public HandResponse compareHands(@RequestBody HandRequest request) {
        return handFactory.ValidatedHand(request);
    }
}
