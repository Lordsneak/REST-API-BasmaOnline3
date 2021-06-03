import { Produit } from './../../models/produit';
import { ProduitService } from './../../services/produit.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css']
})
export class ListProduitComponent implements OnInit {

  products!: Observable<Produit[]>;
  

  constructor(private produitService: ProduitService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.products = this.produitService.getProductsList();
  }

  deleteProduct(productId: String) {
    this.produitService.deleteProduct(productId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  productsDetails(productId: String){
    this.router.navigate(['details', productId]);
  }

  updateProduct(productId: String){
    this.router.navigate(['produit/edit', productId]);
  }

}
