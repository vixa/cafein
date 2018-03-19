/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author vixa
 */
abstract class Category {

    protected TreeMap<String, Command> m_command;
    protected boolean m_canBeShowed;
    protected int m_minAccessLevel;
    
    private static CategoryList categoryList;

    public Category() {
        this.m_command = new TreeMap<>();
        this.m_canBeShowed = false;
        this.m_minAccessLevel = 0;
    }

    /**
     * Divide the line in tab without spaces
     *
     * @param message the command line
     * @return the tab of command divided
     */
    static ArrayList<String> divCommand(String message) {
        int pos = -1, taille = message.length();
        ArrayList<String> command = new ArrayList<>();
        while (pos + 1 < taille) {
            int posTemp = message.indexOf(' ', pos + 1);
            if (posTemp == -1) {
                posTemp = taille;
            }
            command.add(message.substring(pos + 1, posTemp));
            pos = posTemp;
        }
        return command;
    }

    public void execute(String command, String message, MessageReceivedEvent event) {
        if (accessAuthorized(Human.getHuman(event.getAuthor().getIdLong()).getAccessLvl()) && m_command.containsKey(command)) {
            System.out.println(event.getAuthor() + " executed command: " + message);
            m_command.get(command).execute(command, message, event);
        } else {
            defaultMessage(event);
        }
    }
    
    protected static void iniCategoryList() throws FileNotFoundException{
        categoryList = new CategoryList();
    }

    boolean canBeShowed() {
        return this.m_canBeShowed;
    }

    void setAllCategory() {
        for (String com : this.m_command.keySet()) {
            this.m_command.get(com).setCategory(this);
        }
    }

    void generalHelp(MessageReceivedEvent event, CategoryList list) {
        String message = "**Infos générales**\n\n"
                + "Ce bot a été créé par Vixa, un random des internets, pour s'amuser.\n"
                + "\n**Comment utiliser le bot?**\n\n"
                + Constants.SELECTEUR_COMMANDE + " pour changer de catégorie\n"
                + Constants.SELECTEUR_COMMANDE + Constants.SELECTEUR_SUBCOMMANDE + " pour exécuter une commande dans une catégorie!\n"
                + "Chaque catégorie dispose de son propre menu d'aides, ses propre commandes… à vous de les découvrir!\n"
                + "\n**Liste des catégories:**\n\n"
                + list.showList();
        event.getTextChannel().sendMessage(message).queue();
    }

    void defaultMessage(MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("Commande inconnue. Essaye ///help").queue();
    }
    
    public static CategoryList getCategoryList(){
        return categoryList;
    }
    
    /**
     * Authorize the access with a lvl
     * @param lvl the user lvl
     * @return true if the user can access to the category, false else
     */
    public boolean accessAuthorized(int lvl){
        return this.m_minAccessLevel <= lvl;
    }
}
