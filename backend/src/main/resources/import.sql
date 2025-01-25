INSERT INTO roles(id_role,name) VALUE (1,"Admin");
INSERT INTO roles(id_role,name) VALUE (2,"Client");

INSERT INTO users(email,firstname,lastname,password,role_id,guests,allergy) VALUES ("anesierrasa","Andres","Sierra","1234",2,3,"none");
INSERT INTO restaurant(name,description,am_opening_time,pm_opening_time,max_guests) VALUE ("Quai Antique", "French Restaurant", "15h00", "21h00", 30);

INSERT INTO category(name) VALUE ("Entrée");
INSERT INTO category(name) VALUE ("Plat");
INSERT INTO category(name) VALUE ("Dessert");
