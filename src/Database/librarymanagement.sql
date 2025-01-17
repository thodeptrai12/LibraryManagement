-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307:3307
-- Generation Time: Jan 17, 2025 at 07:46 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `librarymanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `BookID` varchar(50) NOT NULL,
  `BookName` varchar(50) NOT NULL,
  `category` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`BookID`, `BookName`, `category`, `author`) VALUES
('0', '0', '0', '0'),
('1', 'The Great Gatsby', 'Fiction', 'F. Scott Fitzgerald'),
('10', 'Crime and Punishment', 'Philosophical', 'Fyodor Dostoevsky'),
('11', 'Brave New World', 'Science Fiction', 'Aldous Huxley'),
('12', 'The Alchemist', 'Adventure', 'Paulo Coelho'),
('13', 'Harry Potter and the Philosopher\'s Stone', 'Fantasy', 'J.K. Rowling'),
('14', 'The Da Vinci Code', 'Mystery', 'Dan Brown'),
('15', 'The Hunger Games', 'Dystopian', 'Suzanne Collins'),
('16', 'Jane Eyre', 'Romance', 'Charlotte Brontë'),
('17', 'The Lord of the Rings', 'Fantasy', 'J.R.R. Tolkien'),
('18', 'The Kite Runner', 'Drama', 'Khaled Hosseini'),
('19', 'A Game of Thrones', 'Fantasy', 'George R.R. Martin'),
('2', 'To Kill a Mockingbird', 'Fiction', 'Harper Lee'),
('20', 'The Fault in Our Stars', 'Romance', 'John Green'),
('3', '1984', 'Dystopian', 'George Orwell'),
('39', '1985', 'Dystopian', 'George Orwell'),
('4', 'Pride and Prejudice', 'Romance', 'Jane Austen'),
('41', '1986', 'Dystopian', 'George Orwell'),
('5', 'The Catcher in the Rye', 'Fiction', 'J.D. Salinger'),
('6', 'The Hobbit', 'Fantasy', 'J.R.R. Tolkien'),
('7', 'Moby Dick', 'Adventure', 'Herman Melville'),
('8', 'War and Peace', 'Historical', 'Leo Tolstoy'),
('9', 'The Odyssey', 'Epic', 'Homer');

-- --------------------------------------------------------

--
-- Table structure for table `borrow`
--

CREATE TABLE `borrow` (
  `StudentID` varchar(50) NOT NULL,
  `BookID` varchar(50) NOT NULL,
  `BorrowDate` datetime NOT NULL,
  `ReturnDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrow`
--

INSERT INTO `borrow` (`StudentID`, `BookID`, `BorrowDate`, `ReturnDate`) VALUES
('24IT2001', '1', '2025-01-02 00:00:00', '2025-01-09 00:00:00'),
('24IT2001', '3', '2025-01-02 00:00:00', '2025-01-09 00:00:00'),
('24IT2001', '4', '2025-01-16 00:00:00', '2025-01-09 00:00:00'),
('24IT2001', '5', '2025-01-16 00:00:00', '2025-01-09 00:00:00'),
('24IT2002', '11', '2025-01-10 00:00:00', '2025-01-14 00:00:00'),
('24IT2003', '3', '2025-01-03 00:00:00', '2025-01-12 00:00:00'),
('24IT2003', '5', '2025-01-04 00:00:00', '2025-01-13 00:00:00'),
('24IT2003', '9', '2025-01-08 00:00:00', '2025-01-17 00:00:00'),
('24IT2005', '9', '2025-01-10 00:00:00', '2025-01-11 00:00:00'),
('24IT2006', '11', '2025-01-09 00:00:00', '2025-01-10 00:00:00'),
('24IT2007', '8', '2025-01-08 00:00:00', '2025-01-17 00:00:00'),
('24IT2008', '11', '2025-01-10 00:00:00', '2025-01-14 00:00:00'),
('24IT2009', '11', '2025-01-10 00:00:00', '2025-01-17 00:00:00'),
('24IT2009', '8', '2025-01-09 00:00:00', '2025-01-09 00:00:00'),
('24IT2009', '9', '2025-01-09 00:00:00', '2025-01-18 00:00:00'),
('24IT2010', '10', '2025-01-10 00:00:00', '2025-01-12 00:00:00'),
('24IT2011', '11', '2025-01-11 00:00:00', '2025-01-20 00:00:00'),
('24IT2011', '12', '2025-01-11 00:00:00', '2025-01-20 00:00:00'),
('24IT2012', '12', '2025-01-12 00:00:00', '2025-01-21 00:00:00'),
('24IT2013', '13', '2025-01-13 00:00:00', '2025-01-22 00:00:00'),
('24IT2013', '16', '2025-01-12 00:00:00', '2025-01-21 00:00:00'),
('24IT2013', '6', '2025-01-08 00:09:39', '2025-01-09 00:09:40'),
('24IT2014', '14', '2025-01-14 00:00:00', '2025-01-23 00:00:00'),
('24IT2014', '16', '2025-01-09 00:48:41', '2025-01-10 00:48:43'),
('24IT2016', '1', '2025-01-16 00:00:00', '2025-01-25 00:00:00'),
('24IT2016', '10', '2025-01-16 00:00:00', '2025-01-25 00:00:00'),
('24IT2016', '11', '2025-01-09 00:00:00', '2025-01-12 00:00:00'),
('24IT2016', '12', '2025-01-16 00:00:00', '2025-01-25 00:00:00'),
('24IT2016', '13', '2025-01-16 00:00:00', '2025-01-25 00:00:00'),
('24IT2016', '14', '2025-01-16 00:00:00', '2025-01-25 00:00:00'),
('24IT2016', '16', '2025-01-16 00:00:00', '2025-01-25 00:00:00'),
('24IT2016', '3', '2025-01-16 00:00:00', '2025-01-25 00:00:00'),
('24IT2016', '4', '2025-01-09 00:00:00', '2025-01-17 00:00:00');

--
-- Triggers `borrow`
--
DELIMITER $$
CREATE TRIGGER `calculate_fine_new` BEFORE INSERT ON `borrow` FOR EACH ROW BEGIN
    -- Kiểm tra ngày trả
    IF NEW.ReturnDate IS NOT NULL AND NEW.ReturnDate < CURDATE() THEN
        SET NEW.Fine = DATEDIFF(CURDATE(), NEW.ReturnDate) * 1000;
    ELSE
        SET NEW.Fine = 0;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StudentID` varchar(50) NOT NULL,
  `StudentName` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`StudentID`, `StudentName`, `Address`, `Phone`) VALUES
