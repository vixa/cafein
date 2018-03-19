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
class Category_MenuJDR extends Category {

    public Category_MenuJDR() {
        this.m_minAccessLevel = 0;
        this.m_command.put("roll", new Command_Roll());
        this.m_command.put("help", new Command_Help());
        this.m_canBeShowed = true;
    }

}
