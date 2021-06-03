import { ListUsersComponent } from './components/list-users/list-users.component';
import { ListCommandeComponent } from './components/list-commande/list-commande.component';
import { AfterAuthGuard } from './guards/after-auth.guard';
import { ListCategoryComponent } from './components/list-category/list-category.component';
import { AddProduitComponent } from './components/add-produit/add-produit.component';
import { EditProduitComponent } from './components/edit-produit/edit-produit.component';
import { ListProduitComponent } from './components/list-produit/list-produit.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditCategoryComponent } from './components/edit-category/edit-category.component';
import { AddCategoryComponent } from './components/add-category/add-category.component';
import { LoginComponent } from './components/login/login.component';
import { PageNotFoundComponent } from './components/partials/page-not-found/page-not-found.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: "", redirectTo: '/produit', pathMatch: 'full'},
  { path: "produit", children:[
    { path: "", component:ListProduitComponent},
    { path: "edit/:id", component: EditProduitComponent},
    { path: "create", component: AddProduitComponent}
  ]
},
{ path: "commande", children:[
  { path: "", component:ListCommandeComponent}
]
},
{ path: "users", children:[
  { path: "", component:ListUsersComponent}
]
},
  { path: "category", children:[
    { path: "", component:ListCategoryComponent},
    { path: "edit/:id", component:EditCategoryComponent},
    { path: "create", component:AddCategoryComponent}
  ]
  },
  { path: "login", component:LoginComponent},
  { path: "**", component:PageNotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
