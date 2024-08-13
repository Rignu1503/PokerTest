package com.IESSoluciones.Prueba_2.infrastructure.service;

import com.IESSoluciones.Prueba_2.api.dto.request.HandRequest;
import com.IESSoluciones.Prueba_2.api.dto.response.HandResponse;
import com.IESSoluciones.Prueba_2.infrastructure.service.AbstractService.IhandSerivce;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class HandService implements IhandSerivce {


    @Override
    public HandResponse validatedHighCard(HandRequest request) {

        String hand1 = request.getHand1();
        String hand2 = request.getHand2();

        String[] ArrayHand1 = hand1.split(" ");
        String[] ArrayHand2 = hand2.split(" ");

        int highestValueHand1 = getHighestCardValue(ArrayHand1);
        int highestValueHand2 = getHighestCardValue(ArrayHand2);

        HandResponse response = new HandResponse();

        String winnerHand;
        if (highestValueHand1 > highestValueHand2) {
            winnerHand = "hand1";
            response.setCompositionWinnerHand(Arrays.asList(getCardNumber(highestValueHand1)));

        } else if (highestValueHand1 < highestValueHand2) {
            winnerHand = "hand2";
            response.setCompositionWinnerHand(Arrays.asList(getCardNumber(highestValueHand2)));

        } else {
            winnerHand = "tie";
        }

        response.setWinnerHand(winnerHand);
        response.setWinnerHandType("HighCard");

        return response;
    }

    private String getCardNumber(int card) {
        int cardValue = card;
        switch (cardValue) {
            case 14:
                return "As";
            case 13:
                return "King";
            case 12:
                return "Queen";
            case 11:
                return "Jack";
            default:
                return String.valueOf(cardValue);
        }
    }



    //obtener carta mayor
    private int getHighestCardValue(String[] hand) {

        int highestValue = 0;

        for (String card : hand) {
            int cardValue = getCardValue(card);

            if (cardValue > highestValue) {
                highestValue = cardValue;
            }
        }
        return highestValue;
    }

    //Obtener valor de las cartas
    private int getCardValue(String card) {
        char rank = card.charAt(0);
        switch (rank) {
            case 'A':
                return 14;
            case 'K':
                return 13;
            case 'Q':
                return 12;
            case 'J':
                return 11;
            default:
                return Character.getNumericValue(rank);
        }
    }

    @Override
    public HandResponse validatedPair(HandRequest request) {
        String hand1 = request.getHand1();
        String hand2 = request.getHand2();

        String[] arrayHand1 = hand1.split(" ");
        String[] arrayHand2 = hand2.split(" ");

        int[] valueHand1 = valueDuplicated(arrayHand1);
        int[] valueHand2 = valueDuplicated(arrayHand2);

        int winnerHand1 = valueHand1.length;
        int winnerHand2 = valueHand2.length;

        System.out.println(winnerHand1);
        System.out.println(winnerHand2);

        HandResponse response = new HandResponse();
        String winnerHand;

         if (winnerHand1 == 1) {
            winnerHand = "hand1";
            response.setCompositionWinnerHand(Arrays.asList(arrayHand1));
            response.setWinnerHand(winnerHand);
            response.setWinnerHandType("OnePair");

        } else if (winnerHand2 == 1) {
            winnerHand = "hand2";
            response.setCompositionWinnerHand(Arrays.asList(arrayHand1));
            response.setWinnerHand(winnerHand);
            response.setWinnerHandType("TwoPair");
        }else {
             return null;
         }


        return response;
    }

    private int[] valueDuplicated(String[] hand) {
        // Almacenar valores vistos
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (String card : hand) {
            int cardValue = getCardValue(card);

            // Verificar si el valor ya ha sido visto
            if (seen.contains(cardValue)) {
                duplicates.add(cardValue);
            } else {

                seen.add(cardValue);
            }
        }

        int[] result = new int[duplicates.size()];
        int i = 0;
        for (int value : duplicates) {
            result[i++] = value;
        }
        return result;
    }



}
