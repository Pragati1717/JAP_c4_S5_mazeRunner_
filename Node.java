
    import java.util.Stack;

    class Node
    {
        private int x, y;
        private int dir;

        public Node(int i, int j)
        {
            this.x = i;
            this.y = j;

            // default value for direction set to 0 (Up)
            this.dir = 0;
        }

        public int getX()
        {
            return x;
        }

        public void setX(int x)
        {
            this.x = x;
        }

        public int getY()
        {
            return y;
        }

        public void setY(int y)
        {
            this.y = y;
        }

        public int getDir()
        {
            return dir;
        }

        public void setDir(int dir)
        {
            this.dir = dir;
        }
    }


