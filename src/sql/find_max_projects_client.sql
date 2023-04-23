SELECT *
FROM client
WHERE id IN (
    SELECT client_id FROM project
    GROUP BY client_id
    HAVING Count(client_id) IN (
        SELECT Count(client_id)
        FROM project
        GROUP BY client_id
        ORDER BY count(client_id) DESC
        LIMIT 1
    )
);