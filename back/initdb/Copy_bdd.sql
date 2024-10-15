-- Script PostgreSQL

-- ------------------------------------------------------------
-- Table: users
-- ------------------------------------------------------------

CREATE TABLE Users (
                        id_users         SERIAL PRIMARY KEY,
                        last_name_users  VARCHAR(50) NOT NULL,
                        first_name_users VARCHAR(50) NOT NULL,
                        email_users      VARCHAR(50) NOT NULL,
                        password_users   VARCHAR(50) NOT NULL
);

-- ------------------------------------------------------------
-- Table: Project
-- ------------------------------------------------------------

CREATE TABLE Project (
                         id_project   SERIAL PRIMARY KEY,
                         name_project VARCHAR(50) NOT NULL,
                         date_project DATE NOT NULL,
                         id_users      INT NOT NULL,
                         CONSTRAINT Project_Users_FK FOREIGN KEY (id_users) REFERENCES Users(id_users) ON DELETE CASCADE
);

-- ------------------------------------------------------------
-- Table: Task
-- ------------------------------------------------------------

CREATE TABLE Task (
                      id_task          SERIAL PRIMARY KEY,
                      title_task       VARCHAR(100) NOT NULL,
                      description_task VARCHAR(1000) NOT NULL,
                      priority_task    INT NOT NULL,
                      deadline_task    DATE NOT NULL,
                      achieved_task    BOOLEAN NOT NULL,
                      id_project       INT NOT NULL,
                      CONSTRAINT Task_Project_FK FOREIGN KEY (id_project) REFERENCES Project(id_project) ON DELETE CASCADE
);