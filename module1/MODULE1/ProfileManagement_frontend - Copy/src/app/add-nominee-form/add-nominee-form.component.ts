import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NomineeService } from '../nominee.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-add-nominee-form',
  templateUrl: './add-nominee-form.component.html',
  styleUrls: ['./add-nominee-form.component.css'],
})
export class AddNomineeFormComponent implements OnInit {
  nominee: any = {
    name: '',
    username: '', // Update the property to nominee.username
    gender: '',
    idProofType: '',
    nomineeType: '',
  };

  constructor(
    private nomineeService: NomineeService,
    private router: Router,
    private userService: UserService
  ) {}

  setUsername(username: string): void {
    this.nominee.username = username; // Set the value of nominee.username
  }

  ngOnInit(): void {}

  addNominee(): void {
    console.log(this.nominee);
    const username = this.userService.getUsername(); // Get the username from the service
    if (username) {
      this.userService.checkProfileExists(username).subscribe(
        (profileExists) => {
          if (profileExists) {
            this.userService.setUsername(username); // Set the username in the UserService
            this.nomineeService.setUsername(username); // Set the username in the NomineeService
            this.nomineeService.addnominee(username, this.nominee).subscribe(
              () => {
                console.log('Nominee added successfully!');
                this.router.navigate(['new-profile']);
              },
              (error) => {
                console.error('Failed to add nominee:', error);
              }
            );
          } else {
            console.error('Profile does not exist for the username:', username);
          }
        },
        (error) => {
          console.error('Failed to check profile existence:', error);
        }
      );
    } else {
      console.error('Username is undefined');
    }
  }

  submitForm(): void {
    this.userService.setUsername(this.nominee.username); // Set the username in the UserService
    this.addNominee();
  }
}
