export interface PlantPayload {
    name: string;
    alias?: string;
    species: string;
    type: 'interior' | 'exterior';
    wateringInterval: number;
    remindersEnabled: boolean;
    reminderDate?: string;
    notes?: string;
    image?: File | null;
}