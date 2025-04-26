import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Donor } from '../models/donor';

@Injectable({
  providedIn: 'root'
})
export class DonorService {
  private apiUrl = 'http://localhost:8080/donors';

  constructor(private http: HttpClient) {}

  getAllDonors(): Observable<Donor[]> {
    return this.http.get<Donor[]>(`${this.apiUrl}/all`);
  }

  getDonorById(id: number): Observable<Donor> {
    return this.http.get<Donor>(`${this.apiUrl}/${id}`);
  }

  getDonorByEmail(email: string): Observable<Donor> {
    return this.http.get<Donor>(`${this.apiUrl}/email/${email}`);
  }

  registerDonor(donor: Donor): Observable<Donor> {
    return this.http.post<Donor>(`${this.apiUrl}/register`, donor);
  }

  updateDonor(id: number, donor: Donor): Observable<Donor> {
    return this.http.put<Donor>(`${this.apiUrl}/update/${id}`, donor);
  }

  deleteDonor(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }
}
