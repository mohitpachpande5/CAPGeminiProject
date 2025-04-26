import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { DonorService } from '../../services/donor.service';
import { Donor } from '../../models/donor';

@Component({
  selector: 'app-donor-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './donor-list.component.html',
  styleUrls: ['./donor-list.component.css']
})
export class DonorListComponent implements OnInit {
  donors: Donor[] = [];

  constructor(private donorService: DonorService) {}

  ngOnInit(): void {
    this.donorService.getAllDonors().subscribe((data) => {
      this.donors = data;
    });
  }

  deleteDonor(id: number): void {
    if (confirm('Are you sure you want to delete this donor?')) {
      this.donorService.deleteDonor(id).subscribe(() => {
        this.donors = this.donors.filter((don) => don.donId !== id);
      });
    }
  }
}
