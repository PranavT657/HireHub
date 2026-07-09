-- ==========================================
-- HireHub Database Schema
-- ==========================================

CREATE DATABASE IF NOT EXISTS hirehub;

USE hirehub;

-- ==========================================
-- USERS TABLE
-- ==========================================

CREATE TABLE users (

    user_id INT AUTO_INCREMENT PRIMARY KEY,

    full_name VARCHAR(100) NOT NULL,

    email VARCHAR(100) NOT NULL UNIQUE,

    password VARCHAR(255) NOT NULL,

    phone VARCHAR(15),

    role ENUM(
        'STUDENT',
        'COMPANY',
        'PLACEMENT_OFFICER',
        'ADMIN'
    ) NOT NULL,

    status ENUM(
        'ACTIVE',
        'INACTIVE'
    ) DEFAULT 'ACTIVE',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

-- ==========================================
-- STUDENTS TABLE
-- ==========================================

CREATE TABLE students (

    student_id INT AUTO_INCREMENT PRIMARY KEY,

    user_id INT NOT NULL UNIQUE,

    srn VARCHAR(20) NOT NULL UNIQUE,

    branch VARCHAR(100) NOT NULL,

    semester INT NOT NULL,

    cgpa DECIMAL(3,2),

    passing_year YEAR,

    gender ENUM('MALE','FEMALE','OTHER'),

    dob DATE,

    FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE
);

-- ==========================================
-- COMPANIES TABLE
-- ==========================================

CREATE TABLE companies (

    company_id INT AUTO_INCREMENT PRIMARY KEY,

    user_id INT NOT NULL UNIQUE,

    company_name VARCHAR(150) NOT NULL,

    hr_name VARCHAR(100),

    website VARCHAR(255),

    location VARCHAR(100),

    description TEXT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE

);


CREATE TABLE jobs (

    job_id INT AUTO_INCREMENT PRIMARY KEY,

    company_id INT NOT NULL,

    title VARCHAR(150) NOT NULL,

    description TEXT,

    location VARCHAR(100),

    salary DECIMAL(10,2),

    minimum_cgpa DECIMAL(3,2),

    vacancies INT,

    job_type ENUM(
        'FULL_TIME',
        'INTERNSHIP',
        'PART_TIME'
    ),

    last_date DATE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (company_id)
        REFERENCES companies(company_id)
        ON DELETE CASCADE

);


CREATE TABLE applications (

    application_id INT AUTO_INCREMENT PRIMARY KEY,

    student_id INT NOT NULL,

    job_id INT NOT NULL,

    application_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    status ENUM(
        'APPLIED',
        'SHORTLISTED',
        'REJECTED',
        'SELECTED'
    ) DEFAULT 'APPLIED',

    FOREIGN KEY (student_id)
        REFERENCES students(student_id)
        ON DELETE CASCADE,

    FOREIGN KEY (job_id)
        REFERENCES jobs(job_id)
        ON DELETE CASCADE

);


