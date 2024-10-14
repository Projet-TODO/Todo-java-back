-- Script PostgreSQL

-- ------------------------------------------------------------
-- Table: User
-- ------------------------------------------------------------

CREATE TABLE "User" (
                        id_user         SERIAL PRIMARY KEY,
                        last_name_user  VARCHAR(50) NOT NULL,
                        first_name_user VARCHAR(50) NOT NULL,
                        email_user      VARCHAR(50) NOT NULL,
                        password_user   VARCHAR(50) NOT NULL
);

-- ------------------------------------------------------------
-- Table: Project
-- ------------------------------------------------------------

CREATE TABLE Project (
                         id_project   SERIAL PRIMARY KEY,
                         name_project VARCHAR(50) NOT NULL,
                         date_project DATE NOT NULL,
                         id_user      INT NOT NULL,
                         CONSTRAINT Project_User_FK FOREIGN KEY (id_user) REFERENCES "User"(id_user) ON DELETE CASCADE
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