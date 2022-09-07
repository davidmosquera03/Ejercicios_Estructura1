package Ejercicios_Estructura1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Horses {

    public static void LeerC(String file_name) {
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

    public static void LeerG(String file_name) {
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

    public static void speed() {

        try {
            BufferedReader reg_g = new BufferedReader(new FileReader("Ejercicios_Estructura1\\Ganan.txt"));
            String lineg = reg_g.readLine();
            BufferedReader reg_c = new BufferedReader(new FileReader("Ejercicios_Estructura1\\Caballos.txt"));
            String linec = reg_c.readLine();

            float totV = 0;
            float totC = 0;
            float min_v = Float.POSITIVE_INFINITY;
            String min_horse = "";
            while(linec!=null){
                float v_carrera = 0;

                String datac[] = linec.split(",");
                String datag[] = lineg.split(",");

                String ncaballoc = datac[0];
                String ncaballo = datag[2];

                if(ncaballoc.equals(ncaballo)){
                    v_carrera+=(float) (Float.parseFloat(datag[3])/Float.parseFloat(datag[4]));
                    totV += v_carrera;
                    totC+= v_carrera;
                    System.out.println("La velocidad de "+datac[1]+" es de "+v_carrera+" en la carrera "+datag[0]);
                }
                lineg = reg_g.readLine();
                if(lineg==null){
                    if(totC<min_v & totC!=0){
                        min_v = totC;
                        min_horse = datac[1];
                    }
                    System.out.println("La velocidad total de "+datac[1]+" es de "+totC);
                    reg_g.close();
                    reg_g = new BufferedReader(new FileReader("Ejercicios_Estructura1\\Ganan.txt"));
                    lineg = reg_g.readLine();
                    linec = reg_c.readLine();
                    totC = 0;
                }
            }
            System.out.println("La velocidad total es de "+totV);
            System.out.println("El caballo con menor velocidad no nula total es "+min_horse+" con "+min_v);

            reg_c.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hola");
        LeerC("Caballos");
        System.out.println("Ganan");
        LeerG("Ganan");
        System.out.println("Speed");
        speed();
    }

}
