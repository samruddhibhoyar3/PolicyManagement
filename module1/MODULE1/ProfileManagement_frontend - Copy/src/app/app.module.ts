import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NewProfileFormComponent } from './new-profile-form/new-profile-form.component';
import { AddNomineeFormComponent } from './add-nominee-form/add-nominee-form.component';
import { NomineeComponent } from './nominee/nominee.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MainpageComponent } from './mainpage/mainpage.component';

const appRoutes: Routes = [
  { path: 'new-profile', component: NewProfileFormComponent },
  { path: 'add-nominee', component: AddNomineeFormComponent },
  { path: 'nominee', component: NomineeComponent },
  { path: '', component: MainpageComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    NewProfileFormComponent,
    AddNomineeFormComponent,
    NomineeComponent,
    MainpageComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
