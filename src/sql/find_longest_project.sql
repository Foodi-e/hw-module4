SELECT *, DATEDIFF(month, start_date, finish_date) AS duration_in_months
FROM project
WHERE DATEDIFF(month, start_date, finish_date) IN (
    SELECT MAX(DATEDIFF(month, start_date, finish_date))
    FROM project
    );
