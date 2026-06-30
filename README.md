# 🔍 Digital Image Forensics and Tampering Analyzer

A Java-based desktop application that performs digital image forensic analysis to help identify potential image tampering. The application uses OpenCV for face detection and image analysis, JavaFX for the graphical user interface, and SHA-256 hashing for image integrity verification.

---

## 📖 Overview

Digital images are widely used across social media, journalism, legal investigations, and cybersecurity. With the increasing availability of image editing tools, verifying image authenticity has become a significant challenge.

This project provides a simple and effective solution for analyzing digital images. It performs image integrity verification, detects faces using OpenCV, and presents the analysis results through an intuitive JavaFX interface. The project demonstrates the practical application of image processing techniques in digital forensics.

---

## ✨ Features

- Upload and analyze digital images
- SHA-256 hash generation for integrity verification
- Face detection using OpenCV Haar Cascade Classifier
- Visual highlighting of detected faces
- Interactive JavaFX desktop interface
- Displays analysis results and forensic verdict
- Maven-based project structure for dependency management

---

## 🛠️ Technologies Used

- Java
- JavaFX
- OpenCV
- Maven
- SHA-256 Cryptographic Hashing
- Eclipse IDE

---

## 📂 Project Structure

```text
ImageForensics
│
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── deepsecure
│       │           ├── service
│       │           │   └── FaceDetector.java
│       │           ├── util
│       │           │   ├── ImageUtils.java
│       │           │   └── MainApp.java
│       │
│       └── resources
│           └── haarcascade_frontalface_default.xml
│
├── pom.xml
├── README.md

```

---

## ⚙️ How It Works

1. Upload an image using the application.
2. Generate a SHA-256 hash to verify image integrity.
3. Detect faces using OpenCV's Haar Cascade classifier.
4. Analyze the image and highlight detected faces.
5. Display the processed image along with the forensic analysis results.

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or later
- Maven
- OpenCV Java Library
- JavaFX SDK
- Eclipse IDE (Recommended)

### Clone the Repository

```bash
git clone https://github.com/bhavanarajendrakumar/ImageForensics.git
```

### Navigate to the Project

```bash
cd ImageForensics
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

Run the `MainApp.java` file from your preferred IDE.

---

## 📸 Screenshots

### Home Screen

<p align="center">
<img width="727" height="329" alt="image" src="https://github.com/user-attachments/assets/89c6b3a1-48df-4e1c-ba85-8bf8a3d8a26f" />
</p>

### Suspiciuos Image & Analysis Result

<p align="center">
<img width="727" height="297" alt="image" src="https://github.com/user-attachments/assets/81fce20f-4e07-48f2-8f65-66401602ffa7" />

</p>

### Authentic Image & Analysis Result

<p align="center">
<img width="727" height="308" alt="image" src="https://github.com/user-attachments/assets/09585d51-c478-49eb-99d7-49efe7e0b537" />

</p>

> Place your screenshots inside an **images** folder in the repository.

---

## 🔮 Future Enhancements

- Deepfake detection
- Error Level Analysis (ELA)
- Copy-Move forgery detection
- Metadata analysis
- AI-based tampering detection
- PDF forensic report generation
- Support for additional image formats

---

## 🎯 Learning Outcomes

This project demonstrates practical implementation of:

- Object-Oriented Programming in Java
- JavaFX Desktop Application Development
- OpenCV Integration
- Digital Image Processing
- Digital Image Forensics
- Maven Project Management
- Cryptographic Hashing using SHA-256

---

## 👩‍💻 Author

**Bhavana Rajendra Kumar**

---

## 📜 License

This project is intended for educational and learning purposes.
