# 🚖 GoCabs - Cab Booking REST API

A Spring Boot REST API for cab booking management, built with Java, Spring Data JPA, and MySQL.

---

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot 4.0.5**
- **Spring Data JPA** (Hibernate 7.2.7)
- **MySQL 8.0**
- **Lombok**
- **Maven**

---

## 📁 Project Structure

```plaintext
src/main/java/com/example/GoCabs/
├── controller/
│   ├── BookingController.java
│   ├── CabController.java
│   ├── CustomerController.java
│   └── DriverController.java
├── service/
│   ├── BookingService.java
│   ├── CabService.java
│   ├── CustomerService.java
│   └── DriverService.java
├── repository/
│   ├── BookingRepository.java
│   ├── CabRepository.java
│   ├── CustomerRepository.java
│   └── DriverRepository.java
├── model/
│   ├── Booking.java
│   ├── Cab.java
│   ├── Customer.java
│   └── Driver.java
├── dto/
│   ├── request/
│   └── responce/
├── transformer/
├── exceptions/
└── Enum/
```

## 🔗 API Endpoints

### 👤 Customer
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/customer/add` | Register new customer |

### 🧑‍✈️ Driver
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/driver/add` | Register new driver |

### 🚕 Cab
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/cab/register/driver/{driverId}` | Register cab for a driver |

### 📋 Booking
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/booking/book/customer/{customerId}` | Book a cab for customer |

---

## 📨 Sample Requests

### Add Customer
```json
POST /customer/add
{
    "name": "Rahul Verma",
    "email": "rahul.verma@gmail.com",
    "age": 30,
    "gender": "MALE"
}
```

### Add Driver
```json
POST /driver/add
{
    "name": "Amit Patel",
    "email": "amit.patel@gmail.com",
    "age": 28
}
```

### Register Cab
```json
POST /cab/register/driver/1
{
    "cab_number": 1234,
    "cab_model": "Maruti Swift Dzire",
    "per_km_rate": 12.5
}
```

### Book a Cab
```json
POST /booking/book/customer/1
{
    "pickup": "Nariman Point, Mumbai",
    "destination": "Bandra Kurla Complex, Mumbai",
    "distance_in_km": 18
}
```

---

## ⚙️ Setup & Run

### Prerequisites
- Java 21
- MySQL 8.0
- Maven

### Steps

**1. Clone the repo**
```bash
git clone https://github.com/RJSHIVA/GoCabs.git
cd GoCabs
```

**2. Create MySQL database**
```sql
CREATE DATABASE gocabs;
```

**3. Configure `application.properties`**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gocabs?allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

**4. Run the application**
```bash
mvn spring-boot:run
```

App will start on `http://localhost:8080`

---

## 🔄 Booking Flow
Add Customer  →  get customer_id
Add Driver    →  get driver_id
Register Cab  →  use driver_id
Book Cab      →  use customer_id
---

## 🚨 Exception Handling

| Exception | HTTP Status | Trigger |
|-----------|-------------|---------|
| `CustomerNotFoundException` | 404 | Customer ID not found |
| `driverNotFoundException` | 404 | Driver ID not found |
| `cabNotFoundException` | 404 | No cab available |

---

## 👨‍💻 Author

**Rahul Choudhary**  
IIT BHU - Ceramic Engineering  
[GitHub](https://github.com/RJSHIVA)
