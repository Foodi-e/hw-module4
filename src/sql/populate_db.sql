INSERT INTO worker (name, birthday, level, salary)
VALUES
    ('John Doe', '1990-01-01', 'Trainee', 500),
    ('Jane Smith', '1985-05-12', 'Junior', 800),
    ('Bob Johnson', '1980-08-23', 'Middle', 1500),
    ('Alice Brown', '1975-12-15', 'Senior', 4000),
    ('Tom Lee', '1995-04-02', 'Trainee', 600),
    ('Sarah Kim', '1992-09-18', 'Junior', 900),
    ('David Chang', '1989-02-28', 'Middle', 2000),
    ('Emily Wang', '1983-06-08', 'Senior', 5000),
    ('Chris Lee', '1998-11-11', 'Trainee', 700),
    ('Cindy Chen', '1991-03-24', 'Junior', 1000),
    ('Sam Wu', '1987-07-06', 'Middle', 2500),
    ('Kelly Liu', '1981-10-17', 'Senior', 6000);

INSERT INTO client (name)
VALUES
    ('ABC Company'),
    ('XYZ Inc.'),
    ('Acme Corporation'),
    ('Smith Enterprises'),
    ('Johnson & Johnson');

INSERT INTO project (client_id, start_date, finish_date)
VALUES
    (1, '2022-01-01', '2023-03-31'),
    (1, '2023-01-01', '2024-03-31'),
    (2, '2022-02-01', '2023-04-30'),
    (2, '2023-02-01', '2024-04-20'),
    (2, '2022-02-01', '2023-04-20'),
    (2, '2023-02-01', '2024-04-20'),
    (3, '2022-03-01', '2023-05-21'),
    (3, '2023-03-01', '2024-05-21'),
    (4, '2022-04-01', '2023-06-30'),
    (4, '2023-04-01', '2024-06-30'),
    (5, '2022-05-01', '2023-07-21'),
    (5, '2023-06-01', '2025-07-21'),
    (5, '2022-05-14', '2023-09-21');


INSERT INTO project (client_id, start_date, finish_date)
VALUES
    (2, '2021-08-11', '2023-08-20'),
    (2, '2020-05-21', '2024-05-20'),
    (5, '2023-06-01', '2025-07-21'),
    (5, '2022-05-14', '2023-09-20');

INSERT INTO project_worker (project_id, worker_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (2, 5),
    (3, 6),
    (3, 7),
    (4, 8),
    (4, 9),
    (4, 10),
    (5, 1),
    (5, 6),
    (5, 9),
    (6, 2),
    (6, 7),
    (7, 3),
    (7, 8),
    (8, 5),
    (8, 10),
    (9, 4),
    (9, 9),
    (10, 1),
    (10, 5),
    (10, 10);

