# Citizen Service Request System - Municipal Government

This project aims to provide a centralized platform for citizens to open service requests directly with the municipal government, making it easier to report issues and receive appropriate responses.

## 🧱 Architecture

The system is built in **Java 21**, following the **Hexagonal Architecture (Ports and Adapters)** approach. This design ensures a clear separation between business logic and the external systems that interact with it.

### 💡 Inputs (Driving Adapters)

- 🌐 **Web**: Browser-accessible interface for citizens
- 📱 **Mobile**: Integration with a mobile application
- ☎️ **Telephone**: Requests submitted via call center operators using a backend API

### 🧩 Core (Application Domain)

- Business rules and use cases related to service request handling
- Fully independent from frameworks and external technologies

### 🔌 Outputs (Driven Adapters)

- **PostgreSQL** database for persistence
- Notification systems (email, SMS, etc.)
- Integrations with internal municipal systems

## 🚀 Technologies

- Java 21
- Spring Boot
- Hexagonal Architecture (Ports and Adapters)
- PostgreSQL
- RESTful APIs
- OpenAPI / Swagger (API documentation)

## 📁 Project Structure

