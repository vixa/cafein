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
class Command_Roll extends Command {

    public Command_Roll() {
        this.name = "roll";
        this.desc = "Roll the dice. Utilisation: roll [valeurMax] [nbDés]";
    }

    @Override
    public void execute(String command, String message, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(Roll.process(message)).queue();
    }

}
