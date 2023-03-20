USE adlister_project_db;

TRUNCATE  users;

INSERT INTO users (id, username, email, password)

VALUES (1, 'user1', 'user1@gmail.com', 'password1'),
       (2, 'user2', 'user2@gmail.com', 'password2'),
       (3, 'user3', 'user3@gmail.com', 'password3'),
       (4, 'user4', 'user4@gmail.com', 'password4'),
       (5, 'user5', 'user5@gmail.com', 'password5');
