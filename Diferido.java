package Ejercicios_Estructura1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Diferido {
    public static void LeerE(String file_name) {
        try {
            BufferedReader reg_e = new BufferedReader(new FileReader("Ejercicios_Estructura1\\" + file_name + ".txt"));
            String line = reg_e.readLine();
            while (line != null) {
                String data[] = line.split(",");
                System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + data[3]);
                line = reg_e.readLine();
            }

            reg_e.close();
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
                System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + data[4]);
                line = reg_c.readLine();
            }

            reg_c.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void update() {

        try {
            float erase_e = 0;
            float new_e = 0;
            float npromc = 0;
            float promc = 0;
            BufferedReader reg_e = new BufferedReader(new FileReader("Ejercicios_Estructura1\\EstudAntes.txt"));
            BufferedReader reg_c = new BufferedReader(new FileReader("Ejercicios_Estructura1\\Cambios.txt"));

            File Temp = new File("Ejercicios_Estructura1\\temp_file.txt"); // crear archivo
            PrintWriter reg_temp = new PrintWriter(new FileWriter(Temp));
            String line_e = reg_e.readLine();
            String line_c = reg_c.readLine();

            while (line_e != null && line_c != null) {

                String datae[] = line_e.split(",");
                String datac[] = line_c.split(",");
                int codee = Integer.parseInt(datae[0]);
                int codec = Integer.parseInt(datac[0]);
                int Tipo = Integer.parseInt(datac[1]);
                if (codee == codec) {
                    if (Tipo == 1) { // Eliminar
                        erase_e++;
                    } else if (Tipo == 3) { // Cambiar promedio
                        npromc++;
                        promc += Float.parseFloat(datac[4]);
                        reg_temp.println(datac[0] + "," + datac[2] + "," + datac[3] + "," + datac[4]);
                    }
                    line_e = reg_e.readLine();
                    line_c = reg_c.readLine();
                } else {
                    if (codee < codec) { // copiar estudiante. Avanzar en EstudAntess
                        reg_temp.println(datae[0] + "," + datae[1] + "," + datae[2] + "," + datae[3]);
                        line_e = reg_e.readLine();
                    } else { // codee>codec si tipo 2 añadir. Avanzar en cambios
                        if (Tipo == 2) {
                            new_e++;
                            reg_temp.println(datac[0] + "," + datac[2] + "," + datac[3] + "," + datac[4]);
                        }
                        line_c = reg_c.readLine();
                    }
                }
            }
            
            while (line_e != null) { // si quedan estudAntes copiar
                reg_temp.println(line_e);
                line_e = reg_e.readLine();
            }
            while(line_c!=null){ // si quedan cambios añadir
                new_e++;
                String datac[] = line_c.split(",");
                if(Integer.parseInt(datac[1])==2){
                    reg_temp.println(datac[0] + "," + datac[2] + "," + datac[3] + "," + datac[4]);
                }
                line_c = reg_c.readLine();
            }
            reg_temp.close();
            reg_e.close();
            reg_c.close();
            System.out.println("nuevos " + new_e + " Eliminados " + erase_e);
            System.out.println("promc es " + promc + " npromc es " + npromc);
            System.out.println("Media promedios cambiados " + ((float) (promc / npromc)));
            System.out.println("Tasa Nuevos/Borrados " + ((float) (new_e / erase_e)));
            //Borrar viejo, renombrar temp
            File original = new File("Ejercicios_Estructura1\\EstudAntes.txt");
            original.delete();
            File nuevo = new File("Ejercicios_Estructura1\\temp_file.txt");
            nuevo.renameTo(new File("Ejercicios_Estructura1\\EstudAntes.txt"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        LeerE("EstudAntes");
        System.out.println();
        LeerC("Cambios");
        System.out.println();
        update();
    
    }
}
