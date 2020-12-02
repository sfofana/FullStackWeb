import { Component, OnInit } from '@angular/core';
import { Animal } from '../animal';
import { AnimalService } from '../animal.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  searchName: string;
  animal: Animal;
  newAnimal: Animal;
  animals: Animal[];

  constructor(private service: AnimalService) { }

  ngOnInit(): void {
    this.animal = null;
    this.newAnimal = new Animal();
    this.loadData();
  }

  loadData() {
    this.service.getAllAnimals().subscribe(
      data => this.animals = data,
      error => console.log(error)
    );
  }

  addAnimal() {
    this.service.addAnimal(this.newAnimal).subscribe(
      data => console.dir(data),
      error => console.log(error),
      () => this.loadData()
    );
  }

  searchAnimal() {
    this.service.getAnimal(this.searchName).subscribe(
      data => this.animal = data,
      error => console.log(error)
    );
  }

  updateAnimal() {
    this.service.updateAnimal(this.newAnimal).subscribe(
      data => console.dir(data),
      error => console.log(error),
      () => this.loadData()
    );
  }

  deleteAnimal() {
    this.service.deleteAnimal(this.searchName).subscribe(
      data => console.log(data),
      error => console.log(error),
      () => this.loadData()
    );
  }

}
