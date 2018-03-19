/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import fr.bsenac.cafein_bot.Command;
import fr.bsenac.cafein_bot.randomWord;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author vixa
 */
class Command_ChooseWord extends Command {

    public Command_ChooseWord() {
        this.name = "chooseword";
        this.desc = "Choisit un mot parmit la liste de mots en entrée. Utilisation: ///chooseword [mot1] [mot2] [mot3 et plus (optionnel)] [\"on peut faire des phrases aussi\"].";
    }

    @Override
    public void execute(String command, String message, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(randomWord.processRandomWord(message)).queue();
    }
}
