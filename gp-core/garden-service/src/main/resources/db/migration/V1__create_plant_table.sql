CREATE TABLE IF NOT EXISTS plant (
    id UUID PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    scientific_name VARCHAR(160) NOT NULL,
    notes VARCHAR(2000),
    location VARCHAR(120),
    indoor BOOLEAN NOT NULL,
    light_exposure VARCHAR(20) NOT NULL,
    humidity_min INTEGER,
    humidity_max INTEGER,
    temperature_max INTEGER,
    temperature_min INTEGER,
    water_frequency VARCHAR(50),
    water_county INTEGER,
    units INTEGER NOT NULL DEFAULT 1,
    created_at DATE NOT NULL DEFAULT CURRENT_DATE,
    updated_at DATE NOT NULL DEFAULT CURRENT_DATE,
    CONSTRAINT chk_light_exposure CHECK (light_exposure IN ('LOW','MEDIUM','HIGH','DIRECT')),
    CONSTRAINT chk_humidity_bounds CHECK (humidity_min IS NULL OR humidity_max IS NULL OR humidity_min <= humidity_max),
    CONSTRAINT chk_temperature_bounds CHECK (temperature_min IS NULL OR temperature_max IS NULL OR temperature_min <= temperature_max),
    CONSTRAINT chk_water_county_nonneg CHECK (water_county IS NULL OR water_county >= 0),
    CONSTRAINT chk_units_nonneg CHECK (units >= 0)
);

CREATE INDEX IF NOT EXISTS idx_plant_name ON plant(name);
CREATE INDEX IF NOT EXISTS idx_plant_scientific_name ON plant(scientific_name);