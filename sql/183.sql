SELECT Name AS Customers FROM Customers
WHERE Id not IN (SELECT CustomerID FROM Orders)
