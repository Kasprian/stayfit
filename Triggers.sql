DELIMITER $$

CREATE TRIGGER food_update AFTER INSERT ON User_food
FOR EACH ROW BEGIN
DECLARE a,b,c,d int;
DECLARE e FLOAT;
SET a=(SELECT Calories_per_100gram FROM Food_calories_and_nutrients WHERE Product=New.Product);
SET b=(SELECT Carbohydrate_per_100gram FROM Food_calories_and_nutrients WHERE Product=New.Product);
SET c=(SELECT Protein_per_100gram FROM Food_calories_and_nutrients WHERE Product=New.Product);
SET d=(SELECT Fats_per_100gram FROM Food_calories_and_nutrients WHERE Product=New.Product);
SET e=(NEW.Weight_of_the_product)/100;
   INSERT INTO Calories_and_nutrients_balance(commitDate,calories,carbohydrate,protein,fats) VALUES (CURDATE(),a*e,b*e,c*e,d*e);
END$$

DELIMITER $$

CREATE TRIGGER exercise_update AFTER INSERT ON User_exercise
FOR EACH ROW BEGIN
DECLARE a FLOAT;
DECLARE b INT;
SET a=(SELECT Calories_per_hour FROM Exercise_calories WHERE Exercise=New.Exercise)/60;
SET b=(NEW.trainingTime);
   INSERT INTO Calories_and_nutrients_balance(commitDate,calories,carbohydrate,protein,fats) VALUES (CURDATE(),a*b,'0','0','0');
END$$

DELIMITER $$
CREATE TRIGGER count_BMI AFTER INSERT ON User_size
FOR EACH ROW BEGIN
DECLARE a FLOAT;
SET a=NEW.Weigh*10000/(New.Height*New.Height);
if(a<18) THEN
INSERT INTO BMI_state(DateHistory,BMI,Description) VALUES (CURDATE(),a,"Niedowaga");
END IF;
if(a<25 && a>=18) THEN
INSERT INTO BMI_state(DateHistory,BMI,Description) VALUES (CURDATE(),a,"Norma");
END IF;
if(a<30 && a>=25) THEN
INSERT INTO BMI_state(DateHistory,BMI,Description) VALUES (CURDATE(),a,"Nadwaga");
END IF;
if(a<40 && a>=30) THEN
INSERT INTO BMI_state(DateHistory,BMI,Description) VALUES (CURDATE(),a,"Otyłość");
END IF;
if(a>=40)  THEN
INSERT INTO BMI_state(DateHistory,BMI,Description) VALUES (CURDATE(),a,"Poważna otyłość");
END IF;
END$$