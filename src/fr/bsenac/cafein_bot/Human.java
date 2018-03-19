/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import java.util.HashMap;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * A object who can store a discord user and his command list
 *
 * @author vixa
 */
class Human {

    private final long id;
    private int right;
    private String cat_root;

    static HashMap<Long, Human> humansList; //The general human list

    Human(long id) {
        this.id = id;
        this.cat_root = "defaut";
        this.right = 0;
    }
    
    Human(long id, int accessRight) {
        this.id = id;
        this.cat_root = "defaut";
        this.right = accessRight;
    }

    /**
     * Initialize the general human list
     */
    static void iniHumanList() {
        humansList = new HashMap<>();
    }

    /**
     * Add a human in the general humanList if he doesn't exit
     *
     * @param humansList the general humanList
     */
    void addHuman() {
        if (!humansList.containsValue(this)) {
            humansList.put(this.id, this);
        }
    }

    /**
     * Remove a human from the general humanList if he exist
     *
     * @param humansList the general humanList
     */
    void removeHuman() {
        if (humansList.containsValue(this)) {
            humansList.remove(this);
        }
    }

    /**
     * Get a human from an id
     *
     * @param id of the human
     * @return the human
     */
    static Human getHuman(long id) {
        return humansList.get(id);
    }

    /**
     * Execute a command for a user
     *
     * @param message the line received
     * @param event the event
     */
    void executeCommand(String message, MessageReceivedEvent event) {
        Category.getCategoryList().executeCommand(MessageSender.extractCommand(message), message, event);
    }

    /**
     * Do operation of registration and creationon human who have execute a
     * command
     *
     * @param id
     */
    static void processCommander(User user) {
        if (!humansList.containsKey(user.getIdLong())) {
            Human human = new Human(user.getIdLong());
            human.addHuman();
        }
    }

    /**
     * Get a copy of the root
     *
     * @return the name of the root
     */
    public String getRoot() {
        String root = new String(cat_root);
        return root;
    }

    /**
     * Change the root of subcommands
     *
     * @param category the name of the category who will be the root
     */
    public void changeRoot(String category) {
        if (Category.getCategoryList().exist(category)) {
            if (Category.getCategoryList().get(category).accessAuthorized(right)) {
                this.cat_root = category;
            }
        }
    }
    
    public int getAccessLvl(){
        return right;
    }
    
    public void setACcessLvl(int lvl){
        right = lvl;
    }
}
