import { Component, ViewChild, inject } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, ReactiveFormsModule } from '@angular/forms';
import { MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatDatepicker, MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { FaIconComponent } from '@fortawesome/angular-fontawesome';
import { faTimes } from '@fortawesome/free-solid-svg-icons';
import { PlantPayload } from '../../interfaces/plant.interface';


@Component({
    selector: 'app-create-new-plant-form',
    standalone: true,
    imports: [
        FaIconComponent,
        ReactiveFormsModule,
        MatDialogModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        MatSlideToggleModule,
        MatDatepickerModule,
        MatNativeDateModule
    ],
    templateUrl: './create-new-plant-form.html'
})
export class CreateNewPlantFormComponent {

    @ViewChild('picker') picker!: MatDatepicker<Date>;

    private formBuilder = inject(FormBuilder);
    private dialogRef = inject(MatDialogRef<CreateNewPlantFormComponent>);

    form = this.formBuilder.group({
        plantName: [''],
        plantAlias: [''],
        plantSpecies: [''],
        plantType: [''],
        remindersEnabled: [false],
        wateringCounting: new FormControl<number | null>(null),
        wateringFrecuency: new FormControl<string>(''),
        notes: [''],
        plantImage: new FormControl<File | null>(null)
    });

    // Exponemos controles para usar [formControl] en template
    checkReminders = this.form.controls.remindersEnabled;
    wateringCounting = this.form.controls.wateringCounting;
    wateringFrecuency = this.form.controls.wateringFrecuency;

    closeFormIcon = faTimes;
    reminderOptions = Array.from({ length: 10 }, (_, i) => i + 1);
    reminderFrecuency: string[] = ['Diaria', 'Semanal', 'Mensual'];

    onFileSelected(evt: Event) {
        const file = (evt.target as HTMLInputElement).files?.[0] ?? null;
        this.form.controls.plantImage.setValue(file);
    }

    mapDataForm(v: any) {
        return {
            plantName: v.plantName ?? '',
            plantAlias: v.plantAlias || undefined,
            plantSpecies: v.plantSpecies ?? '',
            plantType: v.plantType || 'interior',
            remindersEnabled: !!v.remindersEnabled,
            wateringCounting: v.wateringCounting ?? 1,
            wateringFrecuency: v.wateringFrecuency || '',
            notes: v.notes || undefined,
            reminderDate: v.reminderDate ? new Date(v.reminderDate).toISOString() : undefined,
            // imagen 
        };
    }

    onSubmit() {
        const jsonData = this.mapDataForm(this.form.value);
        console.log('JSON listo:', jsonData);
        this.dialogRef.close(jsonData);
    }

    closeForm() {
        this.dialogRef.close();
    }
}