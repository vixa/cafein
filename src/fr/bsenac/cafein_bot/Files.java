/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author vixa
 */
class Files {

    /**
     * List files into a directory
     *
     * @param directoryName the name of the directory
     * @param files the list of files
     */
    public static void listF(String directoryName, ArrayList<File> files) {
        File dir = new File(directoryName);

        File[] fileList = dir.listFiles();
        for (File file : fileList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listF(file.getAbsolutePath(), files);
            }
        }
    }

    /**
     * List only sub-directories of a directory
     *
     * @param directoryName name of the directory
     * @param dirs list of directories
     */
    public static void listDir(String directoryName, ArrayList<File> dirs) throws FileNotFoundException {
        File dir = new File(directoryName);
        File[] fileList = dir.listFiles();
        if (fileList != null) {
            for (File file : fileList) {
                if (file.isDirectory()) {
                    dirs.add(file);
                }
            }
        } else {
            System.out.println("Warning: No images directory");
        }
    }

    /**
     * Choose a random file in the list
     *
     * @param files list of files
     * @return the file choosen, null if the list is empty
     */
    public static File randomFile(ArrayList<File> files) {
        try {
            int value = Roll.random(files.size() - 1);
            return files.get(value);
        } catch (IllegalArgumentException e) {
            System.out.println("ERREUR " + e + " : LISTE VIDE");
        }
        return null;
    }
}
