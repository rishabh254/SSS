-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 22, 2015 at 11:07 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sss`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE IF NOT EXISTS `author` (
  `SSS` varchar(4) NOT NULL,
  `AUTHOR_NAME` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='AUTHOR DETAILS';

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`SSS`, `AUTHOR_NAME`) VALUES
('', ''),
('LB01', 'H. G. Wells'),
('LB03', 'Shannon Delany'),
('LB02', 'Robert I. Rotberg'),
('LB03', 'Dennis Thompson'),
('LB04', 'Clayton Christensen'),
('LB07', 'David Pringle'),
('LB07', 'David Pringle'),
('LB08', 'Patricia Norfiction'),
('LB08', 'Patricia Norfiction'),
('LB09', 'Juvenile Nonficton'),
('LB10', 'George Brown Arfken'),
('LB11', 'Clifford A. Pickover'),
('LB12', ' P. Gnädig, G. Honyek, K. F. Riley'),
('LB13', ' Roselyn Teukolsky'),
('LB14', 'Narsingh Deo'),
('LB15', 'Benjamin Wells, Research and Education Association'),
('LB16', 'S. Trymbaka Murthy'),
('LB17', 'Karl-Heinrich Grote, Erik K. Antonsson'),
('LB18', 'R. S. Sirohi, H. C. Radha Krishna'),
('LB21', 'M. A. Laughton, D.F. Warne'),
('LB22', 'K.N. Srinivas'),
('LB23', 'Richard C. Dorf, Ronald J. Tallarida'),
('LB24', 'Richard C. Dorf'),
('LB25', 'Rajendra Prasad'),
('LB26', 'M. S. Naidu, S. Kamakshaiah'),
('LB27', 'Technical Teachers'' Training Institute, Madras'),
('LB28', 'Arun G. Phadke'),
('LB29', 'Lyle Albright'),
('LB30', 'S. PUSHPAVANAM'),
('LB31', 'Tyler Hicks, S. David Hicks'),
('LB32', 'Dr. B.C. Punmia, Ashok Kumar Jain, Arun Kr. Jain'),
('LB33', '	P. K. Mishra'),
('LB34', 'Ray Bradley'),
('LB36', 'Maria Litvin, Gary Litvin'),
('LB37', 'Ernest C. Ackermann'),
('LB37', 'Ernest C. Ackermann'),
('LB38', 'Behrouz A. Forouzan, Firouz Mosharraf'),
('LB39', 'Ralf Kories, Heinz Schmidt-Walter'),
('LB40', 'Richard C. Dorf'),
('LB41', 'Dr S K Bhattacharya'),
('LB42', 'Rajendra Prasad'),
('LB43', 'Lincoln D. Jones'),
('LB44', 'Roman Malari?'),
('LB45', 'K. N. Srinivas'),
('LB46', 'Frank Kreith, William F. Ames, George Cain, Y. L. Tong, W. Glenn Steele, Hugh W. Coleman, Richard L.'),
('LB47', 'Max Fogiel'),
('LB48', 'Michael R. Lindeburg'),
('LB49', 'T. S. Rajan'),
('LB49', 'J. Edward Pope'),
('LB50', 'Frank Kreith, William F. Ames, George Cain, Y. L. Tong, W. Glenn Steele, Hugh W. Coleman, Richard L.'),
('LB51', 'Frank Kreith, William F. Ames, George Cain, Y. L. Tong, W. Glenn Steele, Hugh W. Coleman, Richard L.'),
('LB52', 'Max Fogiel'),
('LB53', 'A. D. Johnson, Keith Sherwin'),
('LB53', 'Michael R. Lindeburg'),
('LB55', 'Devendra Vashist');

-- --------------------------------------------------------

--
-- Table structure for table `bsell`
--

CREATE TABLE IF NOT EXISTS `bsell` (
  `SSS` varchar(4) NOT NULL,
  `SELLER_NAME` varchar(30) NOT NULL,
  `PHONE_NO` int(10) unsigned NOT NULL,
  `PRICE` int(6) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Selling Book Details';

-- --------------------------------------------------------

--
-- Table structure for table `ebook`
--

CREATE TABLE IF NOT EXISTS `ebook` (
  `SSS` varchar(4) NOT NULL,
  `SYMBOL` varchar(2) NOT NULL,
  `NUM_DOWN` int(5) unsigned zerofill NOT NULL,
  `D_LINK` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Ebook details';

--
-- Dumping data for table `ebook`
--

INSERT INTO `ebook` (`SSS`, `SYMBOL`, `NUM_DOWN`, `D_LINK`) VALUES
('EB01', 'EB', 00000, 'http://www.google.com');

-- --------------------------------------------------------

--
-- Table structure for table `i_details`
--

CREATE TABLE IF NOT EXISTS `i_details` (
  `ROLL_NUM` varchar(9) NOT NULL,
  `SSS` varchar(4) NOT NULL,
  `ISSUE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `RETURN_DATE` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='ISSUED BOOKS DETAILS';

--
-- Dumping data for table `i_details`
--

