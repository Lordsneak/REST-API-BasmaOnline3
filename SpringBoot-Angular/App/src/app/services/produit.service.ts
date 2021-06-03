import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import {BehaviorSubject, Observable} from 'rxjs';
import { Produit } from '../models/produit';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  private baseUrl =  `${environment.apiUrl}/products`;

  constructor(private http: HttpClient) { }

  getProduct(productId: String): Observable<any> {
    return this.http.get(`${this.baseUrl}/${productId}`);
  }

  createProduct(data: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, data);
  }

  updateProduct(productId: String, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${productId}`, value);
  }

  deleteProduct(productId: String): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${productId}`, { responseType: 'text' });
  }

  getProductsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

}
