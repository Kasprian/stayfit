CREATE USER 'kasprian'@'localhost';
SET PASSWORD FOR 'kasprian'@'localhost'= PASSWORD('piotrkasprowicz609');
GRANT SELECT ON stayfit.Calories_and_nutrients_balance TO 'kasprian'@'localhost';
GRANT SELECT,INSERT,UPDATE ON stayfit.User_size TO 'kasprian'@'localhost';
GRANT SELECT,INSERT,UPDATE ON stayfit.User_food TO 'kasprian'@'localhost';
GRANT SELECT,INSERT,UPDATE ON stayfit.Food_calories_and_nutrients TO 'kasprian'@'localhost';
GRANT SELECT,INSERT,UPDATE ON stayfit.Diet_plan TO 'kasprian'@'localhost';
GRANT SELECT,INSERT,UPDATE ON stayfit.Exercise_calories TO 'kasprian'@'localhost';
GRANT SELECT,INSERT,UPDATE ON stayfit.User_exercise TO 'kasprian'@'localhost';
GRANT SELECT,INSERT,UPDATE ON stayfit.Training_plan TO 'kasprian'@'localhost';
GRANT SELECT ON stayfit.BMI_state TO 'kasprian'@'localhost';
SHOW GRANTS FOR 'kasprian'@'localhost';
FLUSH PRIVILEGES;