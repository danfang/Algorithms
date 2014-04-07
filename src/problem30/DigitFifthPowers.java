package problem30;

/*
 Commented areas are for rendering scatterplots with JFreeChart

 Digit fifth powers
 Problem 30
 Surprisingly there are only three numbers that can be written as the sum of 
 fourth powers of their digits:

       1634 = 1^4 + 6^4 + 3^4 + 4^4
       8208 = 8^4 + 2^4 + 0^4 + 8^4
       9474 = 9^4 + 4^4 + 7^4 + 4^4

 The sum of these numbers is 1634 + 8208 + 9474 = 19316.

 Find the sum of all the numbers that can be written as the sum of fifth powers
  of their digits.
 */

public class DigitFifthPowers /*extends JFrame*/ {
   
   //private static XYSeriesCollection dataset;

   public static void main(String[] args) {

      //dataset = new XYSeriesCollection();
      //XYSeries data = new XYSeries("data");
      
      // logic
      int totalSum = 0;
      for (int i = 2; i < 200000; i++) {
         String s = String.valueOf(i);
         int sum = i;
         for (int j = 0; j < s.length(); j++) {
            sum -= Math.pow(Integer.parseInt("" + s.charAt(j)), 5);
         }
         //if (i % 100 == 0) {
         //   data.add(i, sum);
         //}
         if (sum == 0) {
            totalSum += i;
         }
      }
      System.out.println(totalSum);
      
      //dataset.addSeries(data);
      //showGraph();
   }

   /*
   private static void showGraph() {
      final JFreeChart chart = createChart(dataset);
      final ChartPanel chartPanel = new ChartPanel(chart);
      chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
      final ApplicationFrame frame = new ApplicationFrame("Title");
      frame.setContentPane(chartPanel);
      frame.pack();
      frame.setVisible(true);
   }

   private static JFreeChart createChart(final XYDataset dataset) {
      final JFreeChart chart = ChartFactory.createScatterPlot("Title", // chart title
            "X", // x axis label
            "Y", // y axis label
            dataset, // data
            PlotOrientation.VERTICAL, true, // include legend
            true, // tooltips
            false // urls
            );
      XYPlot plot = (XYPlot) chart.getPlot();
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
      renderer.setSeriesLinesVisible(0, true);
      plot.setRenderer(renderer);
      return chart;
   } */

}
