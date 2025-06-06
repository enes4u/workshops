USE CarDealershipDatabase;
INSERT INTO dealerships (name, address, phone) VALUES 
('AutoMax', '123 Main St, Carnegie PA', '555-1234'),
('Speedy Cars', '456 Elm St, Pittsburgh PA', '555-5678');

INSERT INTO vehicles (VIN, make, model, year, color, price, SOLD) VALUES 
('1HGCM82633A123456', 'Honda', 'Civic', 2023, 'Red', 22000.00, FALSE),
('2T3ZF4DVXBW123456', 'Toyota', 'RAV4', 2022, 'Blue', 28000.00, TRUE),
('1FA6P8TH2L5100001', 'Ford', 'Mustang', 2024, 'Red', 36000.00, FALSE),
('2HGFC2F68NH000002', 'Honda', 'Civic', 2023, 'Blue', 23000.00, FALSE),
('3HGCM82633A000003', 'Honda', 'Accord', 2022, 'Black', 27000.00, TRUE),
('5TDBZRFH3LS000004', 'Toyota', 'Highlander', 2024, 'White', 41000.00, FALSE),
('JTMZFREV9JD000005', 'Toyota', 'RAV4', 2023, 'Silver', 29000.00, FALSE),
('4T1BF1FKXHU000006', 'Toyota', 'Camry', 2022, 'Red', 28000.00, TRUE),
('1HGCV1F34NA000007', 'Honda', 'Accord', 2024, 'White', 30000.00, FALSE),
('5YFBURHE4LP000008', 'Toyota', 'Corolla', 2023, 'Blue', 24000.00, FALSE),
('JHMCF1F71CX000009', 'Honda', 'Insight', 2022, 'Silver', 26000.00, TRUE),
('2T3ZF4DVXBW000010', 'Toyota', 'RAV4', 2022, 'Gray', 27500.00, FALSE);


INSERT INTO inventory (dealership_id, VIN) VALUES 
(1, '1HGCM82633A123456'),
(2, '2T3ZF4DVXBW123456'),
(1, '1FA6P8TH2L5100001'),
(2, '2HGFC2F68NH000002'),
(1, '3HGCM82633A000003'),
(2, '5TDBZRFH3LS000004'),
(1, 'JTMZFREV9JD000005'),
(2, '4T1BF1FKXHU000006'),
(1, '1HGCV1F34NA000007'),
(2, '5TDBZRFH3LS000004'),
(1, 'JHMCF1F71CX000009'),
(2, '2T3ZF4DVXBW000010');

INSERT INTO sales_contracts (VIN, dealership_id, customer_name, sale_date, sale_price) VALUES 
('2T3ZF4DVXBW123456', 2, 'Topher Carter', '2025-06-01', 27000.00);

INSERT INTO sales_contracts (VIN, dealership_id, customer_name, sale_date, sale_price) VALUES 
('1FA6P8TH2L5100001', 1, 'Alice Johnson', '2025-06-02', 35000.00),
('2HGFC2F68NH000002', 2, 'Robert Smith', '2025-05-20', 22500.00),
('3HGCM82633A000003', 1, 'Michael Lee', '2025-04-18', 26500.00),
('5TDBZRFH3LS000004', 2, 'Sarah Kim', '2025-03-30', 40500.00),
('JTMZFREV9JD000005', 1, 'David Brown', '2025-06-05', 28500.00),
('4T1BF1FKXHU000006', 2, 'Emily Davis', '2025-06-10', 27500.00),
('1HGCV1F34NA000007', 1, 'Chris Wilson', '2025-05-15', 29500.00),
('5TDBZRFH3LS000004', 2, 'Jessica Martinez', '2025-04-01', 40000.00),
('JHMCF1F71CX000009', 1, 'Daniel Lopez', '2025-06-10', 26000.00);


