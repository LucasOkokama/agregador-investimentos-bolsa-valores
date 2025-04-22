
# About the project
This project is an investment aggregator platform that allows users to create an account, register investment portfolios, and associate specific stocks with each portfolio. It integrates with the [`Brapi API`](https://brapi.dev/) to fetch real-time stock prices, enabling the system to calculate the total amount invested in each stock within a given account. The application provides a structured and centralized way to monitor investments, track individual holdings, and evaluate portfolio value based on current market data.



# Tech Stack
The project is developed with Java and Spring Boot, which handle the backend logic for managing users, investment accounts, and stock associations. It integrates with the Brapi API to fetch real-time stock prices and calculate the total value of investments per account. Data persistence is managed with MySQL, running in a Docker container to provide an isolated and consistent environment. Unit testing is implemented using JUnit and Mockito to ensure the reliability and correctness of the core application logic.
<table align="center">
    <tr>
        <th></th>
        <th>
            Frontend
        </th>
        <th>
            Backend
        </th>
    </tr>
    <tr>
        <th>
            Languages
        </th>
        <td></td>
        <td>
            <img alt="Java" src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" />
        </td>
    </tr>
    <tr>
        <th>
            Frameworks
        </th>
        <td></td>
        <td>
            <img alt="Spring Boot" src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" />
        </td>
    </tr>
    <tr>
        <th>
            Database
        </th>
        <td></td>
        <td>
            <img alt="MySQL" src="https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white" />
        </td>
    </tr>
    <tr>
        <th>
            Unit Testing
        </th>
        <td></td>
        <td>
            <img alt="JUnit" src="https://img.shields.io/badge/JUnit-_?style=for-the-badge&logo=junit5&logoColor=%23fff&color=%23DC524A" />
        </td>
    </tr>
    <tr>
        <th>
            IDE / Editor
        </th>
        <td></td>
        <td>
            <img alt="IntelliJ IDEA" src="https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" />
        </td>
    </tr>
    <tr>
        <th>
            Dev Tool
        </th>
        <td></td>
        <td>
            <img alt="Docker" src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white" />
        </td>
    </tr>
</table>



# Requirements
1. Install [`Java JDK`](https://www.oracle.com/java/technologies/downloads/) to run Java applications.
2. Install [`MySQL`](https://www.mysql.com/downloads/) to manage the tables.
3. Install [`Docker`](https://www.docker.com/) to create a container to run MySQL.

   

# How to run locally (command line)
1. Run a `git clone` of the repository:
```
git clone https://github.com/LucasOkokama/agregador-investimentos-bolsa-valores
```
2. Start the `Docker application` and `run the container` with the MySQL image:
```
cd agregador-investimentos-bolsa-valores
docker compose up
```
3. Open MySQL Workbench and `add a new user account` with:
```
MYSQL_USER=springuser
MYSQL_PASSWORD=ThePassword
```
4. Create a `new connection` using the user account created.
5. Get your [`Brapi API Key`](https://brapi.dev/) and add it as an `environment variable` in IntelliJ IDEA.
6. Run `AgregadorinvestimentosApplication.java`.
7. `Make some requests` using Postman or similar tools.

# References
This project was created based on the video [`[ADI #1] - Creating a CRUD with Java Spring Boot and MySQL`](https://www.youtube.com/watch?v=Tnl4YnB6E54) (and its subsequent episodes) produced by [`Build & Run`](https://github.com/buildrun-tech). The complete project can be found in the repository [`buildrun-investment-aggregator`](https://github.com/buildrun-tech/buildrun-agregador-de-investimentos/tree/crud-usuarios).



# License
```
MIT License

Copyright (c) 2025 Lucas Kazuhiro Okokama

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
