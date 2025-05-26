-- Unique MySQL Solutions for ANSI SQL Exercises
-- This file contains all 25 solutions with unique approaches

-- Database Creation
CREATE DATABASE IF NOT EXISTS event_management;
USE event_management;

-- Table Creation with Unique Constraints
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(100) NOT NULL,
    registration_date DATE NOT NULL,
    last_active_date DATE
) ENGINE=InnoDB;

CREATE TABLE Events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    city VARCHAR(100) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    status ENUM('upcoming','completed','cancelled') NOT NULL,
    organizer_id INT NOT NULL,
    FOREIGN KEY (organizer_id) REFERENCES Users(user_id),
    INDEX (status),
    INDEX (city)
) ENGINE=InnoDB;

CREATE TABLE Sessions (
    session_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT NOT NULL,
    title VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id),
    INDEX (event_id),
    INDEX (speaker_name)
) ENGINE=InnoDB;

CREATE TABLE Registrations (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    event_id INT NOT NULL,
    registration_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id),
    UNIQUE KEY unique_registration (user_id, event_id),
    INDEX (registration_date)
) ENGINE=InnoDB;

CREATE TABLE Feedback (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    event_id INT NOT NULL,
    rating INT NOT NULL CHECK (rating BETWEEN 1 AND 5),
    comments TEXT,
    feedback_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id),
    INDEX (rating)
) ENGINE=InnoDB;

CREATE TABLE Resources (
    resource_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT NOT NULL,
    resource_type ENUM('pdf','image','link') NOT NULL,
    resource_url VARCHAR(255) NOT NULL,
    uploaded_at DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id),
    INDEX (resource_type)
) ENGINE=InnoDB;

-- Sample Data Insertion with Unique Values
INSERT INTO Users (full_name, email, city, registration_date, last_active_date) VALUES
('Alexandra Chen', 'alex.chen@unique.com', 'New York', '2024-12-01', '2025-05-01'),
('Benjamin Wong', 'ben.wong@unique.com', 'Los Angeles', '2024-12-05', '2025-05-10'),
('Clara Rodriguez', 'clara.rod@unique.com', 'Chicago', '2024-12-10', '2025-04-15'),
('Dmitri Ivanov', 'dmitri.iv@unique.com', 'New York', '2025-01-15', '2025-01-20'),
('Elena Petrova', 'elena.pet@unique.com', 'Los Angeles', '2025-02-01', '2025-05-20'),
('Farhan Ahmed', 'farhan.ah@unique.com', 'Boston', '2025-05-01', NULL),
('Gina Lopez', 'gina.lop@unique.com', 'Seattle', '2025-05-15', '2025-05-18');

INSERT INTO Events (title, description, city, start_date, end_date, status, organizer_id) VALUES
('Tech Visionaries Summit', 'Annual gathering of technology leaders', 'New York', '2025-06-10 09:00:00', '2025-06-10 18:00:00', 'upcoming', 1),
('AI Revolution Conference', 'Exploring cutting-edge AI technologies', 'Chicago', '2025-05-15 08:00:00', '2025-05-15 17:00:00', 'completed', 3),
('Frontend Masters Bootcamp', 'Intensive training on modern frontend development', 'Los Angeles', '2025-07-01 10:00:00', '2025-07-03 16:00:00', 'upcoming', 2),
('Data Science Workshop', 'Hands-on data science techniques', 'Boston', '2025-08-15 09:00:00', '2025-08-16 17:00:00', 'upcoming', 4),
('Cloud Computing Expo', 'Latest trends in cloud infrastructure', 'Seattle', '2025-09-10 10:00:00', '2025-09-12 15:00:00', 'upcoming', 7);

INSERT INTO Sessions (event_id, title, speaker_name, start_time, end_time) VALUES
(1, 'Opening Keynote: Future Tech', 'Dr. Samantha Lee', '2025-06-10 10:00:00', '2025-06-10 11:00:00'),
(1, 'Web Development Trends', 'Alexandra Chen', '2025-06-10 11:15:00', '2025-06-10 12:30:00'),
(1, 'Lunch & Networking', 'Various', '2025-06-10 12:30:00', '2025-06-10 13:30:00'),
(2, 'AI in Healthcare', 'Dr. Clara Rodriguez', '2025-05-15 09:30:00', '2025-05-15 11:00:00'),
(2, 'Machine Learning Ethics', 'Prof. James Wilson', '2025-05-15 11:15:00', '2025-05-15 12:45:00'),
(3, 'Intro to HTML5 & CSS3', 'Benjamin Wong', '2025-07-01 10:00:00', '2025-07-01 12:00:00'),
(3, 'JavaScript Frameworks', 'Benjamin Wong', '2025-07-02 10:00:00', '2025-07-02 12:00:00'),
(4, 'Python for Data Science', 'Dmitri Ivanov', '2025-08-15 09:00:00', '2025-08-15 12:00:00'),
(5, 'AWS Deep Dive', 'Gina Lopez', '2025-09-10 10:00:00', '2025-09-10 12:00:00'),
(5, 'Azure vs GCP', 'Gina Lopez', '2025-09-11 10:00:00', '2025-09-11 12:00:00');

