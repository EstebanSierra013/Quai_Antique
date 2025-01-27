import { Component, ElementRef, ViewChild } from '@angular/core';
import { NavbarComponent } from "../navbar/navbar.component";
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MenuService } from '../services/menu.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Menu } from '../models/menu';

@Component({
  selector: 'app-menu-form',
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './menu-form.component.html',
  styleUrl: './menu-form.component.css'
})
export class MenuFormComponent {
  menuForm!: FormGroup;
  dataMenu: any;
  isDeleteInProgress: boolean = false;
  edit: boolean = false;
  menuList: Menu[] = [];
  @ViewChild("closebutton") modal!: ElementRef;

  constructor(private fb: FormBuilder, private menuService:MenuService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.menuForm = this.fb.group({
      idMenu: [null],
      title: ["", [Validators.required]],
      description: ["", [Validators.required]],
      prix: ["", [Validators.required]],
    });  
  }

  ngOnInit(): void{    
    this.getAllMenus();
    console.log(this.menuList);
  }

  getAllMenus(){
    this.menuService.getAllMenus().subscribe((data) => {
      this.menuList = data;
    })
  };  

  createMenu(){
    console.log(this.menuForm.value)
    const createdMenu = this.menuForm.value;
    this.menuService.createMenu(createdMenu).subscribe({
      next: () => {
        console.log('Menu creé');
        alert('Menu creé');
        this.closeModal();
      },
      error: () => {
        console.error('Erreur lors de la création de la réservacion');
      },
    });      
  }

  updateMenu(id: number){
    const updateMenu = this.menuForm.value;
    this.menuService.updateMenu(updateMenu, id).subscribe({
      next: () => {
        console.log('Menu mis à jour');
        alert('Menu mis à jour avec succès.');
        this.closeModal();
      },
      error: () => {
        console.error('Erreur lors de la mise à jour de la réservacion');
      },
    });     
  }

  deleteMenu(id: number){
    this.isDeleteInProgress = true;
    this.menuService.deleteMenu(id).subscribe({
      next: () => {
        console.log('Menu suprimée ');
        alert('Menu suprimée');
        this.getAllMenus();
      },
      error: () => {
        console.error('Erreur lors de supprimer la réservacion');
      },
    });  
  }

  updateModal(id: number){
    this.dataMenu = this.menuList.find(menu => menu.idMenu === id)
    this.edit = true;
    this.menuForm.patchValue(this.dataMenu);        
  }

  closeModal(){
    this.menuForm.reset();
    this.modal.nativeElement.click();
    this.getAllMenus();    
  }
}
