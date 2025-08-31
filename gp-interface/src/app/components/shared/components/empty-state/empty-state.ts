import { Component } from '@angular/core';

@Component({
  selector: 'app-empty-state',
  standalone: true,
  template: `
    <div class="p-6 text-center text-gray-500">
      <p class="text-xl font-semibold">No hay datos almacenados</p>
      <p class="mt-2">Añade tus primeras plantas para verlas aqui</p>
    </div>
  `
})
export class EmptyStateComponent { }
