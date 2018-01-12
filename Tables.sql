CREATE TABLE Calories_and_nutrients_balance(
ID INT AUTO_INCREMENT PRIMARY KEY,
commitDate DATE,
Calories INT UNSIGNED,
Carbohydrate INT UNSIGNED ,
Protein INT UNSIGNED,
Fats INT UNSIGNED
);

CREATE TABLE User_size(
BMI_ID INT AUTO_INCREMENT PRIMARY KEY,
commitDate DATE,
HEIGHT INT UNSIGNED,
WEIGH INT UNSIGNED,
CHEST_SIZE INT UNSIGNED,
WAIST_SIZE INT UNSIGNED,
HIP_SIZE INT UNSIGNED
);
CREATE TABLE BMI_state(
BMI_ID INT AUTO_INCREMENT PRIMARY KEY,
DateHistory DATE,
BMI FLOAT UNSIGNED,
Description VARCHAR(50),
FOREIGN KEY (BMI_ID) REFERENCES User_size(BMI_ID)
);
CREATE TABLE Exercise_calories(
Exercise VARCHAR(50) PRIMARY KEY,
Calories_per_hour INT UNSIGNED
);
CREATE TABLE Training_plan(
train_ID INT AUTO_INCREMENT PRIMARY KEY,
Exercise VARCHAR(50),
trainingDay ENUM('Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday'),
trainingTime TIME,
FOREIGN KEY (Exercise) REFERENCES Exercise_calories(Exercise) ON DELETE CASCADE
);

CREATE TABLE User_exercise(
EX_ID INT AUTO_INCREMENT PRIMARY KEY,
Exercise VARCHAR(50),
trainingDate DATE,
trainingTime TIME,
FOREIGN KEY (Exercise) REFERENCES Exercise_calories(Exercise) ON DELETE CASCADE
);

CREATE TABLE Food_calories_and_nutrients(
Product VARCHAR(50) PRIMARY KEY,
Calories_per_100gram INT UNSIGNED,
Carbohydrate_per_100gram INT UNSIGNED,
Protein_per_100gram INT UNSIGNED,
Fats_per_100gram INT UNSIGNED
);

CREATE TABLE User_food(
food_ID INT AUTO_INCREMENT PRIMARY KEY,
Product VARCHAR(50),
Weight_of_the_product INT UNSIGNED,
eatingDate DATE,
FOREIGN KEY (Product) REFERENCES Food_calories_and_nutrients(Product) ON DELETE CASCADE
);

CREATE TABLE Diet_plan(
diet_ID INT AUTO_INCREMENT PRIMARY KEY,
Product VARCHAR(50),
dietDay ENUM('Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday'),
Meal_type  Enum('Breakfast','Dinner','Lunch','Supper'),
Weight_of_the_product  INT UNSIGNED,
FOREIGN KEY (Product) REFERENCES Food_calories_and_nutrients(Product) ON DELETE CASCADE
);