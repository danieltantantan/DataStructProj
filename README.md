# CS201Proj
## How to run
1. cd into the root folder of the implementation you want to test
Example:
```shell
cd Trie-with-built-in-hashmap
```
2. Run the compile.bat to compile the classes
```shell
compile.bat
```
3. Run the run.bat with the specific search query that you want to search for. 
This will run ProcessCSV, which will then create the CSV file to be built into the trie.
Currently, these words are in the dictionary:
[artificial intelligence, covid-19,cybersecurity courses,data science,donald trump,fishing sleeping,internship,nus computer science,smu computer science]

Template:
```shell
run.bat "word you want to test"
```

Example:
```shell
run.bat "covid 19"
```