INSERT INTO `i_details` (`ROLL_NUM`, `SSS`, `ISSUE_DATE`, `RETURN_DATE`) VALUES
('1301cs55', 'LB01', '2015-03-04 09:05:47', NULL),
('1301cs52', 'LB01', '2015-03-04 09:06:06', NULL),
('1301cs43', 'LB01', '2015-03-04 09:07:04', NULL),
('1301cs55', 'LB02', '2015-03-04 09:07:22', NULL),
('1301cs52', 'LB02', '2015-03-04 09:07:44', NULL),
('1301cs52', 'LB03', '2015-03-04 09:08:20', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `lbook`
--

CREATE TABLE IF NOT EXISTS `lbook` (
  `SSS` varchar(4) NOT NULL,
  `SYMBOL` varchar(2) NOT NULL,
  `NUM_COPIES` int(3) unsigned NOT NULL,
  `NUM_ISSUED` int(3) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='LIBRARY BOOKS DETAILS';

--
-- Dumping data for table `lbook`
--

INSERT INTO `lbook` (`SSS`, `SYMBOL`, `NUM_COPIES`, `NUM_ISSUED`) VALUES
('LB01', 'LB', 50, 3),
('LB02', 'LB', 65, 2),
('LB03', 'LB', 30, 1);

-- --------------------------------------------------------

--
-- Table structure for table `main`
--

CREATE TABLE IF NOT EXISTS `main` (
  `SSS` varchar(4) NOT NULL,
  `SYMBOL` varchar(2) NOT NULL,
  `BOOK_NAME` varchar(150) NOT NULL,
  `EDITION` int(2) unsigned DEFAULT NULL,
  `ISBN` varchar(20) DEFAULT NULL,
  `SUBJECT` varchar(50) NOT NULL,
  `ADDITION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LANGUAGE` varchar(10) DEFAULT 'ENGLISH',
  `DESCRIPTION` varchar(2000) NOT NULL,
  `LENGTH` varchar(20) DEFAULT NULL,
  `PHOTO` varchar(1000) DEFAULT 'NOT AVAILABLE',
  `RATINGS` int(2) unsigned zerofill NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='MAIN TABLE DESCRIPTION';

--
-- Dumping data for table `main`
--

INSERT INTO `main` (`SSS`, `SYMBOL`, `BOOK_NAME`, `EDITION`, `ISBN`, `SUBJECT`, `ADDITION_DATE`, `LANGUAGE`, `DESCRIPTION`, `LENGTH`, `PHOTO`, `RATINGS`) VALUES
('LB01', 'LB', 'The Time Machine', NULL, '978-1936041459', 'Fiction', '2015-03-18 16:28:51', 'ENGLISH', 'The Time Traveller, a dreamer obsessed with traveling through time, builds himself a time machine and, much to his surprise, travels over 800,000 years into the future. He lands in the year 802701: th', NULL, 'http://10.0.3.2/Thetimemachine.jpg', 03),
('LB02', 'LB', 'Beasts and BFFs', 1, '1429990856', 'Fiction', '2015-03-18 16:31:03', 'ENGLISH', 'Meet Jessie Gillmansen as she realizes that things might not be what they seem in the town of Junction. All Jessie wants is to avoid more change … but she has no idea what’s about to come her way.', NULL, 'http://10.0.3.2/BeastsandBFFs.jpg', 03),
('LB03', 'LB', 'Truth v. Justice: The Morality of Truth Commission', 1, '1400832039', 'Political Science', '2015-03-18 16:32:00', 'ENGLISH', 'The truth commission is an increasingly common fixture of newly democratic states with repressive or strife-ridden pasts. From South Africa to Haiti, truth commissions are at work with varying degrees of support and success. To many, they are the best--or only--way to achieve a full accounting of crimes committed against fellow citizens and to prevent future conflict. ', NULL, 'http://10.0.3.2/Truthv.Justice:The MoralityofTruthCommission.jpg', 03),
('LB04', 'LB', 'The Innovator''s Dilemma: When New Technologies Cause Great Firms to Fail', 1, '142219602X', 'Business & Economics', '2015-03-18 16:34:34', 'ENGLISH', 'An innovation classic. From Steve Jobs to Jeff Bezos, Clay Christensen’s work continues to underpin today’s most innovative leaders and organizations', '288 pages', 'http://10.0.3.2/TheInnovator''sDilemma.jpg', 04),
('LB06', 'LB', 'Srimad Bhagvad Gita', 3, '123456789', 'God prayer', '2015-03-18 16:59:18', 'ENGLISH', 'God - people relation', '800', 'http://10.0.3.2/SrimadBhagvadGita.jpg', 05),
('LB07', 'LB', 'Science Fiction', 2, '0786704810, 97807867', 'Finction , General', '2015-03-18 16:35:06', 'ENGLISH', 'This guide will appeal to both newcomers and connoisseurs of the genre. Informative and readable, Pringle''s choices focus on landmarks by Ray Bradbury, Alfred Bester and J. G. Ballard, unearth such lesser known talents as Ian Watson, Octavia Butler and Joanna Russ, and highlights breakthrough novels by William Gibson and Philip K. Dick.', '224', 'http://10.0.3.2/ScienceFiction.jpg', 04),
('LB08', 'LB', 'Physics', NULL, '0748762434, 97807487', 'Science , Physics', '2015-03-18 16:35:55', 'ENGLISH', 'This third editions of Key Science: Physics has been revised to meet the requirements of all 2001 GCSE specifications. It is suitable for middle-ability students, but has material for higher achievers, including in-depth content for all Separate Science specifications. Topics are differentiated between core material for Double/Single science and extension material for the Separate sciences.', '369', 'http://10.0.3.2/Physics.jpg', 05),
('LB09', 'LB', 'Advanced Physics for You', NULL, '074875296X, 97807487', 'Science and Nature', '2015-03-18 10:05:05', 'ENGLISH', 'Advanced Physics for You has been carefully designed to be interesting and motivating to the student, with features that make it highly supportive of individual learning. Written by an experienced author team, with the same straightforward approach as the successful New for You GCSE series.', '432', 'http://10.0.3.2/AdvancedPhysicsforYou.jpg', 05),
('LB10', 'LB', 'Mathematical Methods for Physicists', NULL, '0123846544, 97801238', '  Science', '2015-03-18 16:37:13', 'ENGLISH', 'Now in its 7th edition, Mathematical Methods for Physicists continues to provide all the mathematical methods that aspiring scientists and engineers are likely to encounter as students and beginning researchers. This bestselling text provides mathematical relations and their proofs essential to the study of physics and related fields. While retaining the key features of the 6th edition, the new edition provides a more careful balance of explanation, theory, and examples.', '1207', 'http://10.0.3.2/MathematicalMethodsforPhysicists.jpg', 05),
('LB11', 'LB', 'The Physics Book', 3, '1402778619, 97814027', 'Science, Physics', '2015-03-18 16:37:52', 'ENGLISH', 'Following the hugely successful The Science Book and The Math Book comes a richly illustrated chronology of physics, containing 250 short, entertaining, and thought-provoking entries. In addition to exploring such engaging topics as dark energy, parallel universes, the Doppler effect, the God particle, and Maxwell''s demon, the book''s timeline extends back billions of years to the hypothetical Big Bang and forward trillions of years to a time of “quantum resurrection.', '527', 'http://10.0.3.2/ThePhysicsBook.jpg', 04),
('LB12', 'LB', '200 Puzzling Physics Problems', 4, '0521774802, 97805217', 'Science, Physics', '2015-03-18 16:38:42', 'ENGLISH', 'This text will strengthen a student''s ability to apply the laws of physics to practical situations and problems that yield more easily to intuitive insight than to complex mathematics. These problems, chosen almost exclusively from classical (non-quantum) physics, are posed in accessible nontechnical language and require the student to select the right framework in which to analyze the situation.', '257', 'http://10.0.3.2/200PuzzlingPhysicsProblems.jpg', 05),
('LB13', 'LB', 'Barron''s AP Computer Science A', 4, '0764143735, 97807641', 'Computers , Computer Science', '2015-03-18 16:39:27', 'ENGLISH', 'This best-selling review manual has been thoroughly updated to reflect the College BoardÂ''s elimination of the Level AB course and the updated Level A syllabus. The new edition presents three full-length AP practice exams for the Level A course. The first exam is a diagnostic test and contains charts detailing the topics for each question. All three model tests have questions answered and explained. ', '487', 'http://10.0.3.2/Barron''sAPComputerScienceA.jpg', 05),
('LB14', 'LB', 'Graph Theory with Applications to Engineering and Computer Science', 3, '8120301455, 97881203', 'Graph Theory', '2015-03-18 16:40:07', 'ENGLISH', 'Graph Theory with Applications to Engineering and Computer Science', '478', 'http://10.0.3.2/GraphTheory.jpg', 04),
('LB15', 'LB', 'GRE Computer Science Test', 5, '087891434X, 97808789', 'Computers', '2015-03-18 16:40:56', 'ENGLISH', 'Be prepared for the GRE Computer Science Test. Our savvy exam experts show you how to master the test and score higher. This completely revised and updated test prep contains a new full-length practice test derived from the latest GRE Computer Science tests.', '169', 'http://10.0.3.2/GREComputerScienceTest.jpg', 03),
('LB16', 'LB', 'Textbook of Elements of Mechanical Engineering', 5, '9380578571, 97893805', 'MECHANICAL FIELD', '2015-03-18 16:41:54', 'ENGLISH', 'Suitable for the students of mechanical engineering, this title features: step-by-step approach to help students understand and draw sketches through exhaustive descriptions using sketches and photographs; solutions to problems using common equations; inclusion of a large number of problems solved by different methods using sketches; and, more.', '300', 'http://10.0.3.2/TextbookofElementsofMechanicalEngineering.jpg', 05),
('LB17', 'LB', 'Mechanical Measurements', 3, '8122403832, 97881224', '', '2015-03-18 16:43:00', 'ENGLISH', 'Methods And Techniques Of Measurements Are Becoming Increasingly Important In Engineering In Recent Years Laboratory Programmes Have Been Modernized, Sophisticated Electronic Instrumentation Has Been Incorporated Into The Programme And Newer Techniques Have Been Developed. This Book Dwells On The Physical Aspects Of Measurement Techniques. For The Measurement To Be Meaningful, The Nature And Magnitude Of Error Should Be Known. ', '284', 'http://10.0.3.2/MechanicalMeasurements.jpg', 05),
('LB18', 'LB', 'Springer Handbook of Mechanical Engineering', 3, '3540491317, 97835404', 'Science, Machanics', '2015-03-18 16:43:55', 'ENGLISH', 'Mechanical Engineering is a professional engineering discipline which involves the application of principles of physics, design, manufacturing and maintenance of mechanical systems. It requires a solid understanding of the key concepts including mechanics, kinematics, thermodynamics and energy. Mechanical engineers use these principles and others in the design and analysis of automobiles, aircrafts, heating and cooling systems, industrial equipment and machinery. ', '580', 'http://10.0.3.2/SpringerHandbookofMechanicalEngineering.jpg', 04),
('LB19', 'LB', 'Hand Book Of Mechanical Engineering Terms', NULL, '8122408664, 97881224', '', '2015-03-18 16:44:47', 'ENGLISH', 'The Handbook Of Mechanical Engineering Terms Contains Short, Precise Definitions Of About Four Thousand Terms. These Terms Have Been Collected From Different Sources, Edited And Grouped Under Twenty Six Parts And Given Alphabetically Under Each Part For Easy Reference. The Book Will Be A Source Of Guidance And Help To The Students, Staff And Practising Engineers In Understanding And Updating The Subject Matter.', '380', 'http://10.0.3.2/HandBookOfMechanicalEngineeringTerms.jpg', 00),
('LB20', 'LB', 'No eBook available\r\n\r\n    PHI Learning Pvt. Ltd.\r\n    A1Books.co.in\r\n    Rediff Books\r\n    Flipkart\r\n    Infibeam\r\n    Find in a library\r\n    All sell', NULL, '8120325931, 97881203', '', '2015-03-18 16:45:52', 'ENGLISH', '', '404', 'http://10.0.3.2/NoeBookavailable.jpg', 00),
('LB21', 'LB', 'Electrical Engineer''s Reference Book', 16, '0080523544, 97800805', 'Technology and Engineering, Power resources', '2015-03-18 16:47:07', 'ENGLISH', 'For ease of use, this edition has been divided into the following subject sections: general principles; materials and processes; control, power electronics and drives; environment; power generation; transmission and distribution; power systems; sectors of electricity use.\r\n\r\nNew chapters and major revisions include: industrial instrumentation; digital control systems; programmable controllers; electronic power conversion; environmental control; hazardous area technology; electromagnetic compatibility; alternative energy sources; alternating current generators; electromagnetic transients; power system planning; reactive power plant ', '1504', 'http://10.0.3.2/ElectricalEngineer''sReferenceBook.jpg', 05),
('LB22', 'LB', 'Basic Electrical Engineering', NULL, '8189866346, 97881898', 'Electricity', '2015-03-18 16:47:55', 'ENGLISH', 'The aim of this book is to provide a consolidated text for the first year B.E. Computer Science and Engineering students and B.Tech Information Technology students of Anna University. The syllabus has been thoroughly revised for the non-semester yearly pattern by the University. The book, made up of five chapters, systematically covers the five units of the syllabus. It begins with a detailed discussion on the fundamentals of electric circuits. DC circuits, AC circuits, 3-phase circuits, resonance and the network theorems. Lecture-type presentation of the rudiments of the fundamentals in conjunction with hundreds of solved examples is the strength of this book. Magnetic circuits and various magnetic elements and their properties.', '570', 'http://10.0.3.2/BasicElectricalEngineering.jpg', 04),
('LB23', 'LB', 'Pocket Book of Electrical Engineering Formulas', 2, '0849344735, 97808493', 'Technology and Engineering', '2015-03-18 16:48:55', 'ENGLISH', 'Pocket Book of Electrical Engineering Formulas provides key formulas used in practically all areas of electrical engineering and applied mathematics. This handy, pocket-sized guide has been organized by topic field to make finding information quick and easy. The book features an extensive index and is an excellent quick reference for electrical engineers, educators, and', '224', 'http://10.0.3.2/PocketBookofElectricalEngineeringFormulas.jpg', 04),
('LB24', 'LB', 'The Electrical Engineering Handbook,Second Edition', 2, '1420049763, 97814200', 'Technology and Engineering', '2015-03-18 16:50:32', 'ENGLISH', 'In 1993, the first edition of The Electrical Engineering Handbook set a new standard for breadth and depth of coverage in an engineering reference work. Now, this classic has been substantially revised and updated to include the latest information on all the important topics in electrical engineering today. Every electrical engineer should have an opportunity to expand his expertise with this definitive guide.\r\nIn a single volume, this handbook provides a complete reference to answer the questions encountered by practicing engineers in industry, government, or academia. This well-organized book is divided into 12 major sections that encompass the entire field of electrical ', '2752', 'http://10.0.3.2/TheElectricalEngineeringHandbook,SecondEdition.jpg', 05),
('LB25', 'LB', 'Fundamentals Of Electrical Engineering 2Nd Ed.', NULL, '8120339282, 97881203', '', '2015-03-18 16:51:29', 'ENGLISH', '', '904', 'http://10.0.3.2/FundamentalsOfElectricalEngineering2NdEd.jpg', 00),
('LB26', 'LB', 'Introduction to Electrical Engineering', NULL, '0074622927, 97800746', '', '2015-03-18 16:52:20', 'ENGLISH', 'The book presents a detailed exposition of the basic facets of electrical and electronics engineering. It begins with a general introduction to the basic concepts in electrical engineering and goes on to explain electrostatic fields and batteries. The basic concepts and techniques in circuit analysis are explained next. This followed by a detailed exposition of electric machines which includes discussion of transformers and synchronous motors. ', '740', 'http://10.0.3.2/IntroductiontoElectricalEngineering.jpg', 05),
('LB27', 'LB', 'Electrical Engineering Materials', NULL, '0074604201, 97800746', '', '2015-03-18 16:53:22', 'ENGLISH', '', '125', 'http://10.0.3.2/ElectricalEngineeringMaterials.jpg', 05),
('LB28', 'LB', 'Handbook of Electrical Engineering Calculations', NULL, '0824719557, 97808247', 'Technology and Engineering', '2015-03-18 16:54:17', 'ENGLISH', 'Written by experienced teachers and recognized experts in electrical engineering, Handbook of Electrical Engineering Calculations identifies and solves the seminal problems with numerical techniques for the principal branches of the field -- electric power, electromagnetic fields, signal analysis, communication systems, control systems, and computer engineering.', '336', 'http://10.0.3.2/HandbookofElectricalEngineeringCalculations.jpg', 00),
('LB29', 'LB', 'Albright''s Chemical Engineering Handbook', 3, '0824753623, 97808247', 'Science, chemistry', '2015-03-18 16:55:08', 'ENGLISH', 'Taking greater advantage of powerful computing capabilities over the last several years, the development of fundamental information and new models has led to major advances in nearly every aspect of chemical engineering. Albright’s Chemical Engineering Handbook represents a reliable source of updated methods, applications, and fundamental concepts that will continue to play a significant role in driving new research and improving plant design and operations. ', '928', 'http://10.0.3.2/Albright''sChemicalEngineeringHandbook.jpg', 00),
('LB30', 'LB', 'MATHEMATICAL METHODS IN CHEMICAL ENGINEERING ', NULL, '8120312627, 97881203', 'Science, chemistry', '2015-03-18 16:56:05', 'ENGLISH', 'This comprehensive, well organized and easy to read book presents concepts in a unified framework to establish a similarity in the methods of solutions and analysis of such diverse systems as algebraic equations, ordinary differential equations and partial differential equations. The distin-guishing feature of the book is the clear focus on analytical methods of solving equations. The text explains how the methods meant to elucidate linear problems can be extended to analyse nonlinear problems. The book also discusses in detail modern concepts like bifurcation theory and chaos.To attract engineering students to applied mathematics, the auth', '336', 'http://10.0.3.2/MATHEMATICALMETHODSINCHEMICALENGINEERING.jpg', 00),
('LB31', 'LB', 'Handbook of Civil Engineering Calculations, Second Edition', 3, '0071472932, 97800714', 'Technology & Engineering  ›  Civil  ›  General', '2015-03-18 16:57:06', 'ENGLISH', 'Covering all aspects of civil engineering calculations in an easy-to-understand format, the new edition of the Handbook of Civil Engineering Calculations is now revised and updated with over 500 key calculations that show you exactly how to compute the desired values for a particular design-going quickly from data to finished the result.', '840', 'http://10.0.3.2/HandbookofCivilEngineeringCalculations.jpg', 02),
('LB32', 'LB', 'Basic Civil Engineering', 3, '8170084032, 97881700', '', '2015-03-18 16:57:43', 'ENGLISH', '', '840', 'http://10.0.3.2/BasicCivilEngineering.jpg', 00),
('LB33', 'LB', 'Objective Civil Engineering', 4, '8174827986, 97881748', '', '2015-03-18 16:58:18', 'ENGLISH', '', '174', 'http://10.0.3.2/ObjectiveCivilEngineering.jpg', 04),
('LB34', 'LB', 'Understanding Computer Science for Advanced Level: The Study Guide', 0, '0748761470, 97807487', 'Computers  ›  Computer Science', '2015-03-18 19:00:04', 'ENGLISH', 'Provides concise coverage of Advanced Level Computer Science specifications. Organised in short ''bite-sized'' chapters to facilitate rapid learning, this book is also suitable as a main text for students taking one year AS Level course.', '300', 'http//10.0.3.2/UnderstandingComputerScienceforAdvancedLevel:TheStudyGuide.jpg', 01),
('LB35', 'LB', 'Computer Science With C++ Programming - Class Xi', NULL, '8170239591, 97881702', '', '2015-03-18 19:03:20', 'ENGLISH', 'The best book for introductory computer science.\r\nvery interesting and lucid style.\r\nclearly explained technical jargon.\r\nappropriate content.within the reach of students. ', NULL, 'http//10.0.3.2/ComputerScienceWithC++Programming.jpg', 04),
('LB36', 'LB', 'Be Prepared for the AP Computer Science Exam in Java', 3, '0982477503, 97809824', 'Computers  ›  Programming Languages  ›  Java', '2015-03-18 19:09:45', 'ENGLISH', 'AP Computer Science exam review book', '330', 'http//10.0.3.2/BePreparedfortheAPComputerScienceExaminJava.jpg', 04),
('LB37', 'LB', 'Foundations of Computer Science', 0, '1844807002, 97818448', 'Computers  ›  Computer Science', '2015-03-18 19:15:31', 'ENGLISH', 'Based on the ACM model curriculum guidelines, this easy-to-read and easy-to-navigate text covers all the fundamentals of computer science required for first year students embarking on a computing degree. Divided into five parts – computer and data, computer hardware, computer software, data organization and with an introduction to some of the more advanced topics – Foundations of Computer Science gives students a bird’s', '424', 'http//10.0.3.2/FoundationsofComputerScience.jpg', 04),
('LB38', 'LB', 'Basic Circuit Analysis for Electrical Engineering', NULL, 'illustrated', 'Technology & Engineering  ›  General', '2015-03-21 07:17:49', 'ENGLISH', 'This volume offers basic circuit analysis for electrical engineering. It covers basic concepts and useful mathematical concepts, and includes self-evaluation exercises.', '240', 'http://10.0.3.2/BasicCircuitAnalysisforElectricalEngineering.jpg', 01),
('LB39', 'LB', 'Electrical Engineering: A Pocket Reference', 0, '354043965X, 97835404', 'Technology & Engineering  ›  Electrical', '2015-03-21 07:21:48', 'ENGLISH', 'Purpose ThepurposeoftheElectricalEngineering–APocketReferenceistoprovidethebasicsof electricalengineeringandelectronicsinasinglehandyvolume. The book addresses university students in electrical engineering, telecommunications, computerengineeringaswellasotherengineeringdisciplineswithaminorinelectrical engineering. ', '620', 'http://10.0.3.2/ElectricalEngineering.jpg', 04),
('LB40', 'LB', 'The Electrical Engineering Handbook,Second Edition', 2, '1420049763', 'Technology & Engineering  ›  Electronics  ›  Gener', '2015-03-21 07:30:34', 'ENGLISH', 'In 1993, the first edition of The Electrical Engineering Handbook set a new standard for breadth and depth of coverage in an engineering reference work. Now, this classic has been substantially revised and updated to include the latest information on all the important topics in electrical engineering today. Every electrical engineer should have an opportunity to expand his expertise with this definitive guide.\r\nIn a single volume, this ha', '2752', 'http://TheElectricalEngineeringHandbookSecondEdition.jpg', 05),
('LB41', 'LB', 'Electrical Engineering Drawing', 0, '8122408559, 97881224', '', '2015-03-21 07:35:21', 'ENGLISH', 'Electrical Drawing Is An Important Engineering Subject Taught To Electrical/Electronics Engineering Students Both At Degree And Diploma Level Institutions. The Course Content Generally Covers Assembly And Working Drawings Of Electrical Machines And Machine Parts, Drawing Of Electrical Circuits, Instruments And Components. The Contents Of This Book Have Been Prepared By Consulting The Syllabus Of Various State Boards Of Technical Education As Also Of Different Engineering ', '252', 'http://10.0.3.2/ElectricalEngineeringDrawing.jpg', 05),
('LB42', 'LB', 'Electrical Engineering: Problems & Solutions', 0, '1419521314, 97814195', 'Study Aids  ›  Tests', '2015-03-21 07:37:42', 'ENGLISH', 'Step-by-step solutions to all practice problems for the electrical engineering license examination including: fundamental concepts and techniques, machines, power distribution, electronics, control systems, computing, digital systems, communication syste', '210', 'http://10.0.3.2/ElectricalEngineering:Problems&Solutions.jpg', 03),
('LB43', 'LB', 'Fundamentals Of Electrical Engineering 2Nd Ed. (Google eBook)', NULL, '8120339282', '', '2015-03-21 07:43:30', 'ENGLISH', 'http://10.0.3.2/FundamentalsOfElectricalEngineering2NdEd.(GoogleeBook).jpg', '904', 'NOT AVAILABLE', 00),
('LB44', 'LB', 'Instrumentation and Measurement in Electrical Engineering', 3, '1612335004, 97816123', 'Technology & Engineering  ›  Electronics  ›  Gener', '2015-03-21 07:50:15', 'ENGLISH', 'The inclusion of an electrical measurement course in the undergraduate curriculum of electrical engineering is important in forming the technical and scientific knowledge of future electrical engineers. This book explains the basic measurement techniques, instruments, and methods used in everyday practice. It covers in detail both analogue and digital instruments, measurements errors and uncertainty, instrument transformers, bridges, amplifiers, oscilloscopes, data acquisition, sensors, instrument controls and measurement system', '244', 'http://10.0.3.2/InstrumentationandMeasurementinElectricalEngineering.jpg', 244),
('LB45', 'LB', 'Basic Electrical Engineering', NULL, '8189866346', '', '2015-03-21 07:52:37', 'ENGLISH', 'The aim of this book is to provide a consolidated text for the first year B.E. Computer Science and Engineering students and B.Tech Information Technology students of Anna University. The syllabus has been thoroughly revised for the non-semester yearly pattern by the University. The book, made up of five chapters, systematically covers the five units of the syllabus. It begins with a detailed discussion on the fundamentals of electric circuits. DC circuits, AC circuits, 3-phase circuits, resonance and the network theorems. Lecture-type presentation of the rudiments of the f', '370', 'http://10.0.3.2/BasicElectricalEngineering.jpg', 03),
('LB46', 'LB', 'Mathematics for Mechanical Engineers', 4, '0849300568, 97808493', 'Mathematics  ›  Applied', '2015-03-21 12:08:58', 'ENGLISH', 'Mathematics for Mechanical Engineers gives mechanical engineers convenient access to the essential problem solving tools that they use each day. It covers applications employed in many different facets of mechanical engineering, from basic through advanced, to ensure that you will easily find answers you need in this handy guide.\r\nFor the engineer venturing out of familiar territory, the chapters cover fundamentals like physical constants, derivatives, integrals, Fourier transforms, Bessel functions, and Legendre functions. For the experts, it includes thorough sections on the more advanced topics of partial diff', '264', 'http://10.0.3.2/MathematicsforMechanicalEngineers.jpg', 03),
('LB47', 'LB', 'The Handbook of Mechanical Engineering', 0, '0878919805, 97808789', 'Technology & Engineering  ›  Mechanical', '2015-03-21 12:11:38', 'ENGLISH', 'Provides a comprehensive and concise handbook on mechanical engineering, reviewing the important facts and concepts in one reference source. Provides quick access to the important facts and formulas, principles, theorems, and equations in 0', '1488', 'http//10.0.3.2/TheHandbookofMechanicalEngineering.jpg', 04),
('LB48', 'LB', '101 Solved Mechanical Engineering Problems', 0, '0912045779, 97809120', 'Technology & Engineering  ›  Mechanical', '2015-03-21 12:14:04', 'ENGLISH', 'These 101 problems, in essay format, are substantially more challenging than those you''ll find on the PE exam - offering a great way to hone your solving skills. Here''s what one of our customers writes:\r\n\r\n"Don''t let the (multiple-choice) exam format dictate how you prepare. Working longer, more detailed problems is always good, because this allows for more thorough comprehension. Then, when you get a les', '129', 'http://10.0.3.2/101SolvedMechanicalEngineeringProblems.jpg', 04),
('LB49', 'LB', 'Basic Mechanical Engineering', 0, '812241172X, 97881224', '', '2015-03-21 12:17:39', 'ENGLISH', 'The Book Provides A Glimpse Of The Fascinating Field Of Mechanical Engineering To The Entrants To Engineering Colleges.It Gives An Insight Into The Major Areas Of Mechanical Engineering, Like Power Production, Energy Alternatives, Production Alternatives And The Latest Computer Controlled Machine Tools.The Book Is Made Interesting With Numerous Sketches And Schematics - A Definite Advantage In Understanding The Subject.\r\n', '236', 'http://10.0.3.2/BasicMechanicalEngineering.jpg', 00),
('LB50', 'LB', 'Rules of Thumb for Mechanical Engineers', 0, '0884157903, 97808841', 'Technology & Engineering  ›  Mechanical', '2015-03-21 12:20:18', 'ENGLISH', 'Save time with this collection of straightforward, common-sense techniques that provide quick, accurate solutions to your engineering problems.\r\n\r\nRules of Thumb for Mechanical Engineers assembles hundreds of shortcuts, calculations, practical "how-to" methods, and concise background reviews into one conven', '405', 'http://10.0.3.2/RulesofThumbforMechanicalEngineers.jpg', 03),
('LB51', 'LB', 'Mathematics for Mechanical Engineers', 3, '9780849300561', 'Mathematics  ›  Applied', '2015-03-21 12:26:32', 'ENGLISH', 'Mathematics for Mechanical Engineers gives mechanical engineers convenient access to the essential problem solving tools that they use each day. It covers applications employed in many different facets of mechanical engineering, from basic through advanced, to ensure that you will easily find answers you need in this handy guide.\r\nFor the engineer venturing out of familiar territory, the chapters cover fundamentals like physical constants, derivatives, integrals, Fourier transforms, ', '264', 'http;//10.0.3.2/MathematicsforMechanicalEngineers.jpg', 00),
('LB52', 'LB', 'The Handbook of Mechanical Engineering', 3, '0878919805', 'Technology & Engineering  ›  Mechanical', '2015-03-21 12:41:43', 'ENGLISH', 'Provides a comprehensive and concise handbook on mechanical engineering, reviewing the important facts and concepts in one reference source. Provides quick access to the important facts and formulas, principles, theorems, and equations in 0', '1488', 'http://10.0.3.2/TheHandbookofMechanicalEngineering.jpg', 04),
('LB53', 'LB', 'Foundations of Mechanical Engineering', 0, '0748764232, 97807487', 'Technology & Engineering  ›  Mechanical', '2015-03-21 12:45:00', 'ENGLISH', 'The traditional approach to teaching mechanical engineering has been to cover either mechanics or thermofluid mechanics. In response to the growing trend toward more general modules, Foundations of Mechanical Engineering provides a unified approach to teaching the basic mechanical engineering topics of mechanics, the mechanics of solids, and thermofluid mechanics.\r\n', '380', 'http://10.0.3.2/FoundationsofMechanicalEngineering.jpg', 00),
('LB54', 'LB', '101 Solved Mechanical Engineering Problems', 0, '0912045779', 'Technology & Engineering  ›  Mechanical', '2015-03-21 12:47:51', 'ENGLISH', 'These 101 problems, in essay format, are substantially more challenging than those you''ll find on the PE exam - offering a great way to hone your solving skills. Here''s what one of our customers writes:\r\n\r\n"Don''t let the (multiple-choice) exam format dictate how you prepare. Working longer, more detailed problems is always good, beca', '129', 'http://10.0.3.2/101SolvedMechanicalEngineeringProblems.jpg', 04),
('LB55', 'LB', 'Mechanical Engineering: Fundamentals', NULL, '9380578202, 97893805', '', '2015-03-21 12:49:43', 'ENGLISH', '', '444', 'http://10.0.3.2/MechanicalEngineering:Fundamentals.jpg', 04);

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE IF NOT EXISTS `publisher` (
  `SSS` varchar(4) NOT NULL,
  `PUBLISHER_NAME` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='PUBLISHER DETAIL';

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`SSS`, `PUBLISHER_NAME`) VALUES
('LB02', 'St. Martin''s Press, 2010'),
('LB03', 'Princeton University Press, 2010'),
('LB04', 'Harvard Business Review Press, 2013'),
('LB10', 'Acedemic Press 2012'),
('LB11', 'Sterling, 2011'),
('LB12', 'Cambridge University Press, 2001'),
('LB13', 'Barron''s Educational Series, 2010'),
('LB14', 'PHI Learning Pvt. Ltd., 2004'),
('LB15', 'Research & Education Assoc., 2004'),
('LB16', 'I. K. International Pvt Ltd, 2010'),
('LB17', 'Springer Science & Business Media, 2009'),
('LB18', 'New Age International, 1991'),
('LB21', 'Newnes, 2002'),
('LB22', 'I. K. International Pvt Ltd, 2007'),
('LB23', 'CRC Press, 1993'),
('LB24', 'CRC Press, 1997'),
('LB25', 'PHI Learning Pvt. Ltd., 2009'),
('LB26', 'Tata McGraw-Hill Education, 1995'),
('LB27', 'Tata McGraw-Hill Education, 1989'),
('LB28', 'CRC Press, 1999'),
('LB29', 'CRC Press, 2008'),
('LB30', 'PHI Learning Pvt. Ltd., 1998'),
('LB31', 'McGraw Hill Professional, 2007'),
('LB32', 'Firewall Media, 2003'),
('LB33', 'Upkar Prakashan, 2009'),
('LB34', 'Nelson Thornes, 2001'),
('LB35', 'Allied Publishers'),
('LB36', 'Skylight Publishing, 2009'),
('LB37', 'Research & Education Assoc., 1998'),
('LB38', 'Cengage Learning EMEA, 2008'),
('LB39', 'Springer Science & Business Media, 2003'),
('LB40', 'CRC Press, 1997'),
('LB41', 'New Age International, 2007'),
('LB42', 'PHI Learning Pvt. Ltd., 2009'),
('LB43', 'Dearborn Trade Publishing, 2005'),
('LB44', 'Universal-Publishers, 2011'),
('LB45', 'I. K. International Pvt Ltd, 2007'),
('LB46', 'CRC Press, 1999'),
('LB47', 'Research & Education Assoc., 1999'),
('LB48', 'Professional Publications, 1989'),
('LB49', 'New Age International, 2007'),
('LB50', 'Gulf Professional Publishing, 1997'),
('LB51', 'CRC Press, 1999'),
('LB52', 'Research & Education Assoc., 1999'),
('LB53', 'CRC Press, 1996'),
('LB54', 'Professional Publications, 1989'),
('LB55', 'I. K. International Pvt Ltd, 2010');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `USER_NAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(30) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `ROLL_NUM` varchar(9) NOT NULL,
  `NUM_ISSUED` int(2) unsigned zerofill NOT NULL,
  `LAST_LOGIN` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='USER INFORMATION';

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`USER_NAME`, `PASSWORD`, `NAME`, `ROLL_NUM`, `NUM_ISSUED`, `LAST_LOGIN`) VALUES
('rajkishor.cs13', 'Rajiitp', 'Rajkishor Ranjan', '1301cs35', 04, '2015-03-10 17:34:56'),
('mayank.cs13', 'mayank', 'MAYANK ARYA', '1301cs43', 01, '2015-03-04 08:16:11'),
('rishabh.ce17', 'rishabh', 'RISHABH GOEL', '1301cs52', 03, '2015-03-04 08:17:42'),
('ayush.ce13', 'ayush', 'AYUSH GARG', '1301cs55', 02, '2015-03-04 08:15:05');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bsell`
--
ALTER TABLE `bsell`
 ADD PRIMARY KEY (`SSS`), ADD UNIQUE KEY `SSS` (`SSS`);

--
-- Indexes for table `ebook`
--
ALTER TABLE `ebook`
 ADD PRIMARY KEY (`SSS`), ADD UNIQUE KEY `D_LINK` (`D_LINK`);

--
-- Indexes for table `lbook`
--
ALTER TABLE `lbook`
 ADD PRIMARY KEY (`SSS`), ADD UNIQUE KEY `SSS` (`SSS`);

--
-- Indexes for table `main`
--
ALTER TABLE `main`
 ADD PRIMARY KEY (`SSS`), ADD UNIQUE KEY `ISBN` (`ISBN`);

--
-- Indexes for table `publisher`
--
ALTER TABLE `publisher`
 ADD UNIQUE KEY `SSS` (`SSS`), ADD UNIQUE KEY `SSS_2` (`SSS`), ADD UNIQUE KEY `SSS_4` (`SSS`), ADD UNIQUE KEY `SSS_5` (`SSS`), ADD UNIQUE KEY `SSS_6` (`SSS`), ADD FULLTEXT KEY `SSS_3` (`SSS`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`ROLL_NUM`), ADD UNIQUE KEY `USER_NAME` (`USER_NAME`), ADD UNIQUE KEY `USER_NAME_2` (`USER_NAME`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
