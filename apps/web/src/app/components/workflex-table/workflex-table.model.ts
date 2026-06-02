export interface IWorkation {
  workationId: string;
  employee: string;
  origin: string;
  destination: string;
  start: Date;
  end: Date;
  workingDays: number;
  risk: string;
}