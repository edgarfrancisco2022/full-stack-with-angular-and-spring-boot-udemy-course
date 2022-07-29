import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TodoDataService } from '../service/data/todo-data.service';

export class Todo {

  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date
  ) {

  }
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos: Todo[] | undefined;
  // todos = [
  //   new Todo(1, 'Learn Angular', false, new Date()),
  //   new Todo(2, 'Learn TypeScript', false, new Date()),
  //   new Todo(3, 'Learn React', false, new Date())
  //   // {id : 1, description: 'Learn Angular'},
  //   // {id : 2, description: 'Learn TypeScript'},
  //   // {id : 3, description: 'Learn React'}
  // ]

  message: string | undefined;

  constructor(private todoService: TodoDataService,
              private router: Router) { }

  ngOnInit(): void {
    this.refreshTodos();
  }

  refreshTodos() {
    this.todoService.retrieveAllTodos('in28minutes').subscribe(
      response => {
        console.log(response);
        this.todos = response;
      }
    )
  }

  deleteTodo(id: any) {
    // console.log(`Delete todo ${id}`);
    this.todoService.deleteTodo('in28minutes', id).subscribe(
      response => {
        console.log(response);
        this.message = `Delete of Todo ${id} Successful!`;
        this.refreshTodos();
      }
    );
  }

  updateTodo(id: any) {
    console.log(`Update ${id}`);
    this.router.navigate(['todos', id]);
  }

  addTodo() {
    this.router.navigate(['todos', -1]);
  }
}
