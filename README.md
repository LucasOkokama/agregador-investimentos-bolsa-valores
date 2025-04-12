
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

   

# How to run locally (command line)
1. Run a `git clone` of the repository:
```
git clone https://github.com/LucasOkokama/pexels-image-search.git
```
2. Open the `pexels-image-search` folder and install the `dependencies`:
```
cd pexels-image-search
npm install
```
3. Create a [`Pexels account`](https://www.pexels.com/api/) and get an `API key`. Next, in the root folder, create a `.env` file and add your API key as follows:
```
VITE_PEXELS_API_KEY=<YOUR_API_KEY_HERE>
```
4. `Run the project`:
```
npm run dev
```
5. Access `localhost` to open the website:
```
http://localhost:5173
```

# References
This project was inspired by the [`Flashdash`](https://flashdash-nine.vercel.app/) website created by [`Paulo Victor`](https://github.com/paulopbi).


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
