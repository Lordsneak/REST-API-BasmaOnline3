import { CategoryService } from './../../services/category.service';
import { ProduitService } from './../../services/produit.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from 'src/app/models/produit';
import { Observable } from 'rxjs';
import { Category } from 'src/app/models/category';

@Component({
  selector: 'app-edit-produit',
  templateUrl: './edit-produit.component.html',
  styleUrls: ['./edit-produit.component.css']
})
export class EditProduitComponent implements OnInit {

  productId!: String;
  produit!: Produit;

  categories!: Observable<Category[]>;
  constructor(private route: ActivatedRoute,private router: Router,private produitService: ProduitService, private categoryService:CategoryService) { }

  ngOnInit() {
    this.categories = this.categoryService.getCategorysList();
    this.produit = new Produit();

    this.productId = this.route.snapshot.params['id'];
    this.produitService.getProduct(this.productId)
      .subscribe(data => {
        console.log(data)
        this.produit = data;
      }, error => console.log(error));
  }

  updateProduct() {
    this.produitService.updateProduct(this.productId, this.produit)
      .subscribe(data => console.log(data), error => console.log(error));
    this.produit = new Produit();
    this.gotoList();
  }

  onSubmit() {
    this.updateProduct();    
  }

  gotoList() {
    this.router.navigate(['/produit']);
  }

}
