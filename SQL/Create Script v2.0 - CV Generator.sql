USE MASTER

IF EXISTS (SELECT * FROM sys.databases where name = 'IDA_CV_GENERATOR')
BEGIN
	ALTER DATABASE IDA_CV_GENERATOR SET single_user WITH ROLLBACK immediate
	DROP DATABASE IDA_CV_GENERATOR
	PRINT ' Dropped database:	IDA_CV GENERATOR'
END

CREATE DATABASE IDA_CV_GENERATOR;
PRINT ' Created database:	IDA_CV_GENERATOR'
GO
USE IDA_CV_GENERATOR

/* Create table: Employee */
CREATE TABLE [Employee]
(
	ID				int IDENTITY(0,1)				NOT NULL,
    Emailaddress	varChar(255)					NOT NULL,
    Firstname		varChar(255)					NOT NULL,
	Lastname		varChar(255)					NOT NULL,
	Gender			varChar(1)						NOT NULL,
	Birthdate		date							NOT NULL,
	City			varChar(255)					NOT NULL,
	Driverlicense	bit								NOT NULL,
	[Description]	varChar(1024)					NOT NULL,
	constraint		pk_employee_id					primary key (ID),
	constraint		ak_emailadres					unique (Emailaddress),
	constraint		ck_gender						check(Gender = 'M' OR Gender = 'F' OR Gender = 'O')
)
PRINT '	Created table:	Employee'

/* Create table: Certificate */
CREATE TABLE [Certificate]
(
	ID				int IDENTITY(0,1)				NOT NULL,
	[Name]			varChar(255)					NOT NULL,
	Coursename		varChar(255)					NOT NULL,
	Aquired			date							NOT NULL,
	EmployeeId		int 							NOT NULL,
	constraint		pk_certificate_id				primary key (ID),
	constraint		fk_certificate_employee			foreign key (EmployeeID)
					references Employee (ID) ON DELETE CASCADE ON UPDATE CASCADE
)
PRINT '	Created table:	Certificate'

/* Create table: Company */
CREATE TABLE [Company]
(
	ID				int IDENTITY(0,1)				NOT NULL,
	[Name]			varChar(255)					NOT NULL,
	constraint		pk_company_id					primary key (ID)
)
PRINT '	Created table:	Company'

/* Create table: Job */
CREATE TABLE [Job]
(
	ID				int IDENTITY(0,1)				NOT NULL,
	EmployeeId		int 							NOT NULL,
	CompanyId		int 							NOT NULL,
	[Function]		varChar(255)					NOT NULL,
	Begindate		date							NOT NULL,
	Enddate			date							NULL,
	constraint		pk_jop_id						primary key (ID),
	constraint		fk_job_employee					foreign key (EmployeeId)
					references Employee (ID) ON DELETE CASCADE ON UPDATE CASCADE,
	constraint		fk_job_company					foreign key (CompanyId)
					references Company (ID)
)
PRINT '	Created table:	Job'

/* Create table: Skill */
CREATE TABLE [Skill]
(
	ID				int IDENTITY(0,1)				NOT NULL,
	[Name]			varChar(255)					NOT NULL,
	constraint		pk_skill_id						primary key (ID)
)
PRINT '	Created table:	Skill'

/* Create table: SkillLevel */
CREATE TABLE [SkillLevel]
(
	ID				int IDENTITY(0,1)				NOT NULL,
	EmployeeId		int 							NOT NULL,
	SkillId			int 							NOT NULL,
	Score			tinyint							NOT NULL,
	constraint		pk_skill_level_id				primary key (ID),
	constraint		fk_skill_level_employee			foreign key (EmployeeId)
					references Employee (ID) ON DELETE CASCADE ON UPDATE CASCADE,
	constraint		fk_skill_level_skill			foreign key (SkillId)
					references Skill (ID),
	constraint		ck_score						check (Score >= 1 AND Score <=5)
)
PRINT '	Created table:	SkillLevel'

/* Create table: LanguageSkill */
CREATE TABLE [LanguageSkill]
(
	ID				int								NOT NULL,
	[Value]			varChar(255)					NOT NULL,
	constraint		pk_language_skill_id			primary key (ID)
)
PRINT '	Created table:	LanguageSkill'

/* Create table: Language */
CREATE TABLE [Language]
(
	ID				int								NOT NULL,
	[Name]			varChar(255)					NOT NULL,
	Countrycode		varChar(2)						NOT NULL,
	constraint		pk_language_id					primary key (ID)
)
PRINT '	Created table:	Language'

/* Create table: LanguageLevel */
CREATE TABLE [LanguageLevel]
(
	ID				int IDENTITY(0,1)				NOT NULL,
	EmployeeId		int 							NOT NULL,
	LanguageId		int								NOT NULL,
	Speaking		int								NOT NULL,
	Reading			int								NOT NULL,
	Writing			int								NOT NULL,
	constraint		pk_language_level_id			primary key (ID),
	constraint		fk_language_level_employee		foreign key (EmployeeId)
					references Employee (ID) ON DELETE CASCADE ON UPDATE CASCADE,
	constraint		fk_language_level_language		foreign key ([LanguageId])
					references [Language] (ID),
	constraint		fk_speaking_level				foreign key (Speaking)
					references LanguageSkill (ID),	
	constraint		fk_reading_level				foreign key (Reading)
					references LanguageSkill (ID),	
	constraint		fk_writing_level				foreign key (Writing)
					references LanguageSkill (ID)
)
PRINT '	Created table:	LanguageLevel'

