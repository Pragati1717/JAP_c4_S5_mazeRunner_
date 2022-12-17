import java.util.Stack;

public class MazeRunner
{
    private static final int N = 4;
    private static final int M = 5;

    // maze of n*m matrix
    int n = N, m = M;
    public char[][] buildMaze(int[][] maze)
    {
        // When building the character maze from the integer array make sure the below is verified
        // 1 - is an obstacle - represented by the ascii symbol '‡'
        // 0 - is the space - represented as a blank character ' '
        // S - entry point
        // E - exit point

        // declare the character array that will be returned
        // use the below declaration
        char[][] mazeChar = new char[maze.length][maze[0].length];
        for (int row = 0; row < mazeChar.length; row++)
        {
            for (int col = 0; col < mazeChar[row].length; col++) {
                if(maze[row][col]==0){
                    mazeChar[row][col]=' ';
                }
                else if(maze[row][col]==1){
                    mazeChar[row][col]='‡';
                }
                else if(maze[row][col]==3){
                    mazeChar[row][col]='S';

                }
                else if(maze[row][col]==4){
                    mazeChar[row][col]='E';
                }
            }
        }
        return mazeChar;
    }
    public void printMaze(char[][] mazeChar)
    {

        System.out.println(mazeChar);
    }



    private static boolean[][] visited = new boolean[N][M];

    // Driver code
    public static void main(String[] args)
    {
        // Initially setting the visited
        // array to true (unvisited)
        setVisited(true);

        // Maze matrix
        int maze[][] = {{ 1, 0, 1, 1, 0 },
                { 1, 1, 1, 0, 1 },
                { 0, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1 } };


        if (isReachable(maze))
        {
            System.out.println("Path Found!\n");
        }
        else
            System.out.println("No Path Found!\n");
    }

    private static void setVisited(boolean b)
    {
        for (int i = 0; i < visited.length; i++)
        {
            for (int j = 0; j < visited[i].length; j++)
            {
                visited[i][j] = b;
            }
        }

    }

    private static boolean isReachable(int maze[][])
    {
        // Initially starting at (0, 0).
        int i = 0, j = 0;


        int fx, fy;
        fx = 2;
        fy = 3;

        Stack s = new Stack();

        Node temp = new Node(i, j);

        s.push(temp);

        while (!s.empty())
        {


            temp = (Node) s.peek();
            int d = temp.getDir();
            i = temp.getX();
            j = temp.getY();


            temp.setDir(temp.getDir() + 1);
            s.pop();
            s.push(temp);


            if (i == fx && j == fy)
            {
                return true;
            }

            if (d == 0)
            {
                // Checking the Up direction.
                if (i - 1 >= 0 && maze[i - 1][j] == 1 &&
                        visited[i - 1][j])
                {
                    Node temp1 = new Node(i - 1, j);
                    visited[i - 1][j] = false;
                    s.push(temp1);
                }
            }
            else if (d == 1)
            {
                // Checking the left direction
                if (j - 1 >= 0 && maze[i][j - 1] == 1 &&
                        visited[i][j - 1])
                {
                    Node temp1 = new Node(i, j - 1);
                    visited[i][j - 1] = false;
                    s.push(temp1);
                }
            }
            else if (d == 2)
            {
                // Checking the down direction
                if (i + 1 < N && maze[i + 1][j] == 1 &&
                        visited[i + 1][j])
                {
                    Node temp1 = new Node(i + 1, j);
                    visited[i + 1][j] = false;
                    s.push(temp1);
                }
            }
            else if (d == 3)
            {
                // Checking the right direction
                if (j + 1 < M && maze[i][j + 1] == 1 &&
                        visited[i][j + 1])
                {
                    Node temp1 = new Node(i, j + 1);
                    visited[i][j + 1] = false;
                    s.push(temp1);
                }
            }


            else
            {
                visited[temp.getX()][temp.getY()] = true;
                s.pop();
            }
        }

        // If the stack is empty and
        // no path is found return false.
        return false;
    }
}



