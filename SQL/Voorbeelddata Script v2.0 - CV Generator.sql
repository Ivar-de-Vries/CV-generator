USE IDA_CV_GENERATOR
print '    Deleting present data'
DELETE FROM [RoleInUser]
DELETE FROM [Role]
DELETE FROM [User]
DELETE FROM [ProjectParticipation]
DELETE FROM [Project]
DELETE FROM [EducationParticipation]
DELETE FROM [Education]
DELETE FROM [TrainingParticipation]
DELETE FROM [Training]
DELETE FROM [Institute]
DELETE FROM [LanguageLevel]
DELETE FROM [Language]
DELETE FROM [LanguageSkill]
DELETE FROM [SkillLevel]
DELETE FROM [Skill]
DELETE FROM [Job]
DELETE FROM [Company]
DELETE FROM [Certificate]
DELETE FROM [Employee]
print ''
print '    Data Deleted'
print ''
/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: Employee                        */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [Employee]                                */
/*    SELECT * FROM [Employee]                            */
/*--------------------------==--------------------------*/
print ''
print 'insert Employee:'
SET IDENTITY_INSERT [Employee] ON;
INSERT INTO [Employee] (ID, Emailaddress, Firstname, Lastname, Gender, Birthdate, City, Driverlicense, [Description])
VALUES
(0, 'T.Wagener@student.han.nl', 'Timo', 'Wagener', 'M', '2003-05-13', 'Didam', 0, 'Hallo dit is een testbeschrijving'),
(1, 'E.Wiese@student.han.nl', 'Elmar', 'Wiese', 'M', '2003-11-22', 'Nijmegen', 0, 'Hallo dit is een testbeschrijving'),
(2, 'I.deVries@student.han.nl', 'Ivar', 'De Vries', 'M', '2002-07-22', '', 1, 'Hallo dit is een testbeschrijving'),
(3, 'S.Noordbruis@student.han.nl', 'Sietse', 'Noordbruis', 'M', '1998-08-04', 'Babberich', 0, 'Hallo dit is een testbeschrijving'),
(4, 'JJ.Juan@student.han.nl', 'Junjie', 'Juan', 'M', '1996-03-14', 'Boxmeer', 1, 'Hallo dit is een testbeschrijving'),
(5, 'W.Verhoeven2@student.han.nl', 'Wouter', 'Verhoeven', 'M', '1994-06-27', 'Aardt', 1, 'Hallo dit is een testbeschrijving')
SET IDENTITY_INSERT [Employee] OFF;

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: Certificate                    */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [Certificate]                            */
/*    SELECT * FROM [Certificate]                            */
/*--------------------------==--------------------------*/
print ''
print 'insert Certificate:'
SET IDENTITY_INSERT [Certificate] ON;
INSERT INTO [Certificate] (ID, [Name], Coursename, Aquired, EmployeeId)
VALUES
(0, 'Certified scrum master','Agile & Scrum', '2012', 1),
(1, 'Sys-admin certificate', 'Infrastructuur en Systemen', '2014', 1),
(2, 'Certified data manager', 'Data Management & Analysis', '2016', 2),
(3, 'Certified scrum master', 'Agile & Scrum', '2018', 4),
(4, 'Security Expert', 'Security', '2020', 5)
SET IDENTITY_INSERT [Certificate] OFF;

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: Company                        */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [Company]                                */
/*    SELECT * FROM [Company]                                */
/*--------------------------==--------------------------*/
print ''
print 'insert Company:'
SET IDENTITY_INSERT [Company] ON;
INSERT INTO [Company] (ID, [Name])
VALUES
(0, 'DLA ICT'),
(1, 'Microsoft'),
(2, 'Apple')
SET IDENTITY_INSERT [Company] OFF;

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: Job                            */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [Job]                                    */
/*    SELECT * FROM [Job]                                    */
/*--------------------------==--------------------------*/
print ''
print 'insert Job:'
SET IDENTITY_INSERT [Job] ON;
INSERT INTO [Job] (ID, EmployeeId, CompanyId, [Function], Begindate, Enddate)
VALUES
(0, 0, 0, 'Junior Developer', '2019', '2020'),
(1, 1, 1, 'Junior Developer', '2015', '2019'),
(2, 2, 2, 'Junior Developer', '2015', '2019'),
(3, 3, 0, 'Senior Developer', '2015', '2019'),
(4, 4, 1, 'Senior Developer', '2018', '2019'),
(5, 4, 1, 'Senior Developer', '2018', '2019'),
(6, 4, 1, 'Senior Developer', '2018', '2019'),
(7, 4, 1, 'Senior Developer', '2018', '2019'),
(8, 4, 1, 'Senior Developer', '2018', '2019'),
(9, 4, 1, 'Senior Developer', '2018', '2019'),
(10, 4, 1, 'Senior Developer', '2018', '2019'),
(11, 4, 1, 'Senior Developer', '2018', '2019'),
(12, 4, 1, 'Senior Developer', '2018', '2019'),
(13, 4, 1, 'Senior Developer', '2018', '2019'),
(14, 4, 1, 'Senior Developer', '2018', '2019'),
(15, 4, 1, 'Senior Developer', '2018', '2019'),
(16, 4, 1, 'Senior Developer', '2018', '2019'),
(17, 4, 1, 'Senior Developer', '2018', '2019'),
(18, 4, 1, 'Senior Developer', '2018', '2019'),
(19, 4, 1, 'Senior Developer', '2018', '2019'),
(20, 4, 1, 'Senior Developer', '2018', '2019'),
(21, 4, 1, 'Senior Developer', '2018', '2019'),
(22, 4, 1, 'Senior Developer', '2018', '2019'),
(23, 4, 1, 'Senior Developer', '2018', '2019'),
(24, 4, 1, 'Senior Developer', '2018', '2019'),
(25, 4, 1, 'Senior Developer', '2018', '2019'),
(26, 4, 1, 'Senior Developer', '2018', '2019'),
(27, 4, 1, 'Senior Developer', '2018', '2019'),
(28, 4, 1, 'Senior Developer', '2018', '2019'),
(29, 4, 1, 'Senior Developer', '2018', '2019'),
(30, 5, 2, 'Senior Developer', '2019', '2020')
SET IDENTITY_INSERT [Job] OFF;

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: Skill                            */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [Skill]                                    */
/*    SELECT * FROM [Skill]                                */
/*--------------------------==--------------------------*/
print ''
print 'insert Skill:'
SET IDENTITY_INSERT [Skill] ON;
INSERT INTO [Skill] (ID, [Name])
VALUES
(0, 'Java'),
(1, 'Angular'),
(2, 'C#'),
(3, 'Unittesting'),
(4, 'HTML/CSS'),
(5, 'Springboot')
SET IDENTITY_INSERT [Skill] OFF;

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: SkillLevel                        */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [SkillLevel]                            */
/*    SELECT * FROM [SkillLevel]                            */
/*--------------------------==--------------------------*/
print ''
print 'insert SkillLevel:'
SET IDENTITY_INSERT [SkillLevel] ON;
INSERT INTO [SkillLevel] (ID, EmployeeId, SkillId, Score)
VALUES
(0, 0, 5, 3),
(1, 1, 4, 2),
(2, 2, 3, 4),
(3, 3, 2, 4),
(4, 4, 1, 2),
(5, 5, 0, 3)
SET IDENTITY_INSERT [SkillLevel] OFF;

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: LanguageSkill                    */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [LanguageSkill]                            */
/*    SELECT * FROM [LanguageSkill]                        */
/*--------------------------==--------------------------*/
print ''
print 'insert LanguageSkill:'
INSERT INTO [LanguageSkill]
VALUES
(1, 'Moedertaal'),
(2, 'Uitstekend'),
(3, 'Goed'),
(4, 'Matig'),
(5, 'Basis'),
(6, 'Niet')

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: Language                        */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [Language]                                */
/*    SELECT * FROM [Language]                            */
/*--------------------------==--------------------------*/
print ''
print 'insert Language:'
INSERT INTO [Language] (ID, [Name], Countrycode)
VALUES
(0, 'Nederlands', 'NL'),
(1, 'Engels', 'EN'),
(2, 'Duits', 'DE'),
(3, 'Frans', 'FR'),
(4, 'Spaans', 'ES')

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: LanguageLevel                    */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [LanguageLevel]                            */
/*    SELECT * FROM [LanguageLevel]                        */
/*--------------------------==--------------------------*/
print ''
print 'insert LanguageLevel:'
SET IDENTITY_INSERT [LanguageLevel] ON;
INSERT INTO [LanguageLevel] (ID, EmployeeId, LanguageId, Speaking, Reading, Writing)
VALUES
(0, 0, 0, 1, 1, 1),
(1, 1, 0, 1, 1, 1),
(2, 2, 0, 1, 1, 1),
(3, 3, 0, 1, 1, 1),
(4, 4, 0, 1, 1, 1),
(5, 5, 0, 1, 1, 1),

