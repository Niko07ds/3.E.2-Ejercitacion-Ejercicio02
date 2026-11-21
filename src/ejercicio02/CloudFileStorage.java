package ejercicio02;

import java.util.HashMap;
import java.util.Map;

/**
 * Producto concreto: almacenamiento en un servidor en la nube (simulado en memoria).
 */
public class CloudFileStorage implements FileStorage {

    private final String bucketUrl;
    private final String accessToken;
    private final Map<String, String> files = new HashMap<>();

    public CloudFileStorage(String bucketUrl, String accessToken) {
        this.bucketUrl = bucketUrl;
        this.accessToken = accessToken;
    }

    @Override
    public void save(String fileName, String content) {
        files.put(fileName, content);
        System.out.println("[Nube] Subiendo archivo a " + bucketUrl + "/" + fileName
                + " (token de " + accessToken.length() + " caracteres)");
    }

    @Override
    public String retrieve(String fileName) {
        if (!files.containsKey(fileName)) {
            throw new IllegalArgumentException("No existe el archivo en la nube: " + fileName);
        }
        System.out.println("[Nube] Descargando " + bucketUrl + "/" + fileName);
        return files.get(fileName);
    }

    @Override
    public String getStorageType() {
        return "Nube";
    }
}
