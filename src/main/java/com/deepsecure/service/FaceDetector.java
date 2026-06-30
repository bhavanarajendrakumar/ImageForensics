package com.deepsecure.service;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.File;

public class FaceDetector {

    private CascadeClassifier faceCascade;
    private int lastCount = 0;

    // Constructor: Load Haar Cascade XML
    public FaceDetector() {
        String xmlPath = "src/main/resources/haarcascade_frontalface_default.xml";
        File xmlFile = new File(xmlPath);

        if (!xmlFile.exists()) {
            throw new RuntimeException("Face detection XML file missing!");
        }

        this.faceCascade = new CascadeClassifier(xmlFile.getAbsolutePath());
    }

    // 👤 Face Detection
    public Mat detectFaces(String imagePath) {
        Mat src = Imgcodecs.imread(imagePath);

        MatOfRect faceDetections = new MatOfRect();

        faceCascade.detectMultiScale(
                src,
                faceDetections,
                1.1,
                7,
                0,
                new Size(30, 30),
                new Size()
        );

        lastCount = faceDetections.toArray().length;

        // Draw rectangles around detected faces
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(
                    src,
                    new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0),
                    3
            );
        }

        return src;
    }

    // 🧩 Edge Detection (Canny)
    public Mat analyzeEdges(String imagePath) {
        Mat src = Imgcodecs.imread(imagePath);
        Mat edges = new Mat();

        Imgproc.cvtColor(src, edges, Imgproc.COLOR_BGR2GRAY);
        Imgproc.Canny(edges, edges, 100, 200);

        return edges;
    }

    // 📊 Noise Analysis (Laplacian)
    public Mat analyzeNoise(String imagePath) {
        Mat src = Imgcodecs.imread(imagePath);
        Mat noise = new Mat();

        Imgproc.cvtColor(src, noise, Imgproc.COLOR_BGR2GRAY);
        Imgproc.Laplacian(noise, noise, CvType.CV_8U);

        // Amplify noise visibility
        Core.multiply(noise, new Scalar(15), noise);

        return noise;
    }

    // 🧠 Tampering Score Calculation (Core Logic)
    public double calculateTamperingScore(String imagePath) {

        Mat edges = analyzeEdges(imagePath);
        Mat noise = analyzeNoise(imagePath);

        int totalPixels = edges.rows() * edges.cols();

        int edgePixels = Core.countNonZero(edges);
        int noisePixels = Core.countNonZero(noise);

        double edgeDensity = ((double) edgePixels / totalPixels) * 100;
        double noiseDensity = ((double) noisePixels / totalPixels) * 100;

        // Combine both features
        double score = (edgeDensity * 0.6) + (noiseDensity * 0.4);

        // Normalize score
        if (score > 100) score = 100;

        return score;
    }

    // Getter for face count
    public int getLastCount() {
        return lastCount;
    }
}