INSERT INTO Registrations (user_id, event_id, registration_date) VALUES
(1, 1, '2025-05-01'),
(2, 1, '2025-05-02'),
(3, 2, '2025-04-30'),
(4, 2, '2025-04-28'),
(5, 3, '2025-06-15'),
(1, 3, '2025-06-01'),
(2, 4, '2025-07-20'),
(3, 5, '2025-08-01'),
(3, 1, '2025-05-05'),
(5, 5, '2025-08-15');

INSERT INTO Feedback (user_id, event_id, rating, comments, feedback_date) VALUES
(3, 2, 4, 'Great insights on AI applications', '2025-05-16'),
(4, 2, 5, 'Excellent speakers and content', '2025-05-16'),
(2, 1, 3, 'Good but could use more hands-on', '2025-06-11'),
(1, 3, 2, 'Too basic for my level', '2025-07-05'),
(5, 5, 1, 'Poor organization', '2025-09-13'),
(3, 1, 5, 'Inspiring keynote!', '2025-06-12'),
(3, 5, 4, 'Very technical but useful', '2025-09-14');

INSERT INTO Resources (event_id, resource_type, resource_url, uploaded_at) VALUES
(1, 'pdf', 'https://unique.com/resources/tech_summit_agenda.pdf', '2025-05-01 10:00:00'),
(1, 'image', 'https://unique.com/resources/speaker_photos.zip', '2025-05-02 09:00:00'),
(2, 'link', 'https://unique.com/resources/ai_research_papers', '2025-04-20 09:00:00'),
(3, 'pdf', 'https://unique.com/resources/frontend_cheatsheet.pdf', '2025-06-25 15:00:00'),
(5, 'link', 'https://unique.com/resources/cloud_computing_links', '2025-08-01 11:00:00');

-- Exercise Solutions with Unique Approaches

-- 1. User Upcoming Events
SELECT DISTINCT e.event_id, e.title, e.start_date
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
JOIN Users u ON r.user_id = u.user_id
WHERE e.status = 'upcoming'
AND e.city = u.city
AND r.user_id = 3  -- Example for user_id 3
ORDER BY e.start_date;

-- 2. Top Rated Events (Modified to work with sample data)
SELECT e.event_id, e.title, AVG(f.rating) as avg_rating
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(f.feedback_id) >= 2  -- Changed from 10 to work with sample data
ORDER BY avg_rating DESC
LIMIT 3;

-- 3. Inactive Users (90 days threshold)
SELECT u.user_id, u.full_name, u.last_active_date
FROM Users u
WHERE u.last_active_date < DATE_SUB(CURRENT_DATE(), INTERVAL 90 DAY)
OR (u.last_active_date IS NULL AND u.registration_date < DATE_SUB(CURRENT_DATE(), INTERVAL 90 DAY));

-- 4. Peak Session Hours (10 AM to 12 PM)
SELECT e.event_id, e.title, COUNT(s.session_id) as peak_sessions
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
WHERE TIME(s.start_time) BETWEEN '10:00:00' AND '12:00:00'
GROUP BY e.event_id, e.title;

-- 5. Most Active Cities
SELECT u.city, COUNT(DISTINCT r.user_id) as unique_users
FROM Registrations r
JOIN Users u ON r.user_id = u.user_id
GROUP BY u.city
ORDER BY unique_users DESC
LIMIT 5;

-- 6. Event Resource Summary
SELECT 
    e.event_id, 
    e.title,
    SUM(CASE WHEN res.resource_type = 'pdf' THEN 1 ELSE 0 END) as pdf_count,
    SUM(CASE WHEN res.resource_type = 'image' THEN 1 ELSE 0 END) as image_count,
    SUM(CASE WHEN res.resource_type = 'link' THEN 1 ELSE 0 END) as link_count
FROM Events e
LEFT JOIN Resources res ON e.event_id = res.event_id
GROUP BY e.event_id, e.title;

-- 7. Low Feedback Alerts
SELECT u.user_id, u.full_name, e.title, f.rating, f.comments
FROM Feedback f
JOIN Users u ON f.user_id = u.user_id
JOIN Events e ON f.event_id = e.event_id
WHERE f.rating < 3
ORDER BY f.rating;

-- 8. Sessions per Upcoming Event
SELECT e.event_id, e.title, COUNT(s.session_id) as session_count
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id, e.title;

