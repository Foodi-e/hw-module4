CREATE TABLE IF NOT EXISTS worker(
    id  BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) >= 2),
    birthday DATE CHECK (birthday > '1900-01-01'),
    level ENUM('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL,
    salary DECIMAL(6,2) NOT NULL CHECK (salary >= 100)
);

CREATE TABLE IF NOT EXISTS client(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) >= 2)
);

CREATE TABLE IF NOT EXISTS project(
     id BIGINT PRIMARY KEY AUTO_INCREMENT,

     client_id BIGINT,
     FOREIGN KEY (client_id) REFERENCES client(id),

     start_date DATE,
     finish_date DATE
);

CREATE TABLE IF NOT EXISTS project_worker(
    project_id BIGINT,
    FOREIGN KEY (project_id) REFERENCES project(id),

    worker_id BIGINT,
    FOREIGN KEY (worker_id) REFERENCES worker(id),

    PRIMARY KEY (project_id, worker_id)
);

