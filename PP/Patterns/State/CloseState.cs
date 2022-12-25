namespace State
{
    public class CloseState : State
    {
        public CloseState(DbConnection dbConnection) : base(dbConnection)
        {
        }

        public override void Close()
        {
        }

        public override void Open()
        {
            Console.WriteLine("Open connection...");
            dbConnection.SetState(new OpenState(dbConnection));
        }

        public override void Process(string str)
        {
            throw new CloseStateException("Can't process close DbConnection");
        }
    }
}
