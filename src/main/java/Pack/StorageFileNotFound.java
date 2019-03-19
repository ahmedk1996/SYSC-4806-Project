package Pack;

public class StorageFileNotFound extends StorageException {

    public StorageFileNotFound(String message) {
        super(message);
    }

    public StorageFileNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}