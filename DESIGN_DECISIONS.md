
## Design decisions

### File structure
    - Domain : all the business logic (models like Task, TodoList, interfaces like TodoListRepository etc.)
    - Infrastructure : contains the technical logic (implementations of interfaces, like TodoListFileRepository, JavaIoFileReader etc.)
    - Kernel : represents the application core (interfaces like Command, Query etc.)
    - Application : contains the application logic (commands, queries, command handlers, query handlers etc.)

### Domain:
#### Interface:
Il nous était important dans ce projet de respecter le principe SOLID de l'inversion de dépendance.
C'est pourquoi nous avons créé des interfaces pour les classes qui ont des dépendances externes.
Cela permet de pouvoir changer facilement d'implémentation sans avoir à modifier le code de la classe qui utilise cette dépendance.
Ce qui est très utile pour les tests unitaires par exemple.
Ce découpage permet aussi de distinguer les inputs, les outputs et les traitements de l'application :
    - Input:
        - UserAction
    - Traitement: 
        - FileReader
        - TodoListDeserializer
        - TodoListSerializer
    - Output:
        - TodoListRepository
        - FileWriter
        - ErrorMessageGenerator
        - OkMessageGenerator

#### Class:
Nous avons créé des classes pour représenter les différents objets de notre application :
    - Task : Représente une tâche (id, description, statut, date de création, date de fin)
    - TodoList : Liste de tâches

### Infrastructure:
Ici, nous avons implémenté les interfaces définies dans le domaine.
Nous avons aussi créé des classes pour gérer les exceptions et les messages d'erreur et de succès à sauvegarder dans un fichier de log.
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
Nous avons créé des interfaces pour représenter les différents types de commandes et de requêtes.
Cela permet de pouvoir créer des commandes et des requêtes différentes sans avoir à modifier le code de l'application.
    - Command Interface
    - Query Interface
    - UserActionHandler Interface

### Application:
Enfin, nous avons créé des classes pour représenter les commandes et les requêtes
et des classes pour gérer les commandes et les requêtes.
Ainsi, une fois qu'une commande ou une requête est créée, il suffit de récupérer dans un mapping le bon handler afin de l'exécuter.
    - Commands : Add, Update, Remove
    - CommandHandlers
    - Query : List
    - QueryHandler
