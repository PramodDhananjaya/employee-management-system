import { Injectable } from '@angular/core';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot, CanActivate } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private router: Router, private authService: AuthenticationService) { }

  canActivate(router : ActivatedRouteSnapshot , state : RouterStateSnapshot){
    if(this.authService.isUserLoggedIn()){
      return true;
    }else {
      this.router.navigate(['login']);
      return false;
    }

  }
}
