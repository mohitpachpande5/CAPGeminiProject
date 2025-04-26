---

# Donor CRUD Application

## Overview

This project is a **Donor Management CRUD Application** developed as part of the CAPGemini Internship.  
It is a full-stack web application built using **Angular** (frontend) and **Spring Boot** (backend), with **MySQL** as the database.

Users can **create**, **view**, **edit**, and **delete** donor information through a clean, responsive, and dynamic UI.

---

## Features

- Add new donors with their information
- Edit existing donor details
- View detailed donor information
- Delete donors
- Animated gradient backgrounds and modern UI
- Smooth user experience with real-time updates

---

## Technologies Used

- **Frontend**: Angular 16, Bootstrap 5
- **Backend**: Spring Boot (Java)
- **Database**: MySQL
- **Styling**: Bootstrap 5 + Custom CSS

---

## Prerequisites

Before running the project, ensure you have:

- **Node.js** (v14 or above)
- **Angular CLI** (v12 or above)
- **Java JDK** (v11 or above)
- **Spring Boot** (v2.7 or above)
- **MySQL** (v8.0 or above)

---

## Setup Instructions

### Backend (Spring Boot)

1. Clone the repository:

   ```bash
   git clone https://github.com/mohitpachpande5/CAPGeminiProject.git
   ```

2. Navigate to the backend project folder:

   ```bash
   cd CAPGeminiProject/backend
   ```

3. Set up your database configuration inside `application.properties`.

4. Run the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

The backend server will start on:  
`http://localhost:8080`

---

### Frontend (Angular)

1. Navigate to the frontend project folder:

   ```bash
   cd CAPGeminiProject/frontend
   ```

2. Install project dependencies:

   ```bash
   npm install
   ```

3. Start the Angular development server:

   ```bash
   ng serve
   ```

The frontend will be available at:  
`http://localhost:4200`

---

## Outputs

### Home Page

> Displays a list of all donors with options to view, edit, or delete.

![Home Page](https://github.com/user-attachments/assets/8946e4ec-7806-4b4d-862d-4ee8f54d0c03)

---

### Add Donor

> Allows the user to add a new donor's details.

![Add Donor Form](https://github.com/user-attachments/assets/bd72fdf4-8909-4e33-8727-f67bc7ae361b)

> After successfully adding a donor, details are displayed.

![Donor Added Details](https://github.com/user-attachments/assets/37ee4ae5-3e79-4824-aafc-e06cd68fc7be)

---

### Edit Donor

> Edit the information of an existing donor.

![Edit Donor Form](https://github.com/user-attachments/assets/72d08b89-b95e-4dfd-b9e3-b1ff7f017430)

---

### Delete Donor

> Confirm donor deletion from the list.

![Before Deleting Donor](https://github.com/user-attachments/assets/fcbf7763-52bf-4d95-9687-2e94cdae888f)

> After successful deletion, the donor is removed from the list.

![After Deleting Donor](https://github.com/user-attachments/assets/5f626971-5f4a-423d-a92a-81f3cf370af3)

---

## API Endpoints

| Method | Endpoint | Description |
|:------:|:--------:|:-----------:|
| GET    | `/donors` | Fetch all donors |
| GET    | `/donors/{id}` | Fetch donor by ID |
| POST   | `/donors` | Add a new donor |
| PUT    | `/donors/{id}` | Update existing donor |
| DELETE | `/donors/{id}` | Delete donor |

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Author

**Mohit Pachpande**  
[GitHub Profile](https://github.com/mohitpachpande5)

---
