package Ejercicios_Estructura1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javafx.scene.paint.Stop;

public class Diferido {
    public static void LeerE(String file_name) {
        try {
            BufferedReader reg_c = new BufferedReader(new FileReader("Ejercicios_Estructura1\\" + file_name + ".txt"));
            String line = reg_c.readLine();
            while (line != null) {
                String data[] = line.split(",");
                System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + data[3]);
                line = reg_c.readLine();
            }

            reg_c.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void LeerC(String file_name) {
        try {
            BufferedReader reg_c = new BufferedReader(new FileReader("Ejercicios_Estructura1\\" + file_name + ".txt"));
            String line = reg_c.readLine();
            while (line != null) {
                String data[] = line.split(",");
                System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + data[3]+" "+data[4]);
                line = reg_c.readLine();
            }

            reg_c.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void update(Scanner sc){

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LeerE("EstudAntes");
        System.out.println();
        LeerC("Cambios");
        System.out.println();
        update(sc);
    }
}
