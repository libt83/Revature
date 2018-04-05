-- Part I --
----------------------------------------------------------------------------
-- 2.1 SELECT --
SELECT *
FROM Employee;

SELECT *
FROM Employee
WHERE lastname = 'King';

SELECT *
FROM Employee
WHERE firstname = 'Andrew' AND reportsto IS NULL;

-- 2.2 ORDER BY --
SELECT *
FROM Album
ORDER BY title DESC;

SELECT firstname
FROM Customer
ORDER BY firstname;

-- 2.3 INSERT INTO --
INSERT INTO Genre(genreid, name)
VALUES(26, 'Emo');

INSERT INTO Genre(genreid, name)
VALUES(27, 'Gospel');

INSERT INTO Employee(employeeid, lastname, firstname)
VALUES(9, 'Jenkins', 'Bill');

INSERT INTO Employee(employeeid, lastname, firstname)
VALUES (10, 'Semba', 'Brandon');

INSERT INTO Customer(customerid, firstname, lastname, email)
VALUES(60, 'John', 'Holmes', 'holmes@yahoo.com');

INSERT INTO Customer(customerid, firstname, lastname, email)
VALUES(61, 'Holly', 'Smith', 'hollytime@homtail.com');

-- 2.4 UPDATE --
UPDATE Customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE customerid = 32;

UPDATE Artist
SET name = 'CCR'
WHERE artistid = 76;

-- 2.5 LIKE --
SELECT *
FROM Invoice
WHERE billingaddress LIKE '%T%';

-- 2.6 BETWEEN --
SELECT *
FROM Invoice
WHERE total BETWEEN 15 AND 50;

SELECT *
FROM Employee
WHERE hiredate BETWEEN '01/JUN/2003' AND '01/MAR/2004';

-- DELETE --
DELETE FROM Invoiceline
WHERE invoiceid IN (116, 245, 268, 290, 342, 50, 61);

DELETE FROM Invoice
WHERE customerid = 32;

DELETE FROM Customer
WHERE firstname = 'Robert' AND lastname = 'Walter';
----------------------------------------------------------------------------
-- 2.0 SQL Functions --
-- 7.0 JOINS --
-- 7.1 INNER --
SELECT Customer.firstname, Customer.lastname, Invoice.invoiceid
FROM Customer
JOIN Invoice ON Customer.customerid = Invoice.invoiceid;

-- 7.2 OUTER --
SELECT Customer.customerid, Customer.firstname,
       Customer.lastname, Invoice.invoiceid, Invoice.total
FROM Customer
FULL OUTER JOIN Invoice ON Customer.customerid = Invoice.invoiceid;

-- 7.3 RIGHT --
SELECT Artist.name AS Artist, Album.title
FROM Album
RIGHT JOIN Artist ON Album.artistid = artist.artistid;

-- 7.4 CROSS --
SELECT Artist.name AS Artist_Name
FROM Album
CROSS JOIN Artist 
ORDER BY Artist_Name;

-- 7.5 SELF --
SELECT Emp1.firstname AS Manager_Firstname, Emp1.lastname AS Manager_Lastname,
       Emp2.firstname AS Emp_Firstname, Emp2.lastname AS Emp_Lastname
FROM Employee Emp1, Employee Emp2
WHERE emp1.employeeid = emp2.reportsto;
------------------------------------------------------------------------------


-- Part II --
------------------------------------------------------------------------------
-- 1.1 Create 'Company' database using SMSS Interface --
CREATE USER OfficeSupply IDENTIFIED BY deftones;

DROP USER OfficeSupply;

-- 1.2 Create Company Database using DDL --
CREATE USER OfficeSupply IDENTIFIED BY deftones;
GRANT create session TO OfficeSupply;

-- 2.1  Create  Tables for OfficeSupply --
-- I did not know at this time how to create a function
-- to use for Boolean 'true'/'false' values which is depicted
-- in the picture, so I went with 'Y'/'N'
CREATE TABLE Employee
(
   EmployeeID NUMBER(2) NOT NULL,
   UserName VARCHAR2(20) NOT NULL,
   Password VARCHAR2(20) NOT NULL,
   Name VARCHAR2(25) NOT NULL,
   Department VARCHAR2(2) NOT NULL,
   Manager VARCHAR(1) NOT NULL,
   CONSTRAINT EmployeeID_PK 
        PRIMARY KEY(EmployeeID)
);

