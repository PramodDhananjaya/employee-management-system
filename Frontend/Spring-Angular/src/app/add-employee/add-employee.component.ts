import { Component, OnInit } from '@angular/core';
import { Employee, HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  user : Employee = new Employee(" "," "," "," ");

  constructor(private httpClient : HttpClientService) { }

  ngOnInit(): void {
  }

  createEmployee(): void {
    this.httpClient.createEmployee(this.user)
    .subscribe(data => {
      alert("Employee Created Successfully!");
    })
  }


}