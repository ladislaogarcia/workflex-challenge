import { Route } from '@angular/router';
import { WorkflexTable } from './components/workflex-table/workflex-table';

export const appRoutes: Route[] = [
    {
        path: '',
        component: WorkflexTable
    }
];
