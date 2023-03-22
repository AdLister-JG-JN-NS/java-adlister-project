DROP DATABASE IF EXISTS adlister_project_db;
# Create adlister_project_database
CREATE DATABASE adlister_project_db;

USE adlister_project_db;
# Create a table for users
CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
# Create a table for ads
CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    company VARCHAR(50),
    salary long,
    job_type varchar(50),
    location varchar(100),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);
