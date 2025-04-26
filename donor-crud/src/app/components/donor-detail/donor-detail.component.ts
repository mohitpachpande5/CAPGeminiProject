import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, ActivatedRoute } from '@angular/router';
import { DonorService } from '../../services/donor.service';
import { Donor } from '../../models/donor';

@Component({
  selector: 'app-donor-details',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './donor-detail.component.html',
  styleUrls: ['./donor-detail.component.css']
})
export class DonorDetailsComponent implements OnInit {
  donor?: Donor;

  constructor(
    private donorService: DonorService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.donorService.getDonorById(+id).subscribe((data) => {
        this.donor = data;
      });
    }
  }
}
