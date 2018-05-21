import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RoleLibrianGaurd } from '../app-security/role-librarian-gaurd';
import { AddUserComponent } from './add-user/add-user.component';
import { ModifyUserComponent } from './modify-user/modify-user.component';
import { UserComponent } from './user.component';
import { AuthGaurd } from '../app-security/auth-gaurd.service';

const userRoutes: Routes = [
  {
    path: 'user',
    component: UserComponent,
    canActivateChild: [RoleLibrianGaurd, AuthGaurd],
    children: [
      {
        path: '',
        redirectTo: 'add',
        pathMatch: 'full'
      },
      {
        path: 'add',
        component: AddUserComponent
      },
      {
        path: 'modify',
        component: ModifyUserComponent
      }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(userRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class UserRoutingModule { }