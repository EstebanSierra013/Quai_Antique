INSERT INTO rol(id_rol,name) VALUE (1,"Admin");
INSERT INTO rol(id_rol,name) VALUE (2,"Client");

INSERT INTO user(email,firstname,lastname,password,rol,guest_numbers,allergy) VALUES ("anesierrasa","Andres","Sierra","1234",2,3,"none");
INSERT INTO restaurant(name,description,am_opening_time,pm_opening_time,max_guests) VALUE ("Quai Antique", "French Restaurant", "{}", "{}", 30);

INSERT INTO category(name) VALUE ("Entrée");
INSERT INTO category(name) VALUE ("Plat");
INSERT INTO category(name) VALUE ("Dessert");
