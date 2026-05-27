# Task Tracker CLI

A command-line task management application built in Java. Supports creating, updating, deleting, and filtering tasks by status — all persisted locally without any external dependencies.

Built as part of the [roadmap.sh backend project track](https://roadmap.sh/projects/task-tracker-cli) to apply OOP principles and practice real-world CLI design.

---

## Architecture

The project is structured across 4 classes with clear separation of concerns:

| Class | Responsibility |
|---|---|
| `Main` | Entry point — parses CLI arguments and routes commands |
| `TaskManager` | Business logic — handles all task operations |
| `JsonHandler` | Persistence layer — reads and writes tasks to local storage |
| `Task` | Data model — represents a task and its properties |

---

## Features

- Add tasks with a description
- Update task descriptions
- Delete tasks by ID
- Mark tasks as `todo`, `in-progress`, or `done`
- Filter and list tasks by status
- Tasks persist between sessions via local file storage

---

## Getting Started

### Compile

```bash
javac -d bin src/roadmapProject1/*.java
```

### Usage

```bash
# Add a task
java -cp bin roadmapProject1.Main add "<description>"

# List all tasks
java -cp bin roadmapProject1.Main list

# List by status (todo | in-progress | done)
java -cp bin roadmapProject1.Main list <status>

# Update a task's description
java -cp bin roadmapProject1.Main update <id> "<new description>"

# Mark as in-progress
java -cp bin roadmapProject1.Main mark-in-progress <id>

# Mark as done
java -cp bin roadmapProject1.Main mark-done <id>

# Delete a task
java -cp bin roadmapProject1.Main delete <id>
```

---

## Tech

- Java
- OOP design principles
- File-based persistence (no external libraries or databases)
