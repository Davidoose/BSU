namespace State
{
    public class OpenState : State
    {
        public OpenState(DbConnection dbConnection) : base(dbConnection)
        {
        }

        public override void Close()
        {
            Console.WriteLine("Close connection...");
            dbConnection.SetState(new CloseState(dbConnection));
        }

        public override void Open()
        {
            Console.WriteLine("Connection is already open!");
        }

        public override void Process(string str)
        {
            Console.WriteLine($"Process {str}");
        }
    }
}
