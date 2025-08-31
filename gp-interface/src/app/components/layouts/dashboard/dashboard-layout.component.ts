import { Component } from '@angular/core';
import { FaIconComponent } from '@fortawesome/angular-fontawesome';
import { faSeedling, faGear, faBell, faNoteSticky, faBars } from '@fortawesome/free-solid-svg-icons';
import { RouterOutlet } from '@angular/router';

@Component({
    selector: 'dashboard-layout',
    standalone: true,
    imports: [RouterOutlet, FaIconComponent],
    templateUrl: './dashboard-layout.html'
})
export class DashboardLayoutComponent {
    sideBarMenuOpen = true;

    navigationMenu = [
        { label: 'Invernadero', path: 'jardin', icon: faSeedling },
        { label: 'Configuración', path: 'configuracion', icon: faGear },
        { label: 'Notificaciones', path: 'notificaciones', icon: faBell },
        { label: 'Bloc de notas', path: 'notas', icon: faNoteSticky }
    ];

    faBars = faBars;

    toogleMenuNav() {
        this.sideBarMenuOpen = !this.sideBarMenuOpen;
    }
}
