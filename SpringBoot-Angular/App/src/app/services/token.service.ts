import {
  Injectable
} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() {}

  set(data: any) {
    localStorage.setItem('token', data.token);
    localStorage.setItem('id', data.id);
    localStorage.setItem('nom_user', data.nom_user);
    localStorage.setItem('prenom_user', data.prenom_user);
    localStorage.setItem('email', data.email);

  }

  handle(data: any) {
    this.set(data);
  }

  getToken() {
    return localStorage.getItem('token');
  }

  getId() {
    return localStorage.getItem('id');
  }
  getNomUser() {
    return localStorage.getItem('nom_user');
  }
  getPrenomUser() {
    return localStorage.getItem('prenom_user');
  }
  getEmail() {
    return localStorage.getItem('email');
  }

  remove() {
    localStorage.removeItem('token');
    localStorage.removeItem('id');
    localStorage.removeItem('nom_user');
    localStorage.removeItem('prenom_user');
    localStorage.removeItem('email');

  }

  decode(payload: string) {
    return JSON.parse(atob(payload));
  }

  payload(token: string) {
    const payload = token.split('.')[1];
    console.log('payload : ', payload);
    return this.decode(payload);
  }

  isValid() {
    const token = this.getToken();
    const id = this.getId();

    if (token) {

      const payload = this.payload(token);
      if (payload) {
        return id == payload.id;
      }
    }
    return false;
  }

  getInfos() {
    const token = this.getToken();

    if (token) {
      const payload = this.payload(token);
      return payload ? payload : null;
    }
    return null;
  }
  
  loggedIn() {
    return this.isValid();
  }

}
