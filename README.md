# Project: promotion-ddd

**Description:**
This is a demo project implementing Domain-Driven Design (DDD) principles. The project hosts three main modules - `activity-service`, `prize-service`, and `budget-service`.
- `activity-service`: Manages the creation of activities.
- `prize-service`: Handles the prizes associated with activities.
- `budget-service`: Manages budget allocation for activities.

**Technology Stack:**
The project is developed using the Spring Cloud framework for building microservices.

**Modules:**
1. **activity-service**:
    - Responsible for activity creation.

2. **prize-service**:
    - Manages prizes linked to activities.

3. **budget-service**:
    - Handles budget allocation for activities.

**Framework:**
Spring Cloud framework is utilized for developing the microservices architecture.

**Installation:**
1. Clone the repository:
    ```
    git clone <repository_url>
    cd promotion-ddd
    ```

2. Build and run each module separately:
    - For `activity-service`:
        ```
        cd activity-service
        mvn spring-boot:run
        ```

    - For `prize-service`:
        ```
        cd prize-service
        mvn spring-boot:run
        ```

    - For `budget-service`:
        ```
        cd budget-service
        mvn spring-boot:run
        ```

**Usage:**
- Access the services through their respective endpoints to interact with the activity, prize, and budget functionalities.

**License:**
This project is licensed under the MIT License - see the [LICENSE.md](./LICENSE.md) file for details.

---

Feel free to customize this template further to include more specific details or instructions relevant to your project.
