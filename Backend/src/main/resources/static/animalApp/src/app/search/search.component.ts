import { Component, OnInit } from '@angular/core';
import { Animal } from '../animal';
import { AnimalService } from '../animal.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchName: string;
  animal: Animal;

  constructor(private service: AnimalService) { }

  ngOnInit(): void {
    this.animal = null;
  }

  searchAnimal() {
    this.service.getAnimal(this.searchName).subscribe(
      data => this.animal = data,
      error => console.log(error)
    );
  }
}
