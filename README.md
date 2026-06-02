# WorkFlex Coding Challenge - Full Stack

This project is a full-stack application developed as part of a 2.5-hour coding challenge. it consists of a Spring Boot API and an Angular web application managed within an Nx monorepo.

## Project Overview

The application manages "Workations" (work + vacation), allowing users to view a list of workation records. The data is persisted in a local SQLite database and pre-populated from a CSV file during the initial startup.

## Technology Stack

- **Backend:** Spring Boot 3.x, Java 17, Spring Data JPA, Hibernate, SQLite, Maven.
- **Frontend:** Angular, Nx Workspace, TypeScript, Tailwind CSS (optional).
- **Tooling:** Nx for monorepo management.

## Prerequisites

- **Java 17** or higher.
- **Node.js** (v18+) and **npm**.
- **Maven** (optional, wrapper included).

## Getting Started

### 1. Install Dependencies

From the root of the workspace, run:

```bash
npm install
```

### 2. Run the Backend API

The API runs on `http://localhost:8000`.

```bash
npx nx serve api
```

The database will be created automatically (`apps/api/database.db`) and populated with data from `apps/api/src/main/resources/csv/workations.csv`.

### 3. Run the Web Application

The frontend runs on `http://localhost:4200`.

```bash
npx nx serve web
```

## API Documentation

Once the API is running, you can access the Swagger UI for interactive documentation:
- [http://localhost:8000/swagger-ui.html](http://localhost:8000/swagger-ui.html)

### Endpoints
- `GET /workflex/workation`: Retrieve the list of all workations.

## Implementation Notes

- **Database:** Uses SQLite for zero-configuration local setup. The path is set to `database.db` in the project root for portability.
- **CORS:** Enabled on the API to allow the Angular development server to fetch data.
- **ID Strategy:** The `Workation` entity uses `String` as the ID type to match the provided CSV identifiers (e.g., "w1", "w2").
- **Standalone Components:** The Angular application uses standalone components for modern best practices.

## Running Tests

### API Tests
```bash
npx nx test api
```
Includes unit tests for the service layer and integration tests for the controller using MockMvc.

### Web Tests
```bash
npx nx test web
```
