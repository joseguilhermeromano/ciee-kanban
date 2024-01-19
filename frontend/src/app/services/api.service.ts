import { Injectable } from '@angular/core';
import { catchError, map } from 'rxjs/operators';
import { Professionals } from '../interfaces/professionals.interface';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class ApiService {
    constructor(private http: HttpClient) {}

    private static urlApi = 'http://localhost:8080/professionals/';

    public static headers: {'Content-Type': string, 'Access-Control-Allow-Origin': string} = {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': 'http://localhost:4200',  // Origem permitida
    } 

    public getAllProfessionals(targetColumn:string): Promise<Professionals[]> {
        let headers = ApiService.headers
        const options = { headers };
        return this.http.get<Professionals[]>(ApiService.urlApi + 'target-column/' + targetColumn, options)
        .pipe(
            map((response: Professionals[]) => response),
            catchError(this.handleError)
        )
        .toPromise();
    }

    private handleError(error: any): Promise<any> {
        console.error('Erro ao realizar a chamada HTTP', error);
        return Promise.reject(error.message || error);
    }

    public updateTargetColumn(data: Professionals): Promise<Professionals[]> {
        let headers = ApiService.headers
        const options = { headers };
        return this.http.put<Professionals[]>(ApiService.urlApi + data.id, data, options)
        .pipe(
            map((response: Professionals[]) => response),
            catchError(this.handleError)
        )
        .toPromise();
    }

    public deleteCard(id: number): Promise<Professionals[]> {
        return this.http.delete<Professionals[]>(ApiService.urlApi + id, { headers: ApiService.headers })
          .pipe(
            map((response: Professionals[]) => response),
            catchError(this.handleError)
          ).toPromise();
      }
    
}