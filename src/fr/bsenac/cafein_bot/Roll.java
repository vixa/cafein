/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import java.util.ArrayList;
import java.util.Random;
import static net.vixa.StringToInt.StringToInt.StringToInt;

/**
 * Roll the dice(s)
 *
 * @author vixaa
 */
class Roll {

    static String process(String message) {
        final String rollMessage = "Roll the dice! ";
        ArrayList<String> command = Category.divCommand(message);
        if (synthaxCheck(command)) {
            String resultat;
            if (command.size() == 2) {
                resultat = roll(StringToInt(command.get(1).substring(1)));
            } else {
                resultat = roll(StringToInt(command.get(2).substring(1)), StringToInt(command.get(1)));
            }
            return rollMessage + "`" + resultat + "`";
        }
        return "Erreur - utilisation: ///roll [nbDés - optionnel] -d[valeur]";
    }

    /**
     * Check if the synthax is ok
     *
     * @param message the command line
     * @return true if the synthax is ok, false else
     */
    static boolean synthaxCheck(ArrayList<String> message) {
        int taille = message.size();
        if (taille > 1) {
            if (message.get(1).startsWith("-d")) {
                return message.get(1).length() >= 3 && taille == 2;
            } else {
                return message.get(2).length() >= 3 && taille == 3;
            }
        }
        return false;
    }


    /**
     * Roll multiple dices
     *
     * @param nbTirages number of roll to make
     * @return String with value of all tirages
     */
    static String roll(int maxValue, int nbTirages) {
        StringBuilder values = new StringBuilder(roll(maxValue));
        for (int i = 1; i < nbTirages; i++) {
            values.insert(values.length(), "; " + roll(maxValue));
        }
        return values.toString();
    }

    /**
     * Roll a single dice
     *
     * @param maxValue max value of the dice
     * @return String with value of the tirage
     */
    static String roll(int maxValue) {
        return "" + random(maxValue);
    }

    public static int random(int maxValue) {
        int value = new Random().nextInt(maxValue);
        value++;
        return value;
    }
}
