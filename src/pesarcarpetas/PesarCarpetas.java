package pesarcarpetas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mbernedo
 */
public class PesarCarpetas {

    public static void main(String[] args) {
        String fileName = args[0] + "\\rutas.txt";
        List<String> rutas = new ArrayList<String>();
        String line;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                rutas.add(line);
            }
            ListaDirectorio direct = new ListaDirectorio();
            fichero = new FileWriter(args[0] + "\\peso.txt");
            pw = new PrintWriter(fichero);
            for (String lines : rutas) {
                direct.setPaths();
                String string = lines;
                String[] parts = string.split("#");
                String lastPath = direct.findLastPath(new File(parts[0]), parts[1]);
                String[] cads = lastPath.split(parts[1]);
                String pesar = cads[0] + parts[1];
                String certi = cads[0] + "Certificaciones";
                direct.setTamaño(0);
                System.out.println("DOCUMENTO : " + parts[0] + "\t");
                System.out.println("IPP : " + parts[1] + "\t");
                direct.setTamaño(0);
                System.out.println("PESO : " + direct.ListarUnDirectorio(new File(pesar)) + "\t");
                direct.setTamaño(0);
                System.out.println("CERTIFI: " + direct.ListarUnDirectorio(new File(certi)));
                System.out.println("****************");
            }
        } catch (IOException e) {
            System.out.println("Excepción: ");
            e.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
