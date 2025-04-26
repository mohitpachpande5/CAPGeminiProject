import { Routes } from '@angular/router';
import { DonorListComponent } from './components/donor-list/donor-list.component';
import { DonorFormComponent } from './components/donor-form/donor-form.component';
import { DonorDetailsComponent } from './components/donor-detail/donor-detail.component';

export const routes: Routes = [
  { path: '', component: DonorListComponent },
  { path: 'create', component: DonorFormComponent },
  { path: 'edit/:id', component: DonorFormComponent },
  { path: 'details/:id', component: DonorDetailsComponent },
  { path: '**', redirectTo: '' }
];
