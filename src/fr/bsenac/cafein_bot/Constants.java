package fr.bsenac.cafein_bot;

import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vixaa
 */
enum Constants {
    SELECTEUR_COMMANDE("//"),
    SELECTEUR_SUBCOMMANDE("/"),
    RESSOURCES_DIRECTORY_PATH("rsc"),
    IMAGE_DIRECTORY_PATH(RESSOURCES_DIRECTORY_PATH + File.separator + "imgs"),
    ERROR_MESSAGE("Désolé, mais quelque-chose ne c'est pas passé comme prévu. Mais ne t'en fais pas! Si tu tiens mon créateur, @Vixaa__ au courant, tout rentrera dans l'ordre après correction du bug!"),
    /**
     * ID of the master of the bot
     */
    ID_MASTER("203199799888052224");

    private final String value;

    private Constants(String value) {
        this.value = value;
    }
    
    String value(){
        return value;
    }

}
