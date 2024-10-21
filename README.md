# Library Management System

## Project Overview

The Library Management System is a Spring Boot-based application designed to help librarians manage books, members, and borrowing activities. It supports CRUD operations for books and members, as well as borrowing and returning books. The system enforces borrowing rules such as a maximum number of books a member can borrow and loan duration, ensuring smooth library operations.

## Features

- **Book Management**: Add, update, and remove books from the library catalog.
  - Each book has details like title, author, ISBN, publication year, and availability status.
  
- **Member Management**: Add, update, and remove members.
  - Each member has details like name, member ID, contact information, and borrowing history.
  
- **Borrowing & Returning Books**: Members can borrow and return books, with rules on the number of books and loan durations.
  - Concurrent access is handled to prevent data corruption.

- **Borrowing Rules**:
  - Maximum of 5 books can be borrowed at once.
  - Loan duration of 14 days per book.
  
- **Extensible Design**: The system is designed to be extensible for future enhancements.

## Technology Stack

- **Backend**: Java (JDK 23), Spring Boot
- **Database**: H2 Database (for development), MySQL/PostgreSQL (for production)
- **Build Tool**: Apache Maven 3.9.9
- **Version Control**: Git

## Project Structure


### Key Components

- **Model**: Defines the data structure for `Book`, `Member`, and `Borrow` entities.
- **DAO (Data Access Object)**: Interfaces for interacting with the database (`BookDAO`, `MemberDAO`, `BorrowDAO`).
- **Service**: Business logic layer to handle operations like adding books, borrowing, and returning books.
- **Controller**: RESTful endpoints for interacting with the system.

## Setup and Installation

### Prerequisites

- Java JDK 23
- Apache Maven 3.9.9
- A code editor (e.g., IntelliJ IDEA, Eclipse)
- Git

### Steps

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/hemareddy-bit/LibraryManagement.git