--Had to stick with plural form, because order
--is reserved keyword and I couldn't think of anything else
CREATE TABLE Orders 
(
    OrderID NUMBER(3) NOT NULL,
    EmployeeID NUMBER(2) NOT NULL,
    OrderDate DATE NOT NULL,
    Status VARCHAR(3) NOT NULL,
    CONSTRAINT OrderID_PK 
        PRIMARY KEY(OrderID)
);

CREATE TABLE OrderItem
(
    OrderID NUMBER(3) NOT NULL,
    ProductID VARCHAR2(10) NOT NULL,
    Quantity NUMBER(3) NOT NULL,
    CONSTRAINT OrderID_ProductID_PK 
        PRIMARY KEY(OrderID, ProductID)  
);

CREATE TABLE Category
(
    CatID NUMBER(2) NOT NULL,
    Name VARCHAR2(80) NOT NULL,
    Descript VARCHAR2(255) NULL,
    CONSTRAINT CatID_PK 
        PRIMARY KEY(CatID)
);

CREATE TABLE Product
(
    ProductID VARCHAR(10) NOT NULL,
    CatID NUMBER(2) NOT NULL,
    Name VARCHAR2(80) NULL,
    Descript VARCHAR2(255),
    UnitCost NUMBER(6, 2) NULL,
    SuppID NUMBER(2) NOT NULL,
    CONSTRAINT ProductID_PK 
        PRIMARY KEY (ProductID)
);
    
CREATE TABLE Supplier
(
    SuppID NUMBER(2) NOT NULL,
    Name VARCHAR2(80) NOT NULL,
    CONSTRAINT SuppID_PK
        PRIMARY KEY(SuppID)
);

-- 2.2 Creating Relationships --
-- Added Foreign Key constraint for Orders
ALTER TABLE Orders
ADD CONSTRAINT EmployeeID_FK
        FOREIGN KEY(EmployeeID)
        REFERENCES Employee(EmployeeID);
        
-- Added Foreign Key constraints for OrderItem
ALTER TABLE OrderItem
ADD CONSTRAINT OrderItem_FK
        FOREIGN KEY(OrderID)
        REFERENCES Orders(OrderID);  
        
ALTER TABLE OrderItem
ADD CONSTRAINT ProductID_FK
        FOREIGN KEY(ProductID)
        REFERENCES Product(ProductID);
        
-- Added Foreign Key constraints for Product      
ALTER TABLE Product
ADD CONSTRAINT CatID_FK
        FOREIGN KEY(CatID)
        REFERENCES Category(CatID);
        
ALTER TABLE Product
ADD CONSTRAINT SuppID_FK
        FOREIGN KEY(SuppID)
        REFERENCES Supplier(SuppID);
--------------------------------------------------------------
-- Populating newly created tables in preparation for 3.0 --

-- Added data to Employee Table
INSERT INTO Employee(EmployeeID, Username, Password,
                     Department, Manager)
VALUES(1, 'dclark', 'drc', 'HR', 'N');
INSERT INTO Employee(EmployeeID, Username, Password,
                     Department, Manager)
VALUES(2, 'jsmith', 'js', 'IT', 'Y');
INSERT INTO Employee(EmployeeID, Username, Password,
                     Department, Manager)
VALUES(3, 'mjones', 'mj', 'HR', 'Y');
INSERT INTO Employee(EmployeeID, Username, Password,
                     Department, Manager)
VALUES(4, 'klink', 'kl', 'IT', 'N');

-- Add data to the Category Table --
INSERT INTO Category(CatID, Name)
VALUES(1, 'Audio Visual');
INSERT INTO Category(CatID, Name)
VALUES(2, 'Art Supplies');
INSERT INTO Category(CatID, Name)
VALUES(3, 'Cleaning Supplies');
INSERT INTO Category(CatID, Name)
VALUES(4, 'Computer Supplies');
INSERT INTO Category(CatID, Name)
VALUES(5, 'Desk Accessories');
INSERT INTO Category(CatID, Name)
VALUES(6, 'Writing Supplies');
INSERT INTO Category(CatID, Name)
VALUES(7, 'Printer Supplies');

-- Add data to the Supplier Table --
INSERT INTO Supplier(SuppID, Name)
VALUES(1, 'XYZ Office Supplies');

