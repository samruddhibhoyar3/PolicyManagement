import { Component, OnInit } from '@angular/core';
import { user } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-profile-form',
  templateUrl: './new-profile-form.component.html',
  styleUrls: ['./new-profile-form.component.css'],
})
export class NewProfileFormComponent implements OnInit {
  User: user = new user();
  generatedUsername: string | undefined = '';
  constructor(private userservice: UserService, private router: Router) {}

  ngOnInit(): void {
    this.generateUsername();
  }

  adduserprofile() {
    console.log(this.User);
    this.userservice.adduserprofile(this.User).subscribe({
      next: (response: any) => {
        console.log(response);
        if (response && response.generatedUsername) {
          this.generatedUsername = response.generatedUsername;
          console.log(this.generatedUsername);
          this.router.navigate(['add-nominee']);
        } else {
          console.error('Invalid response format:', response);
          this.generatedUsername = '';
        }
      },
      error: (error: any) => {
        console.error(error);
        this.generatedUsername = '';
        console.log(this.generatedUsername);
      },
    });
  }

  generateUsername(): string {
    return 'generatedUsername';
  }
}
