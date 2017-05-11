
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


INSERT INTO Orders (OrderID,ServerID,TableID,OrderStatus,OrderTotal) VALUES (3,1,5,0,11.1);
INSERT INTO Orders (OrderID,ServerID,TableID,OrderStatus,OrderTotal) VALUES (2,1,6,0,11.1);
INSERT INTO Orders (OrderID,ServerID,TableID,OrderStatus,OrderTotal) VALUES (1,1,7,0,11.1);



INSERT INTO Order_Items(OrderID,Menu_Item_Id,Seat_Number,item_name,item_price,item_description) VALUES (1,24,1,'Veggie Burger',22.50,'Pussy Vegan');
INSERT INTO Order_Items(OrderID,Menu_Item_Id,item_name,item_price,item_description) VALUES (1,23,'Burger',22.50,'Big Meat');
INSERT INTO Order_Items(OrderID,Menu_Item_Id,item_name,item_price,item_description) VALUES (1,22,'Fish',22.50,'Tasty seafood');