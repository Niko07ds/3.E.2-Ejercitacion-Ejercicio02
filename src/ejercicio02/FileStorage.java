package ejercicio02;

/**
 * Producto: interfaz genérica de almacenamiento de archivos.
 */
public interface FileStorage {

    void save(String fileName, String content);

    String retrieve(String fileName);

    String getStorageType();
}
