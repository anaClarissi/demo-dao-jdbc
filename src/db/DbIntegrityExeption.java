package db;

public class DbIntegrityExeption extends RuntimeException {

    private static final long serialVerisionUID = 1L;

    public DbIntegrityExeption(String message) {

        super(message);

    }

}