/* Create table: Institute */
CREATE TABLE [Institute]
(
	ID				int IDENTITY(0,1)				NOT NULL,
	[Name]			varChar(255)					NOT NULL,
	City			varChar(255)					NOT NULL,
	constraint		pk_institute_id					primary key (ID)
)
PRINT '	Created table:	Institute'

/* Create table: Training */
CREATE TABLE [Training]
(
	ID				int IDENTITY(0,1)				NOT NULL,
	[Name]			varChar(255)					NOT NULL,
	InstituteId		int								NOT NULL,
	constraint		pk_training_id					primary key (ID),
	constraint		fk_training_institute			foreign key (InstituteId)
					references Institute (ID)
)
PRINT '	Created table:	Training'

/* Create table: TrainingParticipation */
CREATE TABLE [TrainingParticipation]
(
	ID				int IDENTITY(0,1)				NOT NULL,
	EmployeeId		int 							NOT NULL,
	TrainingId		int 							NOT NULL,
	Begindate		date							NOT NULL,
	Enddate			date							NOT NULL,
	constraint		pk_t_participation_training		primary key (ID),
	constraint		fk_t_participation_employee		foreign key (EmployeeId)
					references Employee (ID) ON DELETE CASCADE ON UPDATE CASCADE,
	constraint		fk_t_participation_training		foreign key (TrainingId)
					references Training (ID)
)
PRINT '	Created table:	TrainingParticipation'

/* Create table: Education */
CREATE TABLE [Education]
(
	ID				int IDENTITY(0,1)				NOT NULL,
	[Name]			varChar(255)					NOT NULL,
	InstituteId		int								NOT NULL,
	constraint		pk_education_id					primary key (ID),
	constraint		fk_education_institute			foreign key (InstituteId)
					references Institute (ID)
)
PRINT '	Created table:	Education'

/* Create table: EducationParticipation */
CREATE TABLE [EducationParticipation]
(
	ID				int IDENTITY(0,1)				NOT NULL,
	EmployeeId		int 							NOT NULL,
	EducationId		int 							NOT NULL,
	Begindate		date							NOT NULL,
	Enddate			date							NOT NULL,
	constraint		pk_e_participation_education	primary key (ID),
	constraint		fk_e_participation_employee		foreign key (EmployeeId)
					references Employee (ID) ON DELETE CASCADE ON UPDATE CASCADE,
	constraint		fk_e_participation_education	foreign key (EducationId)
					references Education (ID)
)
PRINT '	Created table:	EducationParticipation'

/* Create table: Project */
CREATE TABLE [Project]
(
	ID				int IDENTITY(0,1)				NOT NULL,
	[Name]			varChar(255)					NOT NULL,
	CompanyId		int								NOT NULL,
	constraint		pk_project_id					primary key (ID),
	constraint		fk_project_company				foreign key (CompanyId)
					references Company (ID)
)
PRINT '	Created table:	Project'

/* Create table: ProjectParticipation */
CREATE TABLE [ProjectParticipation]
(
	ID				int IDENTITY(0,1)				NOT NULL,
	EmployeeId		int 							NOT NULL,
	ProjectId		int 							NOT NULL,
	[Description]	varChar(1024)					NOT NULL,
	Begindate		date							NOT NULL,
	Enddate			date							NOT NULL,
	constraint		pk_p_participation_project		primary key (ID),
	constraint		fk_p_participation_employee		foreign key (EmployeeId)
					references Employee (ID),
	constraint		fk_p_participation_project		foreign key (ProjectId)
					references Project (ID)
)
PRINT '	Created table:	ProjectParticipation'

/*  */
CREATE TABLE [User]
(
	ID				int IDENTITY(0,1)				NOT NULL,
    Emailaddress	varChar(255)					NOT NULL,
    [Password]		varChar(255)					NOT NULL,
	EmployeeId		int								NULL,
	constraint		pk_user_id						primary key (ID),
	constraint		fk_user_employee				foreign key (EmployeeID)
					references Employee (ID) ON DELETE CASCADE ON UPDATE CASCADE
)
PRINT '	Created table:	User'

/*  */
CREATE TABLE [Role] 
(
	ID				int IDENTITY(0,1)				NOT NULL,
	[Role]			varChar(10)						NOT NULL,
	constraint		pk_role_id						primary key (ID)
)
PRINT '	Created table:	Role'

/*  */
CREATE TABLE [RoleInUser]
(
	UserId			int								NOT NULL,
	RoleId			int								NOT NULL,
	constraint		pk_user_role					primary key (UserId, RoleId),
	constraint		fk_user_in_role					foreign key (UserId)
					references [User] (ID),
	constraint		fk_role_in_user					foreign key (RoleId)
					references [Role] (ID)
)
PRINT '	Created table:	RoleInUser'
PRINT ''
PRINT 'Create script succesfully completed at: ' + CONVERT(varChar(10), GETDATE(), 108)

/* Shows a list of all tables that are created */
SELECT TABLE_NAME as 'Name of Table'
FROM IDA_CV_GENERATOR.INFORMATION_SCHEMA.TABLES 