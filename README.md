# Task Tracker CLI

This is a command line app to track and edit tasks on a to-do list that you create.

## How to compile
`javac -d bin src/roadmapProject1/*.java`

## Commands

adding a task: `java -cp bin roadmapProject1.Main add "<description>"`

listing all tasks: `java -cp bin roadmapProject1.Main list`

updating a task's description: `java -cp bin roadmapProject1.Main update <task id> "<new description>"`

updating a task's status to be in-progress: `java -cp bin roadmapProject1.Main mark-in-progress <task id>`

updating a task's status to be done: `java -cp bin roadmapProject1.Main mark-done <task id>`

deleting a task: `java -cp bin roadmapProject1.Main delete <task id>`

listing tasks according to their status: `java -cp bin roadmapProject1.Main list <status>`
(valid statuses: todo, in-progress, done)

## Project
https://roadmap.sh/projects/task-tracker-cli