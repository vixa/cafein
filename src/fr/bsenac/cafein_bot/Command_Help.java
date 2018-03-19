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
class Command_Help extends Command {

    public Command_Help() {
        this.name = "help";
        this.desc = "Affiche l'aide de la catégorie";
    }

    @Override
    public void execute(String commandReceived, String message, MessageReceivedEvent event) {
        String helpText = "";
        for (String command : this.category.m_command.keySet()){
            helpText += command + ": " + this.category.m_command.get(command).desc + "\n";
        }
        event.getTextChannel().sendMessage(helpText).queue();
    }

}
