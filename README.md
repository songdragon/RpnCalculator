# RpnCalculator

# Requirments
A command-line based RPN
* Basic math operators(+,-,*,/,sqrt)
* Undo and clear functionality

# Folder Structure
|folder|notes|
|---|---|
|doc|design documents|
|src|source code root folder|
|src/rpn-core|RPN core implementation|
|src/cmd-calculator| RPN calculator shell|
|src/release-template|release folder structure|
# Documents
Basic class diagram (Class.puml) to illustrate key classes and their relationships.
## How to read it
Please refer to http://plantuml.com/zh/running .
# Build & Run steps
* On Mac/Linux
  1. sh build.sh.
  2. rpn-calculator.zip will be generated in src/cmd-calculator/target.
  3. unzip rpn-calculator.zip and then execute ./run.sh.
* On Windows
  1. execute build.bat.
  2. rpn-calculator.zip will be generated in src/cmd-calculator/target.
  3. unzip rpn-calculator.zip and then execute run.bat.

* Note     
  Please confirm JDK and maven have been installed.

