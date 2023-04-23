package org.example.storage;

import org.example.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String initDbFileName = new Prefs().getString(Prefs.POPULATE_DB_SQL_FILE_PATH);
        try (Database database = Database.getInstance()) {
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(initDbFileName))
            );
            database.executeUpdate(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
