# Mobile Shop

## Project Description

Mobile Shop is a application user can perchese mobiles. user can login / signup, Add products to the cart, Remove products from car. The system will be developed using Java programming language, MySQL as the database management system, and Hibernate as the Object-Relational Mapping (ORM) framework. 

## System Overview

Mobile Shop focuses on delivering an intuitive interface for users to navigate through various mobile devices, make purchases, and manage their shopping experience efficiently.

## Access

Access the Mobile Shop application through the following URL: [Mobile Shop](https://6593a8a973b2164c52441e50--magical-malabi-b00d0b.netlify.app/)

## Key Features

- **Product Catalog:** Browse, filter, and purchase from an extensive collection of mobile devices.
- **User Registration & Profiles:** Create accounts, manage personal details, and track order history.
- **Shopping Cart Functionality:** Add, remove, and manage selected items before purchase.
- **Search & Filter Options:** Easily find specific mobile phones based on brand, features.

## Design Approach and Assumptions

- User-centric design focusing on an engaging and intuitive shopping experience.
- Assumption: Simplified authentication for demonstration purposes.

## Installation & Getting Started

1. Clone the repository: `git clone <https://github.com/Amit0841/Mobile-Shop>`
2. Running java application.

## User Guide

1. Register/Login using provided credentials.
2. Explore the mobile catalog and select desired devices.
3. Manage the shopping cart: Add, remove, or modify selected items.
5. Utilize search and filter options to find specific mobile phones.

## API Endpoints

### Authentication

- **POST /customer/add:** Register a new user.
- **GET /customer/logini:** Log in an existing user.

### Products

- **GET /mobile/get:** Retrieve all available mobile devices.
- **GET /mobile/get/:id:** Retrieve details of a specific device.
- **POST /mobile/add:** Add a new mobile device to the inventory.
- **DELETE /mobile/delete/:id:** Remove a mobile device from the inventory.

### Cart

- **POST /cart/:customerId:/:mobileId:** Add a mobile to cart.
- **GET /cart/:customerId:** Get all mobile from the customer cart.
- **DELETE /cart/delete/:customerId:/:mobileId:** Remove a mobile device from the cart.
- 
## Technology Stack

- **Front-end:** HTML, CSS, JavaScript
- **Back-end:** Java, Spring Boot
- **Database:** MySQL
- **Authentication:** JWT Tokens
- **Version Control:** Git
