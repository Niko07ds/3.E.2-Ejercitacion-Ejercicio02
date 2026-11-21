package ejercicio02;

/**
 * Creador abstracto: declara el método de fábrica que devuelve el conector de almacenamiento.
 */
public abstract class StorageCreator {

    // Método de fábrica: cada creador devuelve su conector configurado
    public abstract FileStorage createStorage();

    // Operación común: crea el conector y lo deja listo para usar
    public FileStorage openStorage() {
        FileStorage storage = createStorage();
        System.out.println("Conector creado: " + storage.getStorageType());
        return storage;
    }
}