(6, 0, 1, 2, 2, 2),
(7, 1, 1, 2, 2, 2),
(8, 2, 1, 2, 2, 2),
(9, 3, 1, 2, 2, 2),
(1000000010, 4, 1, 2, 2, 2),
(1000000011, 5, 1, 2, 2, 2),

(1000000012, 0, 2, 3, 4, 3),
(1000000013, 5, 3, 2, 3, 3)
SET IDENTITY_INSERT [LanguageLevel] OFF;

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: Institute                        */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [Institute]                                */
/*    SELECT * FROM [Institute]                            */
/*--------------------------==--------------------------*/
print ''
print 'insert Institute:'
SET IDENTITY_INSERT [Institute] ON;
INSERT INTO [Institute] (ID, [Name], City)
VALUES
(0, 'HAN Arnhem', 'Arnhem'),
(1, 'HAN Nijmegen', 'Nijmegen'),
(2, 'TU Delft', 'Delft'),
(3, 'Universiteit Twente', 'Enschede'),
(4, 'Graafschap College', 'Doetinchem'),
(5, 'Ulenhof', 'Doetinchem'),
(6, 'Leerpark Arnhem', 'Arnhem'),
(7, 'Veluws College', 'Apeldoorn')
SET IDENTITY_INSERT [Institute] OFF;

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: Training                        */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [Training]                                */
/*    SELECT * FROM [Training]                            */
/*--------------------------==--------------------------*/
print ''
print 'insert Training:'
SET IDENTITY_INSERT [Training] ON;
INSERT INTO [Training] (ID, [Name], InstituteId)
VALUES
(0, 'IT Security', 0),
(1, 'Docker Java', 0),
(2, 'Java Springboot', 2),
(3, 'Unittesting', 2),
(4, 'Python AI & Machine Learning', 3),
(5, '.NET AI & Machine Learning', 3)
SET IDENTITY_INSERT [Training] OFF;

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: TrainingParticipation            */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [TrainingParticipation]                    */
/*    SELECT * FROM [TrainingParticipation]                */
/*--------------------------==--------------------------*/
print ''
print 'insert TrainingParticipation:'
SET IDENTITY_INSERT [TrainingParticipation] ON;
INSERT INTO [TrainingParticipation] (ID, EmployeeId, TrainingId, Begindate, Enddate)
VALUES
(0, 0, 1, '2020-08-21', '2020-12-17'),
(1, 1, 2, '2019-01-12', '2019-02-11'),
(2, 2, 4, '2018-09-13', '2020-07-15'),
(3, 3, 5, '2017-08-29', '2019-07-21'),
(4, 4, 0, '2019-03-17', '2019-04-17'),
(5, 5, 3, '2021-11-17', '2021-12-03')
SET IDENTITY_INSERT [TrainingParticipation] OFF;

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: Education                        */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [Education]                                */
/*    SELECT * FROM [Education]                            */
/*--------------------------==--------------------------*/
print ''
print 'insert Education:'
SET IDENTITY_INSERT [Education] ON;
INSERT INTO [Education] (ID, [Name], InstituteId)
VALUES
(0, 'HBO-ICT', 0),
(1, 'Multimedia', 4),
(2, 'Bouwkunde', 1),
(3, 'HAVO', 5),
(4, 'VMBO', 6),
(5, 'Gymnasium', 7)
SET IDENTITY_INSERT [Education] OFF;

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: EducationParticipation            */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [EducationParticipation]                */
/*    SELECT * FROM [EducationParticipation]                */
/*--------------------------==--------------------------*/
print ''
print 'insert EducationParticipation:'
SET IDENTITY_INSERT [EducationParticipation] ON;
INSERT INTO [EducationParticipation] (ID, EmployeeId, EducationId, Begindate, Enddate)
VALUES
(0, 0, 0, '2014-09-01', '2018'),
(1, 1, 1, '2008', '2012'),
(2, 2, 2, '2012', '2016'),
(3, 3, 3, '2013', '2018'),
(4, 4, 4, '2010', '2014'),
(5, 5, 5, '2014', '2018')
SET IDENTITY_INSERT [EducationParticipation] OFF;

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: Project                        */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [Project]                                */
/*    SELECT * FROM [project]                                */
/*--------------------------==--------------------------*/
print ''
print 'insert Project:'
SET IDENTITY_INSERT [Project] ON;
INSERT INTO [Project] (ID, [Name], CompanyId)
VALUES
(0, 'Something (I ran out of idea''s)', 0),
(1, 'Office for Android Online', 1),
(2, 'ICloud Security Upgrades', 2),
(3, 'Adobe Library', 0),
(4, 'SQL Server Development Manager', 1),
(5, 'Battery Saver voor Old IPhones', 2)
SET IDENTITY_INSERT [Project] OFF;

