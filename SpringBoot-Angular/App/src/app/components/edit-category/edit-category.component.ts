import { Category } from './../../models/category';
import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-category',
  templateUrl: './edit-category.component.html',
  styleUrls: ['./edit-category.component.css']
})
export class EditCategoryComponent implements OnInit {


  categorieId!: String;
  category!: Category;


  constructor(private route: ActivatedRoute,private router: Router, private categoryService:CategoryService) { }

  ngOnInit(): void {
    this.category = new Category();

    this.categorieId = this.route.snapshot.params['id'];
    this.categoryService.getCategory(this.categorieId)
      .subscribe(data => {
        console.log(data)
        this.category = data;
      }, error => console.log(error));
  }
  updateCategory() {
    this.categoryService.updateCategory(this.categorieId, this.category)
      .subscribe(data => console.log(data), error => console.log(error));
    this.category = new Category();
    this.gotoList();
  }

  onSubmit() {
    this.updateCategory();    
  }

  gotoList() {
    this.router.navigate(['/category']);
  }



}
