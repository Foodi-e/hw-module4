package org.example.storage;

import org.example.queryresults.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private String getSql(String sqlFileName) throws IOException {
        return String.join(
                "\n",
                Files.readAllLines(Paths.get(sqlFileName))
        );
    }
    public List<MaxProjectCountClient> findMaxProjectsClient(String sqlFileName) throws SQLException {
        List<MaxProjectCountClient> result = new ArrayList<>();

        try (PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(getSql(sqlFileName))) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient();
                    maxProjectCountClient.setName(rs.getString("name"));
                    maxProjectCountClient.setId(rs.getLong("id"));
                    result.add(maxProjectCountClient);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<LongestProject> findLongestProjects(String sqlFileName) throws SQLException {
        List<LongestProject> result = new ArrayList<>();

        try (PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(getSql(sqlFileName))) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    LongestProject longestProject = new LongestProject();
                    longestProject.setId(rs.getLong("id"));
                    longestProject.setClientId(rs.getLong("client_id"));
                    longestProject.setDurationInMonths(rs.getInt("duration_in_months"));
                    result.add(longestProject);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorkers(String sqlFileName) throws SQLException {
        List<MaxSalaryWorker> result = new ArrayList<>();

        try (PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(getSql(sqlFileName))) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker();
                    maxSalaryWorker.setName(rs.getString("name"));
                    maxSalaryWorker.setSalary(rs.getBigDecimal("salary"));
                    result.add(maxSalaryWorker);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers(String sqlFileName) throws SQLException {
        List<YoungestEldestWorker> result = new ArrayList<>();

        try (PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(getSql(sqlFileName))) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    YoungestEldestWorker youngestEldestWorker = new YoungestEldestWorker();
                    youngestEldestWorker.setName(rs.getString("name"));
                    youngestEldestWorker.setType(Type.valueOf(rs.getString("type")));
                    youngestEldestWorker.setBirthday(rs.getString("birthday"));
                    result.add(youngestEldestWorker);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<ProjectPrice> findProjectPrices(String sqlFileName) throws SQLException {
        List<ProjectPrice> result = new ArrayList<>();

        try (PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(getSql(sqlFileName))) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ProjectPrice projectPrice = new ProjectPrice();
                    projectPrice.setProjectName(rs.getLong("project_name"));
                    projectPrice.setProjectCost(rs.getBigDecimal("project_cost"));
                    result.add(projectPrice);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
