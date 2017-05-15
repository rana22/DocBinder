# DocBinder
This is spring boot project for saving, managing and retrieving image documents.

##Steps to set up 
1. Clone this project 
2. Import into Spring tool suit
3. To build project, navigate to project using terminal or cmd - mvn clean install
4. To run project - run as 'Spring boot App' 
5. default host: http://localhost:8080

##Setting up test


Test:
POST

url : http://localhost:8090/users/document/saveImg

body{
  file: 'image/path'
}
