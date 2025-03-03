CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(500),
  email VARCHAR(500),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active BOOLEAN DEFAULT TRUE,
  created_by BIGINT NULL,
  updated_at TIMESTAMP,
  updated_by BIGINT NULL,
  role ENUM('USER', 'ADMIN') NOT NULL
);

CREATE TABLE books (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(500),
  author VARCHAR(500),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  genre VARCHAR(500),
  published_year INT,
  status ENUM('AVAILABLE', 'UNAVAILABLE', 'DELETED') DEFAULT 'AVAILABLE',
  created_by BIGINT NULL,
  updated_at TIMESTAMP,
  updated_by BIGINT NULL,
  barcode CHAR(36) DEFAULT (UUID_SHORT()) UNIQUE
);

CREATE TABLE reservations (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  reserved_by BIGINT NOT NULL,
  book_id BIGINT NOT NULL,
  status ENUM('ACTIVE', 'COMPLETED', 'OVERDUE') DEFAULT 'ACTIVE',
  reserved_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  due_date TIMESTAMP NOT NULL
);

CREATE TABLE reviews (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  content TEXT,
  book_id BIGINT NOT NULL,
  user_id BIGINT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  rating INT CHECK (rating BETWEEN 1 AND 5)
);

ALTER TABLE books ADD CONSTRAINT books_created_by_fk FOREIGN KEY (created_by) REFERENCES users (id) ON DELETE SET NULL;
ALTER TABLE books ADD CONSTRAINT books_updated_by_fk FOREIGN KEY (updated_by) REFERENCES users (id) ON DELETE SET NULL;
ALTER TABLE reservations ADD CONSTRAINT reservations_book_id_fk FOREIGN KEY (book_id) REFERENCES books (id) ON DELETE CASCADE;
ALTER TABLE reservations ADD CONSTRAINT reservations_user_id_fk FOREIGN KEY (reserved_by) REFERENCES users (id) ON DELETE CASCADE;
ALTER TABLE reviews ADD CONSTRAINT reviews_book_id_fk FOREIGN KEY (book_id) REFERENCES books (id) ON DELETE CASCADE;
ALTER TABLE reviews ADD CONSTRAINT reviews_user_id_fk FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE SET NULL;

INSERT INTO users (id, name, email, created_at, created_by, role)
VALUES
    (1, 'Admin', 'Admin@admin.com', CURRENT_TIMESTAMP, 1, 'ADMIN');

INSERT INTO users (name, email, created_at, created_by, role)
VALUES
    ('Juan Pérez', 'juan.perez@gmail.com', CURRENT_TIMESTAMP, 1, 'ÚSER'),
    ('María González', 'maria.gonzalez@gmail.com', CURRENT_TIMESTAMP, 1, 'USER');

INSERT INTO books (title, author, genre, published_year, created_by)
VALUES
    ('Pedro Páramo', 'Juan Rulfo', 'Realismo mágico', 1995, 1),
    ('País de nieve', 'Yasunari Kawabata', 'Japonés', 1935, 1);

INSERT INTO reviews (id, content, book_id, user_id, rating)
VALUES
    (1, 'Me encantó', 1, 2, 5),
    (2, 'No envejeció muy bien', 1, 3, 3),
    (3, 'Buena lectura!', 2, 3, 5),
    (4, 'Para nada lo que esperaba', 2, 2, 2);

INSERT INTO reservations(reserved_by, book_id, status, due_date)
VALUES
    (2, 1, 'ACTIVE','2025-03-03');

UPDATE books SET status = 'UNAVAILABLE' WHERE id = 1;
UPDATE books SET updated_at = CURRENT_TIMESTAMP WHERE id = 1;
UPDATE books SET updated_by = 1 WHERE id = 1;

