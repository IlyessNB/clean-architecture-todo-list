# Clean Todolist

## How to use this app
1. Allow the execution of the scripts with `chmod +x run.sh` 
2. You can run the app with `./run.sh` and the following arguments :
=> When there are spaces in your arguments, you need to put them between quotes with a backslash before the quotes like this : `\"your argument\"`
- `./run.sh add -c \"hello world\"` => will add a task with the content "hello world" and a due date of null
- `./run.sh add -c \"finalize the agenda exercise\" -d "2022-03-01T12:00:00"` => will add a task with the content "finalize the agenda exercise" and a due date of "2022-03-01"
- `./run.sh add -p "123" -c \"finalize the agenda exercise\" -d "2022-03-01T12:00:00"` => will add a subtask with the content "finalize the agenda exercise" and a due date of "2022-03-01" to the task with the id "123"
- `./run.sh list` => will list all the tasks and subtasks that are not done
- `./run.sh update "123" -d "2022-04-01T12:00:00"`
- `./run.sh remove "123"`
- `./run.sh update "123" -s "done"`
Options :
- `-c` means content
- `-d` due date
- `-s` status
- `-p` parent task id
3. You can find your tasks in the file `$HOME/consoleagenda/data.json`
4. You can find your logs in the file `$HOME/consoleagenda/logs.txt`


## How to test this app
1. Allow the execution of the scripts with `chmod +x test.sh`
2. Run the tests with `./test.sh`
