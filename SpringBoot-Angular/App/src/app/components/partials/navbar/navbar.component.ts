import { TokenService } from './../../../services/token.service';
import { Router } from '@angular/router';
import { AccountService } from './../../../services/account.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public loggedIn: boolean = false;
  public userInfos: any = null;

  constructor(
    private account: AccountService,
    private router: Router,
    private Token: TokenService,
  ) { }

  ngOnInit() {
    this.account.authStatus.subscribe(value => {
      this.loggedIn = value
      this.userInfos = this.Token.getInfos();
    });
  }

  logout() {
    this.Token.remove();
    this.router.navigateByUrl('/login');
  }
}