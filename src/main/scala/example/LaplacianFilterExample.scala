package example

import javax.swing.WindowConstants

import org.bytedeco.javacpp.opencv_core.Mat
import org.bytedeco.javacpp.opencv_core.BORDER_DEFAULT
import org.bytedeco.javacpp.opencv_imgcodecs.imread
import org.bytedeco.javacpp.opencv_imgproc.Laplacian
import org.bytedeco.javacv.{CanvasFrame, OpenCVFrameConverter}

/*
 Ref: https://github.com/bytedeco/javacv-examples/tree/master/OpenCV2_Cookbook#quick-sample
*/
object LaplacianFilterExample extends App {

  // Read an image.
  val src = imread("data/test.jpg")
  display(src, "Input")

  // Apply Laplacian filter
  val dest = new Mat()
  Laplacian(src, dest, src.depth, 1, 3, 0, BORDER_DEFAULT)
  display(dest, "Laplacian")

  def display(image: Mat, caption: String): Unit = {
    // Create image window named "My Image."
    val canvas = new CanvasFrame(caption, 1.0)

    // Request closing of the application when the image window is closed.
    canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

    // Convert from OpenCV Mat to Java Buffered image for display
    val converter = new OpenCVFrameConverter.ToMat()

    // Show image on window
    canvas.showImage(converter.convert(image))
  }
}