INSERT INTO Supplier(SuppID, Name)
VALUES(2, 'ABC Office Products');

-- Added data to Product table
-- Used VARCHAR2 vs the listed NUMBER datatyps in 2.1 for
-- the ProductID
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('ACM-10414', 2, 'Ruler', '12 inch stainless steel', 3.79, 2);
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('APO-CG7070', 1, 'Transparency', 'Quick dry ink jet', 24.49, 1);
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('APO-FXL', 1, 'Overhead Bulb', 'High intensity replacement bulb', 12.00, 1);
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('APO-MP1200', 1, 'Laser Pointer', 'General purpose laser pointer', 29.99, 2);
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('BIN-68401', 2, 'Colored Pencils', 'Non toxic 12 pack', 2.84, 1);
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('DRA-91249', 3, 'All-Purpose Cleaner', 'Use on all washable surfaces', 4.29, 2);
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('FOH-28124', 3, 'Paper Hand Towels', '320 sheets per roll', 5.25, 1);
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('IMN-41143', 4, 'CD-R', '700mb with jewel case',1.09, 1);
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('IMN-44766', 4, '3.5 inch Disks', 'High Density Formatted Box of 10', 5.99, 1);
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('KMW-12164', 4, 'Monitor Wipes', 'Non abrasive lint free', 6.99, 2);
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('KMW-22256', 4, 'Dust Blaster', 'Ozone safe no CFCs', 8.99, 2);
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('MMM-6200', 2, 'Clear Tape', '1 inch wide 6 rolls', 3.90, 1);
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('MMM-9700P', 1, 'Overhead Projector', 'Portable with travel cover', 759.97, 1);
INSERT INTO Product(ProductID, CatID, Name, Descript, UnitCost, SuppID)
VALUES('OIC-5000', 2, 'Glue Stick', 'Oderless non toxic', 1.99, 2);

-- Add data to the Order Table -- 
INSERT INTO Orders(OrderID, EmployeeID, OrderDate, Status) 
VALUES(12, 2, '12/JAN/09', 'Done');
INSERT INTO Orders(OrderID, EmployeeID, OrderDate, Status) 
VALUES(34, 2, '22/JUL/10', 'Done');
INSERT INTO Orders(OrderID, EmployeeID, OrderDate, Status) 
VALUES(2, 1, '01/FEB/06', 'Done');
INSERT INTO Orders(OrderID, EmployeeID, OrderDate, Status) 
VALUES(67, 4, '23/OCT/13', 'Done');
INSERT INTO Orders(OrderID, EmployeeID, OrderDate, Status) 
VALUES(77, 3, '04/NOV/14', 'Done');
INSERT INTO Orders(OrderID, EmployeeID, OrderDate, Status) 
VALUES(14, 3, '12/MAY/09', 'Done');
INSERT INTO Orders(OrderID, EmployeeID, OrderDate, Status) 
VALUES(200, 2, '22/DEC/16', 'Done');
INSERT INTO Orders(OrderID, EmployeeID, OrderDate, Status) 
VALUES(455, 2, '01/APR/18', 'Transit');
INSERT INTO Orders(OrderID, EmployeeID, OrderDate, Status) 
VALUES(130, 1, '12/OCT/15', 'Done');
INSERT INTO Orders(OrderID, EmployeeID, OrderDate, Status) 
VALUES(456, 1, '03/APR/18', 'Transit');

-- Add data to the OrderItem Table --
INSERT INTO OrderItem(OrderID, ProductID, Quantity) 
VALUES(12, 'ACM-10414', 50);
INSERT INTO OrderItem(OrderID, ProductID, Quantity) 
VALUES(34, 'APO-CG7070', 10);
INSERT INTO OrderItem(OrderID, ProductID, Quantity) 
VALUES(2, 'APO-FXL', 250);
INSERT INTO OrderItem(OrderID, ProductID, Quantity) 
VALUES(67, 'APO-MP1200', 354);
INSERT INTO OrderItem(OrderID, ProductID, Quantity) 
VALUES(77, 'OIC-5000', 765);
INSERT INTO OrderItem(OrderID, ProductID, Quantity) 
VALUES(12, 'MMM-620', 12);
INSERT INTO OrderItem(OrderID, ProductID, Quantity) 
VALUES(14, 'KMW-12164', 43);
INSERT INTO OrderItem(OrderID, ProductID, Quantity) 
VALUES(200, 'KMW-12164', 3);
INSERT INTO OrderItem(OrderID, ProductID, Quantity) 
VALUES(455, 'APO-FXL', 83);
INSERT INTO OrderItem(OrderID, ProductID, Quantity) 
VALUES(130, 'APO-CG7070', 1);
INSERT INTO OrderItem(OrderID, ProductID, Quantity) 
VALUES(456, 'KMW-22256', 11);

