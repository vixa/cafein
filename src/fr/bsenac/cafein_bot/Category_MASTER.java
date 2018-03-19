/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

/**
 *
 * @author vixa
 */
class Category_MASTER extends Category {

    public Category_MASTER() {
        this.m_minAccessLevel = 10;
        this.m_command.put("help", new Command_Help());
        this.m_command.put("quit", new CommandADMIN_quit());
        this.m_canBeShowed = false;
    }
}
