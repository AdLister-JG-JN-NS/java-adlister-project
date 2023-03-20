USE adlister_project_db;

TRUNCATE ads;

INSERT INTO ads (user_id, title, description)

VALUES (1, 'This is a title', 'This is a description'),
       (2, 'This is a title', 'This is a description'),
       (3, 'This is a title', 'This is a description'),
       (4, 'This is a title', 'This is a description')
