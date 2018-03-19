/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author vixa
 */
class Category_defaut extends Category {

    Category_defaut() throws FileNotFoundException {
        this.m_minAccessLevel = 0;
        this.m_command = new TreeMap<>();
        this.m_command.put("hello", new Command_Hello());
        this.m_command.put("chooseword", new Command_ChooseWord());
        this.m_command.put("help", new Command_Help());
        this.constructImagesSenders();
        this.m_canBeShowed = true;
    }

    private void constructImagesSenders() throws FileNotFoundException {
        ArrayList<File> dirs = new ArrayList<>();
        Files.listDir(Constants.IMAGE_DIRECTORY_PATH.value(), dirs);

        for (File dir : dirs) {
            final String name = dir.getName();
            this.m_command.put(name, new Command_image(name));
        }
    }
}
