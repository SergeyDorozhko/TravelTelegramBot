                    Main requirements:

     Create web application to manage their own travel telegram. bot.

1) Telegram bot gives the user background information on the introduced city.
For example, the user enters: "Moscow", chat-bot answers: "don't forget to visit
Red Square. Well, cum can not go)))".

2) Data about cities must be stored in the database.

3) to Manage the data about the cities (add new cities and information about them,
edit, and delete any information) through REST WebService.



     Technology stack:

- SpringBoot
- SpringMVC
- SpringData
- Hibernate
- Java (1.8. or more)
- Maven



     For deploing:
- All database configuration make for PostgreSql10 
- in root directoty of project You can find 'sql' package with SQL scripts (create, init, drop database).
- TelegramBot: 
		name: HaveToSeeBot
		token: 1097774258:AAF_SEyicYlQI5aTm1dQ8Th0WiIV81HyHXk
- You can find Postman backup in package 'postman' in root of project.


     Rest API:

Example: 

GET: /guides/id - Get guide by id.

POST: /guides - Create new guide.
body json example:
{
    "city": "moscow",
    "cityInfo": "don't forget to visit Red Square. Well, cum can not go)))"
}

DELETE: /guides/id - Delete guide by id.

PUT: /guides/ - Update guide.
body json example:
{
    "id": 1,
        "city": "moscow",
    "cityInfo": "don't forget to visit Red Square. Well, cum can not go)))"
}



