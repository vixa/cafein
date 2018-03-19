/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import java.util.TreeMap;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author vixa
 */
class CategoryList extends TreeMap<String, Category> {

    /**
     * Default constructor, build all commands in the map
     */
    public CategoryList() {
        super();
        this.addCategory(new Category_defaut(), "defaut");
        this.addCategory(new Category_MenuJDR(), "menujdr");
        this.addCategory(new Category_empty(), "help");
        this.addCategory(new Category_MASTER(), "master");
    }

    /**
     * Add a new category
     *
     * @param category the name of the category to add
     * @param name name of the category
     */
    public final void addCategory(Category category, String name) {
        category.setAllCategory();
        this.put(name, category);
    }

    /**
     * Remove a catogory
     *
     * @param category the name of the category do remove
     */
    public void rmCategory(String category) {
        if (this.exist(category)) {
            this.remove(category);
        }
    }

    /**
     * Check the existence of a category in the list
     *
     * @param category the name of category to search
     * @return true if the caterory exist, false else
     */
    public boolean exist(String category) {
        return this.containsKey(category);
    }

    void executeCommand(String command, String message, MessageReceivedEvent event) {
        Human human = Human.getHuman(event.getAuthor().getIdLong());
        if (command.startsWith(Constants.SELECTEUR_SUBCOMMANDE.value()) && command.length() > 1) {
            command = command.substring(1);
            this.get(human.getRoot()).execute(command, message, event);
        } else if (command.equals("help")) {
            this.get("help").generalHelp(event, this);
        } else {
            System.out.println(command);
            if (this.containsKey(command)) {
                if (Category.getCategoryList().get(command).accessAuthorized(human.getAccessLvl())) {
                    event.getTextChannel().sendMessage("Catégorie actuelle: " + human.getRoot()).queue();
                    human.changeRoot(command);
                    event.getTextChannel().sendMessage("Nouvelle catégorie définie: " + human.getRoot()).queue();
                } else {
                    event.getTextChannel().sendMessage("Accès non autorisé à " + command).queue();
                    System.out.println("Tentative d'accès à " + command + ", ejecté");
                }
            } else {
                event.getTextChannel().sendMessage("Aucune catégorie " + command + "…").queue();
            }

        }

    }

    public String showList() {
        StringBuilder list = new StringBuilder();
        for (String category : this.keySet()) {
            if (this.get(category).canBeShowed()) {
                list.append(category + "\n");
            }
        }
        return list.toString();
    }

}
