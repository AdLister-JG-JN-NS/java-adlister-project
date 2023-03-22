USE adlister_project_db;
# --Create a table to hold ads
truncate ads;

INSERT INTO ads (user_id, title, description, company, salary, job_type, location)

VALUES (1, 'Front-End Developer', 'Entry Level, minimum PHD required in CS, 5+ years work in HTML/CSS/Javascript', 'Google', 35000, 'Remote/Hybrid', 'San Francisco, CA'),
       (2, 'Back-End Developer', 'Entry Level, minimum Masters degree required 10+ years required in the field', 'Apple', 29000, 'remote', 'Calgary, AB'),
       (3, 'Full-Stack Developer', 'Entry Level, 20+ years experience required.', 'SnapChat', 25632, 'Office Cube onsite', 'Wakiki, HI'),
       (4, 'Codeup Full-Stack/Data-Science/CloudAdmin Instructor', 'Codeup bootcamp graduation required', 'Codeup, LLC', 9999999, 'Classroom', 'San Antonio, TX');

