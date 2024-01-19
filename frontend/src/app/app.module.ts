import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { MatToolbarModule } from '@angular/material/toolbar'; 
import { AvatarModule } from '@coreui/angular';
import { IconDirective } from '@coreui/icons-angular';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { KanbanComponent } from './components/kanban/kanban.component';
import { ConfirmComponent } from './components/confirm/confirm.component';
import { ApiService } from './services/api.service';
import { MatDialogModule } from '@angular/material/dialog';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { ModalComponent } from './components/modal/modal.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MAT_MOMENT_DATE_ADAPTER_OPTIONS, MatMomentDateModule } from '@angular/material-moment-adapter';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MAT_DATE_LOCALE } from '@angular/material/core';

import 'moment/locale/pt-br';


@NgModule({
    declarations: [
      AppComponent, HeaderComponent, FooterComponent, KanbanComponent, ConfirmComponent, ModalComponent
    ],
    imports: [
      BrowserModule, MatToolbarModule, AvatarModule, IconDirective, HttpClientModule, DragDropModule, ReactiveFormsModule, MatMomentDateModule,
      CommonModule, RouterOutlet, MatDialogModule, MatIconModule, MatButtonModule, FormsModule, MatInputModule, MatDatepickerModule, BrowserAnimationsModule
    ],
    providers: [ ApiService,
      { provide: MAT_DATE_LOCALE, useValue: 'pt-BR' },
      { provide: MAT_MOMENT_DATE_ADAPTER_OPTIONS, useValue: { useUtc: true } },
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }