-- Part 1: Test it with SQL --
--SHOW COLUMNS FROM job;
id (int, PK),
name (varchar),
employer (varchar),
skills (varchar);

-- Part 2: Test it with SQL --
--SELECT * FROM employer WHERE (location="St.Louis City");
SELECT name
FROM employer
WHERE location = "St. Louis City";

-- Part 3: Test it with SQL --
--DROP TABLE job;