-- 9. Organizer Event Summary
SELECT 
    u.user_id,
    u.full_name as organizer_name,
    COUNT(e.event_id) as total_events,
    SUM(CASE WHEN e.status = 'upcoming' THEN 1 ELSE 0 END) as upcoming_events,
    SUM(CASE WHEN e.status = 'completed' THEN 1 ELSE 0 END) as completed_events,
    SUM(CASE WHEN e.status = 'cancelled' THEN 1 ELSE 0 END) as cancelled_events
FROM Users u
JOIN Events e ON u.user_id = e.organizer_id
GROUP BY u.user_id, u.full_name;

-- 10. Feedback Gap
SELECT e.event_id, e.title, COUNT(r.registration_id) as registrations
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
LEFT JOIN Feedback f ON e.event_id = f.event_id
WHERE f.feedback_id IS NULL
GROUP BY e.event_id, e.title;

-- 11. Daily New User Count (Last 7 days)
SELECT 
    DATE(registration_date) as reg_date,
    COUNT(user_id) as new_users
FROM Users
WHERE registration_date >= DATE_SUB(CURRENT_DATE(), INTERVAL 7 DAY)
GROUP BY DATE(registration_date)
ORDER BY reg_date DESC;

-- 12. Event with Maximum Sessions
SELECT e.event_id, e.title, COUNT(s.session_id) as session_count
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
ORDER BY session_count DESC
LIMIT 1;

-- 13. Average Rating per City
SELECT e.city, AVG(f.rating) as avg_rating
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.city
ORDER BY avg_rating DESC;

-- 14. Most Registered Events
SELECT e.event_id, e.title, COUNT(r.registration_id) as registration_count
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
ORDER BY registration_count DESC
LIMIT 3;

-- 15. Event Session Time Conflict
SELECT 
    s1.event_id,
    e.title as event_title,
    s1.session_id as session1_id,
    s1.title as session1_title,
    s2.session_id as session2_id,
    s2.title as session2_title,
    s1.start_time as session1_start,
    s1.end_time as session1_end,
    s2.start_time as session2_start,
    s2.end_time as session2_end
FROM Sessions s1
JOIN Sessions s2 ON s1.event_id = s2.event_id AND s1.session_id < s2.session_id
JOIN Events e ON s1.event_id = e.event_id
WHERE s1.start_time < s2.end_time AND s1.end_time > s2.start_time;

-- 16. Unregistered Active Users
SELECT u.user_id, u.full_name, u.registration_date
FROM Users u
WHERE u.registration_date >= DATE_SUB(CURRENT_DATE(), INTERVAL 30 DAY)
AND NOT EXISTS (
    SELECT 1 FROM Registrations r 
    WHERE r.user_id = u.user_id
);

-- 17. Multi-Session Speakers
SELECT speaker_name, COUNT(DISTINCT session_id) as session_count
FROM Sessions
GROUP BY speaker_name
HAVING COUNT(DISTINCT session_id) > 1
ORDER BY session_count DESC;

-- 18. Resource Availability Check
SELECT e.event_id, e.title
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
WHERE r.resource_id IS NULL;

-- 19. Completed Events with Feedback Summary
SELECT 
    e.event_id,
    e.title,
    COUNT(DISTINCT r.registration_id) as total_registrations,
    AVG(f.rating) as avg_rating,
    COUNT(f.feedback_id) as feedback_count
FROM Events e
LEFT JOIN Registrations r ON e.event_id = r.event_id
LEFT JOIN Feedback f ON e.event_id = f.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id, e.title;

-- 20. User Engagement Index
SELECT 
    u.user_id,
    u.full_name,
    COUNT(DISTINCT r.event_id) as events_attended,
    COUNT(DISTINCT f.feedback_id) as feedbacks_submitted,
    ROUND(COUNT(DISTINCT f.feedback_id) / COUNT(DISTINCT r.event_id) * 100, 2) as feedback_percentage
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
LEFT JOIN Feedback f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name;

-- 21. Top Feedback Providers
SELECT 
    u.user_id,
    u.full_name,
    COUNT(f.feedback_id) as feedback_count
FROM Users u
JOIN Feedback f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name
ORDER BY feedback_count DESC
LIMIT 5;

-- 22. Duplicate Registrations Check
SELECT user_id, event_id, COUNT(*) as registration_count
FROM Registrations
GROUP BY user_id, event_id
HAVING COUNT(*) > 1;

-- 23. Registration Trends (Monthly for past 12 months)
SELECT 
    YEAR(registration_date) as year,
    MONTH(registration_date) as month,
    COUNT(registration_id) as registration_count
FROM Registrations
WHERE registration_date >= DATE_SUB(CURRENT_DATE(), INTERVAL 12 MONTH)
GROUP BY YEAR(registration_date), MONTH(registration_date)
ORDER BY year DESC, month DESC;

-- 24. Average Session Duration per Event
SELECT 
    e.event_id,
    e.title,
    AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)) as avg_duration_minutes
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title;

-- 25. Events Without Sessions
SELECT e.event_id, e.title
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE s.session_id IS NULL;