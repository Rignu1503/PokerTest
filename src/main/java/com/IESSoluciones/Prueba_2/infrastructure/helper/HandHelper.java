package com.IESSoluciones.Prueba_2.infrastructure.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class HandHelper {

    public String[] convertArrayToString(int[] array) {

        String[] cardValues = new String[array.length];
        int i = 0;
        for (int value : array) {
            cardValues[i++] = getCardNumber(value);
        }

        // Convertir el array a una lista mutable y luego invertir la lista
        List<String> cardValuesList = new ArrayList<>(Arrays.asList(cardValues));
        Collections.reverse(cardValuesList);

        String[] reversedCardValues = cardValuesList.toArray(new String[0]);

        return reversedCardValues;
    }

    // Obtener valor de las cartas
    public int getCardValue(String card) {
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

    public String getCardNumber(int card) {
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

    // obtener carta mayor
    public int getHighestCardValue(String[] hand) {

        int highestValue = 0;

        for (String card : hand) {
            int cardValue = getCardValue(card);

            if (cardValue > highestValue) {
                highestValue = cardValue;
            }
        }
        return highestValue;
    }

    
    public int[] valueDuplicated(String[] hand) {
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

    public String[] equalCard(String[] hand) {

        int[] valueCount = new int[15];
        String[] arrayValues = new String[2];

        for (String card : hand) {
            int cardValue = getCardValue(card);
            valueCount[cardValue]++;
        }

        int maxCount = 0;
        int card = 0;
        for (int i = 2; i < 15; i++) {
            if (valueCount[i] > maxCount) {
                card = i;
                maxCount = valueCount[i];
            }
        }

        arrayValues[0] = String.valueOf(maxCount);
        arrayValues[1] = getCardNumber(card);

        return arrayValues;
    }



}
