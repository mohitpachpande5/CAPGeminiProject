import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, ActivatedRoute, RouterModule } from '@angular/router';
import { DonorService } from '../../services/donor.service';
import { Donor } from '../../models/donor';

@Component({
  selector: 'app-donor-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './donor-form.component.html',
  styleUrls: ['./donor-form.component.css']
})
export class DonorFormComponent implements OnInit {
  donorForm: FormGroup;
  isEditMode = false;
  donorId?: number;

  constructor(
    private fb: FormBuilder,
    private donorService: DonorService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.donorForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      mobileNumber: [''],
      event: ['', Validators.required],
      amount: ['']
    });
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      const id = params.get('id');
      if (id) {
        this.isEditMode = true;
        this.donorId = +id;
        this.donorService.getDonorById(this.donorId).subscribe((donor) => {
          this.donorForm.patchValue({
            ...donor,
            event: donor.event.split('T')[0] // Format for input type="date"
          });
        });
      }
    });
  }

  onSubmit(): void {
    if (this.donorForm.valid) {
      const donor: Donor = this.donorForm.value;
      if (this.isEditMode && this.donorId) {
        this.donorService.updateDonor(this.donorId, donor).subscribe(() => {
          this.router.navigate(['/']);
        });
      } else {
        this.donorService.registerDonor(donor).subscribe(() => {
          this.router.navigate(['/']);
        });
      }
    }
  }
}
