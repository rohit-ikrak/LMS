<b>
# Library Management System
This is a small project demonstrating my learning progress. The main focus in this project is to demonstrate my understandings of SpringMVC and SpringORM.

## Project Information
<br>-> Jdk version - jdk-17 
<br>-> Project type  - Maven Webapp
<br>-> Languages used - Java, HTML/CSS
<br>-> Database - MySQL
<br>-> Framework - Spring (SpringMVC, SpringORM)
<br>-> Additions Topics used - JSP, JSTL, Bootstrap etc

## How to run this project in your system?
<br>-> Download and extract the zip file.
<br>-> Open it with any IDE (I used STL).
<br>-> Go to spring-servlet.xml page and look for the bean named 'ds' (configuring data source)
<br>-> Change it according to your database requirements.
<br>-> Create the database with the same name as you put there ('lms' in my case).
<br>-> After creating the database, come back to the IDE and run project.
<br>-> It should start and a webpage should open in the browser.

## Understanding Project Structure
<br>1.  In this project I first added the dependencies in pom.xml.
<br>2.  Then I added dispactcher servlet class in web.xml.
<br>3.  I the same place as web.xml file I created another file in which I added (servlet) configurations of the project (basically for declaring beans).
<br>4.  Then I created the database structure and figured out the entities that will be required for operating the project.
<br>5.  Then I created four packages naming them >model >dao >services >controller.
<br>6.  Model will contain entities (POJO) to be defined as a bean.
<br>7.  Dao package will contain classes that will have methods to direct connection for database using Spring HibernateORM.
<br>8.  Services package classes will interact with dao package classes whose dependencies will be injected in these classes.
<br>9.  Controller package classes will have service package classes as the means to give instructions.
<br>10. Then I created frontend using HTML, CSS, Bootstrap.
</b>
#### Note: This is a minimal project that just showcases the basic knowledge of the spring concepts.
#### There is so much to learn further as the framework is very vast and has many subframeworks that can be used combined to make the application much better whether in performance or in security.

## Screenshots of the project (webpages)
![homepage](https://github.com/rohit-ikrak/LMS/assets/86831121/c22ed70f-e741-4175-b47c-22bcad3cf682)
![registerpage](https://github.com/rohit-ikrak/LMS/assets/86831121/54bb034a-f4cc-4998-a783-ef60c2752153)
![loginpage](https://github.com/rohit-ikrak/LMS/assets/86831121/d8ea1ca4-3388-48c6-8435-e1da522861d8)
![adminpage](https://github.com/rohit-ikrak/LMS/assets/86831121/a37b81bf-8950-4f64-a547-9528d3ac59f4)
![library](https://github.com/rohit-ikrak/LMS/assets/86831121/33987cec-5f97-46a7-8b77-c63d5bcc00fd)
