import { Component, OnInit } from '@angular/core';
import {ControlContainer, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.scss', '../../../styles.scss']
})
export class EmployeeFormComponent implements OnInit {
  employeeForm!: FormGroup;
  constructor(private controlContainer: ControlContainer) {
  }

  ngOnInit(): void {
    this.employeeForm = this.controlContainer.control as FormGroup; 
  }

  inputList: {type: string, name: string, id: string}[] = [
    {type:'email', name:'E-mailadres', id: 'emailAddress'},
    {type:'text', name:'Voornaam', id: 'firstname'},
    {type:'text', name:'Achternaam', id: 'lastname'},
    {type:'date', name:'Geboortedatum', id: 'birthdate'},
    {type:'text', name:'Woonplaats', id: 'city'},
  ];

  gender = 'gender';
  geslacht = 'Geslacht';
  genders: {name: string, value: string}[] =[
    {name:'Man', value:'M'},
    {name: 'Vrouw', value:'F'},
    {name: 'Overig', value:'O'}
  ];

}
