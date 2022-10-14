USE sakila;

-- Write a SQL query to find the total rental amount paid for each film. Your query should return the following columns: 
-- film_id, total_amount

SELECT film_id, (rental_rate * rental_duration) AS total_amount 
FROM film 
GROUP BY film_id;

-- Create a view named total_rental_amount using the query from the previous step.

CREATE VIEW total_rental_amount AS
SELECT film_id, (rental_rate * rental_duration) AS total_amount 
FROM film 
GROUP BY film_id;

-- Write a SQL query to find the total number of copies in inventory for each film. Your query should return the following columns:
-- film_id, total_copies

SELECT film_id, COUNT(*) AS total_copies 
FROM inventory 
GROUP BY film_id;


-- Create a view named total_film_copies using the query from the previous step.
CREATE VIEW total_film_copies AS
SELECT film_id, COUNT(*) AS total_copies 
FROM inventory 
GROUP BY film_id;

-- Write a SQL query that combines data from the film table, the total_rental_amount view, and the total_film_copies view to 
-- find all films with a total rental amount greater than 200.00, and display the following columns:
-- film_id, title, description, rental_duration, rental_rate, replacement_cost, rating, total_copies, total_amount
SELECT 
f.film_id,
f.title,
f.description,
f.rental_duration,
f.rental_rate,
f.replacement_cost,
f.rating, 
c.total_copies,
a.total_amount
FROM film f 
INNER JOIN total_film_copies c on f.film_id = c.film_id 
INNER JOIN total_rental_amount a on f.film_id = a.film_id
WHERE (a.total_amount > 200);
