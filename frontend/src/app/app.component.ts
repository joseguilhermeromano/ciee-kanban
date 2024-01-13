import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { KanbanComponent } from './components/kanban/kanban.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, HeaderComponent, FooterComponent, KanbanComponent],
  templateUrl: 'app.component.html',
  styles: [],
})
export class AppComponent {
  title = 'kanban';
}
