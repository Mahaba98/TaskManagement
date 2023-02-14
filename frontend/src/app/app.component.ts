import { Component } from '@angular/core';
import { TaskService  } from 'src/services/task.service';

import { OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [TaskService]
})
export class AppComponent implements OnInit{
  title = 'frontend';
  tasks: Object | any;

  constructor(private taskService: TaskService) {

  }

  ngOnInit(): void {
      console.log("On init...");
      this.taskService.getTasks().subscribe((data) => {
        this.tasks = data;
      })
  }
}
