/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author vixa
 */
class CommandADMIN_quit extends Command {

    public CommandADMIN_quit() {
        this.name = "quit";
        this.desc = "Éteind le bot";
    }

    @Override
    public void execute(String command, String message, MessageReceivedEvent event) {
        System.out.println("ARRÊT DEMANDÉ PAR L'ADMINISTRATEUR " + event.getAuthor().getName());
        event.getJDA().shutdown();
    }
}
