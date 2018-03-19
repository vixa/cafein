/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import java.io.FileNotFoundException;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Game;

/**
 *
 * @author vixa
 */
class Initialisation {
    static void ini(JDA discord) throws FileNotFoundException{
        Category.iniCategoryList();
        Human.iniHumanList();
        discord.addEventListener(new MessageSender());
        discord.getPresence().setGame(net.dv8tion.jda.core.entities.Game.of(Game.GameType.LISTENING, "les gens. //help pour plus d'infos", null));
        Human.humansList.put(Long.decode(Constants.ID_MASTER.value()), new Human(Long.decode(Constants.ID_MASTER.value()), 10));
    }
}
