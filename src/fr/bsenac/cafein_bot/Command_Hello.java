/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import fr.bsenac.cafein_bot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author vixa
 */
class Command_Hello extends Command {

    public Command_Hello() {
        this.name = "hello";
        this.desc = "Envoie une salutation";
    }

    @Override
    public void execute(String command, String message, MessageReceivedEvent event) {
        String name = event.getAuthor().getName();
        String response = "Hello, **" + name + "**";
        event.getTextChannel().sendMessage(response).queue();
    }
}
