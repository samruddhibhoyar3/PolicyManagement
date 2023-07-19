import { Component } from '@angular/core';
import { NomineeService } from '../nominee.service';

@Component({
  selector: 'app-nominee',
  templateUrl: './nominee.component.html',
  styleUrls: ['./nominee.component.css'],
})
export class NomineeComponent {
  username: string = '';
  nominee: any = {};

  constructor(private profileService: NomineeService) {}

  searchNominee() {
    this.profileService.getNominee(this.username).subscribe(
      (response: any) => {
        if (response) {
          this.nominee = response;
        } else {
          console.error('Invalid response format:', response);
        }
      },
      (error: any) => {
        console.error(error);
      }
    );
  }

  deleteNominee() {
    this.profileService.deleteNominee(this.username).subscribe(
      (response: any) => {
        console.log('Nominee deleted successfully:', response);
        this.nominee = {};
      },
      (error: any) => {
        console.error(error);
      }
    );
  }
}
