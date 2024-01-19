import { Component, OnInit } from '@angular/core';
import { Board } from '../../models/board.model';
import { Column } from '../../models/column.model';
import { Professionals } from '../../interfaces/professionals.interface';
import { ApiService } from '../../services/api.service';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmComponent } from '../confirm/confirm.component';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { ModalComponent } from '../modal/modal.component';
import moment from 'moment';

@Component({
  selector: 'app-kanban',
  templateUrl: './kanban.component.html',
  styleUrl: './kanban.component.css',
})

export class KanbanComponent implements OnInit {

  constructor(
    private apiService: ApiService, 
    public dialog: MatDialog,
  ) {
   }

  public board!: Board;
  public listScreening: Professionals[] = [];
  public listInterview: Professionals[] = [];
  public listProposta: Professionals[] = [];
  public listContrato: Professionals[] = [];
  public static kanbanColumns : { [key: string] : string } = {
    cdkDropList0: 'screening', 
    cdkDropList1: 'interview', 
    cdkDropList2: 'proposal', 
    cdkDropList3: 'contract'
  };

  async ngOnInit() {
    try {
      this.listScreening = await this.apiService.getAllProfessionals('screening');
      this.listInterview = await this.apiService.getAllProfessionals('interview');
      this.listProposta = await this.apiService.getAllProfessionals('proposal');
      this.listContrato = await this.apiService.getAllProfessionals('contract');
      this.board = new Board('', [
        new Column('Triagem', this.listScreening),
        new Column('Entrevista', this.listInterview),
        new Column('Proposta', this.listProposta),
        new Column('Contrato', this.listContrato)
      ]);
    } catch (error) {
      console.error('Erro ao carregar dados:', error);
    }
  }

  async drop(event: CdkDragDrop<Professionals[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      let arrTerms: string[] = (event.container.id).split('-');
      const toFirstUpperCase = (item:string, i:number) => {
        return (i !=0) ? item.charAt(0).toUpperCase() + item.slice(1) : item; 
      }
      let targetColumn: string = (arrTerms.map(toFirstUpperCase)).join('');
      let movedProfessional: Professionals = event.previousContainer.data[event.previousIndex];
      movedProfessional.targetColumn = KanbanComponent.kanbanColumns[targetColumn];
      movedProfessional.positionColumn = event.currentIndex;

      try{
        let retorno = await this.apiService.updateTargetColumn(movedProfessional);
      }catch(error){
        console.error('Erro ao tentar sincronizar colunas.');
      }

      transferArrayItem(event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex);
    }
  }

  public addCard(){
    const dialogRef = this.dialog.open(ModalComponent);
    dialogRef.afterClosed().subscribe(result => {
      result.data_para_finalizar = moment(result.dataParaFinalizar).format('YYYY-MM-DD');
      console.log(result);
    });
  }

  async removeCard(card: HTMLElement, id:number, items: Professionals[]) {
    const dialogRef = this.dialog.open(ConfirmComponent);

    dialogRef.afterClosed().subscribe(result => {
      if(!result) return;
      card.remove();
      this.apiService.deleteCard(id);
      const index = items.findIndex(item => item.id === id);
      if (index !== -1) {
        items.splice(index, 1);
      }
    });
  }


}
