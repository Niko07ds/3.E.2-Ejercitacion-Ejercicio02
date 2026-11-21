package ejercicio02;

/**
 * Configuración elegida por el usuario: preferencia, ubicación y credencial (solo nube).
 */
public class StorageConfig {

    private final StoragePreference preference;
    private final String location;
    private final String accessToken;

    public StorageConfig(StoragePreference preference, String location, String accessToken) {
        this.preference = preference;
        this.location = location;
        this.accessToken = accessToken;
    }

    public StoragePreference getPreference() {
        return preference;
    }

    public String getLocation() {
        return location;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
