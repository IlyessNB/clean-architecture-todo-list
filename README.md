# Clean Todolist

## How to use this app
1. Allow the execution of the scripts with `chmod +x run.sh` 
2. You can run the app with `./run.sh` and the following arguments :
- `./run.sh add -c "hello world"` => will add a task with the content "hello world" and a due date of null
- `./run.sh add -c "finalize the agenda exercise" -d "2022-03-01"` => will add a task with the content "finalize the agenda exercise" and a due date of "2022-03-01"
- `./run.sh add -p "123" -c "finalize the agenda exercise" -d "2022-03-01"` => will add a subtask with the content "finalize the agenda exercise" and a due date of "2022-03-01" to the task with the id "123"
- `./run.sh list` => will list all the tasks and subtasks that are not done
- `./run.sh update "123" -d "2022-04-01"`
- `./run.sh remove "123"`
- `./run.sh update "123" -s "done"`
Options :
- `-c` means content
- `-d` due date
- `-s` status
- `-p` parent task id


## How to test this app
1. Allow the execution of the scripts with `chmod +x test.sh`
2. Run the tests with `./test.sh`

## Design decisions

### Architecture
    - Domain :
    - Infrastructure :
    - Kernel : 
    - Application :

### Domain:
#### Interface:
    - Input:
        - UserAction
    - Traitement: 
        - FileReader
        - TodoListDeserializer
        - FileWriter
        - TodoListSerializer
    - Output:
        - TodoListRepository
        - ErrorMessageGenerator
        - OkMessageGenerator
#### Class:
    - Task
    - TodoList : Liste de task

### Infrastructure:
    - Input :
        - CommandLine
    - Traitement :
        - JavaIoFileReader
        - JavaIoFileWriter
        - JSONTodoListDeserializer
        - JSONTodoListSerializer
        - TodoListFileHandler
    - Output :
        - TodoListFileRepository
        - LogOkMessageGenerator
        - LogErrorMessageGenerator
    
### Kernel:
    - Command Interface
    - Query Interface

### Application:
    - Commands : Add, Update, Remove
    - CommandHandlers
    - Query : List
    - QueryHandler
