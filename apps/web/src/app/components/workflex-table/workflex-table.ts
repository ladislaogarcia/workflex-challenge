import { Component, OnInit } from '@angular/core';
import { AsyncPipe } from '@angular/common';
import { Observable } from 'rxjs';
import { IWorkation } from './workflex-table.model';
import { WorkationService } from '../../services/workation.service';

@Component({
  selector: 'app-workflex-table',
  standalone: true,
  imports: [AsyncPipe],
  templateUrl: './workflex-table.html',
  styleUrl: './workflex-table.css',
})
export class WorkflexTable implements OnInit {
  workations$!: Observable<IWorkation[]>;

  constructor(private workationService: WorkationService) {}

  ngOnInit(): void {
    this.workations$ = this.workationService.getWorkations() as Observable<IWorkation[]>;
  }
}
