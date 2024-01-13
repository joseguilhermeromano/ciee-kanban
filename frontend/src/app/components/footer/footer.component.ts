import { MatIconModule } from '@angular/material/icon';
import { Component, OnInit } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar'; 

@Component({
  selector: 'app-footer',
  standalone: true,
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css',
  imports: [
    MatToolbarModule, MatIconModule
  ]
})
export class FooterComponent implements OnInit{
  constructor(){}
  ngOnInit() {}
}
