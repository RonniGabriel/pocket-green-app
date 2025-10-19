import { ChangeDetectionStrategy, ChangeDetectorRef, Component, forwardRef, Input, OnChanges, SimpleChanges } from '@angular/core'
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms'

@Component({
    selector: 'input-text-component',
    standalone: true,
    providers: [{
        provide: NG_VALUE_ACCESSOR,
        useExisting: forwardRef(() => InputTextComponent),
        multi: true
    }],
    changeDetection: ChangeDetectionStrategy.OnPush,
    template: `
    <label [for]="id" class="mb-1 font-medium">{{ label }}</label>
    <input
      [id]="id"
      type="text"
      [attr.placeholder]="placeholder || null"
      class="border rounded px-3 py-2 w-full focus:outline-none focus:ring-2 focus:ring-green-600"
      [disabled]="disabled"
      [value]="value"
      (input)="onInputEvent($event)"
      (blur)="onBlur()"
    />
  `
})
export class InputTextComponent implements ControlValueAccessor, OnChanges {
    @Input({ required: true }) id!: string;
    @Input() label = '';
    @Input() placeholder = '';
    @Input() disabled = false;

    value = '';

    private onChangeCb: (val: string) => void = () => { };
    private onTouchedCb: () => void = () => { };

    constructor(private cdr: ChangeDetectorRef) { }
    ngOnChanges(_: SimpleChanges): void { this.cdr.markForCheck(); }


    writeValue(valueInput: unknown): void {
        this.value = (valueInput as string) ?? '';
        this.cdr.markForCheck();
    }
    registerOnChange(fn: (val: string) => void): void { this.onChangeCb = fn; }
    registerOnTouched(fn: () => void): void { this.onTouchedCb = fn; }
    setDisabledState(isDisabled: boolean): void {
        this.disabled = isDisabled;
        this.cdr.markForCheck();
    }

    onInputEvent(event: Event): void {
        const next = (event.target as HTMLInputElement).value ?? '';
        this.value = next;
        this.onChangeCb(next);

    }

    onBlur(): void {
        this.onTouchedCb();
    }
}
