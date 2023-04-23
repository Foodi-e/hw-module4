SELECT p.id AS project_name,
       SUM(w.salary * TIMESTAMPDIFF(MONTH, p.start_date, p.finish_date)) AS project_cost
FROM project p
         JOIN project_worker pw ON p.id = pw.project_id
         JOIN worker w ON pw.worker_id = w.id
GROUP BY p.id
ORDER BY project_cost DESC;
