public class Main {
  public static void main(String[] args) 
  {
    new Main().run();
  }

  public void run()
  {
    
    double[][][] input = 
    {
      { {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0} },
      { {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0} },
      { {0}, {0}, {1}, {1}, {1}, {1}, {0}, {0} },
      { {0}, {0}, {1}, {1}, {1}, {1}, {0}, {0} },
      { {0}, {0}, {1}, {1}, {1}, {1}, {0}, {0} },
      { {0}, {0}, {1}, {1}, {1}, {1}, {0}, {0} },
      { {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0} },
      { {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0} }
    };

    double[][][][] filter = 
    {
      {
        { {-1}, {-1}, {-1} },
        { {0}, {0}, {0} },
        { {1}, {1}, {1} }
      }
    };

    System.out.println("Input Matrix");
    for(int d = 0; d < input[0][0].length; d++)
    {
      for(int h = 0; h < input[0].length; h++)
      {
        for(int w = 0; w < input.length; w++)
        {
          System.out.print(input[w][h][d] + " ");
        }
        System.out.println();
      }
      System.out.println();
    }

    System.out.println("Filter Matrices");
    for(int f = 0; f < filter[0][0][0].length; f++)
    {
      for(int d = 0; d < filter[0][0].length; d++)
      {
        for(int h = 0; h < filter[0].length; h++)
        {
          for(int w = 0; w < filter.length; w++)
          {
            System.out.print(filter[w][h][d][f] + " ");
          }
        }
        System.out.println();
      }
      System.out.println();
    }

    double[][][] convoluted = Convolution(input, filter);
    
    System.out.println("Output Matrix");
    for(int d = 0; d < convoluted[0][0].length; d++)
    {
      for(int h = 0; h < convoluted[0].length; h++)
      {
        for(int w = 0; w < convoluted.length; w++)
        {
          System.out.print(convoluted[w][h][d] + " ");
        }
        System.out.println();
      }
      System.out.println();
    }
  }

  public double[][][] Convolution(double[][][] input, double[][][][] kernels) {
    int k = kernels[0].length/2;  //Kernel indexing from -1 to 1
    int F = kernels.length;  //Number of filters
    int W = input.length; //Width of input image
    int H = input[0].length;  //Height of input image
    int D = kernels.length; //Depth of images and kernels

    if(D != input [0][0].length) throw new IllegalArgumentException("Input and kernel depths don't match"); //Throw error if depths don't match

    double[][][] convoluted = new double[W-2*k][H-2*k][D];  //create variable for convoluted matrix

    for(int f = 0; f < F; f++)  //Input and kernel filters
    {
      for(int h = k; h < H - k; h++) //Input height
      {
        for(int w = k; w < W - k; w++)  //Input width
        {
          convoluted[w - k][h - k][f] = 0;
          for(int j = -k; j <= k; j++) //Kernel height
          {
            for(int i = -k; i <= k; i++)  //Kernel width
            {
              for(int d = 0; d < D; d++)  //Kernel depth
              {
                convoluted[w - k][h - k][f] += (input[w + i][h + j][d] * kernels[f][i + k][j + k][d]);
              }
            }
          }
        }
      }
    }
    return convoluted;
  } 
}