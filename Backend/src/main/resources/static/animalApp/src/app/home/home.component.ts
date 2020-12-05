import { Component, OnInit } from '@angular/core';
import { Animal } from '../animal';
import { AnimalService } from '../animal.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  
  newAnimal: Animal;
  animals: Animal[];

  constructor(private service: AnimalService) { }

  ngOnInit(): void {
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

  updateAnimal() {
    this.service.updateAnimal(this.newAnimal).subscribe(
      data => console.dir(data),
      error => console.log(error),
      () => this.loadData()
    );
  }

}
