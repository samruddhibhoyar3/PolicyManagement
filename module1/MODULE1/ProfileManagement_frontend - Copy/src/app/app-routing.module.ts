import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewProfileFormComponent } from './new-profile-form/new-profile-form.component';
import { AddNomineeFormComponent } from './add-nominee-form/add-nominee-form.component';
import { NomineeComponent } from './nominee/nominee.component';
import { MainpageComponent } from './mainpage/mainpage.component';

const routes: Routes = [
  { path: 'new-profile', component: NewProfileFormComponent },
  { path: 'add-nominee', component: AddNomineeFormComponent },
  { path: 'nominee', component: NomineeComponent },
  { path: '/', component: MainpageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
