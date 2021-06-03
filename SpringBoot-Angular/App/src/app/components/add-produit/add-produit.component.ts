import { ProduitService } from './../../services/produit.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; 
import {Produit} from '../../models/produit';
import { Observable } from 'rxjs';
import { Category } from 'src/app/models/category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-add-produit',
  templateUrl: './add-produit.component.html',
  styleUrls: ['./add-produit.component.css']
})

export class AddProduitComponent implements OnInit {

  produit: Produit = new Produit();
  submitted = false;
  categories!: Observable<Category[]>;
  constructor(private categoryService: CategoryService,private produitService: ProduitService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.categories = this.categoryService.getCategorysList();
  }

  newProduct(): void {
    this.submitted = false;
    this.produit = new Produit();
  }

  save() {
    this.produitService.createProduct(this.produit)
      .subscribe(data => console.log(data), error => console.log(error));
    this.produit = new Produit();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/produit']);
  }

 
}
