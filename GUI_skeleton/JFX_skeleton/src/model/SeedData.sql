
USE RAS;	
--
-- Dumping data for table `Employees`
--

INSERT INTO `Employees` (`employeeID`, `Employee_name`, `Employee_type`, `working_now`) VALUES
(1, 'Clara Oswald', 'Server', 0),
(2, 'Amy Pond', 'Server', 0);

--
-- Dumping data for table `Tables`
--

INSERT INTO `Tables` (`tableID`, `employeeID`, `max_occupancy`, `Table_status`) VALUES
(1, 1, 6, 'empty'),
(2, 1, 6, 'empty'),
(3, 1, 8, 'empty'),
(4, 1, 10, 'empty'),
(5, 2, 5, 'empty'),
(6, 2, 5, 'empty'),
(7, 2, 7, 'empty'),
(8, 2, 8, 'empty');



INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (001, "Calamari", 10.79, "Tender calamari, lightly breaded and fried. Served with marinara sauce and creamy ranch.");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (002, "Lasagna Fritta", 9.99, "Fried parmesan-breaded lasagna, topped with parmesan cheese and marinara sauce, with creamy alfredo.");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (003, "Five Cheese Ziti al Forno", 13.99, "A baked blend of Italian cheeses, pasta and our signature five cheese marinara.");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (004, "Ravioli di Portobello", 14.49, "Filled with portobello mushrooms, topped with a creamy smoked cheese and sun-dried tomato sauce.");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (005, "Garlic Mussels Marinara", 11.29, "Oven-roasted mussels tossed in our housemade garlic marinara sauce. Served with garlic-parmesan breadstick toast.");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (006, "Herb-Grilled Salmon", 18.79, "Filet grilled to perfection and topped with garlic-herb butter. Served with parmesan-garlic broccoli.");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (007, "Stuffed Chicken Marsala	", 18.49, "Creamy marsala wine sauce with mushrooms over grilled chicken breasts, stuffed with Italian cheeses and sun-dried tomatoes. Served with garlic mashed potatoes.");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (008, "Braised Beef & Tortelloni", 16.79, "Tender slices of slow-braised beef, portobello mushrooms and asiago-filled tortelloni tossed in basil-marsala sauce.");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (009, "Chocolate Caramel Lasagna", 7.99, "Our sweet take on lasagna. Layers of vanilla-soaked sponge cake, decadent chocolate, caramel and custard topped with chocolate shavings.");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (010, "Lemon Cream Cake", 6.99, "Delicate white cake and lemon cream filling with a vanilla crumb topping.");


INSERT INTO `wait_list` VALUES (2,'mike','jones',4),(3,'mike','jones',4),(7,'TOM','PEDERSON',20);

INSERT INTO `reservation` VALUES (8,'tom','pederson',4,'05 04 2017','05:27 PM'),(9,'lili','hai',2,'05 04 2017','05:37 PM');