import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Animal } from './animal';

@Injectable({
  providedIn: 'root'
})
export class AnimalService {

  private baseUrl: string = "http://localhost:9000/api/v1";
  private create: string = "create";
  private read: string = "read";
  private update: string = "update";
  private delete: string = "delete";
  private all: string = "all";

  constructor(private http: HttpClient) { }

  public addAnimal(animal: Animal): Observable<Animal> {
    return this.http.post<Animal>(`${this.baseUrl}/${this.create}`, animal);
  }

  public getAnimal(name: string): Observable<Animal> {
    return this.http.get<Animal>(`${this.baseUrl}/${this.read}/${name}`);
  }

  public updateAnimal(animal: Animal): Observable<Animal> {
    return this.http.put<Animal>(`${this.baseUrl}/${this.update}`, animal);
  }

  public deleteAnimal(name: string): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${this.delete}/${name}`);
  }

  public getAllAnimals(): Observable<Animal[]> {
    return this.http.get<Animal[]>(`${this.baseUrl}/${this.all}`);
  }
}
