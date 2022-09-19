import {Component, Input, OnInit} from '@angular/core';
import {ControlContainer, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-dropdown-form',
  templateUrl: './dropdown-form.component.html',
  styleUrls: ['./dropdown-form.component.scss']
})
export class DropdownFormComponent implements OnInit {
  public dropdownForm!: FormGroup;
  @Input()objects: { value: string; name: string; }[] | undefined;
  @Input()id: string | undefined;
  @Input()name: string | undefined;

  constructor(private controlContainer: ControlContainer) {
  }

  ngOnInit(): void {
    this.dropdownForm = this.controlContainer.control as FormGroup;
  }

}
