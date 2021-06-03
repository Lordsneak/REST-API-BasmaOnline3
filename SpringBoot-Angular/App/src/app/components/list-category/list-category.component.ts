import { CategoryService } from './../../services/category.service';
import { Category } from './../../models/category';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-category',
  templateUrl: './list-category.component.html',
  styleUrls: ['./list-category.component.css']
})
export class ListCategoryComponent implements OnInit {


  categories!: Observable<Category[]>;
  

  constructor(private categoryService: CategoryService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.categories = this.categoryService.getCategorysList();
  }

  deleteCategory(categorieId: String) {
    this.categoryService.deleteCategory(categorieId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  categorysDetails(categorieId: String){
    this.router.navigate(['details', categorieId]);
  }

  updateCategory(categorieId: String){
    this.router.navigate(['category/edit', categorieId]);
  }

}
