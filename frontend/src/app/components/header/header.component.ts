import { MatIconModule } from '@angular/material/icon';
import { Component, OnInit } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar'; 
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-header',
  standalone: true,
  templateUrl: 'header.component.html',
  styleUrls: ['header.component.css'],
  imports: [
    MatToolbarModule, MatIconModule, MatButtonModule
  ]
})
export class HeaderComponent implements OnInit{
  constructor(){}
  ngOnInit() {}
}