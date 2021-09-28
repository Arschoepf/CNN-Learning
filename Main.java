class Main {
  public static void main(String[] args) {
    double [][][] input = 
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

    double [][][] filter = 
    {
      { {-1}, {0}, {1} },
      { {-1}, {0}, {1} },
      { {-1}, {0}, {1} }
    };

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

    for(int d = 0; d < input[0][0].length; d++)
    {
      for(int h = 1; h < input[0].length -1; h++)
      {
        for(int w = 1; w < input.length -1; w++)
        {
          double sum = 0;
          for(int i = 0; i < filter[0][0].length; i++)
          {
            for(int j = 0; j < filter[0].length; j++)
            {
              for(int k = 0; k < filter.length; k++)
              {
                sum += (input[w+k-1][h+j-1][d] * filter[k][j][i]);
                //System.out.print (input[w][h][d] * filter[k][j][i] + " ");
              }
              //System.out.println();
            }
            //System.out.println();
          }
          System.out.print("   " + sum + "   ");
        }
        System.out.println();
      }
      System.out.println();
    }
  }
}