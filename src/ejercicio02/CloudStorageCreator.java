package ejercicio02;

/**
 * Creador concreto: construye el conector de la nube.
 */
public class CloudStorageCreator extends StorageCreator {

    private final String bucketUrl;
    private final String accessToken;

    public CloudStorageCreator(String bucketUrl, String accessToken) {
        this.bucketUrl = bucketUrl;
        this.accessToken = accessToken;
    }

    @Override
    public FileStorage createStorage() {
        return new CloudFileStorage(bucketUrl, accessToken);
    }
}
