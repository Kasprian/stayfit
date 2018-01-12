DELIMITER $$
CREATE PROCEDURE execute_diet(WDay ENUM('Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday'),Meal Enum('Breakfast','Dinner','Lunch','Supper'))
BEGIN
       INSERT INTO Calories_and_nutrients_balance(commitDate,calories,carbohydrate,protein,fats)
       SELECT CURDATE(), F.Calories_per_100gram/100*D.Weight_of_the_product,
       F.Carbohydrate_per_100gram/100*D.Weight_of_the_product,
       F.Protein_per_100gram/100*D.Weight_of_the_product,
       F.Fats_per_100gram/100*D.Weight_of_the_product FROM Food_calories_and_nutrients AS F JOIN
       Diet_plan AS D ON F.Product=D.Product WHERE D.dietDay=WDay AND D.Meal_type=Meal;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE execute_training(WDay ENUM('Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday'))
BEGIN
       INSERT INTO Calories_and_nutrients_balance(commitDate,calories,carbohydrate,protein,fats)
       SELECT CURDATE(), -(E.Calories_per_hour/60*T.trainingTime),'0','0','0'
       FROM Exercise_calories AS E JOIN
       Training_plan AS T ON E.Exercise=T.Exercise WHERE training_day=WDay;
END $$
DELIMITER ;