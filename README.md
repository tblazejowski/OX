
#### Description

Tic-tac-toe (also known as noughts and crosses) **console game for 2 players** developed in TDD.
Game interface is bi-lingual: English and Polish. The whole game consist of 3 matches played in a row.

#### Technical side of this project

##### Minimum requirements

- Linux OS (highly recommended)
- UTF-8 coding
- Java 10
- Maven 3.5.3
- TestNG 6.10

##### How to run application?

Preliminary steps:

- download repository content on your machine
- enter following command: `mvn clean install`

Launch the game

- **Linux users:** Enter following command in terminal to run the application:
`java -jar target/OX-2.0-jar-with-dependencies.jar`
- **Windows users:** execute **run_Wind.bat** file

Enjoy playing!

##### Automated testing

You may emulate automated testing via bash script by running executable file **auto_testOX** with following command:
`./auto_testOX`
The script will simulate 2 games on different bord dimensions (3 and 5) in English and Polish accordingly.
The outcome will be visible under respective files:

- test_3_3.log
- test_5_5.log

##### Log file

Each run creates a file **OX.log** that contains logs from a game.