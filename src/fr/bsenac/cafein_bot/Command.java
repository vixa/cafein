/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import fr.bsenac.cafein_bot.Category;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author vixa
 */
abstract class Command {

    protected String name;
    protected String desc;
    protected Category category; //Reference to the category of the command

    public Command() {
        this.name = "defaut";
        this.desc = "defaut";
    }

    abstract public void execute(String command, String message, MessageReceivedEvent event);

    public void setCategory(Category cat) {
        this.category = cat;
    }

}