('24IT2001', 'Nguyen Van A', '123 Le Loi, Da Nang', '0912345678'),
('24IT2002', 'Tran Thi B', '456 Hai Ba Trung, Ha Noi', '0987654321'),
('24IT2003', 'Le Van C', '789 Tran Phu, Ho Chi Minh', '0901122334'),
('24IT2004', 'Pham Thi D', '321 Ngo Gia Tu, Da Nang', '0934567890'),
('24IT2005', 'Do Van E', '654 Le Duan, Hue', '0976543210'),
('24IT2006', 'Hoang Thi F', '987 Nguyen Trai, Can Tho', '0945678901'),
('24IT2007', 'Vu Van G', '345 Tran Hung Dao, Nha Trang', '0923456789'),
('24IT2008', 'Bui Thi H', '678 Ly Thuong Kiet, Da Lat', '0967890123'),
('24IT2009', 'Tran Van I', '123 Phan Chau Trinh, Quang Nam', '0911223344'),
('24IT2010', 'Ngo Thi K', '456 Nguyen Hue, Quang Binh', '0988112233'),
('24IT2011', 'Phan Van L', '789 Bach Dang, Ha Long', '0909988776'),
('24IT2012', 'Vu Thi M', '321 Hoang Van Thu, Hai Phong', '0933221100'),
('24IT2013', 'Dang Van N', '654 Tran Quoc Toan, Thanh Hoa', '0977334455'),
('24IT2014', 'Le Thi O', '987 Hai Ba Trung, Binh Dinh', '0944455667'),
('24IT2015', 'Nguyen Van P', '345 Pham Van Dong, Quang Tri', '0925566778'),
('24IT2016', 'Tran Thi Q', '678 Ly Thai To, Binh Duong', '0966677889'),
('24IT2017', 'Pham Van R', '123 Nguyen Van Cu, Long An', '0912349988'),
('24IT2018', 'Hoang Thi S', '456 Tran Quang Khai, Vinh Long', '0987678899'),
('24IT2019', 'Do Van T', '789 Phan Van Hon, An Giang', '0901122335'),
('24IT2023', 'Bui Thi U', '321 Tran Cao Van, Soc Trang', '0934567891');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`BookID`);

--
-- Indexes for table `borrow`
--
ALTER TABLE `borrow`
  ADD PRIMARY KEY (`StudentID`,`BookID`),
  ADD KEY `FK_bookID` (`BookID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StudentID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `borrow`
--
ALTER TABLE `borrow`
  ADD CONSTRAINT `FK_bookID` FOREIGN KEY (`BookID`) REFERENCES `book` (`BookID`),
  ADD CONSTRAINT `FKstudentID` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
