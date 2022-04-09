package org.sm.jk.application.utils;

import java.io.*;

public class PreferenceUtil {

    public static File getPreference() {
        File preferenceFile = new File("../preferences.txt");
        if(!preferenceFile.exists()) {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("../preferences.txt"))) {
                bw.write(".");
                bw.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try(BufferedReader br = new BufferedReader(new FileReader("../preferences.txt"))) {
            return new File(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(".");
    }

    public static void savePreference(File selectedChoggiFile) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("../preferences.txt"))) {
            bw.write(selectedChoggiFile.getParent());
            bw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
