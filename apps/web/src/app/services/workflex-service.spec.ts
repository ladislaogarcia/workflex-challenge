import { ComponentFixture, TestBed } from '@angular/core/testing';
import { WorkflexService } from './workflex-service';

describe('WorkflexService', () => {
  let component: WorkflexService;
  let fixture: ComponentFixture<WorkflexService>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WorkflexService],
    }).compileComponents();

    fixture = TestBed.createComponent(WorkflexService);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
