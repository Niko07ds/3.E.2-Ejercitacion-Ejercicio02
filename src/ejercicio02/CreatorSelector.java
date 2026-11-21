package ejercicio02;

/**
 * Decide qué creador instanciar según la configuración.
 * Esta lógica de selección está separada de la lógica de negocio.
 */
public class CreatorSelector {

    public StorageCreator select(StorageConfig config) {
        switch (config.getPreference()) {
            case LOCAL:
                return new LocalStorageCreator(config.getLocation());
            case CLOUD:
                if (config.getAccessToken() == null || config.getAccessToken().isEmpty()) {
                    throw new IllegalArgumentException("El almacenamiento en la nube requiere un token de acceso.");
                }
                return new CloudStorageCreator(config.getLocation(), config.getAccessToken());
            default:
                throw new IllegalArgumentException("Preferencia no soportada: " + config.getPreference());
        }
    }
}