/*--------------------------==--------------------------*/
/*    Voorbeelddata Tabel: ProjectParticipation            */
/*                                                        */
/* SELECT & DELETE:                                        */
/*    DELETE FROM [ProjectParticipation]                    */
/*    SELECT * FROM [ProjectParticipation]                */
/*--------------------------==--------------------------*/
print ''
print 'insert ProjectParticipation:'
SET IDENTITY_INSERT [ProjectParticipation] ON;
INSERT INTO [ProjectParticipation] (ID, EmployeeId, ProjectId, [Description], Begindate, Enddate)
VALUES
(0, 0, 0, 'Beschrijving', '2014-2-2', '2016-2-2'),
(1, 1, 1, 'Beschrijving', '2016-2-2', '2017-2-2'),
(2, 2, 2, 'Beschrijving', '2012-2-2', '2014-2-2'),
(3, 3, 3, 'Beschrijving', '2015-2-2', '2019-2-2'),
(4, 4, 4, 'Beschrijving', '2013-3-5', '2017-6-9'),
(5, 5, 5, 'Beschrijving', '2016-1-5', '2016-12-22')
SET IDENTITY_INSERT [ProjectParticipation] OFF;

print ''
print 'insert User:'
SET IDENTITY_INSERT [User] ON;
INSERT INTO [User] (ID, Emailaddress, Password, EmployeeId)
VALUES
(0, 't.wagener@student.han.nl', '$2a$12$PGCnVwdDhWHUzIk3.duHouwoT1hrSKhLgK7Q3unQ9kbZpJltjzQDS', 0),
(1, 'e.wiese@student.han.nl', '$2a$12$PGCnVwdDhWHUzIk3.duHouwoT1hrSKhLgK7Q3unQ9kbZpJltjzQDS', 1),
(2, 'i.devries@student.han.nl', '$2a$12$PGCnVwdDhWHUzIk3.duHouwoT1hrSKhLgK7Q3unQ9kbZpJltjzQDS', 2),
(3, 's.noordbruis@student.han.nl', '$2a$12$PGCnVwdDhWHUzIk3.duHouwoT1hrSKhLgK7Q3unQ9kbZpJltjzQDS', 3),
(4, 'jj.juan@student.han.nl', '$2a$12$PGCnVwdDhWHUzIk3.duHouwoT1hrSKhLgK7Q3unQ9kbZpJltjzQDS', 4),
(5, 'w.verhoeven2@student.han.nl', '$2a$12$PGCnVwdDhWHUzIk3.duHouwoT1hrSKhLgK7Q3unQ9kbZpJltjzQDS', 5),
(6, 'tester@tester.nl', '$2a$12$PGCnVwdDhWHUzIk3.duHouwoT1hrSKhLgK7Q3unQ9kbZpJltjzQDS', NULL)
SET IDENTITY_INSERT [User] OFF;

print ''
print 'insert Role:'
SET IDENTITY_INSERT [Role] ON;
INSERT INTO [Role] (ID, [Role])
values
(0, 'ROLE_USER'),
(1, 'ROLE_ADMIN')
SET IDENTITY_INSERT [Role] OFF;

print ''
print 'insert RoleInUser:'
INSERT INTO [RoleInUser]
values
(0, 1),
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 0)
