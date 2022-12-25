namespace State
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var dbConnection = new DbConnection();

            string str = "SELECT * FROM ...";

            dbConnection.Open();
            dbConnection.Process(str);
            dbConnection.Close();
        }
    }
}
