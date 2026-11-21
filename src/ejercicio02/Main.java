package ejercicio02;

public class Main {

    public static void main(String[] args) {
        System.out.println("Creador de conexiones a repositorios de archivos");

        CreatorSelector selector = new CreatorSelector();

        // Configuraciones que simulan la preferencia del usuario
        StorageConfig localConfig = new StorageConfig(StoragePreference.LOCAL, "C:/Multimedia", null);
        StorageConfig cloudConfig = new StorageConfig(StoragePreference.CLOUD,
                "https://almacen.ejemplo.com/fotos", "token-secreto-123");
        StorageConfig invalidCloudConfig = new StorageConfig(StoragePreference.CLOUD,
                "https://almacen.ejemplo.com/fotos", null);

        System.out.println("\n--- Preferencia 1: disco local ---");
        MediaFileManager localManager = new MediaFileManager(selector.select(localConfig));
        localManager.upload("vacaciones.jpg", "<imagen-de-vacaciones>");
        localManager.download("vacaciones.jpg");

        System.out.println("\n--- Preferencia 2: nube ---");
        MediaFileManager cloudManager = new MediaFileManager(selector.select(cloudConfig));
        cloudManager.upload("cumpleanos.mp4", "<video-de-cumpleanos>");
        cloudManager.download("cumpleanos.mp4");

        System.out.println("\n--- Recuperar un archivo inexistente ---");
        try {
            localManager.download("no-existe.png");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Nube sin token de acceso ---");
        try {
            selector.select(invalidCloudConfig);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
