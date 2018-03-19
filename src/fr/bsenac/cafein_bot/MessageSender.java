/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Class to send messages
 *
 * @author vixaa
 */
class MessageSender extends ListenerAdapter {

    /**
     * On reception of a message
     *
     * @param event
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        Human.processCommander(event.getAuthor());

        if (message.startsWith(Constants.SELECTEUR_COMMANDE.value())) {
            Human human = Human.getHuman(event.getAuthor().getIdLong());
            human.executeCommand(message, event);
        }
    }

    /**
     * Permet d'extraire une commande du message
     *
     * @param message le message reçu
     * @return la commande
     */
    static String extractCommand(String message) {
        final int TAILLE_SELECTEUR_COMMANDE = Constants.SELECTEUR_COMMANDE.value().length();
        int posSpace = message.indexOf(' ');
        if (posSpace != -1) {
            return message.substring(TAILLE_SELECTEUR_COMMANDE, posSpace);
        } else {
            return message.substring(TAILLE_SELECTEUR_COMMANDE);
        }
    }
}
