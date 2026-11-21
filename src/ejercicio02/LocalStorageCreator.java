package ejercicio02;

/**
 * Creador concreto: construye el conector de disco local.
 */
public class LocalStorageCreator extends StorageCreator {

    private final String directory;

    public LocalStorageCreator(String directory) {
        this.directory = directory;
    }

    @Override
    public FileStorage createStorage() {
        return new LocalFileStorage(directory);
    }
}
