import { ComponentFixture, TestBed } from '@angular/core/testing';
import { WorkflexTable } from './workflex-table';

describe('WorkflexTable', () => {
  let component: WorkflexTable;
  let fixture: ComponentFixture<WorkflexTable>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WorkflexTable],
    }).compileComponents();

    fixture = TestBed.createComponent(WorkflexTable);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
