# student-management-app
a simple java application with gui and mysql

## IDE

Netbeans

## Application

Language: Java

GUI Components
- Frame
- Panel
- Text Field
- Label
- Radio Button
- Radio Button Group
- Combo Box

## Database

Database: MySQL 
Database Name: students

Table: students
```
+--------------+-------------+------+-----+---------+----------------+
| Field        | Type        | Null | Key | Default | Extra          |
+--------------+-------------+------+-----+---------+----------------+
| id           | int(11)     | NO   | PRI | NULL    | auto_increment |
| id_number    | int(11)     | YES  |     | NULL    |                |
| first_name   | varchar(50) | YES  |     | NULL    |                |
| middle_name  | varchar(50) | NO   |     | NULL    |                |
| last_name    | varchar(50) | YES  |     | NULL    |                |
| gender       | varchar(10) | YES  |     | NULL    |                |
| civil_status | varchar(30) | YES  |     | NULL    |                |
+--------------+-------------+------+-----+---------+----------------+
```