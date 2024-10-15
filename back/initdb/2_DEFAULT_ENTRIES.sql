INSERT INTO "User" (last_name_user, first_name_user, email_user, password_user)
VALUES 
('Smith', 'John', 'john.smith@example.com', 'password123'),
('Doe', 'Jane', 'jane.doe@example.com', 'securepass'),
('Miller', 'Alice', 'alice.miller@example.com', 'alice123'),
('Brown', 'Bob', 'bob.brown@example.com', 'bobby456');

-- ------------------------------------------------------------
-- Insert mock data into the Project table
-- ------------------------------------------------------------

INSERT INTO Project (name_project, date_project, id_user)
VALUES 
('Project A', '2024-01-15', 1),
('Project B', '2024-02-10', 2),
('Project C', '2024-03-05', 1),
('Project D', '2024-04-20', 3);

-- ------------------------------------------------------------
-- Insert mock data into the Task table
-- ------------------------------------------------------------

INSERT INTO Task (title_task, description_task, priority_task, deadline_task, achieved_task, id_project)
VALUES 
('Design Database', 'Design the schema for the new project', 1, '2024-01-20', FALSE, 1),
('Write API', 'Develop the RESTful API for the project', 2, '2024-02-01', FALSE, 1),
('Testing', 'Test the application thoroughly', 3, '2024-03-10', FALSE, 2),
('Documentation', 'Prepare project documentation', 1, '2024-04-15', TRUE, 3),
('Deploy to Cloud', 'Deploy the app to the cloud environment', 2, '2024-05-01', FALSE, 3);
