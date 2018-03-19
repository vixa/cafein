/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import java.io.File;
import java.util.ArrayList;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author vixa
 */
class Command_image extends Command {

    public Command_image(String commandName) {
        this.name = commandName;
        this.desc = "Envoie une image aléatoire de " + commandName;
    }

    @Override
    public void execute(String command, String message, MessageReceivedEvent event) {
        ArrayList<File> files = new ArrayList<>();
        Files.listF(Constants.IMAGE_DIRECTORY_PATH + File.separator + this.name, files);
        File img = Files.randomFile(files);
        if (img != null) {
            event.getTextChannel().sendMessage("Une magnifique image de " + this.name + ", demandée par " + event.getAuthor().getName()).queue();
            event.getTextChannel().sendFile(img).queue();
        } else {
            event.getTextChannel().sendMessage(Constants.ERROR_MESSAGE.value()).queue();
        }
    }

}
