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