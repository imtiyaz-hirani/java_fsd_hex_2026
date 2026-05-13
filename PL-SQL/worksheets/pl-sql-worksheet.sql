-- Creating DB
create database hex_fsd_may_2026;

-- select DB for working 
use hex_fsd_may_2026;

-- create table customer 
create table customers(id INT primary key, 
name varchar(255) NOT NULL, 
city varchar(255), 
age INT);

-- check table structure 
desc customers;

-- inserting in DB 
insert into customers values 
(1, "harry potter", "london", 19 ),
(2, "ronald weasley", "surrey", 20 ),
(3, "hermione granger", "london", 19);

select * from customers; 


/* Simple stored Procedure to display all customers */
DELIMITER $$
create procedure get_all_customers()
BEGIN 
	select * from customers;
END
$$

/* CALL Proc */
CALL get_all_customers;

/*
Create a Procedure to read input from the user and display rows
Input: city 
Output: Customer rows 
*/

DELIMITER $$
create procedure get_customers_by_city(IN p_city varchar(255)) -- reading city input value 
BEGIN
	-- validate the input
    IF TRIM(p_city) = "" OR p_city IS NULL THEN
		SIGNAL sqlstate "45000" 
        SET message_text ="city value cannot be blank or null";
    END IF; 
    
    -- SQL 
	select *
    from customers
    where city = p_city;
END
$$
-- drop the proc 
drop procedure get_customers_by_city;

CALL get_customers_by_city('london');
CALL get_customers_by_city('surrey');
CALL get_customers_by_city('');
CALL get_customers_by_city('    ');
/*
IF <condition> THEN
	do something 
END IF; 
*/

/* Proc to count number of rows using 
Input and output */
DELIMITER $$
create procedure get_customer_count_by_city(IN p_city varchar(255), OUT p_total_customers INT)
BEGIN
	-- validate the input
    IF TRIM(p_city) = "" OR p_city IS NULL THEN
		SIGNAL sqlstate "45000" 
        SET message_text ="city value cannot be blank or null";
    END IF; 
    -- SQL 
	select COUNT(*) into p_total_customers
    from customers
    where city = p_city;
    
END
$$

CALL get_customer_count_by_city('london', @total_customers);
CALL get_customer_count_by_city('surrey', @total_customers); -- @ is for session variables 
select @total_customers;

















