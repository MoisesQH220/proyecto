
INSERT INTO "university" ("name", "district", "city", "ruc", "country") VALUES
('Universidad Tecnológica del Perú', 'Jesús María', 'Lima', '4510159680', 'Perú'),
('Universidad Nacional Tecnológica del Sur', 'Villa El Salvador', 'Lima', '451349685', 'Perú');

INSERT INTO "user" ("name", "last_name", "email", "password", "university_id", "role") VALUES
('Moisés', 'Quispe', 'moises.quispe@gmail.com', 'contraXxXx', 1, 'ADMIN' ),
('Brandon', 'Ayala', 'brandon.ayala@gmail.com', 'contra1234', 1, 'USER' );