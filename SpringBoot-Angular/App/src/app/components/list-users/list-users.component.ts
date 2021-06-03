import { Users } from './../../models/users';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UsersService } from 'src/app/services/users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {

  users!: Observable<Users[]>;
  

  constructor(private usersService: UsersService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.users = this.usersService.getUsersList();
  }

  deleteUser(userId: String) {
    this.usersService.deleteUser(userId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  usersDetails(userId: String){
    this.router.navigate(['details', userId]);
  }

  updateUser(userId: String){
    this.router.navigate(['edit', userId]);
  }

}
