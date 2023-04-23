package org.example;


import org.example.queryresults.*;
import org.example.storage.DatabaseQueryService;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient("src/sql/find_max_projects_client.sql");
            System.out.println("maxProjectCountClients = " + maxProjectCountClients);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProjects("src/sql/find_longest_project.sql");
            System.out.println("longestProjects = " + longestProjects);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            List<MaxSalaryWorker> maxSalaryWorkers = new DatabaseQueryService().findMaxSalaryWorkers("src/sql/find_max_salary_worker.sql");
            System.out.println("maxSalaryWorkers = " + maxSalaryWorkers);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            List<YoungestEldestWorker> youngestEldestWorkers = new DatabaseQueryService().findYoungestEldestWorkers("src/sql/find_youngest_eldest_workers.sql");
            System.out.println("youngestEldestWorkers = " + youngestEldestWorkers);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            List<ProjectPrice> projectPrices = new DatabaseQueryService().findProjectPrices("src/sql/print_project_prices.sql");
            System.out.println("projectPrices = " + projectPrices);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
