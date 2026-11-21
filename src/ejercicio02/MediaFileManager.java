package ejercicio02;

/**
 * Lógica de negocio: gestiona los archivos multimedia sin conocer dónde se almacenan.
 */
public class MediaFileManager {

    private final FileStorage storage;

    public MediaFileManager(StorageCreator creator) {
        this.storage = creator.openStorage();
    }

    public void upload(String fileName, String content) {
        storage.save(fileName, content);
    }

    public void download(String fileName) {
        String content = storage.retrieve(fileName);
        System.out.println("Contenido recuperado: " + content);
    }
}
