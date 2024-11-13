-- Insert users into the User table
INSERT INTO Users (id_users, last_name_users, first_name_users, email_users, password_users) VALUES
                                                                                                 (1, 'Doe', 'John', 'john.doe@example.com', 'password1'),
                                                                                                 (2, 'Smith', 'Jane', 'jane.smith@example.com', 'password2'),
                                                                                                 (3, 'Brown', 'Charlie', 'charlie.brown@example.com', 'password3');

-- Insert projects into the Project table
INSERT INTO Project (name_project, date_project, id_users) VALUES
                                                               ('Project Alpha', '2023-01-01', 1),
                                                               ('Project Beta', '2023-02-01', 2),
                                                               ('Project Gamma', '2023-03-01', 3);


-- Insert tasks into the Task table
INSERT INTO Task (title_task, description_task, priority_task, deadline_task, achieved_task, id_project) VALUES
                                                                                                             ('Task 2', 'Description for Task 2', 2, '2023-05-01', true, 1),
                                                                                                             ('Task 3', 'Description for Task 3', 3, '2023-06-01', false, 2),
                                                                                                             ('Task 4', 'Description for Task 4', 1, '2023-07-01', true, 2);
