package org.example.storage;

import org.example.prefs.Prefs;
import org.flywaydb.core.Flyway;

public class DatabaseMigrate {
    public static void main(String[] args) {
        String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, null, null)
                .load();
        flyway.migrate();

    }
}
