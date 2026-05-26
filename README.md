# ADRO
## Movie Ticket Reservation System

ADRO is a JavaFX-based movie ticket reservation system backed by MySQL.

### Prerequisites
- Java 17
- MySQL

### Configuration
Set these environment variables to point the application at your database:

- `ADRO_DB_HOST` (default: `127.0.0.1`)
- `ADRO_DB_PORT` (default: `3306`)
- `ADRO_DB_NAME` (default: `adro`)
- `ADRO_DB_USERNAME` (default: `root`)
- `ADRO_DB_PASSWORD` (default: empty)

### Database schema (minimum required columns)
```sql
CREATE TABLE register (
  fullname VARCHAR(255),
  email VARCHAR(255),
  phone VARCHAR(50),
  username VARCHAR(255) PRIMARY KEY,
  password VARCHAR(255),
  dateOfBirth DATE
);

CREATE TABLE admin (
  username VARCHAR(255) PRIMARY KEY,
  password VARCHAR(255)
);

CREATE TABLE movies (
  title VARCHAR(255),
  description TEXT,
  genre VARCHAR(100),
  language VARCHAR(100),
  duration INT,
  number_tickets INT,
  session VARCHAR(50),
  start_date DATE,
  end_date DATE,
  price INT
);

CREATE TABLE cart (
  Movie_name VARCHAR(255),
  Movie_theatre VARCHAR(255),
  Movie_id VARCHAR(255),
  Language VARCHAR(100),
  Movie_time DATE,
  Tickets_num INT,
  Price VARCHAR(50)
);
```

### Run
```bash
./mvnw javafx:run
```

### Tests
```bash
./mvnw test
```
