import { Component, inject } from '@angular/core';
import { EmptyStateComponent } from '../../shared/components/empty-state/empty-state';
import { CreateNewPlantFormComponent } from '../../shared/forms/create-new-plant/create-new-plant-form';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';

@Component({
    selector: 'garden-layout',
    standalone: true,
    templateUrl: './garden-page.html',
    imports: [EmptyStateComponent, MatDialogModule]
})
export class GardenPageComponent {
    data = false;
    private dialog = inject(MatDialog);

    menuOptions = [
        { label: 'Mis Plantas' },
        { label: 'Añadir planta', action: 'openNewPlantForm' },
        { label: 'Opciones' }
    ];

    openOptions(item: { action?: string }) {
        if (item.action === 'openNewPlantForm') {
            this.dialog.open(CreateNewPlantFormComponent, {
                width: '1200px',
            });
        }
    }
}
