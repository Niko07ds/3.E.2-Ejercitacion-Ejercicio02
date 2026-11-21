package ejercicio02;

import java.util.HashMap;
import java.util.Map;

/**
 * Producto concreto: almacenamiento en el disco local (simulado en memoria).
 */
public class LocalFileStorage implements FileStorage {

    private final String directory;
    private final Map<String, String> files = new HashMap<>();

    public LocalFileStorage(String directory) {
        this.directory = directory;
    }

    @Override
    public void save(String fileName, String content) {
        files.put(fileName, content);
        System.out.println("[Disco local] Archivo guardado en " + directory + "/" + fileName);
    }

    @Override
    public String retrieve(String fileName) {
        if (!files.containsKey(fileName)) {
            throw new IllegalArgumentException("No existe el archivo en el disco local: " + fileName);
        }
        System.out.println("[Disco local] Leyendo " + directory + "/" + fileName);
        return files.get(fileName);
    }

    @Override
    public String getStorageType() {
        return "Disco local";
    }
}
