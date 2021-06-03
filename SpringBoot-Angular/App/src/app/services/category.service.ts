import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private baseUrl =  `${environment.apiUrl}/categories`;

  constructor(private http: HttpClient) { }

  getCategory(categorieId: String): Observable<any> {
    return this.http.get(`${this.baseUrl}/${categorieId}`);
  }

  createCategory(data: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, data);
  }

  updateCategory(categorieId: String, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${categorieId}`, value);
  }

  deleteCategory(categorieId: String): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${categorieId}`, { responseType: 'text' });
  }

  getCategorysList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
