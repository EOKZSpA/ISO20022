# 📤 ISO20022 MT→MX Converter API

API REST desarrollada en Java Spring Boot para convertir mensajes financieros tipo SWIFT **MT** a su equivalente en formato **MX (ISO 20022)**.

---

## ✅ Funcionalidades

- ✔️ Conversión de archivos MT a XML MX.
- 📂 Creación automática de carpetas `mt-files/` y `converted-files/`.
- ❌ Detección si la carpeta de entrada está vacía.
- 🕒 Registro de cada conversión en base de datos SQLite.
- 📄 Consulta del historial de conversiones vía API.
- 🧪 Compatible con Postman para pruebas manuales.

---

## 📦 Requisitos

- Java 17+
- Maven 3.8+
- Postman (para pruebas)
- Git (opcional para clonar)
- Visor SQLite (opcional: [DB Browser for SQLite](https://sqlitebrowser.org/))

---

## 🚀 Cómo ejecutar

### 1. Clonar el proyecto

```bash
git clone https://github.com/EOKZSpA/ISO20022.git
cd ISO20022
