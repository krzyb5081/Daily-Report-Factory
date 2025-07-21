# 🏭 Daily Report Factory

Generate. Organize. Report.

**Daily Report Factory** is a lightweight, browser-based tool built with Spring Boot and Thymeleaf that helps users quickly create and generate daily work reports in PDF format. It's simple, clean, and built for speed.

---

## 🚀 Features

- ✍️ **Custom Report Generator** – fill in working hours, tasks done, unfinished work, duties and more  
- ⚡ **Dynamic input system** – add multiple bullet points (via Enter or automatically on submit)  
- 🧾 **PDF report output** – structured, clean layout ready for printing or archiving  
- 🔐 **User registration & login** – basic authentication system  
- 🎨 **Tailwind-powered UI** – responsive, modern interface  
- 💾 **Hibernate-based user persistence**  

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring MVC + Spring Security**
- **Thymeleaf** – HTML rendering
- **Hibernate (JPA)** – user data storage
- **Lombok** – boilerplate code reduction
- **PDFBox** – PDF generation
- **Tailwind CSS** – frontend styling
- **Maven** – build tool

---

## 📋 Usage

1. Register a new account  
2. Log in to the system  
3. Fill out the report form:
   - Date  
   - Working Hours  
   - Tasks Done  
   - Tasks To Finish  
   - Tasks Undone  
   - Optional flags: Late, Week Duty, Holiday Duty  
4. Submit and generate a PDF file  

---

## 📦 Installation

```bash
git clone https://github.com/krzyb5081/Daily-Report-Factory.git
cd Daily-Report-Factory
./mvnw spring-boot:run
```

> 💡 Make sure you have **Java 17+**, **Maven**, and **Lombok** properly set up in your IDE (e.g. IntelliJ).

---

## 🧠 Developer Notes

- Reports are generated using **Apache PDFBox**  
- Bullet points in form inputs are separated with `|` and parsed into multiline output  
- Input fields support Enter-based dynamic expansion  
- TailwindCSS is loaded via CDN  
- Basic error handling via URL parameters (e.g. `?error`)  
- Server-side validation is minimal (planned for improvement)  
- Email sending system is partially implemented but not yet tested  

---

## 💡 Ideas for Future

- 🗂️ Report history view per user  
- 📅 Calendar integration  
- 📤 Email/send report (pending full integration & testing)  
- 🌍 Multi-language support (EN/PL switch)  
- 🐳 Docker support for easy deployment  
- 🔍 Admin dashboard for managing users & reports  

---

## 🤘 Author

Made with ❤️ and late-night coding by [krzyb5081](https://github.com/krzyb5081)  
> *“Have a good day, choom.”*

---

## 📜 License

MIT – free to use, modify, break, enhance, or remix.