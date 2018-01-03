package pesarcarpetas;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mbernedo
 */
public class ListaDirectorio {

    private int cont = 0;
    private long tamaño = 0;
    private List<String> paths = new ArrayList<String>();
    private String lastPath = "";

    public void listarDirectorio(File f) {
        File arr[] = f.listFiles();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].isDirectory()) {
                    listarDirectorio(arr[i]);
                } else {
                    listarDirectorio(arr[i]);
                    tamaño += (long) (arr[i].length());
                }
            }
        }
    }

    public long ListarUnDirectorio(File f) {
        File arr[] = f.listFiles();
        if (arr != null) {
            listarDirectorio(new File(f.getAbsolutePath()));
        }
        return tamaño;
    }

    public String findLastPath(File f, String buscar) {
        File arr[] = f.listFiles();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].isDirectory()) {
                    findLastPath(arr[i], buscar);
                } else {
                    findLastPath(arr[i], buscar);
                    paths.add(arr[i].getAbsolutePath());
                    //tamaño += (long) (arr[i].length());
                }
            }
            searchPath(buscar);
        }
        return lastPath;
    }

    public void searchPath(String buscar) {

        for (String path : paths) {
            if (path.contains(buscar)) {
                lastPath = path;
            }
        }

    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public String getLastPath() {
        return lastPath;
    }

    public void setLasPath(String lasPath) {
        this.lastPath = lasPath;
    }
    
    public List<String> getPaths() {
        return paths;
    }

    public void setPaths() {
        this.paths = new ArrayList<String>();
    }

}
