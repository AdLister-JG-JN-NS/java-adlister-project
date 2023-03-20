USE adlister_project_db;

TRUNCATE ads;

INSERT INTO ads (user_id, title, description, company, salary, job_type, location)

VALUES (1, 'Front-End Developer', 'Entry Level, minimum PHD required in CS, 5+ years work in HTML/CSS/Javascript', 'Google', '35,000', 'Remote/Hybrid', 'San Francisco, CA'),
       (2, 'Back-End Developer', 'Entry Level, minimum Masters degree required 10+ years required in the field', 'Apple', 'Remote/WFH', '29,000', 'Calgery, AB'),
       (3, 'Full-Stack Developer', 'Entry Level, 20+ years experience required.', 'SnapChat', 'Office Cube onsite', '100,000', 'Wakiki, HI'),
       (4, 'Codeup Full-Stack/Data-Science/CloudAdmin Instructor', 'Codeup bootcamp graduation required', 'Codeup, LLC', 'ON site Classroom', '999,999', 'San Antonio, TX');
