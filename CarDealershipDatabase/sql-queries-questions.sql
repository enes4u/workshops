USE CarDealershipDatabase;

-- 1. Get all dealerships
SELECT * FROM dealerships;
SELECT * FROM vehicles;
SELECT * FROM sales_contracts;


-- 2. Find all vehicles for a specific dealership
SELECT v.* FROM vehicles v
JOIN inventory i ON v.VIN = i.VIN
WHERE i.dealership_id = 2;

-- 3. Find a car by VIN
SELECT * FROM vehicles WHERE VIN = '1HGCM82633A123456';

-- 4. Find the dealership where a certain car is located, by VIN
SELECT d.name, d.address FROM dealerships d
JOIN inventory i ON d.dealership_id = i.dealership_id
WHERE i.VIN = '1HGCM82633A123456';

-- 5. Find all Dealerships that have a certain car type (i.e. Red Ford Mustang)
SELECT d.name, d.address, v.VIN, v.make, v.model FROM dealerships d
JOIN inventory i ON d.dealership_id = i.dealership_id
JOIN vehicles v ON i.VIN = v.VIN
WHERE v.make = 'Ford' AND v.model = 'Mustang' AND v.color = 'Red';


-- 6. Get all sales information for a specific dealer for a specific date range
SELECT * FROM sales_contracts 
WHERE dealership_id = 2 AND sale_date BETWEEN '2025-06-01' AND '2025-06-30';
-- lease contracts 
SELECT * FROM lease_contracts 
WHERE dealership_id = 2 AND lease_start BETWEEN '2024-06-01' AND '2025-06-30';