package com.IESSoluciones.Prueba_2.infrastructure.service;

import com.IESSoluciones.Prueba_2.api.dto.request.HandRequest;
import com.IESSoluciones.Prueba_2.api.dto.response.HandResponse;
import com.IESSoluciones.Prueba_2.infrastructure.helper.HandHelper;
import com.IESSoluciones.Prueba_2.infrastructure.service.AbstractService.IHandSerivce;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
@AllArgsConstructor
public class HandService implements IHandSerivce {

    private final HandHelper handHelper;

    @Override
    public HandResponse validatedHighCard(HandRequest request) {

        String hand1 = request.getHand1();
        String hand2 = request.getHand2();

        String[] ArrayHand1 = hand1.split(" ");
        String[] ArrayHand2 = hand2.split(" ");

        int highestValueHand1 = this.handHelper.getHighestCardValue(ArrayHand1);
        int highestValueHand2 = this.handHelper.getHighestCardValue(ArrayHand2);

        HandResponse response = new HandResponse();

        String winnerHand;
        if (highestValueHand1 > highestValueHand2) {
            winnerHand = "hand1";
            response.setCompositionWinnerHand(Arrays.asList(this.handHelper.getCardNumber(highestValueHand1)));

        } else if (highestValueHand1 < highestValueHand2) {
            winnerHand = "hand2";
            response.setCompositionWinnerHand(Arrays.asList(this.handHelper.getCardNumber(highestValueHand2)));

        } else {
            winnerHand = "tie";
        }

        response.setWinnerHand(winnerHand);
        response.setWinnerHandType("HighCard");

        return response;
    }


    @Override
    public HandResponse validatedPair(HandRequest request) {
        String hand1 = request.getHand1();
        String hand2 = request.getHand2();

        String[] arrayHand1 = hand1.split(" ");
        String[] arrayHand2 = hand2.split(" ");

        int[] valueHand1 = this.handHelper.valueDuplicated(arrayHand1);
        int[] valueHand2 = this.handHelper.valueDuplicated(arrayHand2);

        int winnerHand1 = valueHand1.length;
        int winnerHand2 = valueHand2.length;

        HandResponse response = new HandResponse();
        String winnerHand;

         if (winnerHand1 == 1) {
            winnerHand = "hand1";
            response.setCompositionWinnerHand(Arrays.asList(this.handHelper.convertArrayToString(valueHand1)));
            response.setWinnerHand(winnerHand);
            response.setWinnerHandType("OnePair");

        } else if (winnerHand2 == 1) {
            winnerHand = "hand2";
            response.setCompositionWinnerHand(Arrays.asList(this.handHelper.convertArrayToString(valueHand2)));
            response.setWinnerHand(winnerHand);
            response.setWinnerHandType("TwoPair");
        }else {
             return null;
         }


        return response;
    }


    @Override
    public HandResponse validatedTwoPair(HandRequest request) {

        String hand1 = request.getHand1();
        String hand2 = request.getHand2();

        String[] arrayHand1 = hand1.split(" ");
        String[] arrayHand2 = hand2.split(" ");

        int[] valueHand1 = this.handHelper.valueDuplicated(arrayHand1);
        int[] valueHand2 = this.handHelper.valueDuplicated(arrayHand2);

        int winnerHand1 = valueHand1.length;
        int winnerHand2 = valueHand2.length;


        HandResponse response = new HandResponse();
        String winnerHand;

        if (winnerHand1 == 2) {
            winnerHand = "hand1";
            response.setCompositionWinnerHand(Arrays.asList(this.handHelper.convertArrayToString(valueHand1)));
            response.setWinnerHand(winnerHand);
            response.setWinnerHandType("TwoPair");

        } else if (winnerHand2 == 2) {
            winnerHand = "hand2";
            response.setCompositionWinnerHand(Arrays.asList(arrayHand2));
            response.setWinnerHand(winnerHand);
            response.setWinnerHandType("TwoPair");

        }else {
            return null;

        }

        return response;
    }

    @Override
    public HandResponse validatedWinThreeOfAKind(HandRequest request) {

        System.out.println("hola");

        String hand1 = request.getHand1();
        String hand2 = request.getHand2();

        String[] arrayHand1 = hand1.split(" ");
        String[] arrayHand2 = hand2.split(" ");

        String[] valueHand1 = this.handHelper.equalCard(arrayHand1);
        String[] valueHand2 = this.handHelper.equalCard(arrayHand2);

        HandResponse response = new HandResponse();
        String winnerHand;

        if (valueHand1[0].equals("3")) {
            winnerHand = "hand1";
            response.setCompositionWinnerHand(Arrays.asList(valueHand1[1]));
            response.setWinnerHand(winnerHand);
            //response.setWinnerHandType("ThreeOfA" + valueHand1[1]);
            response.setWinnerHandType("ThreeOfAKind");

        } else if (valueHand2[0].equals("3")) {
            winnerHand = "hand2";
            response.setCompositionWinnerHand(Arrays.asList(valueHand2[1]));
            response.setWinnerHand(winnerHand);
            //response.setWinnerHandType("ThreeOfA" + valueHand2[1]);
            response.setWinnerHandType("ThreeOfAKind");

        }else {
            return null;
        }

        return response;
    }


    @Override
    public HandResponse validatedPoker(HandRequest request) {

        String hand1 = request.getHand1();
        String hand2 = request.getHand2();

        String[] arrayHand1 = hand1.split(" ");
        String[] arrayHand2 = hand2.split(" ");

        String[] valueHand1 = this.handHelper.equalCard(arrayHand1);
        String[] valueHand2 = this.handHelper.equalCard(arrayHand2);


        HandResponse response = new HandResponse();
        String winnerHand;

        if (valueHand1[0].equals("4")) {
            winnerHand = "hand1";
            response.setCompositionWinnerHand(Arrays.asList(valueHand1[1]));
            response.setWinnerHand(winnerHand);
            //response.setWinnerHandType("FourOfA" + valueHand1[1]);
            response.setWinnerHandType("FourOfAKind");

        } else if (valueHand2[0].equals("4")) {
            winnerHand = "hand2";
            response.setCompositionWinnerHand(Arrays.asList(valueHand2[2]));
            response.setWinnerHand(winnerHand);
            //response.setWinnerHandType("FourOfA" + valueHand2[1]);
            response.setWinnerHandType("FourOfAKind");

        }else {
            return null;
        }

        return response;
    }



}
