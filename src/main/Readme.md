
# Adlister Project

Be able to register an account, view current job openings, create/delete jobs, and save job openings to a profile page.


## Authors

- [@ToastBubbles](https://www.github.com/ToastBubbles)
- [@SolleyN](https://github.com/SolleyN)
- [@gijoe250](https://github.com/gijoe250)


## How to Run
Clone the project
```bash 
git clone https://github.com/AdLister-JG-JN-NS/java-adlister-project
```
Make sure to have a mySQL server running with terminal command
```bash
mySQL.server start
```
Create a Config.java in the following directory.
```bash
touch {project directory}/src/main/java/com.codeup.package.adlister/dao/Config.java
```
Populate Config.java with the following content where username and password are your mySQL credentials.
```bash
package com.codeup.adlister.dao;

public class Config {

    public String getUrl(){
        return "jdbc:mysql://localhost:3306/adlister_project_db?allowPublicKeyRetrieval=true&useSSL=false";
    }
    public String getUser(){
        return "";
    }
    public String getPassword(){
        return "";
    }
}
```

Ensure lastest TomCat 9.0.69 server is ready to deploy on local host. Install all Maven dependancies.

Run the following files: Migration.sql, Optionally run user_seeder.sql, and ad_seeder.sql files.


Launch Tomcat and a browser tab prompting login will appear.

Enjoy!



