import { Component, signal } from '@angular/core';
import { DashboardLayoutComponent } from './components/layouts/dashboard/dashboard-layout.component';

@Component({
  selector: 'app-root',
  imports: [DashboardLayoutComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('gp-interface');
}