-- 3.1 SELECT --
SELECT *
FROM Employee;

SELECT *
FROM Employee
WHERE Department = 'HR';

SELECT *
FROM Employee
WHERE Username = 'jsmith' AND Department = 'HR';

SELECT *
FROM Employee
WHERE Manager = 'Y' OR Department = 'HR';

-- 3.2 --
SELECT Name
FROM Product
ORDER BY Name;

SELECT Name
FROM Product
ORDER BY Name DESC;

SELECT *
FROM Category
ORDER BY Name;

-- 3.3 INSERT INTO --
INSERT INTO Employee(EmployeeID, Username, Password,
                     Department, Manager)
VALUES(5, 'retro23', 'brown', 'IT', 'N');

INSERT INTO Category(CatID, Name)
VALUES(8, 'Food');

INSERT INTO Supplier(SuppID, Name)
VALUES(3, 'PJs Groceries');
INSERT INTO Supplier(SuppID, Name)
VALUES(4, 'Revature');
INSERT INTO Supplier(SuppID, Name)
VALUES(5, 'Mi Casa');

-- 3.4 UPDATE --
UPDATE Product
SET UnitCost = 2.00
WHERE Name = 'Ruler';

UPDATE Category
SET Descript = 'Comp cleam'
WHERE CatID = 3;

UPDATE Category
SET Descript = 'Clean it up'
WHERE CatID = 4;

-- 3.5 LIKE --
SELECT Username
FROM Employee
WHERE Username LIKE '%j%';

SELECT name
FROM Product
WHERE name LIKE '%O%';

-- 3.6 BETWEEN --
SELECT name
FROM Product
Where UnitCost BETWEEN 3 AND 10;

SELECT name
FROM Product
Where UnitCost BETWEEN 500 AND 800;

-- 3.7 DELETE --
DELETE FROM Product -- Have to delete first due to constraint
WHERE CatID = 1;

DELETE FROM Category
WHERE name = 'Audio Visual';

DELETE FROM Supplier
WHERE SuppID IN (3, 4, 5);

-- 8.0 Joins --
----------------------------------------------

-- 8.1 INNER JOIN --
SELECT *
FROM Product 
JOIN Category ON Product.CatID = Category.CatID;

SELECT *
FROM Employee 
JOIN Orders ON Employee.EmployeeID = Orders.EmployeeID;

-- 8.2 OUTER JOIN --
SELECT *
FROM Product
FULL OUTER JOIN OrderItem ON Product.ProductID = OrderItem.ProductID;

SELECT *
FROM Employee
FULL OUTER JOIN Orders ON Employee.EmployeeID = Orders.EmployeeID;

-- 8.3 RIGHT JOIN --
SELECT *
FROM Orders 
RIGHT JOIN OrderItem ON Orders.OrderID = OrderItem.OrderID;

SELECT *
FROM Product 
RIGHT JOIN OrderItem ON Product.ProductID = OrderItem.ProductID;

-- 8.4 LEFT JOIN --
SELECT *
FROM Product 
LEFT JOIN Category ON Product.CatID = Category.CatID;

SELECT *
FROM Employee 
LEFT JOIN Orders ON Employee.EmployeeID = Orders.EmployeeID;

-- 8.5 CROSS JOIN --
SELECT *
FROM Product
CROSS JOIN Category;

-- 8.6 SELF-JOIN --
SELECT Emp1.Username, Emp2.Username
FROM Employee Emp1, Employee Emp2
WHERE Emp1.Username = Emp2.Username AND Emp1.Manager = Emp2.Manager;

------------------------------------------------------------------------------------
-- 9.0 Views --
ALTER TABLE Employee
ADD SSN VARCHAR2(10);

CREATE VIEW VW_PROD_DESCRIPT(Produc
