CREATE DATABASE menudatabase;

CREATE TABLE menuitem(
item_id INT NOT NULL PRIMARY KEY,
item_name VARCHAR(30) NOT NULL,
item_price DOUBLE NOT NULL,
item_description VARCHAR(200) NOT NULL);

INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (001, "Empire State Hotdog", 4.80, "A premium Hotdog with BBQ sauce, grated parmesan cheese, and pineapple.");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (002, "42nd Street Hotdog", 4.50, "A prime Hotdog with Maple BBQ sauce, cream cheese, and coleslaw");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (003, "56th Street Hotdog", 3.75, "A choice Hotdog with Hawaiian BBQ Sauce, caramel popcorn, and marinara sauce");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (004, "153rd Street Hotdog", 4.00, "A superior Hotdog with Papa John's BBQ Sauce, garlic slices, and apple turnover bites");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (005, "68th Street Hotdog", 5.00, "An exceptional Hotdog with Peanut Butter BBQ Sauce, onion rings, and tzatziki sauce");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (006, "24th Street Hotdog", 3.50, "A prize Hotdog with Cherry Chipotle BBQ Sauce, pad thai, and lemon lime soda");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (007, "82nd Street Hotdog", 5.50, "A good Hotdog with Mayo BBQ Sauce, Chicken Parmesan, and turtle stew");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (008, "1st Street Hotdog", 1.00, "An excellent Hotdog with Tahini BBQ Sauce, poutine, and lavender");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (009, "009th Street Hotdog", 9.99, "A first-rate Hotdog with Khrenovina BBQ Sauce, Natto, and seaweed");
INSERT INTO menuitem (item_id,item_name,item_price,item_description) VALUES (010, "5th Street Hotdog", 1000.00, "An expensive Hotdog with Gold BBQ Sauce, Caviar, and $100 bills");