/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

/**
 *
 * @author vixaa
 */
public class Connection {

    public static void main(String[] args) {
        if (args.length == 1) {
            final String TOKEN = args[0];
            JDA discord = null;
            try {
                discord = new JDABuilder(AccountType.BOT).setToken(TOKEN).buildBlocking();
                Initialisation.ini(discord);
            } catch (LoginException | IllegalArgumentException | InterruptedException ex) {
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("Nombre d'arguments invalides");
            throw new IllegalArgumentException();
        }
    }
}
